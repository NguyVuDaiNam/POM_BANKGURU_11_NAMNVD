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

public class RegisterLogin_Level_9_ExtentReport_CloseBrowser_ShareGlobalClass_BrowserDriver extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;

	@Test
	public void TC_01_CheckUndisplayedOverrideTimeout(Method testMethod) {
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
	
		loginPage =PageFactoryManager.getLoginPage(driver);
	
		loginPage.inputToUserIDTextbox(RegisterLogin_Global.USER_ID);
		
		loginPage.inputToPasswordTextbox(RegisterLogin_Global.PASSWORD);
		
		homePage=loginPage.clickToLoginButton();
	
		verifyTrue(homePage.isHomePageDisplayed());
	}
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
