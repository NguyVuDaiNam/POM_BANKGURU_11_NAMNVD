package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;


public class CustomizedStatementPageObject extends AbstractPage {
	WebDriver driver;

	public CustomizedStatementPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
}
