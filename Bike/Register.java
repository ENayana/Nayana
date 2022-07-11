package Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import Bike.ExcelUtility;

public class Register {
private WebDriver driver;
private ExcelUtility utility;

@DataProvider
public Object[][] getTestData() throws Exception {
utility = new ExcelUtility();

int totalRows = utility.getRowCount("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\rregister.xlsx",
"Sheet1");
int totalColumns = utility.getColumnCount("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\rregister.xlsx",
"Sheet1");
System.out.println("=> Total rows and columns is/are (" + totalRows + ", " + totalColumns + ")");

Object[][] data = new Object[totalRows][totalColumns];
for (int i = 0; i < totalRows; i++) {
for (int j = 0; j < totalColumns; j++) {
data[i][j] = new ExcelUtility()
.getData("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\rregister.xlsx", "Sheet1", i, j);
}
}
return data;
}

@BeforeMethod
public void setup() throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
this.driver = new ChromeDriver();

driver.get("file:///C:/Users/itctesting21/Desktop/New%20folder/register.html");
Thread.sleep(2000);

}

@Test(dataProvider = "getTestData")
public void test(String FullName, String Username, String Email, String PhoneNum, String Paswrd, String ConPass)
throws InterruptedException {
driver.findElement(By.id("fulname")).sendKeys(FullName);
Thread.sleep(1000);
driver.findElement(By.id("username")).sendKeys(Username);
Thread.sleep(1000);
driver.findElement(By.id("email")).sendKeys(Email);
Thread.sleep(1000);
driver.findElement(By.id("phone")).sendKeys(PhoneNum);
Thread.sleep(1000);
driver.findElement(By.id("pass")).sendKeys(Paswrd);
Thread.sleep(1000);
driver.findElement(By.id("pass1")).sendKeys(ConPass);
Thread.sleep(1000);
WebElement radioboxSelect = driver.findElement(By.id("r2"));
Boolean isSelect = radioboxSelect.isSelected();
if (isSelect == false) {
radioboxSelect.click();
}
driver.findElement(By.id("sub")).click();
Thread.sleep(2000);
driver.switchTo().alert().accept();
//driver.close();
}
@AfterMethod
public void register() {
	driver.quit();
}
}

