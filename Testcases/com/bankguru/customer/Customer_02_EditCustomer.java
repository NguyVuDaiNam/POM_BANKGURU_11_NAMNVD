package com.bankguru.customer;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.RegisterLogin_Global;

import commons.AbstractTest;
import commons.Constansts;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;

public class Customer_02_EditCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;

	private EditCustomerPageObject editCustomerPage;

	@Test
	public void TC_01_CustomerIDCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Customer ID");
		editCustomerPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "cusid");

		log.info("Step 02: Press Tab Customer ID");
		editCustomerPage.DynamicPressTab(driver, "cusid");

		log.info("Step 03: Verify text Customer ID");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Customer ID is required"),"Customer ID is required");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_02_CustomerIDMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Customer ID must be numeric");
		editCustomerPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "cusid");


		log.info("Step 03: Verify text Customer ID");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_03_CustomerIDCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Customer ID");
		
		editCustomerPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "cusid");
		
		verifyEquals(editCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_04_CustomerIDValid(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Enter valid Customer ID");
		editCustomerPage.inputDynamicText(driver, Customer_01_NewCustomer.CUSTOMER_ID, "cusid");
		
		log.info("Step 02: Click Submit");
		editCustomerPage.clickDynamicSubmit(driver, "AccSubmit");
		
		log.info("Step 03: Verify ");
		editCustomerPage.isDynamicSuccessfullyPageDisplayed(driver,"Edit Customer");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_05_NameCannotEmpty(Method testMethod) {
		log.info("==============  "+testMethod.getName()+" ============== ");
		log.info("SYTEM NOT EDIT");
	}
	@Test
	public void TC_06_NameCannotNumeric(Method testMethod) {
		log.info("==============  "+testMethod.getName()+" ============== ");
		log.info("SYTEM NOT EDIT");
	}
	@Test
	public void TC_07_NameCannotHaveSpecialCharacter(Method testMethod) {
		log.info("==============  "+testMethod.getName()+" ============== ");
		log.info("SYTEM NOT EDIT");
	}
	@Test
	public void TC_08_AddressCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Address");
		editCustomerPage.inputDynamicTextArea(driver, Constansts.BLANK_SENKEY, "addr");

		log.info("Step 02: Press Tab Address");
		editCustomerPage.DynamicPressTabTextArea(driver, "addr");

		log.info("Step 03: Verify text Address");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Address Field must not be blank"),"Address Field must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}

	@Test
	public void TC_09_CityCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value City");
		editCustomerPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "city");

		log.info("Step 02: Press Tab City");
		editCustomerPage.DynamicPressTab(driver, "city");

		log.info("Step 03: Verify text city");
		verifyEquals(editCustomerPage.getDynamicText(driver, "City Field must not be blank"),"City Field must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_10_CityCannotNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: City must be numeric");
		editCustomerPage.inputDynamicText(driver, Constansts.NUMBER_SENKEY, "city");


		log.info("Step 03: Verify text City");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Numbers are not allowed"),"Numbers are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_11_CityCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in city");
		
		editCustomerPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "city");
		
		verifyEquals(editCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_12_StateCannotEmpty(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value State");
		editCustomerPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "state");

		log.info("Step 02: Press Tab State");
		editCustomerPage.DynamicPressTab(driver, "state");

		log.info("Step 03: Verify text State");
		verifyEquals(editCustomerPage.getDynamicText(driver, "State must not be blank"),"State must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_13_stateCanNotNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: state must be numeric");
		editCustomerPage.inputDynamicText(driver, Constansts.NUMBER_SENKEY, "state");


		log.info("Step 03: Verify text state");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Numbers are not allowed"),"Numbers are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_14_stateCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in state");
		editCustomerPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "state");
		
		log.info("Step 02: Verify text State");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	
	@Test
	public void TC_15_PinMustBeNumeric(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: state must be numeric");
		editCustomerPage.inputDynamicText(driver, Constansts.CHARACTER_SENKEY, "pinno");

		log.info("Step 02: Verify text Pin");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Characters are not allowed"),"Characters are not allowed");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_16_PinCannotEmpty(Method testMethod) {///
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Pin");
		editCustomerPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "pinno");
		
		log.info("Step 02: Press Tab Pin");
		editCustomerPage.DynamicPressTab(driver, "pinno");
		
		log.info("Step 03: Verify text Pin");
		verifyEquals(editCustomerPage.getDynamicText(driver, "PIN Code must not be blank"),"PIN Code must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_17_PinHave6Digits(Method testMethod) {///
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Pin");
		editCustomerPage.inputDynamicText(driver, Constansts.NUMBER_MIN_SENKEY, "pinno");

		log.info("Step 02: Verify text Pin");
		verifyEquals(editCustomerPage.getDynamicText(driver, "PIN Code must have 6 Digits"),"PIN Code must have 6 Digits");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}

	@Test
	public void TC_18_PinCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in pin");
		editCustomerPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "pinno");
		
		log.info("Step 02: Verify text Pin");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_19_TelephoneCannotEmpty(Method testMethod) {///
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Telephone");
		editCustomerPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "telephoneno");

		log.info("Step 02: Press Tab Telephone");
		editCustomerPage.DynamicPressTab(driver, "telephoneno");
		
		log.info("Step 03: Verify text Telephone");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Mobile no must not be blank"),"Mobile no must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_20_TelephoneCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in telephone");
		editCustomerPage.inputDynamicText(driver, Constansts.SPECIAL_SENKEY, "telephoneno");
		
		log.info("Step 02: Verify text telephone");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_21_EmailCannotEmpty(Method testMethod) {///
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Do not enter a value Email");
		editCustomerPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "emailid");

		log.info("Step 02: Press Tab Email");
		editCustomerPage.DynamicPressTab(driver, "emailid");
		
		log.info("Step 03: Verify text Email");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Email-ID must not be blank"),"Email-ID must not be blank");
				
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_22_EmailInvalide(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Enter invalid in Email");
		editCustomerPage.inputDynamicText(driver, Constansts.EMAIL1_SENKEY, "emailid");
		log.info("Step 02: Verify text Email");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		log.info("Step 03: Enter invalid in Email");
		editCustomerPage.inputDynamicText(driver, Constansts.EMAIL2_SENKEY, "emailid");
		log.info("Step 04: Verify text Email");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		log.info("Step 05: Enter invalid in Email");
		editCustomerPage.inputDynamicText(driver, Constansts.EMAIL3_SENKEY, "emailid");
		log.info("Step 06: Verify text Email");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		log.info("Step 07: Enter invalid in Email");
		editCustomerPage.inputDynamicText(driver, Constansts.EMAIL4_SENKEY, "emailid");
		log.info("Step 08: Verify text Email");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		log.info("Step 09: Enter invalid in Email");
		editCustomerPage.inputDynamicText(driver, Constansts.EMAIL5_SENKEY, "emailid");
		log.info("Step 10: Verify text Email");
		verifyEquals(editCustomerPage.getDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_31_ValidAllField(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Enter valid edit Address");
		editCustomerPage.inputDynamicTextArea(driver, Constansts.EDIT_ADDRESS_SENKEY, "addr");
		
		log.info("Step 02: Enter valid edit City");
		editCustomerPage.inputDynamicText(driver, Constansts.EDIT_CITY_SENKEY, "city");
		
		log.info("Step 03: Enter valid edit State");
		editCustomerPage.inputDynamicText(driver, Constansts.EDIT_STATE_SENKEY, "state");
		
		log.info("Step 04: Enter valid edit Pin");
		editCustomerPage.inputDynamicText(driver, Constansts.EDIT_PIN_SENKEY, "pinno");
		
		log.info("Step 05: Enter valid edit Moblile number");
		editCustomerPage.inputDynamicText(driver, Constansts.EDIT_MOBILE_SENKEY, "telephoneno");
		
		log.info("Step 06: Enter valid edit Email");
		editCustomerPage.inputDynamicText(driver, RegisterLogin_Global.EMAIL, "emailid");
		
		log.info("Step 06: Click Submit");
		editCustomerPage.clickDynamicSubmit(driver, "sub");
	
		log.info("Step 07: Verify successfully editCustomer");
		editCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Customer details updated Successfully!!!");
		
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

		log.info("Step: Click Edit Customer");
		editCustomerPage = (EditCustomerPageObject) homePage.openDynamicPage(driver, "Edit Customer");
		Assert.assertTrue(editCustomerPage.isEditCustomerPageDisplayed());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
