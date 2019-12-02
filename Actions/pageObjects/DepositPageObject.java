package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constansts;
import pageUIs.DepositPageUI;

public class DepositPageObject extends AbstractPage{
	WebDriver driver;
	public DepositPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isNewDepositPageDisplayed() {
		waitForControlVisible(driver,DepositPageUI.DEPOSIT_TEXT);
		return isControlDisplayed(driver, DepositPageUI.DEPOSIT_TEXT);
	}
	public void inputAccountID(String AccountID) {
		waitForControlVisible(driver, DepositPageUI.ACCOUNT_ID_SENKEY);
		senkeyToElement(driver, DepositPageUI.ACCOUNT_ID_SENKEY, AccountID);
	}
	public void inputAmount() {
		waitForControlVisible(driver, DepositPageUI.AMOUNT_SENKEY);
		senkeyToElement(driver, DepositPageUI.AMOUNT_SENKEY, Constansts.AMOUNT_SENKEY);
	}
	public void inputDescription() {
		waitForControlVisible(driver, DepositPageUI.DESCRIPTION_SENKEY);
		senkeyToElement(driver, DepositPageUI.DESCRIPTION_SENKEY, Constansts.DESCRIPTION_SENKEY);
	}
	public void clickSubmitDeposit() {
		waitForControlVisible(driver, DepositPageUI.SUBMIT_BUTTON);
		clickToElementByJS(driver, DepositPageUI.SUBMIT_BUTTON);
	}
	
	public boolean isTransactionSuccessfullyPageDisplayed(String locator) {
		waitForControlVisible(driver, locator);
		return isControlDisplayed(driver, locator);
	}
	public String getTransactionID() {
		waitForControlVisible(driver, DepositPageUI.TRANSACTION_ID_TEXT);
		return getTextInElement(driver, DepositPageUI.TRANSACTION_ID_TEXT);
	}
	public String getCurrentBalance() {
		waitForControlVisible(driver, DepositPageUI.CURRENT_BALACE_TEXT);
		return getTextInElement(driver, DepositPageUI.CURRENT_BALACE_TEXT);
	}
	
	
	
	
}
