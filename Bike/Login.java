package Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import Bike.ExcelUtility;


public class Login {
	private WebDriver driver;
	private ExcelUtility utility;

	@DataProvider
	public Object[][] getTestData() throws Exception {
	utility = new ExcelUtility();

	int totalRows = utility.getRowCount("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\llogin.xlsx",
	"Sheet1");
	int totalColumns = utility.getColumnCount("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\llogin.xlsx",
	"Sheet1");
	System.out.println("=> Total rows and columns is/are (" + totalRows + ", " + totalColumns + ")");

	Object[][] data = new Object[totalRows][totalColumns];
	for (int i = 0; i < totalRows; i++) {
	for (int j = 0; j < totalColumns; j++) {
	data[i][j] = new ExcelUtility()
	.getData("C:\\Users\\itctesting21\\eclipse-workspace\\bike_g\\src\\test\\resources\\Excel\\llogin.xlsx", "Sheet1", i, j);
	}
	}
	return data;
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	this.driver = new ChromeDriver();

	driver.get("file:///C:/Users/itctesting21/Desktop/New%20folder/login.html");
	Thread.sleep(2000);

	}

	@Test(dataProvider = "getTestData")
	public void test(String username, String password) throws InterruptedException {
	driver.findElement(By.id("name")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("login")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	//driver.close();
	}
	
	@AfterMethod
	public void login() {
		driver.quit();
	}
	
	}


