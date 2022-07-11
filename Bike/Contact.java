package Bike;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Contact {
	private WebDriver driver;
	   private ExcelUtility utility;
@Test(dataProvider = "getTestData")
	   public void test(String fname,String lname, String mail,String phone,String mesg) throws Exception {
	   
	  driver.findElement(By.id("fname1")).sendKeys(fname);
	  driver.findElement(By.id("lname1")).sendKeys(lname);
	  driver.findElement(By.id("email1")).sendKeys(mail);
	  driver.findElement(By.id("mobile1")).sendKeys(phone);

	 driver.findElement(By.id("meg1")).sendKeys(mesg);

	driver.findElement(By.id("sub")).click();
	     Thread.sleep(500);
	 
	 

	   }
@BeforeMethod
public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
   this.driver = new ChromeDriver();
   driver.get("file:///C:/Users/itctesting21/Desktop/New%20folder/contact.html");
//Thread.sleep(2000);
}


@DataProvider
public Object[][] getTestData() throws Exception {
	  utility = new ExcelUtility();

	     
   int totalRows = utility.getRowCount("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\ccontact.xlsx","Sheet1");
int totalColumns = utility.getColumnCount("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\ccontact.xlsx","Sheet1");
   System.out.println("=> Total rows and columns is/are ("+totalRows+", "+totalColumns+")");

   Object[][] data = new Object[totalRows][totalColumns];
   for(int i=0;i<totalRows;i++) {
       for(int j=0;j<totalColumns;j++) {
           // Give your excel absolute path with the extension
       
       data[i][j]=new ExcelUtility().getData("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\ccontact.xlsx", "Sheet1", i, j);           
       }
   }
   return data;
 
}
@AfterMethod
public void contact() {
	driver.quit();
}
}

  

