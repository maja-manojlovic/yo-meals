package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public List<WebElement> products() {
		return this.driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}

	public ArrayList<String> productName() {
		String name = "";
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < products().size(); i++) {
			name = products().get(i).getText();
			names.add(name);
		}
		return names;
	}
	
	public int productsNo() {
		return  products().size();
	}
}
