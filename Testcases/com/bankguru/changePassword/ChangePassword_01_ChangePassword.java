package com.bankguru.changePassword;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.RegisterLogin_Global;

import commons.AbstractTest;
import commons.Constansts;
import pageObjects.ChangePasswordPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;

public class ChangePassword_01_ChangePassword extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	
	private ChangePasswordPageObject changePasswordPage;
	private String OldPass_Locator="oldpassword";
	private String NewPass_Locator="newpassword";
	private String ConfirmPass_Locator="confirmpassword";
	@Test
	public void TC_01_OldPasswordCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Old Password");
		changePasswordPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, OldPass_Locator);

		log.info("Step 02: Press Tab Old Password");
		changePasswordPage.DynamicPressTab(driver, OldPass_Locator);

		log.info("Step 03: Verify text Old Password");
		verifyEquals(changePasswordPage.getDynamicText(driver, "Old Password must not be blank"),"Old Password must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_02_NewPasswordCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value New Password");
		changePasswordPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, NewPass_Locator);

		log.info("Step 02: Press Tab New Password");
		changePasswordPage.DynamicPressTab(driver, NewPass_Locator);

		log.info("Step 03: Verify text New Password");
		verifyEquals(changePasswordPage.getDynamicText(driver, "New Password must not be blank"),"New Password must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_03_NewPasswordMustHaveOneNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: New Password must one numeric");
		changePasswordPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, NewPass_Locator);

		log.info("Step 02: Verify text New Password");
		verifyEquals(changePasswordPage.getDynamicText(driver, "Enter at-least one numeric value"),"Enter at-least one numeric value");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_04_NewPasswordMustHaveOneSpacial(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: New Password must one Spacial Character");
		changePasswordPage.inputDynamicText(driver, Constansts.NUMBER_SENKEY, NewPass_Locator);

		log.info("Step 02: Verify text New Password");
		verifyEquals(changePasswordPage.getDynamicText(driver, "Enter at-least one special character"),"Enter at-least one special character");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_05_NewPasswordCannotHaveStringpasswordOrPassword(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: New Password cannot have string password");
		changePasswordPage.inputDynamicText(driver, "123@password", NewPass_Locator); 
		
		log.info("Step 02: Verify text New Password");
		verifyEquals(changePasswordPage.getDynamicText(driver, "Choose a difficult Password"),"Choose a difficult Password");

		log.info("Step 03: New Password cannot have string Password");
		changePasswordPage.inputDynamicText(driver, "123@Password", NewPass_Locator);
		
		log.info("Step 04: Verify text New Password");
		verifyEquals(changePasswordPage.getDynamicText(driver, "Choose a difficult Password"),"Choose a difficult Password");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_06_ConfirmPassword(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Confirm pass");
		changePasswordPage.inputDynamicText(driver, Constansts.NUMBER_SENKEY, "confirmpassword");

		log.info("Step 02: Verify text Confirm pass");
		verifyEquals(changePasswordPage.getDynamicText(driver, "Passwords do not Match"),"Passwords do not Match");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_06_ConfirmPasswordInvalid(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: input Old password");
		changePasswordPage.inputDynamicText(driver, RegisterLogin_Global.PASSWORD, OldPass_Locator);

		log.info("Step 02: input new password");
		changePasswordPage.inputDynamicText(driver, Constansts.PASSWORD_NEW_SENKEY, NewPass_Locator);
		
		log.info("Step 03: confirm new password");
		changePasswordPage.inputDynamicText(driver, Constansts.PASSWORD_NEW_SENKEY, ConfirmPass_Locator);
		
		log.info("Step 04: Click Submit");
		changePasswordPage.clickDynamicSubmit(driver, "sub");
		
		log.info("Step 05: Verify Password is Changed");
		verifyEquals(changePasswordPage.getTextAlert(driver),"Password is Changed");
		
		log.info("Step 06: Accep alert ");
		changePasswordPage.acceptAlert(driver);
		
		log.info("Step 07: Verify");
		verifyEquals(changePasswordPage.getDynamicTextH2(driver, "Guru99 Bank"),"Guru99 Bank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("============== START: LOGIN ============== ");
		driver = opentMultiBrowser(browserName, url);
		loginPage = PageFactoryManager.getLoginPage(driver);

		log.info("Step 01: Input data to UserID");
		loginPage.inputDynamicText(driver, RegisterLogin_Global.USER_ID, "uid");
		
		log.info("Step 02: Input data to Password");
		loginPage.inputDynamicText(driver, RegisterLogin_Global.PASSWORD, "password");

		log.info("Step 03: Click to Submit button");
		homePage = loginPage.clickToLoginButton();

		log.info("Step 04: verify Home Page");
		verifyTrue(homePage.isHomePageDisplayed());

		log.info("============== AND: LOGIN ============== ");

		log.info("Step: Click Change Password");
		changePasswordPage =    (ChangePasswordPageObject) homePage.openDynamicPage(driver, "Change Password");
		
		log.info("Step: Verify Change Password Displayed");
		verifyTrue(changePasswordPage.isDynamicSuccessfullyPageDisplayed(driver, "Change Password"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
