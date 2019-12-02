package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constansts;
import pageUIs.AbstractPageUI;
import pageUIs.EditCustomerPageUI;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage{
	WebDriver driver;
	public NewCustomerPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isNewCustomerPageDisplayed() {
		waitForControlVisible(driver,NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}
	public boolean isHomePageUnDisplayed() {
		waitToElementInvisible(driver,HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		return isControlUndisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
	}
	
	public boolean isAddCustomerFormUndisplayed() {
		waitToElementInvisible(driver, NewCustomerPageUI.CUSTOMER_FORM);
		return isControlUndisplayed(driver, NewCustomerPageUI.CUSTOMER_FORM);
	}
	
	public boolean isNewCustomerSuccessfullyPageDisplayed() {
		waitForControlVisible(driver,NewCustomerPageUI.NEW_CUSTOMER_SUCCESSFULLY_TEXT);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_SUCCESSFULLY_TEXT);
	}
	public String getCustomerIDText() {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_NAME_TEXT);
		return getTextInElement(driver, EditCustomerPageUI.EDIT_CUSTOMER_NAME_TEXT);
	}
	// start payment
	public  void inputAdressTextArea() {
		waitForControlVisible(driver, NewCustomerPageUI.ADDRESS_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.ADDRESS_SENKEY, Constansts.ADDRESS_SENKEY);
	}
	public  void inputDateOfBirthText() {
		waitForControlVisible(driver, NewCustomerPageUI.DATEOFBIRTH_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.DATEOFBIRTH_SENKEY, Constansts.DATEOFBIRTH_SENKEY);
	}
	public  void inputCityText() {
		waitForControlVisible(driver, NewCustomerPageUI.CITY_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.CITY_SENKEY, Constansts.CITY_SENKEY);
	}
	public  void inputStateText() {
		waitForControlVisible(driver, NewCustomerPageUI.STATE_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.STATE_SENKEY, Constansts.STATE_SENKEY);
	}
	public  void inputPinText() {
		waitForControlVisible(driver, NewCustomerPageUI.PIN_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.PIN_SENKEY, Constansts.PIN_SENKEY);
	}
	public  void inputMobileText() {
		waitForControlVisible(driver, NewCustomerPageUI.MOBILE_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.MOBILE_SENKEY, Constansts.MOBILE_SENKEY);
	}
	
	public  void inputPasswordText() {
		waitForControlVisible(driver, NewCustomerPageUI.PASSWORD_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.PASSWORD_SENKEY, Constansts.PASSWORD_SENKEY);
	}
	// end payment
	
	
	public void inputNameText(String value) {
		waitForControlVisible(driver, NewCustomerPageUI.NAME_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.NAME_SENKEY, value);
		
	}
	public void namePressTab() {
		waitForControlVisible(driver, NewCustomerPageUI.NAME_SENKEY);
		sendKeyboardToElement(driver, NewCustomerPageUI.NAME_SENKEY, Keys.TAB);
	}
	public String getNameEmptyText() {
		waitForControlVisible(driver, NewCustomerPageUI.NAME_EMPTY_TEXT);
		return getTextInElement(driver, NewCustomerPageUI.NAME_EMPTY_TEXT);
	}


	public  void inputAdressTextArea(String value) {
		waitForControlVisible(driver, NewCustomerPageUI.ADDRESS_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.ADDRESS_SENKEY, value);
	}
	
	public void addressPressTab() {
		waitForControlVisible(driver, NewCustomerPageUI.ADDRESS_SENKEY);
		sendKeyboardToElement(driver, NewCustomerPageUI.ADDRESS_SENKEY, Keys.TAB);
	}
	
	public void inputCityText(String value) {
		waitForControlVisible(driver, NewCustomerPageUI.CITY_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.CITY_SENKEY, value);
	}
	public void cityPressTab() {
		waitForControlVisible(driver, NewCustomerPageUI.CITY_SENKEY);
		sendKeyboardToElement(driver, NewCustomerPageUI.CITY_SENKEY, Keys.TAB);
	}
	
	public void inputStateText(String value) {
		waitForControlVisible(driver, NewCustomerPageUI.STATE_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.STATE_SENKEY, value);
	}
	public void statePressTab() {
		waitForControlVisible(driver, NewCustomerPageUI.STATE_SENKEY);
		sendKeyboardToElement(driver, NewCustomerPageUI.STATE_SENKEY, Keys.TAB);
	}
	
	public void inputPinText(String value) {
		waitForControlVisible(driver, NewCustomerPageUI.PIN_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.PIN_SENKEY, value);	
	}
	public void pinPressTab() {
		waitForControlVisible(driver, NewCustomerPageUI.PIN_SENKEY);
		sendKeyboardToElement(driver, NewCustomerPageUI.PIN_SENKEY, Keys.TAB);
	}
	public void inputTelephoneText(String value) {
		waitForControlVisible(driver, NewCustomerPageUI.MOBILE_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.MOBILE_SENKEY, value);	
	}
	public void telephonePressTab() {
		waitForControlVisible(driver, NewCustomerPageUI.MOBILE_SENKEY);
		sendKeyboardToElement(driver, NewCustomerPageUI.MOBILE_SENKEY, Keys.TAB);
	}
	public void inputEmailText(String value) {
		waitForControlVisible(driver, NewCustomerPageUI.EMAIL_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.EMAIL_SENKEY, value);	
	}
	public void emailPressTab() {
		waitForControlVisible(driver, NewCustomerPageUI.EMAIL_SENKEY);
		sendKeyboardToElement(driver, NewCustomerPageUI.EMAIL_SENKEY, Keys.TAB);
	}
		
	public  void clicksubmitButton() {
		waitForControlVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElementByJS(driver,NewCustomerPageUI.SUBMIT_BUTTON);
	}

	public String getLabelCustomerDynamicText(WebDriver driver,String dynamicValue ) {
		waitForControlVisible(driver,AbstractPageUI.DYNAMIC_LABEL_TEXT);
		return getTextDynamicInElement(driver, AbstractPageUI.DYNAMIC_LABEL_TEXT, dynamicValue);
	}
	public String getNameDynamicText(WebDriver driver,String dynamicValue ) {
		waitForControlVisible(driver,AbstractPageUI.DYNAMIC_TEXT);
		return getTextDynamicInElement(driver, AbstractPageUI.DYNAMIC_TEXT, dynamicValue);
	}
	

}
