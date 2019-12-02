package pageObjects;

import org.openqa.selenium.WebDriver;

import liveguruPageObjects.LiveRegisterPageObject;

public class PageFactoryManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
	public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}
	public static EditAccountPageObject getEditAccountPage(WebDriver driver) {
		return new EditAccountPageObject(driver);
	}
	public static DepositPageObject getDepositPage(WebDriver driver) {
		return new DepositPageObject(driver);
	}
	public static FundTransterPageObject getFundTransferPage(WebDriver driver) {
		return new FundTransterPageObject(driver);
	}
	public static HomePageObject openHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static WithdrawPageObject getWithdrawPage(WebDriver driver) {
		return new WithdrawPageObject(driver);
	}
	public static BalanceEnquiryPageObject getBalanceEnquiryPage(WebDriver driver) {
		return new BalanceEnquiryPageObject(driver);
	}
	public static DeleteAccountPageObject getDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}
	public static DeleteCustomerPageObject getDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomerPageObject(driver);
	}
	public static MiniStatementPageObject getMiniStatementPage(WebDriver driver) {
		return new MiniStatementPageObject(driver);
	}
	public static CustomizedStatementPageObject getCustomizedStatementPage(WebDriver driver) {
		return new CustomizedStatementPageObject(driver);
	}
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
}
