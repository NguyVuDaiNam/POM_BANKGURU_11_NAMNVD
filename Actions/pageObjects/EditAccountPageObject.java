package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;


public class EditAccountPageObject extends AbstractPage{
	WebDriver driver;
	public EditAccountPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	
}
