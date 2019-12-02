package com.bankguru.login;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.RegisterLogin_Global;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class Login_01_ValidateLoginForm extends AbstractTest {
	private WebDriver driver;
	public static String USER_ID, PASSWORD, EMAIL, EMAIL_INVALID,PASS_INCORRECT;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@Test
	public void TC_01_LoginWithEmailInvalid(Method testMethod) {
		log.info("============== START:  " + testMethod.getName() + "============== ");

		log.info("Step 01: Click to hete link");
		registerPage = loginPage.clickToHereLink();

		log.info("Step 02: Input data to Email textbox");
		registerPage.inputDynamicText(driver, EMAIL_INVALID, "emailid");

		log.info("Step 03: Click to Submit button");
		registerPage.clickDynamicSubmit(driver, "btnLogin");

		log.info("Step 04: verify Msg");
		verifyEquals(registerPage.getDynamicText(driver, "Email ID is not valid"), "Email ID is not valid");

		log.info("============== AND:  " + testMethod.getName() + "============== ");
	}

	@Test
	public void TC_02_LoginWithEmailValid(Method testMethod) {
		log.info("============== START:  " + testMethod.getName() + "============== ");
		log.info("Step 01: Click to hete link");
		registerPage = loginPage.clickToHereLink();

		log.info("Step 02: Input data to Email textbox");
		registerPage.inputDynamicText(driver, EMAIL, "emailid");

		log.info("Step 03: Click to Submit button");
		registerPage.clickDynamicSubmit(driver, "btnLogin");
		
		log.info("TC_01 - Step 04: Get User/ Pass information");
		
		USER_ID=registerPage.getDynamicTextDisplayed(driver, "User ID :");
		log.info("USER_ID:  "+ USER_ID);

		PASSWORD=registerPage.getDynamicTextDisplayed(driver, "Password :");
		log.info("PASSWORD:  "+ PASSWORD);
	
		log.info("============== AND:  " + testMethod.getName() + "============== ");
	}

	@Test
	public void TC_03_LoginWithPasswordLessThan6Chars(Method testMethod) {
		log.info("============== START:  " + testMethod.getName() + "============== ");
		log.info("Step 01: Input data to UserID");
		loginPage.inputDynamicText(driver, RegisterLogin_Global.USER_ID, "uid");
		
		log.info("Step 02: Input data to Password");
		loginPage.inputDynamicText(driver, "123", "password");

		log.info("Step 03: Click to Submit button");
		homePage = loginPage.clickToLoginButton();

		log.info("Step 04:Verify and Accep alert ");
		String ABC=homePage.getTextAlert(driver);
		System.out.println("ABC="+ABC);
		verifyEquals(homePage.getTextAlert(driver),"User or Password is not valid");
		homePage.acceptAlert(driver);

		log.info("============== AND:  " + testMethod.getName() + "============== ");
	}

	@Test
	public void TC_04_LoginWithPaswordIncorrect(Method testMethod) {
		log.info("============== START:  " + testMethod.getName() + "============== ");
		log.info("Step 01: Input data to UserID");
		loginPage.inputDynamicText(driver, RegisterLogin_Global.USER_ID, "uid");
		
		log.info("Step 02: Input data to Password");
		loginPage.inputDynamicText(driver, PASS_INCORRECT, "password");

		log.info("Step 03: Click to Submit button");
		homePage = loginPage.clickToLoginButton();

		log.info("Step 04:Verify and Accep alert ");
		verifyEquals(homePage.getTextAlert(driver),"User or Password is not valid");
		homePage.acceptAlert(driver);

		log.info("============== AND:  " + testMethod.getName() + "============== ");
	}

	@Test
	public void TC_05_LoginWithUserAndPassValid(Method testMethod) {
		log.info("============== START:  " + testMethod.getName() + "============== ");
		log.info("Step 01: Input data to UserID");
		loginPage.inputDynamicText(driver, RegisterLogin_Global.USER_ID, "uid");
		
		log.info("Step 02: Input data to Password");
		loginPage.inputDynamicText(driver, RegisterLogin_Global.PASSWORD, "password");

		log.info("Step 03: Click to Submit button");
		homePage = loginPage.clickToLoginButton();

		log.info("Step 04: verify Home Page");
		verifyTrue(homePage.isHomePageDisplayed());

		log.info("============== AND:  " + testMethod.getName() + "============== ");
	}

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void beforeClass(String browserName, String url) {
		EMAIL = "seleniumonline" + randomNumber() + "@gmail.com";
		driver = opentMultiBrowser(browserName, url);
		loginPage = PageFactoryManager.getLoginPage(driver);
		EMAIL_INVALID = "Email";
		PASS_INCORRECT="PASS_INCORRECT";
	}

	@AfterMethod(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
