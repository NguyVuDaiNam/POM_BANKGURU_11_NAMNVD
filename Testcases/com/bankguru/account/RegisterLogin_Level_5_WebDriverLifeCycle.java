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
import pageObjects.DepositPageObject;
import pageObjects.FundTransterPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterLogin_Level_5_WebDriverLifeCycle extends AbstractTest {
	private WebDriver driver;
	private AbstractPage abstractPage;
	private String email, UserID, password, LoginURL;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private FundTransterPageObject fundTransferPage;
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
	public void TC_03_WebDriverLifeCycle() {
		//NewCustomer > newAccount > Depsit > FundTransfer > homepage > newAccount
		newCustomerPage=homePage.openNewCustomerPage(driver);
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		newAccountPage=newCustomerPage.openNewAccountPage(driver);
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
		
		depositPage=newAccountPage.openDepositPage(driver);
		Assert.assertTrue(depositPage.isNewDepositPageDisplayed());
		
		fundTransferPage=depositPage.openFundTransferPage(driver);
		Assert.assertTrue(fundTransferPage.isFundTransferDisplayed());
		
		homePage=fundTransferPage.openHomePage(driver);
		Assert.assertTrue(homePage.isHomePageDisplayed());
		
		newAccountPage=homePage.openNewAccountPage(driver);
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
	}

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver=opentMultiBrowser(browserName,url);
		email = "seleniumonline" + randomNumber() + "@gmail.com";
		loginPage =PageFactoryManager.getLoginPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
