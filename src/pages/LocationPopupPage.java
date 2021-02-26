package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getLocationBtn() {
		WebElement locationButton = this.driver.findElement(By.className("location-selector"))
												.findElement(By.tagName("a"));
		return locationButton;
	}
	
	public WebElement getBtnClose() {
		return this.driver.findElement(By.className("close-btn-white"));
	} 
	
	public WebElement getKeyword() {
		return this.driver.findElement(By.name("locality_keyword"));
	}
	
	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput() {
		return this.driver.findElement(By.id("location_id"));
	}
	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	
	public void getLocationForm() {
		getLocationBtn().click();
	}

	public void insertLocation(String locationName) {
		getKeyword().click();
		String value = getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", getLocationInput(), value);
		js.executeScript("arguments[0].click()", getSubmit());
	}
	
	public void closeLocationForm() {
		getBtnClose().click();
	}
	
}
