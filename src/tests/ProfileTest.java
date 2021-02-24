package tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	private String imgPath;
	
	@Test
	public void editProfileTest() throws InterruptedException {
		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		this.locationPopupPage.closeLocationForm();
		this.loginPage.login(this.username, this.password);
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Login Successfull"));
		this.driver.navigate().to(this.baseUrl + "/member/profile");
		this.profilePage.editProfileInfomations("Maja", "Manojlovic", "maja@gmail.com",
												"Zorana Djindjica", "066666666", "7225", "United Kingdome", 
												"Belfast", "Holywood");
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Setup Successfull"));
		this.authPage.logout();
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Logout Successfull"));
	}
	
	@Test
	public void changeProfileImageTest() throws IOException {
		this.imgPath = new File("img/profileImg.jpg").getCanonicalPath();
		
		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		this.locationPopupPage.closeLocationForm();
		this.loginPage.login(this.username, this.password);
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Login Successfull"));
		this.driver.navigate().to(this.baseUrl + "/member/profile");
//		this.profilePage.removePhoto();
		this.profilePage.setProfilePhoto(imgPath);
		Assert.assertTrue(this.notificationPage.getMessageText().contains("Profile Image Uploaded Successfully"));
		this.waiter.until(ExpectedConditions.invisibilityOf(this.notificationPage.getMessage()));
		this.profilePage.removePhoto();
		
	}
}
