package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{

	@Test
	public void addMealToCart() {
		this.driver.navigate().to(this.baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.locationPopupPage.closeLocationForm();
		this.mealPage.addToCart(2);
		Assert.assertTrue(this.notificationPage.getMessageText().contains("The Following Errors Occurred:"));
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Please Select Location"));
		this.waiter.until(ExpectedConditions.invisibilityOf(this.notificationPage.getMessage()));
		this.locationPopupPage.getLocationBtn().click();
		this.locationPopupPage.insertLocation("City Center - Albany");
		this.mealPage.addToCart(2);
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Meal Added To Cart"));
	} 
	
	@Test
	public void favoriteMealsTest() {
		this.driver.navigate().to(this.baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.locationPopupPage.closeLocationForm();
		this.mealPage.getFavoriteBtn().click();
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Please login first!"));
		this.loginPage.getLoginBtn().click();
		this.loginPage.login(this.username, this.password);
		this.driver.navigate().to(this.baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.locationPopupPage.closeLocationForm();
		this.mealPage.getFavoriteBtn().click();
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Product has been added to your favorites."));
	}
	
	@Test
	public void clearCartTest() throws IOException {
		this.driver.navigate().to(this.baseUrl + "meals");
		this.locationPopupPage.insertLocation("City Center - Albany");
		
		File file = new File("data/data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");
		
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			
		}
	}
}
