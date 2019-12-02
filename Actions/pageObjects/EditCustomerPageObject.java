package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constansts;
import pageUIs.EditCustomerPageUI;


public class EditCustomerPageObject extends AbstractPage{
	WebDriver driver;
	public EditCustomerPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isEditCustomerPageDisplayed() {
		waitForControlVisible(driver,EditCustomerPageUI.EDIT_CUSTOMERID_TEXT);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_CUSTOMERID_TEXT);
	}
	public boolean isEditCustomerSuccessfullyPageDisplayed() {
		waitForControlVisible(driver,EditCustomerPageUI.EDIT_CUSTOMER_SUCCESSFULLY_TEXT);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_CUSTOMER_SUCCESSFULLY_TEXT);
	}
	public  void inputCustomerIDText(String CustomerID) {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_CUSTOMERID_SENKEY);
		senkeyToElement(driver, EditCustomerPageUI.EDIT_CUSTOMERID_SENKEY, CustomerID);
	}
	public  void clickCustomerIDSubmit() {
		waitForControlVisible(driver, EditCustomerPageUI.SUBMIT_CUSTOMER_EDIT_BUTTON);
		clickToElementByJS(driver, EditCustomerPageUI.SUBMIT_CUSTOMER_EDIT_BUTTON);
	}
	/// start payment
	public  void inputEditAdressTextArea() {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_SENKEY);
		
		senkeyToElement(driver, EditCustomerPageUI.EDIT_ADDRESS_SENKEY, Constansts.EDIT_ADDRESS_SENKEY);
	}
	public  void inputEditCityText() {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_CITY_SENKEY);
		senkeyToElement(driver, EditCustomerPageUI.EDIT_CITY_SENKEY, Constansts.EDIT_CITY_SENKEY);
	}
	public  void inputEditStateText() {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_STATE_SENKEY);
		senkeyToElement(driver, EditCustomerPageUI.EDIT_STATE_SENKEY, Constansts.EDIT_STATE_SENKEY);
	}
	public  void inputEditPinText() {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_PIN_SENKEY);
		senkeyToElement(driver, EditCustomerPageUI.EDIT_PIN_SENKEY, Constansts.EDIT_PIN_SENKEY);
	}
	public  void inputEditMobileText() {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_MOBILE_SENKEY);
		senkeyToElement(driver, EditCustomerPageUI.EDIT_MOBILE_SENKEY, Constansts.EDIT_MOBILE_SENKEY);
	}
	public  void inputEditEmailText(String email) {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_EMAIL_SENKEY);
		senkeyToElement(driver,  EditCustomerPageUI.EDIT_EMAIL_SENKEY, email);
	}
	//and payment

	
	
}
