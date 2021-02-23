package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getMessage() {
		return this.driver.findElement(By.xpath("//*[contains(@class,"
	+ " 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	
	public String getMessageText() {
		return getMessage().getText();
	}
	
	public void notification() {
		WebElement notification = 
				this.driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
		waiter.until(ExpectedConditions.attributeContains(notification, "style", "display: none;"));
	}
	
	
}
