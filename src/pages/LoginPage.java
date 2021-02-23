package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	
	}

	public WebElement getLoginBtn() {
		return this.driver.findElement(By.xpath("//*[@class='accounts-link']/ul//li[2]/a"));
	}
	
	public WebElement getUsername() {
		return this.driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}
	
	public WebElement getRememberMe() {
		return this.driver.findElement(By.name("remember_me"));
	} 
	
	public WebElement getSaveLoginBtn() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	public void login(String username, String password) {
		getLoginBtn().click();
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getSaveLoginBtn().click();
	}
	
}
