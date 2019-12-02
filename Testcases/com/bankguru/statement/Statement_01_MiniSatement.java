package com.bankguru.statement;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.Account_01_NewAccount;
import com.bankguru.account.RegisterLogin_Global;

import commons.AbstractTest;
import commons.Constansts;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MiniStatementPageObject;
import pageObjects.PageFactoryManager;

public class Statement_01_MiniSatement extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	
	private MiniStatementPageObject miniStatementPage;
	@Test
	public void TC_01_AccountNOCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Account NO");
		miniStatementPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "accountno");

		log.info("Step 02: Press Tab Account NO");
		miniStatementPage.DynamicPressTab(driver, "accountno");

		log.info("Step 03: Verify text Account NO");
		verifyEquals(miniStatementPage.getDynamicText(driver, "Account Number must not be blank"),"Account Number must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_02_AccountNOMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Account NO must be numeric");
		miniStatementPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "accountno");


		log.info("Step 03: Verify text Account NO");
		verifyEquals(miniStatementPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_03_AccountNOCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in AccountNO");
		
		miniStatementPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "accountno");
		
		verifyEquals(miniStatementPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_04_AccountNOCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Account NO Cannot Have bank spage");
		
		miniStatementPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, "accountno");
		
		verifyEquals(miniStatementPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_05_AccountNOFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Account NO First Cannot space");
		
		miniStatementPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_SENKEY, "accountno");
		
		verifyEquals(miniStatementPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_06_MiniStatementValid(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Account NO valid");
		
		miniStatementPage.inputDynamicText(driver,Account_01_NewAccount.ACCOUNT_NO, "accountno");

		log.info("Step 02: Click Submit");
		miniStatementPage.clickDynamicSubmit(driver, "AccSubmit");

			
		log.info("Step 05: Verify Account NO");
		
		verifyTrue(miniStatementPage.isDynamicSuccessfullyPageDisplayed(driver, "Last Five Transaction Details for Account No: "+Account_01_NewAccount.ACCOUNT_NO));
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
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

		log.info("Step: Click  Account NO");
		miniStatementPage =   (MiniStatementPageObject) homePage.openDynamicPage(driver, "Mini Statement");
		
		log.info("Step: Verify Mini Statement Displayed");
		verifyTrue(miniStatementPage.isDynamicSuccessfullyPageDisplayed(driver, "Mini Statement Form"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
