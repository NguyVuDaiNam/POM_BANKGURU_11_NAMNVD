package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constansts;
import pageUIs.FundTransterPageUI;

public class FundTransterPageObject extends AbstractPage {
	WebDriver driver;

	public FundTransterPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isFundTransferDisplayed() {
		waitForControlVisible(driver, FundTransterPageUI.FUND_TRANSFER_TEXT);
		return isControlDisplayed(driver, FundTransterPageUI.FUND_TRANSFER_TEXT);
	}

	public void inputPayersAccount(String AccountID) {
		waitForControlVisible(driver, FundTransterPageUI.PAYERS_ACCOUNT_NO_SENKEY);
		senkeyToElement(driver,  FundTransterPageUI.PAYERS_ACCOUNT_NO_SENKEY, AccountID);
	}

	public void inputPayeessAccount() {
		waitForControlVisible(driver, FundTransterPageUI.PAYEES_ACCOUNT_NO_SENKEY);
		senkeyToElement(driver,  FundTransterPageUI.PAYEES_ACCOUNT_NO_SENKEY, Constansts.PAYEES_ACCOUNT_SENKEY);
	}

	public void inputAmount() {
		waitForControlVisible(driver, FundTransterPageUI.AMOUNT_SENKEY);
		senkeyToElement(driver,  FundTransterPageUI.AMOUNT_SENKEY, Constansts.AMOUNT_FUND_TRANSFER_SENKEY);
	}

	public void inputDescription() {
		waitForControlVisible(driver, FundTransterPageUI.DESCRIPTION_SENKEY);
		senkeyToElement(driver,  FundTransterPageUI.DESCRIPTION_SENKEY, Constansts.DESCRIPTION_FUND_TRANSFER_SENKEY);
	}
	public void clickSubmit() {
		waitForControlVisible(driver, FundTransterPageUI.SUBMIT_FUND_TRANSFER_BUTTON);
		clickToElementByJS(driver, FundTransterPageUI.SUBMIT_FUND_TRANSFER_BUTTON);
	}
	
	public boolean isTransactionSuccessfullyPageDisplayed() {
		waitForControlVisible(driver, FundTransterPageUI.FUND_TRANSFER_SUCCESSEFULLY_TEXT);
		return isControlDisplayed(driver, FundTransterPageUI.FUND_TRANSFER_SUCCESSEFULLY_TEXT);
	}
	public String getFromAccount() {
		waitForControlVisible(driver, FundTransterPageUI.FROM_ACCOUNT_TEXT);
		return getTextInElement(driver, FundTransterPageUI.FROM_ACCOUNT_TEXT);
	}
	public String getToAccount() {
		waitForControlVisible(driver, FundTransterPageUI.TO_ACCOUNT_TEXT);
		return getTextInElement(driver, FundTransterPageUI.TO_ACCOUNT_TEXT);
	}
	public String getAmountFundTranster() {
		waitForControlVisible(driver, FundTransterPageUI.AMOUNT_TEXT);
		return getTextInElement(driver, FundTransterPageUI.AMOUNT_TEXT);
	}
}
