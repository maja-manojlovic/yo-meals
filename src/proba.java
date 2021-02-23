
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class proba {

	public abstract class BasicTest {

		protected WebDriver driver;
		protected WebDriverWait waiter;
		protected JavascriptExecutor js;
		
	@BeforeClass
	public void setup () {
		System.setProperty("webdriver.chrome.driver",
					"driver-lib\\chromedriver.exe");
			
		this.driver = new ChromeDriver ();
		this.waiter = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;
			
			
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
		
	@AfterClass
	public void clean () {
		this.driver.quit();
		
	}
//	sendKeys(Keys.chord(Keys.CONTROL, "a", "Maja"));
//	File file = new File("data/data.xlsx");
//	FileInputStream fis = new FileInputStream(file);
//	XSSFWorkbook wb = new XSSFWorkbook(fis);
//	XSSFSheet sheet = wb.getSheet("Лист1");
	
}}
