package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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

public class PaymentFunction extends AbstractTest {
	private WebDriver driver;
		
	private String email, loginURL,customerID, accountID;
	private LoginPageObject loginPage;
		private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private FundTransterPageObject fundTransferPage;
	private WithdrawPageObject withdrawPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;
	
	@Test
	public void TC_01_NewCustomer() {
		
		newCustomerPage=(NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		newCustomerPage.senkeyDynamicPage(driver, "name");
		newCustomerPage.inputDateOfBirthText();
		newCustomerPage.inputAdressTextArea();
		newCustomerPage.inputCityText();
		newCustomerPage.inputStateText();
		newCustomerPage.inputPinText();
		newCustomerPage.inputMobileText();
		newCustomerPage.inputEmailText(email);
		newCustomerPage.inputPasswordText();
		newCustomerPage.clicksubmitButton();
		Assert.assertTrue(newCustomerPage.isNewCustomerSuccessfullyPageDisplayed());
		customerID=newCustomerPage.getCustomerIDText();
	}
	@Test
	public void TC_02_EditCustomerAndCheckSuccessfully() {
		editCustomerPage=(EditCustomerPageObject) newCustomerPage.openDynamicPage(driver, "Edit Customer");
		Assert.assertTrue(editCustomerPage.isEditCustomerPageDisplayed());
		
		editCustomerPage.inputCustomerIDText(customerID);
		editCustomerPage.clickCustomerIDSubmit();
		
		editCustomerPage.inputEditAdressTextArea();
		editCustomerPage.inputEditCityText();
		editCustomerPage.inputEditStateText();
		editCustomerPage.inputEditMobileText();
		editCustomerPage.inputEditEmailText(email);
		editCustomerPage.clickCustomerIDSubmit();
		Assert.assertTrue(editCustomerPage.isEditCustomerSuccessfullyPageDisplayed());
	}
	@Test
	public void TC_03_NewAccountAndCheckSuccessfullyThenCurrentAmountEqualInitialDeposit() {
		newAccountPage=(NewAccountPageObject) editCustomerPage.openDynamicPage(driver, "New Account");
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
		
		newAccountPage.inputCustomerID(customerID);
		newAccountPage.inputAccountType();
		newAccountPage.inpuInitialDeposit();
		newAccountPage.clickNewAccountSubmit();
		
		newAccountPage.isNewAccountSuccessefullyPageDisplayed();
		newAccountPage.isCurrentAmountPageDisplayed();
		Assert.assertEquals(newAccountPage.getCurrentAmount(), Constansts.INITIAL_DEPOSIT_SENKEY);
		accountID=newAccountPage.getAccountIDText();
	
	}
	@Test
	public void TC_04_TransferAndCheck_Deposit() {
		
		depositPage=(DepositPageObject) newAccountPage.openDynamicPage(driver, "Deposit");
		Assert.assertTrue(depositPage.isNewDepositPageDisplayed());
		
		depositPage.inputAccountID(accountID);
		depositPage.inputAmount();
		depositPage.inputDescription();
		depositPage.clickSubmitDeposit();
		
		Assert.assertTrue(depositPage.isTransactionSuccessfullyPageDisplayed("//p[text()='Transaction details of Deposit for Account "+accountID+"']"));
		Assert.assertEquals(depositPage.getCurrentBalance(), "55000");
		//depositPage.getTransactionID();
		//depositPage.getCurrentBalance();
	}
	@Test
	public void TC_05_WithdrawalAndCheck() {
		withdrawPage=(WithdrawPageObject) depositPage.openDynamicPage(driver, "Withdrawal");
		Assert.assertTrue(withdrawPage.isWithdrawalPageDisplayed());
		
		withdrawPage.inputAccountID(accountID);
		withdrawPage.inputAmount();
		withdrawPage.inputDescription();
		withdrawPage.clickSubmitWithdrawal();
		
		Assert.assertTrue(withdrawPage.isTransactionSuccessfullyPageDisplayed("//p[text()='Transaction details of Withdrawal for Account "+accountID+"']"));
		Assert.assertEquals(depositPage.getCurrentBalance(), "40000");
		//depositPage.getTransactionID();
		//depositPage.getCurrentBalance();
	}
	@Test
	public void TC_06_TransferIntoAnotherAccountAndCheck() {
		fundTransferPage=(FundTransterPageObject) withdrawPage.openDynamicPage(driver, "Fund Transfer");
		Assert.assertTrue(fundTransferPage.isFundTransferDisplayed());
		
		fundTransferPage.inputPayersAccount(accountID);
		fundTransferPage.inputPayeessAccount();
		fundTransferPage.inputAmount();
		fundTransferPage.inputDescription();
		fundTransferPage.clickSubmit();
		
		Assert.assertTrue(fundTransferPage.isTransactionSuccessfullyPageDisplayed());
		Assert.assertEquals(fundTransferPage.getAmountFundTranster(), "10000");
		//fundTransferPage.getFromAccount();
		//fundTransferPage.getToAccount();
		
	}
	@Test
	public void TC_07_CheckBalance() {
		balanceEnquiryPage=(BalanceEnquiryPageObject) fundTransferPage.openDynamicPage(driver, "Balance Enquiry");
		Assert.assertTrue(balanceEnquiryPage.isBalanceEnquiryDisplayed());
		
		balanceEnquiryPage.inputAccountID(accountID);
		balanceEnquiryPage.clickSubmit();
		
		Assert.assertTrue(balanceEnquiryPage.isBalanceEnquirySuccessfullyPageDisplayed("//p[text()='Balance Details for Account "+accountID+"']"));
		Assert.assertEquals(balanceEnquiryPage.getBalanceEnquiry(), "30000");
	}
	@Test
	public void TC_08_DeleteAllAccountAndCheck() throws Exception {
		deleteAccountPage=(DeleteAccountPageObject) balanceEnquiryPage.openDynamicPage(driver, "Delete Account");
		Assert.assertTrue(deleteAccountPage.isDeleteAccountDisplayed());
		
		deleteAccountPage.inputAccountID(accountID);
		deleteAccountPage.clickSubmit();
		Thread.sleep(3000);
		deleteAccountPage.AcceptDeleteAccountPageDisplayed();
		Assert.assertEquals(deleteAccountPage.getDeleteAccountSuccessfullyPageDisplayed(), "Account Deleted Sucessfully");
		Thread.sleep(3000);
		deleteAccountPage.AcceptDeleteAccountSuccessfullyPageDisplayed();
		
		homePage=(HomePageObject) deleteAccountPage.openDynamicPage(driver, "Manager");
		Assert.assertTrue(homePage.isHomePageDisplayed());
		
	}
	@Test
	public void TC_09_DeleteExistCustomerAccountAndCheck() throws Exception {
		deleteCustomerPage=(DeleteCustomerPageObject) homePage.openDynamicPage(driver, "Delete Customer");
		Assert.assertTrue(deleteCustomerPage.isDeleteCustomerDisplayed());
		
		deleteCustomerPage.inputCustomerID(customerID);
		deleteCustomerPage.clickSubmit();
		Thread.sleep(3000);
		deleteCustomerPage.AcceptDeleteCustomerPageDisplayed();
		Assert.assertEquals(deleteCustomerPage.getDeleteCustomerSuccessfullyPageDisplayed(), "Customer deleted Successfully");
		Thread.sleep(3000);
		deleteCustomerPage.AcceptDeleteCustomerSuccessfullyPageDisplayed();
		
		homePage=(HomePageObject) deleteCustomerPage.openDynamicPage(driver, "Manager");
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver=opentMultiBrowser(browserName, url);
		
		email = "seleniumonline" + randomNumber() + "@gmail.com";
		loginPage =PageFactoryManager.getLoginPage(driver);
		
		loginURL =loginPage.getLoginPageUrl();
	
		loginPage=loginPage.openLoginPage(loginURL);
		loginPage.inputToUserIDTextbox(Constansts.USER);
		loginPage.inputToPasswordTextbox(Constansts.PASS);
		homePage=loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
}
