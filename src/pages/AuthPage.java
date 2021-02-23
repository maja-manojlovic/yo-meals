package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		
	}

	public WebElement getUserBtn() {
		return this.driver.findElement(By.xpath("//*[@class='accounts-link']/ul//li[2]/a"));
	}
	
	public WebElement getMyAccountBtn() {
		return this.driver.findElement(By.linkText("My account"));
	}
	
	public WebElement getLogoutBtn() {
		return this.driver.findElement(By.xpath("//header//ul[2]/li[2]/a"));
	}
	
	public void logout() {
		getUserBtn().click();
		getLogoutBtn().click();
	}
}
