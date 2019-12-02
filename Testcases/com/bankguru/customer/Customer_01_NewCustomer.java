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
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;

public class Customer_01_NewCustomer extends AbstractTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	public static String CUSTOMER_ID;

	@Test
	public void TC_01_NameCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Name");
		//newCustomerPage.inputNameText(Constansts.BLANK_SENKEY);
		newCustomerPage.inputDynamicText(driver, Constansts.BLANK_SENKEY, "name");
		
		log.info("Step 02: Press Tab");
		//newCustomerPage.namePressTab();
		newCustomerPage.DynamicPressTab(driver, "name");
	
		log.info("Step 03: Verify Name");
		
		verifyEquals(newCustomerPage.getDynamicText(driver, "Customer name must not be blank"), "Customer name must not be blank");
		//verifyEquals(newCustomerPage.getNameDynamicText(driver, "Customer name must not be blank"), "Customer name must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_02_NameCannotNumeric(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Numeric value in Name");
		//newCustomerPage.inputNameText(Constansts.NUMBER_SENKEY);
		newCustomerPage.inputDynamicText(driver,Constansts.NUMBER_SENKEY,"name");
		
		verifyEquals(newCustomerPage.getDynamicText(driver, "Numbers are not allowed"), "Numbers are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_03_NameCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Name");
		newCustomerPage.inputDynamicText(driver,Constansts.SPECIAL_SENKEY,"name");
		
		verifyEquals(newCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_04_NameCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Name");
		newCustomerPage.inputDynamicText(driver,Constansts.FIRST_SPAGE_SENKEY,"name");
		
		verifyEquals(newCustomerPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_05_AddressCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Address");
		newCustomerPage.inputDynamicTextArea(driver,Constansts.BLANK_SENKEY,"addr");
		
		log.info("Step 02: Press Tab");
		newCustomerPage.DynamicPressTabTextArea(driver,"addr");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "Address Field must not be blank"), "Address Field must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_06_AddressCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Address");
		newCustomerPage.inputDynamicTextArea(driver,Constansts.FIRST_SPAGE_SENKEY,"addr");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_07_AddressCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Address");
		newCustomerPage.inputDynamicTextArea(driver,Constansts.SPECIAL_SENKEY,"addr");
		
		verifyEquals(newCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_08_CityCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value City");
		newCustomerPage.inputDynamicText(driver,Constansts.BLANK_SENKEY,"city");
		
		log.info("Step 02: Press Tab");
		newCustomerPage.DynamicPressTab(driver,"city");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "City Field must not be blank"), "City Field must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_09_CityCannotNumeric(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Numeric value in City");
		newCustomerPage.inputDynamicText(driver,Constansts.NUMBER_SENKEY,"city");
		
		verifyEquals(newCustomerPage.getDynamicText(driver, "Numbers are not allowed"), "Numbers are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_10_CityCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in City");
		newCustomerPage.inputDynamicText(driver,Constansts.SPECIAL_SENKEY,"city");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_11_CityCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in City");
		newCustomerPage.inputDynamicText(driver,Constansts.FIRST_SPAGE_SENKEY,"city");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_12_StateCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value State");
		newCustomerPage.inputDynamicText(driver,Constansts.BLANK_SENKEY,"state");
		
		log.info("Step 02: Press Tab");
		newCustomerPage.DynamicPressTab(driver, "state");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "State must not be blank"), "State must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_13_StateCannotNumeric(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Numeric value in State");
		newCustomerPage.inputDynamicText(driver,Constansts.NUMBER_SENKEY,"state");
			
		verifyEquals(newCustomerPage.getDynamicText(driver, "Numbers are not allowed"), "Numbers are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_14_StateCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in State");
		newCustomerPage.inputDynamicText(driver,Constansts.SPECIAL_SENKEY,"state");
		
		verifyEquals(newCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_15_StateCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in State");
		newCustomerPage.inputDynamicText(driver,Constansts.FIRST_SPAGE_SENKEY,"state");
				
		verifyEquals(newCustomerPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_16_PinIsNumeric(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Pin");
		newCustomerPage.inputDynamicText(driver,Constansts.CHARACTER_SENKEY,"pinno");
			
		verifyEquals(newCustomerPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_17_PinCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Pin");
		newCustomerPage.inputDynamicText(driver,Constansts.BLANK_SENKEY,"pinno");
		
		log.info("Step 02: Pin Press Tab");
		newCustomerPage.DynamicPressTab(driver, "pinno");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "PIN Code must not be blank"), "PIN Code must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_18_PinHave6Digits(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Numeric value in Pin");
		newCustomerPage.inputDynamicText(driver,Constansts.NUMBER_MIN_SENKEY,"pinno");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "PIN Code must have 6 Digits"), "PIN Code must have 6 Digits");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_19_PinCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Pin");
		newCustomerPage.inputDynamicText(driver,Constansts.SPECIAL_SENKEY,"pinno");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_20_PinCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Pin");
		newCustomerPage.inputDynamicText(driver,Constansts.FIRST_SPAGE_SENKEY,"pinno");

		verifyEquals(newCustomerPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_21_PinCannotHaveSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Pin");
		newCustomerPage.inputDynamicText(driver,Constansts.NUMBER_SPAGE_SENKEY,"pinno");
			
		verifyEquals(newCustomerPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_22_TelephoneCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Telephone");
		newCustomerPage.inputDynamicText(driver,Constansts.BLANK_SENKEY,"telephoneno");
		
		log.info("Step 02: Press Tab");
		newCustomerPage.DynamicPressTab(driver, "telephoneno");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "Mobile no must not be blank"), "Mobile no must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_23_TelephoneCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Telephone");
		newCustomerPage.inputDynamicText(driver,Constansts.FIRST_SPAGE_SENKEY,"telephoneno");
				
		verifyEquals(newCustomerPage.getDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_24_TelephoneCannotHaveSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Telephone");
		newCustomerPage.inputDynamicText(driver,Constansts.NUMBER_SPAGE_SENKEY,"telephoneno");
			
		verifyEquals(newCustomerPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_25_TelephoneCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Telephone");
		newCustomerPage.inputDynamicText(driver,Constansts.SPECIAL_SENKEY,"telephoneno");
		
		verifyEquals(newCustomerPage.getDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_26_EmailCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Telephone");
		newCustomerPage.inputDynamicText(driver,Constansts.BLANK_SENKEY,"emailid");
		
		log.info("Step 02: Press Tab");
		newCustomerPage.DynamicPressTab(driver, "emailid");
	
		verifyEquals(newCustomerPage.getDynamicText(driver, "Email-ID must not be blank"), "Email-ID must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_27_EmailMustCorrectFormat(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Email must be in correct format");
		newCustomerPage.inputDynamicText(driver,Constansts.EMAIL1_SENKEY,"emailid");
		verifyEquals(newCustomerPage.getDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		newCustomerPage.inputDynamicText(driver,Constansts.EMAIL2_SENKEY,"emailid");
		verifyEquals(newCustomerPage.getDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		newCustomerPage.inputDynamicText(driver,Constansts.EMAIL3_SENKEY,"emailid");
		verifyEquals(newCustomerPage.getDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		newCustomerPage.inputDynamicText(driver,Constansts.EMAIL4_SENKEY,"emailid");
		verifyEquals(newCustomerPage.getDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		newCustomerPage.inputDynamicText(driver,Constansts.EMAIL5_SENKEY,"emailid");
		verifyEquals(newCustomerPage.getDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	//@Test 
	public void TC_29_EmailCannotHaveSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Email");
		newCustomerPage.inputDynamicText(driver,Constansts.NUMBER_SPAGE_SENKEY,"emailid");
			
		verifyEquals(newCustomerPage.getDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test 
	public void TC_30_VerifyLabels(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Verify Faile Label Customer Name");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Customer Name"),"Customer Name");
		
		log.info("Step 02: Verify Faile Label Gender");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Gender"),"Gender");
		
		log.info("Step 03: Verify Faile Label Date of Birth");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Date of Birth"),"Date of Birth");
		
		log.info("Step 04: Verify Faile Label Address");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Address"),"Address");
		
		log.info("Step 05: Verify Faile Label City");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "City"),"City");
		
		log.info("Step 06: Verify Faile Label State");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "State"),"State");
		
		log.info("Step 07: Verify Faile Label PIN");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "PIN"),"PIN");
		
		log.info("Step 08: Verify Faile Label Mobile Number");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Mobile Number"),"Mobile Number");
		
		log.info("Step 09: Verify Faile Label E-mail");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "E-mail"),"E-mail");
		
		log.info("Step 10: Verify Faile Label Password");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Password"),"Password");
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_31_ValidAllField(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		log.info("Step 01: Enter valid Customer Name");
		newCustomerPage.inputDynamicText(driver, Constansts.CUSTOMER_NAME_SENKEY, "name");
		log.info("Step 02: Enter valid  Date of birth");
		newCustomerPage.inputDynamicText(driver, Constansts.DATEOFBIRTH_SENKEY, "dob");
		log.info("Step 01: Enter valid Address");
		newCustomerPage.inputDynamicTextArea(driver, Constansts.ADDRESS_SENKEY, "addr");
		log.info("Step 01: Enter valid city");
		newCustomerPage.inputDynamicText(driver, Constansts.CITY_SENKEY, "city");
		log.info("Step 01: Enter valid State");
		newCustomerPage.inputDynamicText(driver, Constansts.STATE_SENKEY, "state");
		log.info("Step 01: Enter valid PIN");
		newCustomerPage.inputDynamicText(driver, Constansts.PIN_SENKEY, "pinno");
		log.info("Step 01: Enter valid Mobile");
		newCustomerPage.inputDynamicText(driver, Constansts.MOBILE_SENKEY, "telephoneno");
		log.info("Step 01: Enter valid Email");
		newCustomerPage.inputDynamicText(driver, RegisterLogin_Global.EMAIL, "emailid");
		log.info("Step 01: Enter valid Password");
		newCustomerPage.inputDynamicText(driver, Constansts.PASSWORD_SENKEY, "password");
		log.info("Step 01: Click button submit");
		newCustomerPage.clickDynamicSubmit(driver, "sub");
		log.info("Step 01: Verify successfully new Customer");
		newCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Customer Registered Successfully!!!");
		CUSTOMER_ID=newCustomerPage.getDynamicTextDisplayed(driver, "Customer ID");
		log.info("CUSTOMER_ID : "+CUSTOMER_ID);
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("============== START: LOGIN ============== ");
		driver=opentMultiBrowser(browserName, url);
		loginPage =PageFactoryManager.getLoginPage(driver);
		
		log.info("Step 01: Input data to UserID");
		//loginPage.inputToUserIDTextbox(RegisterLogin_Global.USER_ID);
		loginPage.inputDynamicText(driver, RegisterLogin_Global.USER_ID, "uid");
		
		log.info("Step 02: Input data to Password");
		//loginPage.inputToPasswordTextbox(RegisterLogin_Global.PASSWORD);
		loginPage.inputDynamicText(driver, RegisterLogin_Global.PASSWORD, "password");
		
		log.info("Step 03: Click to Submit button");
		homePage=loginPage.clickToLoginButton();
		
		log.info("Step 04: verify Home Page");
		verifyTrue(homePage.isHomePageDisplayed());
		
		log.info("============== AND: LOGIN ============== ");
		
		log.info("Step: Click New Customer");
		newCustomerPage=(NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());


	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
