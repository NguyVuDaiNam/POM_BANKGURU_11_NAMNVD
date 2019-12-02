package com.liveguru;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import liveguruPageObjects.LiveHomePageObject;
import liveguruPageObjects.LiveMyAccountPageObject;
import liveguruPageObjects.LivePageFactoryManager;
import liveguruPageObjects.LiveRegisterPageObject;

public class FrontEnd_User extends AbstractTest {
	private WebDriver driver;
	public static String EMAIL;
	
	private LiveHomePageObject liveHomePage;
	private LiveRegisterPageObject liveRegisterPage;
	private LiveMyAccountPageObject liveMyAccountPage;
	private String firstName, middleName, lastName, password, confirmPass, fullName,letUsKnowYourThoughts,summaryOfYourReview,nickname,zip,shipping;
	private String subtotal,grandTotal,address,country,state,city,telephone;

	@Test
	public void TC_01_Register(Method testMethod) {

		log.info("============== START: " + testMethod.getName() + " ============== ");
		
		log.info("Step 1: Click ACCOUNT menu");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		liveHomePage.clickAccountMenu();

		log.info("Step 2: Choose Register link");
		liveRegisterPage=liveHomePage.clickRegisterMenu();

		log.info("Step 3: Input data");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, firstName, "firstname");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, middleName, "middlename");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, lastName, "lastname");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, EMAIL, "email_address");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, password, "password");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, confirmPass, "confirmation");

		log.info("Step 4: Click button REGISTER");
		liveRegisterPage.clickDynamicButton(driver, "Register");

		log.info("Step 5: Verify text displayed after register successelly");
		verifyEquals(liveRegisterPage.getDynamicTextDisplayedLive(driver,"Thank you for registering with Main Website Store."),"Thank you for registering with Main Website Store.");

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_02_VerifyUser(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click MY ACCOUNT ");
		liveMyAccountPage=liveHomePage.clickMyAccountMenu();
		
		log.info("Step 3: Verify user information displayed");
		String VerifyMyAccount=liveMyAccountPage.getTextDisplayedVerifyMyAccountLive(driver);
		verifyTrue(VerifyMyAccount.contains(fullName) && VerifyMyAccount.contains(EMAIL));
		
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_03_VerifyCostProduct(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu Mobile");
		liveHomePage.clickDynamicLink(driver, "Mobile");
		
		log.info("Step 3: Get cost Sony Xperia");
		String CostList=liveHomePage.getDynamicCostListLive(driver, "Sony Xperia");
		
		log.info("Step 4: Click detail");
		liveHomePage.clickDynamicLink(driver, "Sony Xperia");
		
		log.info("Step 5: Get cost detail");
		String CostDetail=liveHomePage.getDynamicCostDetailLive(driver, "price");
		
		verifyTrue(CostList.contains("$100")&&CostDetail.contains("$100"));

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_04_DiscountCoupon(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu Mobile");
		liveHomePage.clickDynamicLink(driver, "Mobile");
		
		log.info("Step 3: Add Iphone to cart ");
		liveHomePage.clickDynamicAddToCart(driver, "IPhone");
		
		log.info("Step 4: Verify ");
		liveHomePage.getDynamicTextDisplayedLive(driver, "IPhone was added to your shopping cart.");
		
		log.info("Step 5: Input Discount codes ");
		liveHomePage.inputDynamicTextBoxTextArea(driver, "GURU50", "coupon_code");
		
		log.info("Step 6: Click button apply ");
		liveHomePage.clickDynamicButton(driver, "Apply");
		
		log.info("Step 7: Verify Discount and Grand total");
		verifyEquals(liveHomePage.getDiscountLive(), "-$25.00");
		verifyEquals(liveHomePage.getGrandTotalLive(), "$500.00");
		
		
		liveHomePage.clickDynamicButton(driver, "Empty Cart");

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_05_VerifyCannotAddMore500Items(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu Mobile");
		liveHomePage.clickDynamicLink(driver, "Mobile");
		
		log.info("Step 3: Add Iphone to cart ");
		liveHomePage.clickDynamicAddToCart(driver, "Sony Xperia");
		
		log.info("Step 4: Verify ");
		liveHomePage.getDynamicTextDisplayedLive(driver, "Sony Xperia was added to your shopping cart.");
		
		log.info("Step 5: Input QTY value 501 ");;
		liveHomePage.inputDynamicTextBoxQTY(driver, "1000", "Sony Xperia");
	
		log.info("Step 6:Click button Update ");
		//liveHomePage.clickDynamicButton(driver, "Update");
		liveHomePage.clickButtonUpdateQTY(driver);

		log.info("Step 7:Verify Message error ");
		verifyEquals(liveHomePage.getMsgErrorQTYLive(),"* The maximum quantity allowed for purchase is 500. ");
		
		log.info("Step 8: Click link Empty cart");
		liveHomePage.clickDynamicButton(driver, "Empty Cart");
		
		log.info("Step 9: Verify Empty cart");
		verifyEquals(liveHomePage.getEmptyCartLive(),"SHOPPING CART IS EMPTY");

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_06_VerifyCompareTwoProduct(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu Mobile");
		liveHomePage.clickDynamicLink(driver, "Mobile");
		
		log.info("Step 3: Add to compare Sony Xperia ");
		liveHomePage.clickDynamicCompare(driver, "Sony Xperia");
		verifyEquals(liveHomePage.getDynamicTextDisplayedLive(driver, "The product Sony Xperia has been added to comparison list."),"The product Sony Xperia has been added to comparison list.");
	
		log.info("Step 4: Add to compare IPhone ");
		liveHomePage.clickDynamicCompare(driver, "IPhone");
		verifyEquals(liveHomePage.getDynamicTextDisplayedLive(driver, "The product IPhone has been added to comparison list."),"The product IPhone has been added to comparison list.");
		
		log.info("Step 5: Click Compare ");
		String parentWindow = driver.getWindowHandle();
		liveHomePage.clickDynamicButton(driver, "Compare");
		
		log.info("Step 6: Verify Pop- up Window");
		
		liveHomePage.switchToWindowByTitle(driver, "Products Comparison List - Magento Commerce");
		verifyEquals(liveHomePage.getDynamicTextH1Live(driver, "Compare Products"),"COMPARE PRODUCTS");
		
		liveHomePage.closeAllWithoutParentWindows(driver, parentWindow);
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_07_ShareWishlist(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu TV");
		liveHomePage.clickDynamicLink(driver, "TV");
		
		log.info("Step 3: Add LG LCD product your wishlist and Msg display");
		liveHomePage.clickDynamicWishList(driver, "LG LCD");
		
		verifyTrue(liveHomePage.isTextWishListDisplayed());
		
		log.info("Step 4: Click button Share Wishlist ");
		liveHomePage.clickDynamicButton(driver, "Share Wishlist");
		
		log.info("Step 5: Input Email and msg ");
		liveHomePage.inputDynamicTextBoxTextArea(driver, "TrangHC0938@gmail.com", "email_address");
		
		liveHomePage.inputDynamicTextBoxTextArea(driver, "Message WishList", "message");
		
		
		log.info("Step 6: Click button Share Wishlist ");
		liveHomePage.clickDynamicButton(driver, "Share Wishlist");
		
		verifyTrue(liveHomePage.isTextWishListDisplayed());
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_08_AddYourReview(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu TV");
		liveHomePage.clickDynamicLink(driver, "TV");
		
		log.info("Step 3: Click detail Samsung LCD");
		liveHomePage.clickDynamicLink(driver, "Samsung LCD");
		
		log.info("Step 4: Click link 'Add Your Review'");
		liveHomePage.clickDynamicLink(driver, "Add Your Review");
		
		log.info("Step 5: Input data 3 field Empty");
		liveHomePage.inputDynamicTextBoxTextArea(driver, "", "review_field");
		liveHomePage.inputDynamicTextBoxTextArea(driver, "", "summary_field");
		liveHomePage.inputDynamicTextBoxTextArea(driver, "", "nickname_field");
		
		
		log.info("Step 6: Click button Submit Review ");
		liveHomePage.clickDynamicButton(driver, "Submit Review");
		
		verifyTrue(liveHomePage.isDynamicTextDisplayed(driver, "advice-required-entry-review_field"));
		verifyTrue(liveHomePage.isDynamicTextDisplayed(driver, "advice-required-entry-summary_field"));
		verifyTrue(liveHomePage.isDynamicTextDisplayed(driver, "advice-required-entry-nickname_field"));
		
		log.info("Step 7: Input data 3 field ");
		liveHomePage.inputDynamicTextBoxTextArea(driver, letUsKnowYourThoughts, "review_field");
		liveHomePage.inputDynamicTextBoxTextArea(driver, summaryOfYourReview, "summary_field");
		liveHomePage.inputDynamicTextBoxTextArea(driver, nickname, "nickname_field");
		
		log.info("Step 8: Click button Submit Review ");
		liveHomePage.clickDynamicButton(driver, "Submit Review");
		verifyTrue(liveHomePage.isDynamicTextDisplayed_SPAN(driver, "Your review has been accepted for moderation."));
		
		liveHomePage.clickAccountMenu();
		liveHomePage.clickDynamicLink(driver, "Log Out");
		
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_09_UserIsAblePuschaseProduct(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click MY ACCOUNT ");
		liveHomePage.clickMyAccountMenu();
		
		log.info("Step 3: Login ");
		liveHomePage.inputDynamicTextBoxTextArea(driver, EMAIL, "email");
		liveHomePage.inputDynamicTextBoxTextArea(driver, password, "pass");
		liveHomePage.clickDynamicButton(driver, "Login");
		
		log.info("Step 4: Click link My Wishlist");
		//liveHomePage.clickDynamicLink(driver, "My Wishlist");
		liveHomePage.clickLinkMyWishlist(driver);
		
		log.info("Step 5: Click Add to cart");
		liveHomePage.clickButtonAddToCart(driver);
		
		log.info("Step 6: Enter general shipping country, state/province and zip for the shipping cost estimate");
		liveHomePage.inputDynamicDropdown(driver, country ,"country_id");
		liveHomePage.inputDynamicDropdown(driver, state,"region_id");
		liveHomePage.inputDynamicTextBoxTextArea(driver, zip, "postcode");
		
		log.info("Step 7: Click Estimate");
		liveHomePage.clickDynamicButton(driver, "Estimate");
		
		log.info("Step 8: Verify Shipping cost generated");
		verifyEquals(liveHomePage.getShippingCostGeneratdLive(),shipping);
		
		log.info("Step 9: Select Shipping Cost, Update Total ");
		liveHomePage.ClickDynamicTextBoxTextAreaRadio(driver, "s_method_flatrate_flatrate");
		liveHomePage.clickDynamicButton(driver, "Update Total");
		
		log.info("Step 10: Verify shipping cost is added to total ");
		verifyEquals(liveHomePage.getShippingCostTotalLive(),shipping);
		
		log.info("Step 11: Click Button 'Proceed to Checkout'");
		liveHomePage.clickDynamicButton(driver, "Proceed to Checkout");
		
		log.info("Step 12a: Enter Billing Information, and click Continue");
		
		liveHomePage.inputDynamicTextBoxTextArea(driver, address, "billing:street1");
		liveHomePage.inputDynamicTextBoxTextArea(driver, city, "billing:city");
		liveHomePage.inputDynamicDropdown(driver, state,"billing[region_id]");
		liveHomePage.inputDynamicTextBoxTextArea(driver, zip, "billing:postcode");
		liveHomePage.inputDynamicDropdown(driver, country ,"billing[country_id]");
		liveHomePage.inputDynamicTextBoxTextArea(driver, telephone, "billing:telephone");
		
		liveHomePage.ClickDynamicTextBoxTextAreaRadio(driver, "billing:use_for_shipping_no");
		
		liveHomePage.clickDynamicContinue(driver, "Billing Information");
		
		log.info("Step 12b.: Enter Shipping Information, and click Continue");
		
		liveHomePage.inputDynamicTextBoxTextArea(driver, firstName, "shipping:firstname");
		liveHomePage.inputDynamicTextBoxTextArea(driver, lastName, "shipping:lastname");
		liveHomePage.inputDynamicTextBoxTextArea(driver, address, "shipping:street1");
		liveHomePage.inputDynamicTextBoxTextArea(driver, city, "shipping:city");
		liveHomePage.inputDynamicDropdown(driver, state,"shipping[region_id]");
		liveHomePage.inputDynamicTextBoxTextArea(driver, zip, "shipping:postcode");
		liveHomePage.inputDynamicDropdown(driver, country ,"shipping[country_id]");
		liveHomePage.inputDynamicTextBoxTextArea(driver, telephone, "shipping:telephone");
		
		liveHomePage.clickDynamicContinue(driver, "Shipping Information");
		
		log.info("Step 13: In Shipping Method, Click Continue");
		liveHomePage.clickDynamicContinue(driver, "Shipping Method");
		
		log.info("Step 14: In Payment Information select 'Check/Money Order' radio button. Click Continue");
		liveHomePage.ClickDynamicTextBoxTextAreaRadio(driver, "p_method_checkmo");
		liveHomePage.clickDynamicContinue(driver, "Payment Information");
		
		//verifyEquals(liveHomePage.getDynamicOrderReviewLive(driver, "Subtotal"),subtotal);
		verifyEquals(liveHomePage.getDynamicOrderReviewLive(driver, "Shipping & Handling"),shipping);
	//	verifyEquals(liveHomePage.getOrderReviewTotalLive(driver),grandTotal);
		
		log.info("Step 15: Click 'PLACE ORDER' button ");
		liveHomePage.clickDynamicButton(driver, "Place Order");
		
		log.info("Step 16: Verify Oder is generated. Note the order number ");
		verifyTrue(liveHomePage.isTextOrderNumberDisplayed());
		String ORDER_NUMBER=liveHomePage.getOrderNumberLive();
		
		log.info("ORDER_NUMBER:   " +ORDER_NUMBER);
		
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_10_VerifySearchFuntionality(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click Advanced Search ");
		liveHomePage.clickDynamicLink(driver, "Advanced Search");
		
		log.info("Step 3: In price enter rangen 0-150 and click search");
		liveHomePage.inputDynamicTextBoxTextArea(driver, "0", "price");
		liveHomePage.inputDynamicTextBoxTextArea(driver, "150", "price_to");
		//liveHomePage.clickDynamicButton(driver, "Search");
		liveHomePage.clickButtonSearch(driver);

		log.info("Step 4: print on console name and price product ");
		liveHomePage.GetNameAndPrice(driver);
		
		log.info("Step 5: Click Advanced Search ");
		liveHomePage.clickDynamicLink(driver, "Advanced Search");
		
		log.info("Step 6: In price enter rangen 151-1000 and click search");
		liveHomePage.inputDynamicTextBoxTextArea(driver, "151", "price");
		liveHomePage.inputDynamicTextBoxTextArea(driver, "1000", "price_to");
		liveHomePage.clickButtonSearch(driver);
	
		log.info("Step 7: print on console name and price product ");
		liveHomePage.GetNameAndPrice(driver);
		

		
		
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = opentMultiBrowser(browserName, url);

		firstName = "Trang";
		middleName = "";
		lastName = "Tran";
		EMAIL = "seleniumonline" + randomNumber() + "@gmail.com";
		password = "123456";
		confirmPass = "123456";
		fullName = firstName +" "+ lastName;
		
		letUsKnowYourThoughts="Ready to experience";
		summaryOfYourReview="Good";
		nickname="small roses";
		
		shipping="$5.00";
		subtotal="$100.00";
		grandTotal="$105.00";
		
		country = "United States"; 
		state= "New York";
		zip="542896";
		address="ABC";
		city="New York";
		telephone="12345678";

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
