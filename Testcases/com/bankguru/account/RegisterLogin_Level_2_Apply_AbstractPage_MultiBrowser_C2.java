package com.bankguru.account;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;

public class RegisterLogin_Level_2_Apply_AbstractPage_MultiBrowser_C2 extends AbstractTest {
	private WebDriver driver;
	private AbstractPage abstractPage;
	private String email, UserID, password, LoginURL;

	@Test
	public void TC_01_RegisterToSystem() {

		abstractPage.openURL(driver, "http://demo.guru99.com/V4");
		LoginURL = abstractPage.getCurrenUrl(driver);
		abstractPage.clickToElement(driver, "//a[text()='here']");
		Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//input[@name='emailid']"));
		abstractPage.senkeyToElement(driver, "//input[@name='emailid']", email);
		abstractPage.clickToElement(driver, "//input[@type='submit']");
		UserID = abstractPage.getTextInElement(driver, "//td[text()='User ID :']/following-sibling::td");
		password = abstractPage.getTextInElement(driver, "//td[text()='Password :']/following-sibling::td");

	}

	@Test
	public void TC_02_LoginWithAboveInformation() {

		abstractPage.openURL(driver, LoginURL);
		Assert.assertTrue(abstractPage.isControlDisplayed(driver,"//form[@name='frmLogin']"));
		abstractPage.senkeyToElement(driver, "//input[@name='uid']", UserID);
		abstractPage.senkeyToElement(driver, "//input[@name='password']", password);
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
		Assert.assertTrue(abstractPage.isControlDisplayed(driver,"//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
		Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//td[text()='Manger Id : " + UserID + "']"));

	}

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver=opentMultiBrowser(browserName,url);
		System.out.println("Driver in tesst case: "+driver.toString());
		abstractPage = new AbstractPage();
		email = "seleniumonline" + abstractPage.randomNumber() + "@gmail.com";

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
