package com.bankguru.account;


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

public class RegisterLogin_Level_7_CheckUndisplayed_OverrideTimeout extends AbstractTest {
	private WebDriver driver;
	private String email, UserID, password, LoginURL;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
		@Test
	public void TC_01_RegisterToSystem() {
		LoginURL =loginPage.getLoginPageUrl();
		registerPage=loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		UserID=registerPage.getUserIDText();
		password=registerPage.getPasswordText();
	}

	@Test
	public void TC_02_LoginWithAboveInformation() {
		loginPage=registerPage.openLoginPage(LoginURL);
		loginPage.inputToUserIDTextbox(UserID);
		loginPage.inputToPasswordTextbox(password);
		homePage=loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}
	@Test
	public void TC_03_CheckUndisplayedOverrideTimeout() {
	
		newCustomerPage=homePage.openNewCustomerPage(driver);
		
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		//Có trong DOM- ko visible
		Assert.assertTrue(newCustomerPage.isAddCustomerFormUndisplayed());
		// Không có trong DOM
		Assert.assertTrue(newCustomerPage.isHomePageUnDisplayed());
		
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
