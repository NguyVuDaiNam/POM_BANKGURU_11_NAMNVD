package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruPageUIs.AbstractLivePageUI;
import liveguruPageUIs.LiveHomePageUI;
import pageUIs.AbstractPageUI;

public class LiveHomePageObject extends AbstractPage{
	WebDriver driver;
	public LiveHomePageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public LiveAdminPageObject openAdminPage(String AdminPageUrl) {
		openURL(driver, AdminPageUrl);
		return LivePageFactoryManager.getAdminPageLive(driver);
	}
	public void clickAccountMenu() {
		waitForControlVisible(driver, LiveHomePageUI.ACCOUNT_MENU_HEADER);
		clickToElement(driver, LiveHomePageUI.ACCOUNT_MENU_HEADER);
	
	}
	public LiveRegisterPageObject clickRegisterMenu() {
		waitForControlVisible(driver, LiveHomePageUI.REGISTER_MENU_HEADER);
		clickToElement(driver, LiveHomePageUI.REGISTER_MENU_HEADER);
		return new LiveRegisterPageObject(driver);
	}
	public LiveMyAccountPageObject clickMyAccountMenu() {
		waitForControlVisible(driver, LiveHomePageUI.MYACCOUNT_MENU_FOOTER);
		clickToElement(driver, LiveHomePageUI.MYACCOUNT_MENU_FOOTER);
		return new LiveMyAccountPageObject(driver);
	}
	public String getDiscountLive() {
		waitForControlVisible(driver, LiveHomePageUI.DISCOUNT);
		return getTextInElement(driver, LiveHomePageUI.DISCOUNT);
	}
	
	public String getGrandTotalLive() {
		waitForControlVisible(driver, LiveHomePageUI.GRAND_TOTAL);
		return getTextInElement(driver, LiveHomePageUI.GRAND_TOTAL);
	}
	public String getMsgErrorQTYLive() {
		waitForControlVisible(driver, LiveHomePageUI.MSG_ERROR_QTY);
		return getTextInElement(driver, LiveHomePageUI.MSG_ERROR_QTY);
	}
	public String getEmptyCartLive() {
		waitForControlVisible(driver, LiveHomePageUI.VERIFY_EMPTY_CART);
		return getTextInElement(driver, LiveHomePageUI.VERIFY_EMPTY_CART);
	}
	
	public boolean isTextWishListDisplayed() {
		waitForControlVisible(driver, LiveHomePageUI.MSG_WISHLIT);
		return isControlDisplayed(driver, LiveHomePageUI.MSG_WISHLIT);
	}
	public String getShippingCostTotalLive() {
		waitForControlVisible(driver, LiveHomePageUI.SHIPPING_COST_TOTAL);
		return getTextInElement(driver, LiveHomePageUI.SHIPPING_COST_TOTAL);
	}
	public String getShippingCostGeneratdLive() {
		waitForControlVisible(driver, LiveHomePageUI.SHIPPING_COST_GENERATED);
		return getTextInElement(driver, LiveHomePageUI.SHIPPING_COST_GENERATED);
	}
	public void clickButtonAddToCart(WebDriver driver) {
		waitForControlVisible(driver, LiveHomePageUI.BUTTON_ADD_TO_CART);
		clickToElement(driver, LiveHomePageUI.BUTTON_ADD_TO_CART);
	}
	
	public void clickButtonUpdateQTY(WebDriver driver) {
		waitForControlVisible(driver, LiveHomePageUI.BUTTON_UPDATE_QTY);
		clickToElementByJS(driver,  LiveHomePageUI.BUTTON_UPDATE_QTY);
	}
	
	public void clickLinkMyWishlist(WebDriver driver) {
		waitForControlVisible(driver, LiveHomePageUI.LINK_MY_WISHLIST);
		clickToElementByJS(driver,  LiveHomePageUI.LINK_MY_WISHLIST);
	}
	public void clickButtonEstimate(WebDriver driver) {
		waitForControlVisible(driver, LiveHomePageUI.LINK_MY_WISHLIST);
		clickToElementByJS(driver,  LiveHomePageUI.LINK_MY_WISHLIST);
	}
	
	public boolean isTextOrderNumberDisplayed() {
		waitForControlVisible(driver, LiveHomePageUI.ORDER_NUMBER);
		return isControlDisplayed(driver, LiveHomePageUI.ORDER_NUMBER);
	}

	public String getOrderNumberLive() {
		waitForControlVisible(driver, LiveHomePageUI.ORDER_NUMBER);
		return getTextInElement(driver, LiveHomePageUI.ORDER_NUMBER);
	}
	public String getOrderReviewTotalLive(WebDriver driver ) {
		waitForControlVisible(driver, LiveHomePageUI.TOTAL_ORDER);
		return getTextDynamicInElement(driver, LiveHomePageUI.TOTAL_ORDER);
	}
	public void clickButtonSearch(WebDriver driver) {
		waitForControlVisible(driver, LiveHomePageUI.BUTTON_SEARCH);
		clickToElementByJS(driver,  LiveHomePageUI.BUTTON_SEARCH);
	}
	public void clickReviewTab(WebDriver driver) {
		waitForControlVisible(driver, LiveHomePageUI.REVIEW_TAB);
		clickToElementByJS(driver, LiveHomePageUI.REVIEW_TAB);
	}
	public String GetReviewDisplayed() {
		waitForControlVisible(driver, LiveHomePageUI.VERYFY_REVIEW_TOP1);
		return getTextInElement(driver, LiveHomePageUI.VERYFY_REVIEW_TOP1);
	}
	
}
