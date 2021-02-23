
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Metode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

////	}
//	function getElementsByXPath(xpath)
//	{
//	    let results = [];
//	    let query = document.evaluate(xpath,  document,
//	        null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);
//	    for (let i = 0, length = query.snapshotLength; i < length; ++i) {
//	        results.push(query.snapshotItem(i));
//	    }
//	    return results;
//	}
//
//
//	function getElementByXPath(path) {
//	  return document.evaluate(path, document, null,
//	XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
//	}
//	}
	 {   System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");  
		  WebDriver driver = new ChromeDriver();     
		  driver.get("https://www.google.com");    
		  driver.findElement(By.className("gLFyf")).sendKeys("IT Bootcamp");  
		  driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);  
		 }  
}
}
