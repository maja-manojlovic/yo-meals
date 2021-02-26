package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}

	public WebElement getMealsPage() {
		return this.driver.findElement(By.linkText("Meals"));
	}
	
	public List<WebElement> getMeals() {
		return this.driver.findElements(By.id("listing"));
	}
	
	public void addToCart(int quantity) {
		String qty = String.valueOf(quantity);  
		WebElement qtyField = this.driver.findElement(By.name("product_qty"));
		qtyField.clear();
		qtyField.sendKeys(qty);
		this.driver.findElement(By.className("js-proceedtoAddInCart")).click();
	} 
	
	public WebElement getFavoriteBtn() {
		return this.driver.findElement(By.className("itemfav"));
	}
	
}
