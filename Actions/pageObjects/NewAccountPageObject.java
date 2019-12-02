package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constansts;
import pageUIs.NewAccountPageUI;

public class NewAccountPageObject extends AbstractPage{
	WebDriver driver;
	public NewAccountPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isNewAccountPageDisplayed() {
		waitForControlVisible(driver,NewAccountPageUI.NEW_ACCOUNT_TEXT);
		return isControlDisplayed(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
	}
	public void inputCustomerID(String CustomerID) {
		waitForControlVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXT);
		senkeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXT, CustomerID);
	}
	public void inputAccountType() {
		waitForControlVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInHtmlDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, Constansts.ACCOUNT_TYPE_SENKEY);
		getSelectedItemInHtmlDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
	}
	public void inpuInitialDeposit() {
		waitForControlVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXT);
		senkeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXT, Constansts.INITIAL_DEPOSIT_SENKEY);
	}
	public  void clickNewAccountSubmit() {
		waitForControlVisible(driver, NewAccountPageUI.SUBMIT_NEW_ACCOUNT_BUTTON);
		clickToElementByJS(driver, NewAccountPageUI.SUBMIT_NEW_ACCOUNT_BUTTON);
	}
	public boolean isNewAccountSuccessefullyPageDisplayed() {
		waitForControlVisible(driver,NewAccountPageUI.NEW_ACCOUNT_SUCCESSFULLY_TEXT);
		return isControlDisplayed(driver, NewAccountPageUI.NEW_ACCOUNT_SUCCESSFULLY_TEXT);
	}
	public boolean isCurrentAmountPageDisplayed() {
		waitForControlVisible(driver,NewAccountPageUI.CURRENT_AMOUNT_TEXT);
		return isControlDisplayed(driver, NewAccountPageUI.CURRENT_AMOUNT_TEXT);
	}
	public  String getCurrentAmount() {
		waitForControlVisible(driver, NewAccountPageUI.CURRENT_AMOUNT_TEXT);
		return getTextInElement(driver, NewAccountPageUI.CURRENT_AMOUNT_TEXT);
	}
	public String getAccountIDText() {
		waitForControlVisible(driver, NewAccountPageUI.ACCOUNT_ID_TEXT);
		return getTextInElement(driver, NewAccountPageUI.ACCOUNT_ID_TEXT);
	}
	
}
