package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterLogin_Level_1_StepByStep {
	WebDriver driver;
	private String email, UserID, password, LoginURL;//
	@Test
	  public void TC_01_RegisterToSystem() {
		
		  driver.get("http://demo.guru99.com/V4");
		  LoginURL=driver.getCurrentUrl();
		  driver.findElement(By.xpath("//a[text()='here']")).click();
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@name='emailid']")).isDisplayed());
		  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  UserID=driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		  password=driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		  
		  System.out.println("UserID: "+UserID);
		  System.out.println("Password: "+ password);
		  
	  }
	  @Test
	  public void TC_02_LoginWithAboveInformation() {
		  
		  driver.get(LoginURL);
		  Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
		  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(UserID);
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		  Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
		  Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : "+UserID+"']")).isDisplayed());

	  }
	  public int randomNumber() {
		  Random random= new Random();
		  int number=random.nextInt(999);
		  return number;
	  }
	  
	  @BeforeClass
	  public void beforeClass() {
		  driver= new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			email="seleniumonline"+randomNumber()+"@gmail.com";
	  }

	  @AfterClass(alwaysRun = true)
	  public void afterClass() {
		 driver.quit();
	  }
}
