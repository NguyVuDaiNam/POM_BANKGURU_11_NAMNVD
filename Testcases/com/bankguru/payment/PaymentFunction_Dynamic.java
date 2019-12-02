package com.bankguru.payment;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.RegisterLogin_Global;

import commons.AbstractTest;
import commons.Constansts;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransterPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.WithdrawPageObject;

public class PaymentFunction_Dynamic extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	public static String customerID,accountID; 
	

	private NewAccountPageObject newAccountPage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private DepositPageObject depositPage;
	private FundTransterPageObject fundTransferPage;
	private WithdrawPageObject withdrawPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;

	@Test
	public void TC_01_NewCustomer(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 1: Click  New Customer");
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");

		log.info("Step 2: Verify New Customer");
		verifyTrue(newCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Add New Customer"));

		log.info("Step 3: Input Customer Name");
		newCustomerPage.inputDynamicText(driver, Constansts.CUSTOMER_NAME_SENKEY, "name");

		log.info("Step 4: Input Date of Birth");
		newCustomerPage.inputDynamicText(driver, Constansts.DATEOFBIRTH_SENKEY, "dob");

		log.info("Step 5: Input Address");
		newCustomerPage.inputDynamicTextArea(driver, Constansts.ADDRESS_SENKEY, "addr");

		log.info("Step 6: Input City");
		newCustomerPage.inputDynamicText(driver, Constansts.CITY_SENKEY, "city");

		log.info("Step 7: Input State");
		newCustomerPage.inputDynamicText(driver, Constansts.STATE_SENKEY, "state");

		log.info("Step 8: Input PIN");
		newCustomerPage.inputDynamicText(driver, Constansts.PIN_SENKEY, "pinno");

		log.info("Step 9: Input Mobile Number");
		newCustomerPage.inputDynamicText(driver, Constansts.MOBILE_SENKEY, "telephoneno");

		log.info("Step 10: Input Email");
		newCustomerPage.inputDynamicText(driver, RegisterLogin_Global.EMAIL, "emailid");

		log.info("Step 11: Input Password");
		newCustomerPage.inputDynamicText(driver, Constansts.PASSWORD_SENKEY, "password");

		log.info("Step 12: Click Submit");
		newCustomerPage.clickDynamicSubmit(driver, "sub");
		
		log.info("Step 13: Verify new Customer Successfully");
		verifyTrue(newCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Customer Registered Successfully!!!"));
		customerID = newCustomerPage.getDynamicTextDisplayed(driver, "Customer ID");

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}

	@Test
	public void TC_02_EditCustomer(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Click  Edit Customer");
		editCustomerPage = (EditCustomerPageObject) homePage.openDynamicPage(driver, "Edit Customer");

		log.info("Step 2: Verify Edit Customer");
		verifyTrue(editCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Edit Customer Form"));

		log.info("Step 3: Input Customer ID");
		editCustomerPage.inputDynamicText(driver, customerID, "cusid");

		log.info("Step 4: Click Submit");
		editCustomerPage.clickDynamicSubmit(driver, "AccSubmit");

		log.info("Step 5: Input Address");
		editCustomerPage.inputDynamicTextArea(driver, Constansts.EDIT_ADDRESS_SENKEY, "addr");

		log.info("Step 6: Input City");
		editCustomerPage.inputDynamicText(driver, Constansts.EDIT_CITY_SENKEY, "city");

		log.info("Step 7: Input State");
		editCustomerPage.inputDynamicText(driver, Constansts.EDIT_STATE_SENKEY, "state");

		log.info("Step 8: Input PIN");
		editCustomerPage.inputDynamicText(driver, Constansts.EDIT_PIN_SENKEY, "pinno");

		log.info("Step 9: Input Mobile Number");
		editCustomerPage.inputDynamicText(driver, Constansts.EDIT_MOBILE_SENKEY, "telephoneno");

		log.info("Step 10: Input Email");
		editCustomerPage.inputDynamicText(driver, RegisterLogin_Global.EMAIL, "emailid");

		log.info("Step 11: Click Submit");
		editCustomerPage.clickDynamicSubmit(driver, "sub");

		log.info("Step 12: Verify Edit Customer Successfully");
		verifyTrue(editCustomerPage.isDynamicSuccessfullyPageDisplayed(driver,"Customer details updated Successfully!!!"));
		customerID = editCustomerPage.getDynamicTextDisplayed(driver, "Customer ID");

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}

	@Test
	public void TC_03_NewAccount(Method testMethod) {

		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Click  New Account");
		newAccountPage =  (NewAccountPageObject) homePage.openDynamicPage(driver, "New Account");

		log.info("Step 2: Verify New Account");
		verifyTrue(newAccountPage.isDynamicSuccessfullyPageDisplayed(driver, "Add new account form"));
		
		log.info("Step 3: Input Customer ID");
		newAccountPage.inputDynamicText(driver, customerID, "cusid");

		log.info("Step 4: Select dropdown");
		newAccountPage.inputDynamicDropdown(driver, "Current","selaccount");
		
		log.info("Step 5: Input Initial deposit");
		newAccountPage.inputDynamicText(driver,Constansts.INITIAL_DEPOSIT_SENKEY, "inideposit");
		
		log.info("Step 6: Click Submit");
		newAccountPage.clickDynamicSubmit(driver, "button2");
		
		log.info("Step 7: Verify New Account Successfully");
		verifyTrue(newAccountPage.isDynamicSuccessfullyPageDisplayed(driver,"Account Generated Successfully!!!"));
		
		log.info("Step 8: Verify current Amount");
		verifyEquals(newAccountPage.getDynamicTextDisplayed(driver, "Current Amount"), Constansts.INITIAL_DEPOSIT_SENKEY);

		accountID=newAccountPage.getDynamicTextDisplayed(driver, "Account ID");
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_04_TransferAndCheck_Deposit(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Click  Deposit");
		depositPage =  (DepositPageObject) homePage.openDynamicPage(driver, "Deposit");

		log.info("Step 2: Verify Deposit");
		verifyTrue(depositPage.isDynamicSuccessfullyPageDisplayed(driver, "Amount Deposit Form"));
		
		log.info("Step 3: Input Account ID");
		depositPage.inputDynamicText(driver, accountID, "accountno");
		
		log.info("Step 4: Input Amount");
		depositPage.inputDynamicText(driver, Constansts.AMOUNT_SENKEY, "ammount");
		
		log.info("Step 5: Input Discription");
		depositPage.inputDynamicText(driver, Constansts.DESCRIPTION_SENKEY, "desc");
		
		log.info("Step 6: Click Submit");
		depositPage.clickDynamicSubmit(driver, "AccSubmit");
		
		log.info("Step 7: Verify Transaction Successfully");
		verifyTrue(depositPage.isDynamicSuccessfullyPageDisplayed(driver,"Transaction details of Deposit for Account "+accountID+""));
		
		log.info("Step 8: Verify current Amount");
		verifyEquals(depositPage.getDynamicTextDisplayed(driver, "Current Balance"), Constansts.AMOUNT_CURRENT_SENKEY);
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_05_WithdrawalAndCheck(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Click  Deposit");
		withdrawPage =   (WithdrawPageObject) homePage.openDynamicPage(driver, "Withdrawal");

		log.info("Step 2: Verify Deposit");
		verifyTrue(withdrawPage.isDynamicSuccessfullyPageDisplayed(driver, "Amount Withdrawal Form"));
		
		log.info("Step 3: Input Account ID");
		withdrawPage.inputDynamicText(driver, accountID, "accountno");
		
		log.info("Step 4: Input Amount");
		withdrawPage.inputDynamicText(driver, Constansts.AMOUNT_WITHDRAWAL_SENKEY, "ammount");
		
		log.info("Step 5: Input Discription");
		withdrawPage.inputDynamicText(driver, Constansts.DESCRIPTION_SENKEY, "desc");
		
		log.info("Step 6: Click Submit");
		withdrawPage.clickDynamicSubmit(driver, "AccSubmit");
		
		log.info("Step 7: Verify Transaction Successfully");
		verifyTrue(withdrawPage.isDynamicSuccessfullyPageDisplayed(driver,"Transaction details of Withdrawal for Account "+accountID+""));
		
		log.info("Step 8: Verify current Amount");
		verifyEquals(withdrawPage.getDynamicTextDisplayed(driver, "Current Balance"), Constansts.AMOUNT_CURRENT_WITHDRAW_SENKEY);
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_06_TransferIntoAnotherAccountAndCheck(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Click  Fund Transfer");
		fundTransferPage =    (FundTransterPageObject) homePage.openDynamicPage(driver, "Fund Transfer");

		log.info("Step 2: Verify Fund Transfer");
		verifyTrue(fundTransferPage.isDynamicSuccessfullyPageDisplayed(driver, "Fund transfer"));
		
		log.info("Step 3: Input Payers account ID");
		fundTransferPage.inputDynamicText(driver, accountID, "payersaccount");
		
		log.info("Step 4: Input Payees account");
		String accountID_Before=Integer.parseInt(accountID)-1+"";
		fundTransferPage.inputDynamicText(driver, accountID_Before, "payeeaccount");
		
		log.info("Step 5: Input Amount");
		fundTransferPage.inputDynamicText(driver, Constansts.AMOUNT_FUND_TRANSFER_SENKEY, "ammount");
		
		log.info("Step 6: Input Discription");
		fundTransferPage.inputDynamicText(driver, Constansts.DESCRIPTION_FUND_TRANSFER_SENKEY, "desc");
		
		log.info("Step 7: Click Submit");
		fundTransferPage.clickDynamicSubmit(driver, "AccSubmit");
		
		log.info("Step 8: Verify Transaction Successfully");
		verifyTrue(fundTransferPage.isDynamicSuccessfullyPageDisplayed(driver,"Fund Transfer Details"));
		
		log.info("Step 9: Verify current Amount");
		verifyEquals(fundTransferPage.getDynamicTextDisplayed(driver, "Amount"), Constansts.AMOUNT_FUND_TRANSFER_SENKEY);
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_07_CheckBalance(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Click Balance Enquiry");
		balanceEnquiryPage =    (BalanceEnquiryPageObject) homePage.openDynamicPage(driver, "Balance Enquiry");

		log.info("Step 2: Verify Balance Enquiry");
		verifyTrue(balanceEnquiryPage.isDynamicSuccessfullyPageDisplayed(driver, "Balance Enquiry Form"));
		
		log.info("Step 3: Input  account ID");
		balanceEnquiryPage.inputDynamicText(driver, accountID, "accountno");
		
		log.info("Step 4: Click Submit");
		balanceEnquiryPage.clickDynamicSubmit(driver, "AccSubmit");
		
		log.info("Step 5: Verify Transaction Successfully");
		verifyTrue(balanceEnquiryPage.isDynamicSuccessfullyPageDisplayed(driver,"Balance Details for Account "+accountID+""));
		
		log.info("Step 6: Verify current Amount");
		verifyEquals(balanceEnquiryPage.getDynamicTextDisplayed(driver, "Balance"), Constansts.BALANCE_SENKEY);
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_08_DeleteAllAccountAndCheck(Method testMethod) throws Exception {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Click Delete Account");
		deleteAccountPage =   (DeleteAccountPageObject) homePage.openDynamicPage(driver, "Delete Account");

		log.info("Step 2: Verify Delete Account");
		verifyTrue(deleteAccountPage.isDynamicSuccessfullyPageDisplayed(driver, "Delete Account Form"));
		
		log.info("Step 3: Input  account ID");
		deleteAccountPage.inputDynamicText(driver, accountID, "accountno");
		
		log.info("Step 4: Click Submit");
		deleteAccountPage.clickDynamicSubmit(driver, "AccSubmit");
		Thread.sleep(3000);
		
		log.info("Step 5: Accep Alert");
		deleteAccountPage.AccepAlertwait(driver);
		Thread.sleep(3000);
		
		log.info("Step 6: Verify Account Deleted Sucessfully");
		verifyEquals(deleteAccountPage.getAlert(driver),"Account Deleted Sucessfully");
		
		log.info("Step 7: Accep Alert Account Deleted Sucessfully");
		Thread.sleep(3000);
		deleteAccountPage.AccepAlertwait(driver);
		
		log.info("Step 8: Welcome Home Page");
		homePage=(HomePageObject) deleteAccountPage.openDynamicPage(driver, "Manager");
		verifyTrue(homePage.isHomePageDisplayed());

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	
	@Test
	public void TC_09_DeleteExistCustomerAccountAndCheck(Method testMethod) throws Exception {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Click Delete Customer");
		deleteCustomerPage =  (DeleteCustomerPageObject) homePage.openDynamicPage(driver, "Delete Customer");

		log.info("Step 2: Verify Delete Customer");
		verifyTrue(deleteCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Delete Customer Form"));
		
		log.info("Step 3: Input Customer ID");
		deleteCustomerPage.inputDynamicText(driver, customerID, "cusid");
		
		log.info("Step 4: Click Submit");
		deleteCustomerPage.clickDynamicSubmit(driver, "AccSubmit");
		Thread.sleep(3000);
		
		log.info("Step 5: Accep Alert");
		deleteCustomerPage.AccepAlertwait(driver);
		Thread.sleep(3000);
		
		log.info("Step 6: Verify Customer Deleted Sucessfully");
		verifyEquals(deleteCustomerPage.getAlert(driver),"Customer deleted Successfully");
		
		log.info("Step 7: Accep Alert Customer Deleted Sucessfully");
		Thread.sleep(3000);
		deleteCustomerPage.AccepAlertwait(driver);

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
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
