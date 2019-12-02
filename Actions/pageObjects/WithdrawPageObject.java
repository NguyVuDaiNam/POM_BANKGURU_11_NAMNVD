package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constansts;
import pageUIs.WithdrawalPageUI;

public class WithdrawPageObject extends AbstractPage{
	WebDriver driver;
	public WithdrawPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isWithdrawalPageDisplayed() {
		waitForControlVisible(driver,WithdrawalPageUI.WITHDRAWAL_TEXT);
		return isControlDisplayed(driver, WithdrawalPageUI.WITHDRAWAL_TEXT);
	}
	public void inputAccountID(String AccountID) {
		waitForControlVisible(driver, WithdrawalPageUI.ACCOUNT_ID_SENKEY);
		senkeyToElement(driver, WithdrawalPageUI.ACCOUNT_ID_SENKEY, AccountID);
	}
	public void inputAmount() {
		waitForControlVisible(driver, WithdrawalPageUI.AMOUNT_SENKEY);
		senkeyToElement(driver, WithdrawalPageUI.AMOUNT_SENKEY, Constansts.AMOUNT_WITHDRAWAL_SENKEY);
	}
	public void inputDescription() {
		waitForControlVisible(driver, WithdrawalPageUI.DESCRIPTION_SENKEY);
		senkeyToElement(driver, WithdrawalPageUI.DESCRIPTION_SENKEY, Constansts.DESCRIPTION_WITHDRAWAL_SENKEY);
	}
	public void clickSubmitWithdrawal() {
		waitForControlVisible(driver, WithdrawalPageUI.SUBMIT_BUTTON);
		clickToElementByJS(driver, WithdrawalPageUI.SUBMIT_BUTTON);
	}
	
	public boolean isTransactionSuccessfullyPageDisplayed(String locator) {
		waitForControlVisible(driver, locator);
		return isControlDisplayed(driver, locator);
	}
	public String getTransactionID() {
		waitForControlVisible(driver, WithdrawalPageUI.TRANSACTION_ID_TEXT);
		return getTextInElement(driver, WithdrawalPageUI.TRANSACTION_ID_TEXT);
	}
	
	
	
}
