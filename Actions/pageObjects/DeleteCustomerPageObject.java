package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

import pageUIs.DeleteCustomerPageUI;

public class DeleteCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public DeleteCustomerPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isDeleteCustomerDisplayed() {
		waitForControlVisible(driver, DeleteCustomerPageUI.DELETE_CUSTOMER_TEXT);
		return isControlDisplayed(driver, DeleteCustomerPageUI.DELETE_CUSTOMER_TEXT);
	}

	public void inputCustomerID(String CustomerID) {
		waitForControlVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_SENKEY);
		senkeyToElement(driver,  DeleteCustomerPageUI.CUSTOMER_ID_SENKEY, CustomerID);
	}

	public void clickSubmit() {
		waitForControlVisible(driver,  DeleteCustomerPageUI.SUBMIT_DELETE_CUSTOMER_BUTTON);
		clickToElementByJS(driver, DeleteCustomerPageUI.SUBMIT_DELETE_CUSTOMER_BUTTON);
	}
	public void AcceptDeleteCustomerPageDisplayed() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}
	public String getDeleteCustomerSuccessfullyPageDisplayed() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}
	public void AcceptDeleteCustomerSuccessfullyPageDisplayed() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}
	

	
}
