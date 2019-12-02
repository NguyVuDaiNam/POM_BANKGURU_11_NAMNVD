package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	
	
	
	public String getLoginPageUrl() {
		return getCurrenUrl(driver);
	}
	
	public LoginPageObject openLoginPage(String loginPageUrl) {
		openURL(driver, loginPageUrl);
		//return new LoginPageObject(driver);
		return PageFactoryManager.getLoginPage(driver);
	}
	public void inputToUserIDTextbox(String userID) {
		waitForControlVisible(driver, LoginPageUI.USERID_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userID);
	}
	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public HomePageObject clickToLoginButton() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManager.getHomePage(driver);
	}
	public RegisterPageObject clickToHereLink() {
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		//return new RegisterPageObject(driver);
		return PageFactoryManager.getRegisterPage(driver);
	}

}
