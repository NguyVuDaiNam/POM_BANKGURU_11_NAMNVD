package com.bankguru.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
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

public class RegisterLogin_Level_10_DynamicPageObject_PageElement_PageUI extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private String customerName, gender, dateOfBirth, address, email, city, state, pin, phone, password, genderValue;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private FundTransterPageObject fundTransferPage;
	public static String CUSTOMER_ID;

	@Test(description = "TC_03_ New Customer")
	public void TC_03_DynamicPageObjectPageElementPageUI(Method testMethod) {
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		verifyTrue(newCustomerPage.isNewCustomerPageDisplayed());

		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Enter valid Customer Name");
		newCustomerPage.inputDynamicText(driver, customerName, "name");

		log.info("Step 02: Enter valid gender");
		newCustomerPage.clickDynamicRadio(driver, gender, "f");

		log.info("Step 03: Enter valid  Date of birth");
		newCustomerPage.inputDynamicText(driver, dateOfBirth, "dob");

		log.info("Step 04: Enter valid Address");
		newCustomerPage.inputDynamicTextArea(driver, address, "addr");

		log.info("Step 05: Enter valid city");
		newCustomerPage.inputDynamicText(driver, city, "city");

		log.info("Step 06: Enter valid State");
		newCustomerPage.inputDynamicText(driver, state, "state");

		log.info("Step 07: Enter valid PIN");
		newCustomerPage.inputDynamicText(driver, pin, "pinno");

		log.info("Step 08: Enter valid Mobile");
		newCustomerPage.inputDynamicText(driver, phone, "telephoneno");

		log.info("Step 09: Enter valid Email");
		newCustomerPage.inputDynamicText(driver, email, "emailid");

		log.info("Step 10: Enter valid Password");
		newCustomerPage.inputDynamicText(driver, password, "password");

		log.info("Step 11: Click button submit");
		newCustomerPage.clickDynamicSubmit(driver, "sub");

		log.info("Step 12: Verify successfully new Customer");
		verifyTrue(newCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Customer Registered Successfully!!!"));

		CUSTOMER_ID = newCustomerPage.getDynamicTextDisplayed(driver, "Customer ID");
		log.info("CUSTOMER_ID : " + CUSTOMER_ID);

		log.info("Step 13: Verify Customer name");
		verifyEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Customer Name"), customerName);

		log.info("Step 14: Verify gender");
		verifyEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Gender"), genderValue);

		log.info("Step 15: Verify Date of Birth");
		verifyEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Birthdate"), dateOfBirth);

		log.info("Step 16: Verify Adddress");
		verifyEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Address"), address);

		log.info("Step 17: Verify city");
		verifyEquals(newCustomerPage.getDynamicTextDisplayed(driver, "City"), city);

		log.info("Step 18: Verify State");
		verifyEquals(newCustomerPage.getDynamicTextDisplayed(driver, "State"), state);

		log.info("Step 19: Verify Pin");
		verifyEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Pin"), pin);

		log.info("Step 20: Verify Mobile No");
		verifyEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Mobile No."), phone);

		log.info("Step 21: Verify Email");
		verifyEquals(newCustomerPage.getDynamicTextDisplayed(driver, "Email"), email);

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}

	@Test
	public void TC_04_OpenDynamicCheckPageDisplayed(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== "); 
		
		log.info("Step 01: Click New Customer");
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		log.info("Step 02: Verify New Customer");
		verifyTrue(newCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Add New Customer"));

		log.info("Step 03: Click New Account");
		newAccountPage = (NewAccountPageObject) newCustomerPage.openDynamicPage(driver, "New Account");
		log.info("Step 04: Verify New Account");
		verifyTrue(newAccountPage.isDynamicSuccessfullyPageDisplayed(driver, "Add new account form"));

		log.info("Step 05: Click Deposit");
		depositPage = (DepositPageObject) newAccountPage.openDynamicPage(driver, "Deposit");
		log.info("Step 06: Verify Deposit");
		verifyTrue(depositPage.isDynamicSuccessfullyPageDisplayed(driver, "Amount Deposit Form"));

		log.info("Step 07: Click Fund Transfer");
		fundTransferPage = (FundTransterPageObject) depositPage.openDynamicPage(driver, "Fund Transfer");
		log.info("Step 08: Verify Fund Transfer");
		verifyTrue(fundTransferPage.isDynamicSuccessfullyPageDisplayed(driver, "Fund transfer"));
		log.info("============== AND: " + testMethod.getName() + " ============== "); 

	}

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = opentMultiBrowser(browserName, url);
		email = "seleniumonline" + randomNumber() + "@gmail.com";

		loginPage = PageFactoryManager.getLoginPage(driver);

		loginPage.inputToUserIDTextbox(RegisterLogin_Global.USER_ID);

		loginPage.inputToPasswordTextbox(RegisterLogin_Global.PASSWORD);

		homePage = loginPage.clickToLoginButton();

		verifyTrue(homePage.isHomePageDisplayed());

		customerName = "Selenium Online fg";
		gender = "f";
		dateOfBirth = "2000-01-01";
		address = "258 Le Duan";
		city = "Sai Gon";
		state = "Thu Duc";
		pin = "258435";
		phone = "0163245987";
		password = "123456";
		email = "Dangnm12565@gmail.com";
		gender = "f";
		genderValue = "female";
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
