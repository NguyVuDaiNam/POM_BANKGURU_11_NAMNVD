package com.bankguru.fundTransfer;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.RegisterLogin_Global;

import commons.AbstractTest;
import commons.Constansts;
import pageObjects.FundTransterPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;

public class FundTransfer_01_FundTransfer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private String PayersAccountNumber_Locator="payersaccount";
	private String PayeeAccountNumber_Locator="payeeaccount";
	private String Amount_Locator="ammount";
	
	
	
	private FundTransterPageObject fundTransterPage;
	@Test
	public void TC_01_PayersAccountNumberCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Payers Account Number");
		fundTransterPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, PayersAccountNumber_Locator);

		log.info("Step 02: Press Tab Payers Account Number");
		fundTransterPage.DynamicPressTab(driver, PayersAccountNumber_Locator);

		log.info("Step 03: Verify text Payers Account Number");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Payers Account Number must not be blank"),"Payers Account Number must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_02_PayersAccountNumberMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Payers Account Number must be numeric");
		fundTransterPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, PayersAccountNumber_Locator);


		log.info("Step 02: Verify text Payers Account Number");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_03_PayersAccountNumberCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Payers Account Number");
		
		fundTransterPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, PayersAccountNumber_Locator);
		
		verifyEquals(fundTransterPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_04_PayersAccountNumberCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Payers Account Number Cannot Have bank spage");
		
		fundTransterPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, PayersAccountNumber_Locator);
		
		verifyEquals(fundTransterPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_05_PayersAccountNumberFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Payers Account Number First Cannot space");
		
		fundTransterPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_SENKEY, "payersaccount");
		
		verifyEquals(fundTransterPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_06_PayeesAccountNumberCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Payees Account Number");
		fundTransterPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, PayeeAccountNumber_Locator);

		log.info("Step 02: Press Tab Payees Account Number");
		fundTransterPage.DynamicPressTab(driver, PayeeAccountNumber_Locator);

		log.info("Step 03: Verify text Payers Account Number");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Payees Account Number must not be blank"),"Payees Account Number must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_07_PayeesAccountNumberMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Payees Account Number must be numeric");
		fundTransterPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, PayeeAccountNumber_Locator);


		log.info("Step 02: Verify text Payees Account Number");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_08_PayeesAccountNumberCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Payees Account Number");
		fundTransterPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, PayeeAccountNumber_Locator);
		
		log.info("Step 02: Verify text Payees Account");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_09_PayeesAccountNumberCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Payees Account Number Cannot Have bank spage");
		fundTransterPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, PayeeAccountNumber_Locator);
		
		log.info("Step 02: Verify text Payees Account");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_10_PayeesAccountNumberFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Payees Account Number First Cannot space");
		fundTransterPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_SENKEY, PayeeAccountNumber_Locator);
		
		log.info("Step 02: Verify text Payees Account");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_11_AmountCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Amount");
		fundTransterPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, Amount_Locator);

		log.info("Step 02: Press Tab Amount");
		fundTransterPage.DynamicPressTab(driver, Amount_Locator);

		log.info("Step 03: Verify text Amount");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Amount field must not be blank"),"Amount field must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_12_AmountMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Amount must be numeric");
		fundTransterPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, Amount_Locator);


		log.info("Step 02: Verify text Amount");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_13_AmountCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Amount");
		fundTransterPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, Amount_Locator);
		
		log.info("Step 02: Verify text Amount");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_14_AmountCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Amount Cannot Have bank spage");
		fundTransterPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, Amount_Locator);
		
		log.info("Step 02: Verify text Amount");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_15_AmountFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Amount Amount");
		fundTransterPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_SENKEY, Amount_Locator);
		
		log.info("Step 02: Verify text Amount");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_16_DescriptionCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Descriptior");
		fundTransterPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "desc");

		log.info("Step 02: Press Tab Descriptio");
		fundTransterPage.DynamicPressTab(driver, "desc");

		log.info("Step 03: Verify text Descriptio");
		verifyEquals(fundTransterPage.getDynamicText(driver, "Description can not be blank"),"Description can not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
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
		fundTransterPage =    (FundTransterPageObject) homePage.openDynamicPage(driver, "Fund Transfer");
		
		log.info("Step: Verify Account NO Displayed");
		verifyTrue(fundTransterPage.isDynamicSuccessfullyPageDisplayed(driver, "Fund transfer"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
