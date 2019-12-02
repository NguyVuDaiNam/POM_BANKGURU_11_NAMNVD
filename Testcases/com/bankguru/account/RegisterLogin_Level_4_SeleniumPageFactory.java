package com.bankguru.account;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankguru.pageFactory.HomePageFactory;
import bankguru.pageFactory.LoginPageFactory;
import bankguru.pageFactory.RegisterPageFactory;
import commons.AbstractTest;

public class RegisterLogin_Level_4_SeleniumPageFactory extends AbstractTest {
	private WebDriver driver;

	private String loginPageUrl, userID, password,email;
	
	private LoginPageFactory loginPage;
	private HomePageFactory homePage;
	private RegisterPageFactory registerPage;
	@Test
	public void TC_01_RegisterToSystem() {
		
		loginPage = new LoginPageFactory(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayes());
		
		loginPageUrl =loginPage.getLoginPageUrl();
		loginPage.clickToHereLink();
		
		registerPage=new RegisterPageFactory(driver);
		Assert.assertTrue(registerPage.isRegisterFormDisplayes());
		
		registerPage.inputEmailIDTextbox(email);
		registerPage.clickToLoginButton();
		userID=registerPage.getUserIDInfor();
		password=registerPage.getPasswordInfor();
		
		

	}

	@Test
	public void TC_02_LoginWithAboveInformation() {
		registerPage.openLoginPage(loginPageUrl);
		
		loginPage = new LoginPageFactory(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayes());
		
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage=new HomePageFactory(driver);
		Assert.assertTrue(homePage.isWebcomeMessageDisplayed());
		
		
	}

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver=opentMultiBrowser(browserName, url);
		email = "seleniumonline" + randomNumber() + "@gmail.com";
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
