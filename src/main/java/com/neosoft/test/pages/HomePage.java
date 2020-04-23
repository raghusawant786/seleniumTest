package com.neosoft.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

	@FindBy(xpath = "//a[@title='Women']")
	public WebElement Women;

	@FindBy(xpath = "//a[@title='Summer Dresses']")
	public WebElement Summer_Dresses;

	@FindBy(id = "list")
	public WebElement List;

	@FindBy(xpath = "//*[@class='btn btn-default btn-facebook']")
	public WebElement facebook_share;

	@FindBy(id = "quantity_wanted")
	public WebElement Quantity_Input;

	@FindBy(xpath = "//*[@title='Close']")
	public WebElement Close_button;

	@FindBy(id = "wishlist_button")
	public WebElement Wishlist_button;

	@FindBy(id = "add_to_cart")
	public WebElement Add_to_cart_button;

	@FindBy(id = "layer_cart_product_price")
	public WebElement Product_price;

	@FindBy(xpath = "//*[@title='Proceed to checkout']")
	public WebElement Proceed_checkout_button1;

	@FindBy(xpath = "//*[@name='processCarrier']")
	public WebElement process_Carrier_button;

	@FindBy(xpath = "//*[text()='Proceed to checkout']")
	public WebElement Proceed_checkout_button;

	@FindBy(xpath = "//*[@class='ajax_block_cart_total']")
	public WebElement Add_to_cart_total_price;

	@FindBy(id = "total_price")
	public WebElement summary_total_price;

	@FindBy(id = "cgv")
	public WebElement accept_condition_checkbox;

	@FindBy(xpath = "//*[text()='I confirm my order']")
	public WebElement confirm_order_Button;

	@FindBy(xpath = "//*[@title='Pay by bank wire']")
	public WebElement pay_bank_wire_button;

	@FindBy(xpath = "//*[@class='price']/strong")
	public WebElement final_price;

	@FindBy(xpath = "//*[@class='logout']")
	public WebElement logout_button;

	WebDriver driver;
	Actions action;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void goToSummerDresses() {
		action.moveToElement(Women).build().perform();
		Summer_Dresses.click();
		List.click();
	}

	public void logout() {
		logout_button.click();
	}
}
