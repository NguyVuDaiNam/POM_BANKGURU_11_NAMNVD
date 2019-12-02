package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DeleteAccountPageUI;


public class DeleteAccountPageObject extends AbstractPage {
	WebDriver driver;

	public DeleteAccountPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isDeleteAccountDisplayed() {
		waitForControlVisible(driver, DeleteAccountPageUI.DELETE_ACCOUNT_TEXT);
		return isControlDisplayed(driver, DeleteAccountPageUI.DELETE_ACCOUNT_TEXT);
	}

	public void inputAccountID(String AccountID) {
		waitForControlVisible(driver, DeleteAccountPageUI.ACCOUNT_NO_SENKEY);
		senkeyToElement(driver,  DeleteAccountPageUI.ACCOUNT_NO_SENKEY, AccountID);
	}

	public void clickSubmit() {
		waitForControlVisible(driver,  DeleteAccountPageUI.SUBMIT_DELETE_ACCOUNT_BUTTON);
		clickToElementByJS(driver, DeleteAccountPageUI.SUBMIT_DELETE_ACCOUNT_BUTTON);
	}
	public void AcceptDeleteAccountPageDisplayed() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}
	public String getDeleteAccountSuccessfullyPageDisplayed() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}
	public void AcceptDeleteAccountSuccessfullyPageDisplayed() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}
	

	
}
