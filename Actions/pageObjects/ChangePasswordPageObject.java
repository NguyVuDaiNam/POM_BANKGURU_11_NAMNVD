package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;


public class ChangePasswordPageObject extends AbstractPage {
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
}
