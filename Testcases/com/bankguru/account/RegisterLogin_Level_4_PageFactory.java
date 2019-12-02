package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterLogin_Level_4_PageFactory extends AbstractTest {
	private WebDriver driver;
	private AbstractPage abstractPage;
	private String email, UserID, password, LoginURL;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
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
	public void Account_03_OpenMultiplePages() {
		
	}

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName,String url) {
		driver=opentMultiBrowser(browserName,url);
		email = "seleniumonline" + randomNumber() + "@gmail.com";
		loginPage =PageFactoryManager.getLoginPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
