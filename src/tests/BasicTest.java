package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	protected SoftAssert sa;
	
	protected String baseUrl;
	protected String email;
	protected String password;
	
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected ProfilePage profilePage;
	protected NotificationSystemPage notificationPage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage summaryPage;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
					"driver-lib\\chromedriver.exe");
			
		this.driver = new ChromeDriver ();
		this.waiter = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;
		this.sa = new SoftAssert();
			
		this.baseUrl = "http://demo.yo-meals.com";
		this.email = "customer@dummyid.com";
		this.password = "12345678a";
		
		this.locationPopupPage = new LocationPopupPage(driver, waiter, js);
		this.loginPage = new LoginPage (driver, waiter, js);
		this.profilePage = new ProfilePage (driver, waiter, js);
		this.notificationPage = new NotificationSystemPage (driver, waiter, js);
		this.authPage = new AuthPage (driver, waiter, js);
		this.mealPage = new MealPage (driver, waiter, js);
		this.summaryPage = new CartSummaryPage (driver, waiter, js);
		
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
	@AfterMethod
	public void takeScreenshoot (ITestResult test ) throws IOException {
		if (test.getStatus() == ITestResult.FAILURE) {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File photo = scrShot.getScreenshotAs(OutputType.FILE);
		File location = new File ("screenshots/photo1.png");
		FileUtils.copyFile(photo, location);
		}
		
		this.driver.manage().deleteAllCookies();
				
	}
	
	@AfterClass
	public void clean() {
		this.driver.quit();
		
	}
}

