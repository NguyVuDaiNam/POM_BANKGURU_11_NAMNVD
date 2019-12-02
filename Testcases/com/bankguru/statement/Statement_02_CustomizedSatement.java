package com.bankguru.statement;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.RegisterLogin_Global;

import commons.AbstractTest;
import commons.Constansts;
import pageObjects.CustomizedStatementPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;

public class Statement_02_CustomizedSatement extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	
	private CustomizedStatementPageObject customizedStatementPage;
	@Test
	public void TC_01_AccountNOCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Account NO");
		customizedStatementPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "accountno");

		log.info("Step 02: Press Tab Account NO");
		customizedStatementPage.DynamicPressTab(driver, "accountno");

		log.info("Step 03: Verify text Account NO");
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Account Number must not be blank"),"Account Number must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_02_AccountNOMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Account NO must be numeric");
		customizedStatementPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "accountno");


		log.info("Step 03: Verify text Account NO");
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_03_AccountNOCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in AccountNO");
		
		customizedStatementPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "accountno");
		
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_04_AccountNOCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Account NO Cannot Have bank spage");
		
		customizedStatementPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, "accountno");
		
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_05_AccountNOFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Account NO First Cannot space");
		
		customizedStatementPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_SENKEY, "accountno");
		
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_06_MinimumTransactionValueCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Minimum Transaction Value");
		customizedStatementPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "amountlowerlimit");

		log.info("Step 02: Press Tab Minimum Transaction Value");
		customizedStatementPage.DynamicPressTab(driver, "accountno");

		//log.info("Step 03: Verify text Minimum Transaction Value");
		//verifyEquals(customizedStatementPage.getDynamicText(driver, "Account Number must not be blank"),"Account Number must not be blank");
		
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_07_MinimumTransactionValueMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Minimum Transaction Value must be numeric");
		customizedStatementPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "amountlowerlimit");


		log.info("Step 02: Verify text Minimum Transaction Value");
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_08_MinimumTransactionValueCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Minimum Transaction Value");
		customizedStatementPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "amountlowerlimit");
		
		log.info("Step 02: Verify text Minimum Transaction Value");
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_09_MinimumTransactionValueCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Minimum Transaction Value Cannot Have bank spage");
		customizedStatementPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, "amountlowerlimit");
		
		log.info("Step 02: Verify text Minimum Transaction Value");
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_10_MinimumTransactionValueFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Minimum Transaction Value First Cannot space");
		customizedStatementPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_SENKEY, "amountlowerlimit");
		
		log.info("Step 02: Verify text Minimum Transaction Value");
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_11_NumberOfTransactionCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Number Of Transaction");
		customizedStatementPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "numtransaction");

		log.info("Step 02: Press Tab Number Of Transaction");
		customizedStatementPage.DynamicPressTab(driver, "accountno");

		//log.info("Step 03: Verify text Number Of Transaction");
		//verifyEquals(customizedStatementPage.getDynamicText(driver, "Account Number must not be blank"),"Account Number must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_12_NumberOfTransactionMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Number Of Transaction must be numeric");
		customizedStatementPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "numtransaction");


		log.info("Step 02: Verify text Number Of Transaction");
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_13_NumberOfTransactionCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Number Of Transaction");
		customizedStatementPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "numtransaction");
		
		log.info("Step 02: Verify text Number Of Transaction");
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_14_NumberOfTransactionCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Number Of Transaction Cannot Have bank spage");
		customizedStatementPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, "numtransaction");
		
		log.info("Step 02: Verify text Number Of Transaction");
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_15_NumberOfTransactionFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Number Of Transaction First Cannot space");
		customizedStatementPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_SENKEY, "numtransaction");
		
		log.info("Step 02: Verify text Number Of Transaction");
		verifyEquals(customizedStatementPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
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
		customizedStatementPage =    (CustomizedStatementPageObject) homePage.openDynamicPage(driver, "Customised Statement");
		
		log.info("Step: Verify Account NO Displayed");
		verifyTrue(customizedStatementPage.isDynamicSuccessfullyPageDisplayed(driver, "Customized Statement Form"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
