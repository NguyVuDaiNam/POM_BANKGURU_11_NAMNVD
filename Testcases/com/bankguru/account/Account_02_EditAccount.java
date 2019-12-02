package com.bankguru.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constansts;
import pageObjects.EditAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;

public class Account_02_EditAccount extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	
	private EditAccountPageObject  editAccountPage;
	@Test
	public void TC_01_AccountNOCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Customer ID");
		editAccountPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "accountno");

		log.info("Step 02: Press Tab Customer ID");
		editAccountPage.DynamicPressTab(driver, "accountno");

		log.info("Step 03: Verify text Account NO");
		verifyEquals(editAccountPage.getDynamicText(driver, "Account Number must not be blank"),"Account Number must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_02_AccountNOMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Account NO must be numeric");
		editAccountPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "accountno");


		log.info("Step 03: Verify text Account NO");
		verifyEquals(editAccountPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_03_AccountNOCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in AccountNO");
		
		editAccountPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "accountno");
		
		verifyEquals(editAccountPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_04_AccountNOCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Account NO Cannot Have bank spage");
		
		editAccountPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, "accountno");
		
		verifyEquals(editAccountPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_05_AccountNOFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Account NO First Cannot space");
		
		editAccountPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_SENKEY, "accountno");
		
		verifyEquals(editAccountPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_06_AccountNOValid(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Account NO valid");
		
		editAccountPage.inputDynamicText(driver,Account_01_NewAccount.ACCOUNT_NO, "accountno");

		log.info("Step 02: Click Submit");
		editAccountPage.clickDynamicSubmit(driver, "AccSubmit");
		
		log.info("Step 03: Verify valid edit Account");
		verifyTrue(editAccountPage.isDynamicSuccessfullyPageDisplayed(driver, "Edit Account Entry Form"));
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	////
	@Test
	public void TC_07_CustomerIDCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info(" DO NOT ALLOW REPAIR");
/*
		log.info("Step 01: Do not enter a value Customer ID");
		editAccountPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "txtcid");

		log.info("Step 02: Press Tab Customer ID");
		editAccountPage.DynamicPressTab(driver, "txtcid");

		log.info("Step 03: Verify text Customer ID");
		verifyEquals(editAccountPage.getDynamicText(driver, "Customer ID is required"),"Customer ID is required");
			*/	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_08_CustomerIDMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info(" DO NOT ALLOW REPAIR");
		/*
		log.info("Step 01: Customer ID must be numeric");
		editAccountPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "txtcid");


		log.info("Step 03: Verify text Customer ID");
		verifyEquals(editAccountPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
		*/		
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_09_CustomerIDCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		log.info(" DO NOT ALLOW REPAIR");
		/*
		log.info("Step 01: Cannot Special Character value in CustomerID");
		
		editAccountPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "txtcid");
		
		verifyEquals(editAccountPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		*/
		log.info("============== AND: "+testMethod.getName()+" ============== ");
		
	}
	@Test
	public void TC_10_CustomerIDCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		log.info(" DO NOT ALLOW REPAIR");
		/*
		log.info("Step 01: Customer ID Cannot Have bank spage");
		
		editAccountPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, "txtcid");
		
		verifyEquals(editAccountPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		*/
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_11_CustomerIDFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		log.info(" DO NOT ALLOW REPAIR");
		/*
		log.info("Step 01: Customer ID First Cannot space");
		
		editAccountPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_NUMMER_SENKEY, "txtcid");
		
		verifyEquals(editAccountPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		*/
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	
	///
	
	@Test
	public void TC_12_BalanceCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info(" DO NOT ALLOW REPAIR");
		/*
		log.info("Step 01: Do not enter a value Balance");
		editAccountPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "inideposit");

		log.info("Step 02: Press Tab Initial Deposit");
		editAccountPage.DynamicPressTab(driver, "inideposit");

		log.info("Step 03: Verify text Initial Deposit");
		verifyEquals(editAccountPage.getDynamicText(driver, "Initial Deposit must not be blank"),"Initial Deposit must not be blank");
				*/
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_13_BalanceMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info(" DO NOT ALLOW REPAIR");
		/*
		log.info("Step 01: Initial Deposit must be numeric");
		editAccountPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "inideposit");


		log.info("Step 03: Verify text Initial Deposit");
		verifyEquals(editAccountPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				*/
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_14_BalanceCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		log.info(" DO NOT ALLOW REPAIR");
		/*
		log.info("Step 01: Cannot Special Character value in Balance");
		
		editAccountPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "inideposit");
		
		verifyEquals(editAccountPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		*/
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_15_BalanceCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		log.info(" DO NOT ALLOW REPAIR");
		/*
		log.info("Step 01: Initial Deposit Cannot Have bank spage");
		
		editAccountPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, "inideposit");
		
		verifyEquals(editAccountPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		*/
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_16_BalanceFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		log.info(" DO NOT ALLOW REPAIR");
		/*
		log.info("Step 01: Initial Deposit First Cannot space");
		
		editAccountPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_NUMMER_SENKEY, "inideposit");
		
		verifyEquals(editAccountPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		*/
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_17_EditAccountValid(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Click Submit");
		editAccountPage.clickDynamicSubmit(driver, "AccSubmit");
		
		log.info("Step 02: Accep alert ");
		editAccountPage.acceptAlert(driver);
		
		log.info("Step 03: Verify valid edit Account");
		verifyTrue(editAccountPage.isDynamicSuccessfullyPageDisplayed(driver, "Edit Account Form"));
					
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName,String url) {
		log.info("============== START: LOGIN ============== ");
		driver = opentMultiBrowser(browserName,url);
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

		log.info("Step: Click  Edit Acount");
		editAccountPage =  (EditAccountPageObject) homePage.openDynamicPage(driver, "Edit Account");
		
		log.info("Step: Verify Edit account Displayed");
		verifyTrue(editAccountPage.isDynamicSuccessfullyPageDisplayed(driver, "Edit Account Form"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
