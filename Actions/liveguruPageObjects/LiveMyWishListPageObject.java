package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruPageUIs.LiveHomePageUI;
import liveguruPageUIs.LiveMyAccountUI;
import pageUIs.HomePageUI;

public class LiveMyWishListPageObject extends AbstractPage{
	WebDriver driver;
	public LiveMyWishListPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}

	
}
