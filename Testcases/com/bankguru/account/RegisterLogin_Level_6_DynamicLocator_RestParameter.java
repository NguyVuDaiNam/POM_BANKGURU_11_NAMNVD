package com.bankguru.account;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.DepositPageObject;
import pageObjects.FundTransterPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterLogin_Level_6_DynamicLocator_RestParameter extends AbstractTest {
	private WebDriver driver;
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
	@Test
	public void TC_04_DynamicLocatorFewPage() {
		//NewCustomer > newAccount > Depsit > FundTransfer > homepage > newAccount
		
		newCustomerPage=(NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		newAccountPage=(NewAccountPageObject) newCustomerPage.openDynamicPage(driver, "New Account");
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
	
		depositPage=(DepositPageObject) newAccountPage.openDynamicPage(driver, "Deposit");
		Assert.assertTrue(depositPage.isNewDepositPageDisplayed());

		fundTransferPage=(FundTransterPageObject) depositPage.openDynamicPage(driver, "Fund Transfer");
		Assert.assertTrue(fundTransferPage.isFundTransferDisplayed());
	
		homePage=(HomePageObject) fundTransferPage.openDynamicPage(driver, "Manager");
		Assert.assertTrue(homePage.isHomePageDisplayed());
	
		newAccountPage=(NewAccountPageObject) homePage.openDynamicPage(driver, "New Account");
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
	}
	@Test
	public void TC_05_DynamicLocatorManyPage() {
		//NewCustomer > newAccount > Depsit > FundTransfer > homepage > newAccount
	
		homePage.openDynamicMorePage(driver, "New Customer");
		newCustomerPage=PageFactoryManager.getNewCustomerPage(driver);
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		newCustomerPage.openDynamicMorePage(driver, "New Account");
		newAccountPage=PageFactoryManager.getNewAccountPage(driver);
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
		
		newAccountPage.openDynamicMorePage(driver, "Deposit");
		depositPage=PageFactoryManager.getDepositPage(driver);
		Assert.assertTrue(depositPage.isNewDepositPageDisplayed());
		
		depositPage.openDynamicMorePage(driver, "Fund Transfer");
		fundTransferPage=PageFactoryManager.getFundTransferPage(driver);
		Assert.assertTrue(fundTransferPage.isFundTransferDisplayed());
		
		fundTransferPage.openDynamicMorePage(driver, "Manager");
		homePage=PageFactoryManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageDisplayed());
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
