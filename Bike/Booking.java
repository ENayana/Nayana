package Bike;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

import com.google.common.base.Function;
import Bike.ExcelUtility;

public class Booking {
private WebDriver driver;
private ExcelUtility utility;

@DataProvider
public Object[][] getTestData() throws Exception {
utility = new ExcelUtility();

int totalRows = utility.getRowCount("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\bbooking.xlsx",
"Sheet1");
int totalColumns = utility.getColumnCount("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\bbooking.xlsx",
"Sheet1");
System.out.println("=> Total rows and columns is/are (" + totalRows + ", " + totalColumns + ")");

Object[][] data = new Object[totalRows][totalColumns];
for (int i = 0; i < totalRows; i++) {
for (int j = 0; j < totalColumns; j++) {
data[i][j] = new ExcelUtility()
.getData("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\bbooking.xlsx", "Sheet1", i, j);
}
}
return data;
}

@BeforeMethod
public void setup() throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
this.driver = new ChromeDriver();

driver.get("file:///C:/Users/itctesting21/Desktop/New%20folder/booking.html");
Thread.sleep(2000);

}

@Test(dataProvider = "getTestData")
public void test(String fname, String lname, String address, String mail, String phone,String dob, String min,
String max) throws InterruptedException {
driver.findElement(By.id("fname")).sendKeys(fname);
Thread.sleep(1000);
driver.findElement(By.id("lname")).sendKeys(lname);
Thread.sleep(1000);
driver.findElement(By.id("address")).sendKeys(address);
Thread.sleep(1000);
driver.findElement(By.id("mail")).sendKeys(mail);
Thread.sleep(1000);
driver.findElement(By.id("phone")).sendKeys(phone);
Thread.sleep(1000);
driver.findElement(By.id("DOB")).sendKeys(dob);
Thread.sleep(1000);
/*WebElement DOB=driver.findElement(By.xpath("//input[@id=\'DOB\']"));
DOB.sendKeys("10072000");*/
Select se=new Select(driver.findElement(By.xpath("//*[@id='option']")));
se.selectByIndex(2);
Thread.sleep(2000);
WebElement checkboxSelect=driver.findElement(By.id("v1"));
Boolean isSelect=checkboxSelect.isSelected();
if(isSelect==false) {
	checkboxSelect.click();
}
driver.findElement(By.id("min")).sendKeys(min);
Thread.sleep(1000);
driver.findElement(By.id("max")).sendKeys(max);
Thread.sleep(1000);
driver.findElement(By.id("sub")).click();

driver.switchTo().alert().accept();
Thread.sleep(1000);
//driver.close();

}
@AfterMethod
public void book() {
	driver.quit();
}

}
