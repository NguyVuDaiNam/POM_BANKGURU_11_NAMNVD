package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import liveguruPageObjects.LiveRegisterPageObject;

public class LivePageFactoryManager {

	public static LiveRegisterPageObject getRegisterLivePage(WebDriver driver) {
		return new LiveRegisterPageObject(driver);
	}
	
	public static LiveHomePageObject getHomePageLive(WebDriver driver) {
		return new LiveHomePageObject(driver);
	}
	public static LiveMyWishListPageObject getMyWishListPageLive(WebDriver driver) {
		return new LiveMyWishListPageObject(driver);
	}
	public static LiveAdminPageObject getAdminPageLive(WebDriver driver) {
		return new LiveAdminPageObject(driver);
	}
	
}
