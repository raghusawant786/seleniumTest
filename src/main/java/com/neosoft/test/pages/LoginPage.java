package com.neosoft.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

		
	}

	@FindBy(id = "email")
	public WebElement Email_address;
	
	@FindBy(id = "passwd")
	public WebElement Email_password;
	
	@FindBy(id = "SubmitLogin")
	public WebElement Sign_in;
	
	
	
	public void loginApplication() {
		Email_address.sendKeys("raghunath.s_qua@gmail.com");
		Email_password.sendKeys("YCS@123");
		Sign_in.click();
		;
	}
}
