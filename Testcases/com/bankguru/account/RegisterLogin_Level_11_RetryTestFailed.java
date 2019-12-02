package com.bankguru.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;

public class RegisterLogin_Level_11_RetryTestFailed extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;

	@Test
	public void TC_01_LoginWithAboveInformation(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		
		log.info("Step 1- Input userID");
		loginPage.inputToUserIDTextbox(RegisterLogin_Global.USER_ID);

		log.info("Step 2- Input password");
		loginPage.inputToPasswordTextbox(RegisterLogin_Global.PASSWORD);

		log.info("Step 3- Click button");
		homePage = loginPage.clickToLoginButton();

		verifyFalse(homePage.isHomePageDisplayed());
		log.info("============== AND: " + testMethod.getName() + " ============== ");

	}
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = opentMultiBrowser(browserName, url);

		loginPage = PageFactoryManager.getLoginPage(driver);

	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
