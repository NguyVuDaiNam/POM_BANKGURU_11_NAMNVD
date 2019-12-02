package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.BalanceEnquiryPageUI;

public class BalanceEnquiryPageObject extends AbstractPage {
	WebDriver driver;

	public BalanceEnquiryPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isBalanceEnquiryDisplayed() {
		waitForControlVisible(driver, BalanceEnquiryPageUI.BALANCE_ENQUIRY_TEXT);
		return isControlDisplayed(driver, BalanceEnquiryPageUI.BALANCE_ENQUIRY_TEXT);
	}

	public void inputAccountID(String AccountID) {
		waitForControlVisible(driver, BalanceEnquiryPageUI.ACCOUNT_NO_SENKEY);
		senkeyToElement(driver,  BalanceEnquiryPageUI.ACCOUNT_NO_SENKEY, AccountID);
	}

	public void clickSubmit() {
		waitForControlVisible(driver,  BalanceEnquiryPageUI.SUBMIT_BALANCE_BUTTON);
		clickToElementByJS(driver, BalanceEnquiryPageUI.SUBMIT_BALANCE_BUTTON);
	}
	
	public boolean isBalanceEnquirySuccessfullyPageDisplayed(String locator) {
		waitForControlVisible(driver, locator);
		return isControlDisplayed(driver, locator);
	}
	public String getBalanceEnquiry() {
		waitForControlVisible(driver, BalanceEnquiryPageUI.BALANCE_TEXT);
		return getTextInElement(driver, BalanceEnquiryPageUI.BALANCE_TEXT);
	}
}
