package com.bankguru.customer;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.RegisterLogin_Global;

import commons.AbstractTest;
import commons.Constansts;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;

public class Customer_03_DeleteCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;

	private DeleteCustomerPageObject deleteCustomerPage;

	@Test
	public void TC_01_CustomerIDCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Customer ID");
		deleteCustomerPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "cusid");

		log.info("Step 02: Press Tab Customer ID");
		deleteCustomerPage.DynamicPressTab(driver, "cusid");

		log.info("Step 03: Verify text Customer ID");
		verifyEquals(deleteCustomerPage.getDynamicText(driver, "Customer ID is required"),"Customer ID is required");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_02_CustomerIDMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Customer ID must be numeric");
		deleteCustomerPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "cusid");


		log.info("Step 03: Verify text Customer ID");
		verifyEquals(deleteCustomerPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_03_CustomerIDCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in CustomerID");
		
		deleteCustomerPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "cusid");
		
		verifyEquals(deleteCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_04_CustomerIDCannotHaveBlankSpage(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Customer ID Cannot Have bank spage");
		
		deleteCustomerPage.inputDynamicText(driver, Constansts.NUMBER_SPAGE_SENKEY, "cusid");
		
		verifyEquals(deleteCustomerPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_05_CustomerIDFirstCannotSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Customer ID First Cannot space");
		
		deleteCustomerPage.inputDynamicText(driver, Constansts.FIRST_SPAGE_NUMMER_SENKEY, "cusid");
		
		verifyEquals(deleteCustomerPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_06_DeleteCustomerIDValid(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Enter valid CustomerID");
		deleteCustomerPage.inputDynamicText(driver, Customer_01_NewCustomer.CUSTOMER_ID, "cusid");
		
		log.info("Step 02: Click Submit");
		deleteCustomerPage.clickDynamicSubmit(driver, "AccSubmit");
		
		log.info("Step 03: accept Alert Delete");
		deleteCustomerPage.acceptAlert(driver);
		
		log.info("Step 04: accept Alert Delete Successfully");
		deleteCustomerPage.acceptAlert(driver);
		
		log.info("Step 05: Verify  Home page");
		verifyTrue(homePage.isHomePageDisplayed());
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("============== START: LOGIN ============== ");
		driver = opentMultiBrowser(browserName, url);
		loginPage = PageFactoryManager.getLoginPage(driver);

		log.info("Step 01: Input data to UserID");
		loginPage.inputDynamicText(driver, RegisterLogin_Global.USER_ID, "uid");
		
		log.info("Step 02: Input data to Password");
		loginPage.inputDynamicText(driver, RegisterLogin_Global.PASSWORD, "password");

		log.info("Step 03: Click to Submit button");
		homePage = loginPage.clickToLoginButton();

		log.info("Step 04: verify Home Page");
		verifyTrue(homePage.isHomePageDisplayed());

		log.info("============== AND: LOGIN ============== ");

		log.info("Step: Click Delete Customer");
		deleteCustomerPage = (DeleteCustomerPageObject) homePage.openDynamicPage(driver, "Delete Customer");
		
		log.info("Step: Verify Delete Customer Displayed");
		verifyTrue(deleteCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Delete Customer Form"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
