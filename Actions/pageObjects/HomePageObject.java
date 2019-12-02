package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage{
	WebDriver driver;
	public HomePageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isHomePageDisplayed() {
		waitForControlVisible(driver,HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		return isControlDisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
	}
	public boolean isNewCustomerPageDisplayed() {
		waitToElementInvisible(driver, HomePageUI.NO_HOMEPAGE_WELCOME_MESSAGE);
		return isControlUndisplayed(driver, HomePageUI.NO_HOMEPAGE_WELCOME_MESSAGE);
	}
	
	
}
