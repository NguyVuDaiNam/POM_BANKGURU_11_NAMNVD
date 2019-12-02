package com.bankguru.account;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class RegisterLogin_Level_2_Apply_AbstractPage_MultiBrowser_C1 extends AbstractPage {
	WebDriver driver;
	private String email, UserID, password, LoginURL;

	@Test
	public void TC_01_RegisterToSystem() {

		openURL(driver, "http://demo.guru99.com/V4");
		LoginURL = getCurrenUrl(driver);
		clickToElement(driver, "//a[text()='here']");
		Assert.assertTrue(isControlDisplayed(driver, "//input[@name='emailid']"));
		senkeyToElement(driver, "//input[@name='emailid']", email);
		clickToElement(driver, "//input[@type='submit']");
		UserID = getTextInElement(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getTextInElement(driver, "//td[text()='Password :']/following-sibling::td");
	}

	@Test
	public void TC_02_LoginWithAboveInformation() {

		openURL(driver, LoginURL);
		senkeyToElement(driver, "//input[@name='uid']", UserID);
		Assert.assertTrue(isControlDisplayed(driver, "//form[@name='frmLogin']"));
		senkeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		Assert.assertTrue(isControlDisplayed(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
		Assert.assertTrue(isControlDisplayed(driver, "//td[text()='Manger Id : " + UserID +"']"));

	}


	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		email = "seleniumonline" + randomNumber() + "@gmail.com";
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
