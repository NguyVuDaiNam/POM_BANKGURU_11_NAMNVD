package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;


public class LiveRegisterPageObject extends AbstractPage {
	WebDriver driver;

	public LiveRegisterPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
}
