package bankguru.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import commons.AbstractPage;


public class LoginPageFactory extends AbstractPage {
	private WebDriver driver;
	
	@FindBy(how= How.XPATH, using="//form[@name='frmLogin']")
	private WebElement loginForm;
	
	@FindBy(how= How.NAME, using="uid")
	private WebElement userIDTextbox;
	
	@FindBy(how= How.NAME, using="password")
	private WebElement passwordTextbox;
	
	@FindBy(how= How.CSS, using="//input[@name='btnLogin']")
	private WebElement loginButton;
	
	@FindBy(how= How.XPATH, using="//a[text()='here']")
	private WebElement hereLink;
	
	@FindBy(how= How.NAME, using="emailid")
	private WebElement emailIDTextbox;
	
	public LoginPageFactory(WebDriver mappingDriver) {
		this.driver=mappingDriver;
		//driver=mappingDriver;
		PageFactory.initElements(driver, this.getClass());
		//PageFactory.initElements(driver.this);
	}
	public boolean isLoginFormDisplayes() {
		return loginForm.isDisplayed();
	}
	public String getLoginPageUrl() {
		return getCurrenUrl(driver);
	}
	
	public void inputToUserIDTextbox(String userID) {
		userIDTextbox.sendKeys(userID);
	}
	public void inputToPasswordTextbox(String password) {
		passwordTextbox.sendKeys(password);
	}
	public void clickToLoginButton() {
		loginButton.click();
	}

	public void clickToHereLink() {
		hereLink.click();
	}
	

}
