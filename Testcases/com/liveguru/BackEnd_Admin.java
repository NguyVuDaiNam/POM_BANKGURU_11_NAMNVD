package com.liveguru;

import java.lang.reflect.Method;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constansts;
import liveguruPageObjects.LiveAdminPageObject;
import liveguruPageObjects.LiveHomePageObject;
import liveguruPageObjects.LivePageFactoryManager;

public class BackEnd_Admin extends AbstractTest {
	private WebDriver driver;
	private LiveAdminPageObject liveAdminPage;
	private LiveHomePageObject liveHomePage;
	private String USER, PASS, review, summaryReview, nickReview, ID, Name, Email, Telephone, Zip, Country, State;
@Test
	public void TC_01_VerifyInvoiceCanBePrinted(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 2: Login");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, USER, "username");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, PASS, "login");
		liveAdminPage.clickLogin(driver);

		liveAdminPage.clickDynamicMenu(driver, "close");

		log.info("Step 3: Goto Sales -> Orders menu");
		liveAdminPage.clickDynamicMenu(driver, "Sales");
		liveAdminPage.clickDynamicMenu(driver, "Orders");

		log.info("Step 4:  In the status field select 'Canceled'. Click Search");
		liveAdminPage.inputDynamicDropdown(driver, "Canceled", "status");
		liveAdminPage.clickDynamicButton(driver, "Search");
		liveAdminPage.sleepInSecond(3);
		log.info("Step 5: Select checkbox next to first order");
		liveAdminPage.clickCheckboxOrder(driver);
		liveAdminPage.sleepInSecond(3);

		log.info("Step 6: In action, select Print Invoices. Click button Submit");
		liveAdminPage.inputDynamicDropdown_ID(driver, "Print Invoices", "sales_order_grid_massaction-select");
		liveAdminPage.clickDynamicButton(driver, "Submit");

		log.info("Step 7: Verify error msg ");
		verifyTrue(liveAdminPage.isDynamicTextDisplayed_SPAN(driver,
				"There are no printable documents related to selected orders."));

		log.info("Step 8: Select Complete. Click search");
		liveAdminPage.inputDynamicDropdown(driver, "Complete", "status");
		liveAdminPage.sleepInSecond(3);
		// liveAdminPage.scrollToTopPage(driver);
		// liveAdminPage.sleepInSecond(5);
		liveAdminPage.clickDynamicButton(driver, "Search");//
		liveAdminPage.sleepInSecond(2);
		log.info("Step 9: Select checkbox next to first order");
		liveAdminPage.clickCheckboxOrder(driver);

		log.info("Step 10: In action, select Print Invoices. Click button Submit");
		liveAdminPage.inputDynamicDropdown_ID(driver, "Print Invoices", "sales_order_grid_massaction-select");
		liveAdminPage.clickDynamicButton(driver, "Submit");

		log.info("Step 11: Verify invoice is downloaded");
		liveAdminPage.sleepInSecond(2);
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
@Test
	public void TC_02_VerifyProductReview(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 01:  http://live.guru99.com/");
		liveHomePage = liveAdminPage.openHomePage(Constansts.LIVE_URL);

		log.info("Step 02: Go To Link - http://live.guru99.com/index.php/review/product/list/id/1/");
		liveHomePage.openURL(driver, Constansts.LIVE_BACKEND_REVIEW_URL);

		log.info("Step 03: Fill the required review and submit it");
		liveHomePage.inputDynamicTextBoxTextArea(driver, review, "review_field");
		liveHomePage.inputDynamicTextBoxTextArea(driver, summaryReview, "summary_field");
		liveHomePage.inputDynamicTextBoxTextArea(driver, nickReview, "nickname_field");
		liveHomePage.scrollToBottomPage(driver);//
		// liveHomePage.sleepInSecond(3);

		liveHomePage.clickDynamicButton(driver, "Submit Review");
		liveHomePage.sleepInSecond(3);
		log.info("Step 04: Go to http: //live.guru99.com/index.php/backendlogin");
		liveAdminPage = liveHomePage.openAdminPage(Constansts.LIVE_BACKEND_URL);

		log.info("Step 05: Login");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, USER, "username");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, PASS, "login");
		liveAdminPage.clickLogin(driver);

		liveAdminPage.clickDynamicMenu(driver, "close");

		log.info("Step 6: Go to Catalogue -> Reviews and Ratings -> Customer Reviews ->Pending Reviews Menu");
		liveAdminPage.clickDynamicMenu(driver, "Catalog");
		liveAdminPage.clickDynamicMenu(driver, "Reviews and Ratings");
		liveAdminPage.clickDynamicMenu(driver, "Customer Reviews");
		liveAdminPage.clickDynamicMenu(driver, "Pending Reviews");

		log.info("Step 07:Sort table by Id and select cormment then click on Edit link");
		liveAdminPage.clickDynamicMenu(driver, "ID");
		liveAdminPage.clickDynamicMenu(driver, "ID");
		liveAdminPage.clickCheckboxTableReview(driver);
		liveAdminPage.clickEditTableReview(driver);

		log.info("Step 08:Change status to 'Approved' and click Save Review");
		liveAdminPage.inputDynamicDropdown(driver, "Approved", "status_id");
		liveAdminPage.clickButtonSaveReview(driver);

		log.info("Step 09: Go to http: //live.guru99.com/ Click Mobile Menu");
		liveHomePage = liveAdminPage.openHomePage(Constansts.LIVE_URL);
		liveHomePage.clickDynamicLink(driver, "Mobile");

		log.info("Step 10: Click on Sony Xperia image.");
		liveHomePage.clickDynamicImg(driver, "Sony Xperia");

		log.info("Step 11: In detail page click on Review tab at bottom of page");
		liveHomePage.scrollToBottomPage(driver);
		liveHomePage.clickReviewTab(driver);

		log.info("Step 12: Verify the review comment is shown");
		verifyEquals(liveHomePage.GetReviewDisplayed(), summaryReview);

		log.info("==============END: " + testMethod.getName() + " ============== ");
	}
@Test
	public void TC_03_VerifySortIsWorkingCorrectly(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 02: Login");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, USER, "username");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, PASS, "login");
		liveAdminPage.clickLogin(driver);

		liveAdminPage.clickDynamicMenu(driver, "close");

		log.info("Step 3: Go to Sales-> Invoice");
		liveAdminPage.clickDynamicMenu(driver, "Sales");
		liveAdminPage.clickDynamicMenu(driver, "Invoices");

		log.info("Step 4: Sort with criteria in ascending and descending order:");
		log.info("Invoice Date");
		liveAdminPage.clickDynamicMenu(driver, "Invoice #");
		liveAdminPage.sleepInSecond(2);

		log.info("lnvoice #");
		liveAdminPage.clickDynamicMenu(driver, "Invoice Date");
		liveAdminPage.sleepInSecond(2);

		log.info("Invoice Date Column");
		liveAdminPage.clickDynamicMenu(driver, "Order #");
		liveAdminPage.sleepInSecond(2);

		log.info("Order #");
		liveAdminPage.clickDynamicMenu(driver, "Order Date");
		liveAdminPage.sleepInSecond(2);

		log.info("Order Date");
		liveAdminPage.clickDynamicMenu(driver, "Bill to Name");
		liveAdminPage.sleepInSecond(2);
		log.info("Bill to Name");
		liveAdminPage.clickDynamicMenu(driver, "Amount");
		log.info("Amount");

		log.info("Step 5: Verify the sort is working as expected");// Lam tiep

		log.info("==============END: " + testMethod.getName() + " ============== ");
	}

	@Test
	public void TC_04_VerifyPaginationFunctionality(Method testMethod) throws ParseException {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 02: Login");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, USER, "username");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, PASS, "login");
		liveAdminPage.clickLogin(driver);

		liveAdminPage.clickDynamicMenu(driver, "close");

		log.info("Step 3: Go to Sales-> Invoice");
		liveAdminPage.clickDynamicMenu(driver, "Sales");
		liveAdminPage.clickDynamicMenu(driver, "Invoices");

		log.info("Step 4: Select view per page with criteria 20/30/50/100/200");

		log.info("- 20");
		liveAdminPage.inputDynamicDropdown(driver, "20", "limit");
		liveAdminPage.sleepInSecond(2);
		
		log.info("- 30");
		liveAdminPage.inputDynamicDropdown(driver, "30", "limit");
		liveAdminPage.sleepInSecond(2);

		log.info("- 50");
		liveAdminPage.inputDynamicDropdown(driver, "50", "limit");
		liveAdminPage.sleepInSecond(2);

		log.info("- 100");
		liveAdminPage.inputDynamicDropdown(driver, "100", "limit");
		liveAdminPage.sleepInSecond(2);

		log.info("- 200");
		liveAdminPage.inputDynamicDropdown(driver, "200", "limit");
		liveAdminPage.sleepInSecond(2);

		log.info("Step 5: Select view per page with criteria 20/30/50/100/200");//// lam tiep
		int CountRowTable = liveAdminPage.countElementNumber(driver,
				"//table[@id='sales_invoice_grid_table']/tbody/tr");
		log.info("AB=" + CountRowTable);
	
		log.info("==============END: " + testMethod.getName() + " ============== ");
	}
@Test
	public void TC_05_VerifySeachFunctionality(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 02: Login");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, USER, "username");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, PASS, "login");
		liveAdminPage.clickLogin(driver);

		liveAdminPage.clickDynamicMenu(driver, "close");

		log.info("Step 3: Go to Customer- > manage customers");
		liveAdminPage.clickDynamicMenu(driver, "Customers");
		liveAdminPage.clickDynamicMenu(driver, "Manage Customers");

		log.info("Step 4: Seach data with each criteria:");
		log.info("ID");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, ID, "customerGrid_filter_entity_id_to");
		liveAdminPage.clickDynamicButton(driver, "Search");
		liveAdminPage.sleepInSecond(2);
		verifyEquals(liveAdminPage.getVerifyTableCustomerLive(driver, "2"), ID);

		log.info("Name");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, Name, "customerGrid_filter_name");
		liveAdminPage.clickDynamicButton(driver, "Search");
		liveAdminPage.sleepInSecond(2);
		verifyEquals(liveAdminPage.getVerifyTableCustomerLive(driver, "3"), Name);

		log.info("Email");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, Email, "customerGrid_filter_email");
		liveAdminPage.clickDynamicButton(driver, "Search");
		liveAdminPage.sleepInSecond(2);
		verifyEquals(liveAdminPage.getVerifyTableCustomerLive(driver, "4"), Email);

		log.info("Telephone");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, Telephone, "customerGrid_filter_Telephone");
		liveAdminPage.clickDynamicButton(driver, "Search");
		liveAdminPage.sleepInSecond(2);
		verifyEquals(liveAdminPage.getVerifyTableCustomerLive(driver, "6"), Telephone);

		log.info("Zip");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, Zip, "customerGrid_filter_billing_postcode");
		liveAdminPage.clickDynamicButton(driver, "Search");
		liveAdminPage.sleepInSecond(2);
		verifyEquals(liveAdminPage.getVerifyTableCustomerLive(driver, "7"), Zip);

		log.info("Country");
		liveAdminPage.inputDynamicDropdown(driver, Country, "billing_country_id");
		liveAdminPage.clickDynamicButton(driver, "Search");
		liveAdminPage.sleepInSecond(2);
		verifyEquals(liveAdminPage.getVerifyTableCustomerLive(driver, "8"), Country);

		log.info("State");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, State, "customerGrid_filter_billing_region");
		liveAdminPage.clickDynamicButton(driver, "Search");
		liveAdminPage.sleepInSecond(2);
		verifyEquals(liveAdminPage.getVerifyTableCustomerLive(driver, "9"), State);// lafm tieeps

		log.info("==============END: " + testMethod.getName() + " ============== ");
	}
@Test
	public void TC_06_VerifySelectCheckboxFunctionality(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 02: Login");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, USER, "username");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, PASS, "login");
		liveAdminPage.clickLogin(driver);

		liveAdminPage.clickDynamicMenu(driver, "close");

		log.info("Step 3: Go to Sales- > Orders");
		liveAdminPage.clickDynamicMenu(driver, "Sales");
		liveAdminPage.clickDynamicMenu(driver, "Orders");

		log.info("Step 4: Click Select Visible link");
		liveAdminPage.clickDynamicLink(driver, "Select Visible");
		verifyEquals(liveAdminPage.getVerifyItemsSelectedLive(driver, "sales_order_grid_massaction-count"), "20");// ???

		log.info("Step 5: Click Unselect Visible link");
		liveAdminPage.clickDynamicLink(driver, "Unselect Visible");
		verifyEquals(liveAdminPage.getVerifyItemsSelectedLive(driver, "sales_order_grid_massaction-count"), "0");

		log.info("==============END: " + testMethod.getName() + " ============== ");
	}
@Test
	public void TC_07_VerifyDisabledFields(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 02: Login");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, USER, "username");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, PASS, "login");
		liveAdminPage.clickLogin(driver);

		liveAdminPage.clickDynamicMenu(driver, "close");

		log.info("Step 3: Go to Customer -> Manage Customer menu");
		liveAdminPage.clickDynamicMenu(driver, "Customers");
		liveAdminPage.clickDynamicMenu(driver, "Manage Customers");

		log.info("Step 4: Open any customer's detail by clicking on view link in the grid");

		log.info("Step 5: Click on 'Account Information' tab for the customer's detail page");

		log.info("Step 6:  Verify disabled fields");

		log.info("Step 7:  Verify Blank fields");

		log.info("==============END: " + testMethod.getName() + " ============== ");
	}

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void beforeClass(String browserName, String url) {
		driver = opentMultiBrowser(browserName, url);
		liveAdminPage = LivePageFactoryManager.getAdminPageLive(driver);

		USER = "user01";
		PASS = "guru99com";
		review = "This is good prouct";
		summaryReview = "GOOD";
		nickReview = "Huyen Trang";

		ID = "32562";
		Name = "Automation FC";
		Email = "automationfc.vn@gmail.com ";
		Telephone = "0123654789";
		Zip = "550000";
		Country = "Vietnam";
		State = "Cam Le";
	}

	@AfterMethod(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
