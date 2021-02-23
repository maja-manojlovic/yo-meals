
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class screenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		@AfterMethod
//		public void takeScreenshoot (ITestResult test ) throws IOException {
//		if (test.getStatus() == ITestResult.FAILURE) {
//			TakesScreenshot scrShot = ((TakesScreenshot)driver);
//			File photo = scrShot.getScreenshotAs(OutputType.FILE);
//			File location = new File ("screenshots/photo1.png");
//			FileUtils.copyFile(photo, location);
//		}
	}

}
