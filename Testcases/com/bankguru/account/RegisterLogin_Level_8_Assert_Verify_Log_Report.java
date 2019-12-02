package com.bankguru.account;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterLogin_Level_8_Assert_Verify_Log_Report extends AbstractTest {
	private WebDriver driver;
	private String email, UserID, password, LoginURL;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;

	@Test
	public void TC_01_RegisterToSystem(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("TC_01 - Step 01: Get Login page URL");
		LoginURL =loginPage.getLoginPageUrl();
		
		log.info("TC_01 - Step 02: Click to hete link");
		registerPage=loginPage.clickToHereLink();
		
		log.info("TC_01 - Step 03: Input data to Email textbox");
		registerPage.inputToEmailIDTextbox(email);
		
		log.info("TC_01 - Step 04: Click to Submit button");
		registerPage.clickToSubmitButton();
		
		log.info("TC_01 - Step 05: Get User/ Pass information");
		UserID=registerPage.getUserIDText();
		password=registerPage.getPasswordText();
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}

	@Test
	public void TC_02_LoginWithAboveInformation(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("TC_02 - Step 01: Open Login Page Url");
		loginPage=registerPage.openLoginPage(LoginURL);
		
		log.info("TC_02 - Step 02: Input to UserID textbox");
		loginPage.inputToUserIDTextbox(UserID);
		
		log.info("TC_02 - Step 03: Input to password textbox");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("TC_02 - Step 04: Click to Login Button");
		homePage=loginPage.clickToLoginButton();
		
		log.info("TC_02 - Step 05: Verify Home page displayed");
		verifyTrue(homePage.isHomePageDisplayed());
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_03_CheckUndisplayedOverrideTimeout(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("TC_03 - Step 01: Open New Customer Page");
		newCustomerPage=homePage.openNewCustomerPage(driver);
		
		log.info("TC_03 - Step 02: verify New Customer page displayed");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());

		log.info("TC_03 - Step 03: verify Add Customer page displayed");
		Assert.assertTrue(newCustomerPage.isAddCustomerFormUndisplayed());
		
		log.info("TC_03 - Step 04: verify Home page displayed");
		Assert.assertTrue(newCustomerPage.isHomePageUnDisplayed());
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
		
	}

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver=opentMultiBrowser(browserName, url);
		email = "seleniumonline" + randomNumber() + "@gmail.com";
		loginPage =PageFactoryManager.getLoginPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
