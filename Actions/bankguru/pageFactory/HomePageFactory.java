package bankguru.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import commons.AbstractPage;


public class HomePageFactory extends AbstractPage {
	private WebDriver driver;
	
	@FindBy(how= How.XPATH, using="//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")
	private WebElement welcomeMessage;
	
	
	

	public HomePageFactory(WebDriver mappingDriver) {
		this.driver=mappingDriver;
		//driver=mappingDriver;
		PageFactory.initElements(driver, this.getClass());
		//PageFactory.initElements(driver.this);
	}
	public boolean isWebcomeMessageDisplayed() {
		return welcomeMessage.isDisplayed();
	}
	
	

}
