package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruPageUIs.LiveHomePageUI;
import liveguruPageUIs.LiveMyAccountUI;
import pageUIs.HomePageUI;

public class LiveMyAccountPageObject extends AbstractPage{
	WebDriver driver;
	public LiveMyAccountPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public String getTextDisplayedVerifyMyAccountLive(WebDriver driver ) {
		waitForControlVisible(driver, LiveMyAccountUI.VERIFY_MYACCOUNT);
		return getTextInElement(driver, LiveMyAccountUI.VERIFY_MYACCOUNT);
	}
	
	
}
