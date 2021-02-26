package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class SearchTest extends BasicTest {
	
	@Test (priority = 0)
	public void searchResultsTest() throws IOException {
		this.driver.navigate().to(this.baseUrl + "/meals");
		this.locationPopupPage.insertLocation("City Center - Albany");
		
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");
		
		for (int i = 1; i < 7; i++) {
			XSSFRow row = sheet.getRow(i);
			
			String location = row.getCell(0).getStringCellValue();
			String mealUrl = row.getCell(1).getStringCellValue();
			double resultsNo = row.getCell(2).getNumericCellValue();
			int results = (int)resultsNo;
			
			this.driver.get(mealUrl);
			this.locationPopupPage.getLocationForm();
			this.locationPopupPage.insertLocation(location);
			this.sa.assertEquals(this.searchPage.productsNo(), results, "[ERROR]: Number of products doesn't match.");
			
			for (int j = 3; j <= row.getLastCellNum(); j++) {
				String mealName = row.getCell(j).getStringCellValue();
				this.sa.assertEquals(this.searchPage.productName().get(j), mealName, "[ERROR]: Results aren't the same.");
			}
		}
		wb.close();
		fis.close();
		this.sa.assertAll();
	}
}
