package tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	private String imgPath;
	private String loginMsg;
	private String errorLoginMsg;
	private String setupMsg;
	private String errorSetupMsg;
	private String logoutMsg;
	private String errorLogoutMsg;
	
	@BeforeTest
	public void testSetup() {
		this.loginMsg = "Login Successfull";
		this.errorLoginMsg = "[ERROR]: Login isn't successfull!";
		this.setupMsg = "Setup Successful";
		this.errorSetupMsg = "[ERROR]: Setup isn't successfull!";
		this.logoutMsg = "Logout Successfull!";
		this.errorLogoutMsg = "[ERROR]: Logout isn't successfull!";
	}
	
	@Test (priority = 0)
	public void editProfileTest() throws InterruptedException {
		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		this.locationPopupPage.closeLocationForm();
		this.loginPage.login(this.email, this.password);
		this.sa.assertTrue(this.notificationPage.getMessageText().contains(loginMsg), errorLoginMsg);
		this.driver.navigate().to(this.baseUrl + "/member/profile");
		this.profilePage.editProfileInfomations("Maja", "Manojlovic", "Superior Ave", "066666666",
												"7225", "United Kingdom", "Aberdeen", "Cleveland");
		this.sa.assertTrue(this.notificationPage.getMessageText().contains(setupMsg), errorSetupMsg);
		this.authPage.logout();
		this.sa.assertTrue(this.notificationPage.getMessageText().contains(logoutMsg), errorLogoutMsg);
		this.sa.assertAll();
	}
	
	@Test (priority = 5)
	public void changeProfileImageTest() throws IOException, InterruptedException {
		this.imgPath = new File("img/profileImg.jpg").getCanonicalPath();

		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		this.locationPopupPage.closeLocationForm();
		this.loginPage.login(this.email, this.password);
		this.sa.assertTrue(this.notificationPage.getMessageText().contains(loginMsg), errorLoginMsg);
		
		this.driver.navigate().to(this.baseUrl + "/member/profile");
		this.profilePage.setProfilePhoto(imgPath);
		this.sa.assertTrue(this.notificationPage.getMessageText()
				.contains("Profile Image Uploaded Successfully"), "[ERROR]:Profile image isn't uploaded!");
		
		this.waiter.until(ExpectedConditions.invisibilityOf(this.notificationPage.getMessage()));
		this.profilePage.removeImg();
		this.sa.assertTrue(this.notificationPage.getMessageText()
				.contains("Profile Image Deleted Successfully"), "[ERROR]:Profile image isn't deleted!");
		
		this.waiter.until(ExpectedConditions.invisibilityOf(this.notificationPage.getMessage()));
		this.authPage.logout();
		this.sa.assertTrue(this.notificationPage.getMessageText().contains(logoutMsg), errorLogoutMsg);
		this.sa.assertAll();
	}
}
