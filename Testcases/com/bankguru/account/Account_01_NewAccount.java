package com.bankguru.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.customer.Customer_01_NewCustomer;

import commons.AbstractTest;
import commons.Constansts;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.PageFactoryManager;

public class Account_01_NewAccount extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	public static String  ACCOUNT_NO;

	private NewAccountPageObject newAccountPage;

	@Test
	public void TC_01_CustomerIDCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Customer ID");
		newAccountPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "cusid");

		log.info("Step 02: Press Tab Customer ID");
		newAccountPage.DynamicPressTab(driver, "cusid");

		log.info("Step 03: Verify text Customer ID");
		verifyEquals(newAccountPage.getDynamicText(driver, "Customer ID is required"),"Customer ID is required");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_02_CustomerIDMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Customer ID must be numeric");
		newAccountPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "cusid");


		log.info("Step 03: Verify text Customer ID");
		verifyEquals(newAccountPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_03_CustomerIDCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in CustomerID");
		
		newAccountPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "cusid");
		
		verifyEquals(newAccountPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_04_CustomerIDCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Customer ID Cannot Have bank spage");
		
		newAccountPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, "cusid");
		
		verifyEquals(newAccountPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_05_CustomerIDFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Customer ID First Cannot space");
		
		newAccountPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_NUMMER_SENKEY, "cusid");
		
		verifyEquals(newAccountPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_06_InitialDepositCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value InitialDeposit");
		newAccountPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "inideposit");

		log.info("Step 02: Press Tab Initial Deposit");
		newAccountPage.DynamicPressTab(driver, "inideposit");

		log.info("Step 03: Verify text Initial Deposit");
		verifyEquals(newAccountPage.getDynamicText(driver, "Initial Deposit must not be blank"),"Initial Deposit must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_07_InitialDepositMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Initial Deposit must be numeric");
		newAccountPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "inideposit");


		log.info("Step 03: Verify text Initial Deposit");
		verifyEquals(newAccountPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_08_InitialDepositCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in InitialDeposit");
		
		newAccountPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "inideposit");
		
		verifyEquals(newAccountPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_09_InitialDepositCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Initial Deposit Cannot Have bank spage");
		
		newAccountPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, "inideposit");
		
		verifyEquals(newAccountPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_10_InitialDepositFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Initial Deposit First Cannot space");
		
		newAccountPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_NUMMER_SENKEY, "inideposit");
		
		verifyEquals(newAccountPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_11_ValidNewAccount(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Enter valid CustomerID");
		newAccountPage.inputDynamicText(driver, Customer_01_NewCustomer.CUSTOMER_ID, "cusid");
		newAccountPage.inputDynamicText(driver, Constansts.INITIAL_DEPOSIT_SENKEY, "inideposit");
		
		log.info("Step 02: Click Submit");
		newAccountPage.clickDynamicSubmit(driver, "button2");
		
			
		log.info("Step 05: Verify  New Account");
		verifyTrue(newAccountPage.isDynamicSuccessfullyPageDisplayed(driver, "Account Generated Successfully!!!"));
		
		ACCOUNT_NO=newAccountPage.getDynamicTextDisplayed(driver, "Account ID");
		log.info("ACCOUNT_NO: " +ACCOUNT_NO);
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName,String url) {
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

		log.info("Step: Click  New Acount");
		newAccountPage =  (NewAccountPageObject) homePage.openDynamicPage(driver, "New Account");
		
		log.info("Step: Verify new account Displayed");
		verifyTrue(newAccountPage.isDynamicSuccessfullyPageDisplayed(driver, "Add new account form"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
