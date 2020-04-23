package com.neosoft.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.asserts.SoftAssert;

public class ShoppingCartSummaryPage {

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

	@FindBy(xpath = "//*[@name='processCarrier']")
	public WebElement process_Carrier_button;

	@FindBy(xpath = "//*[text()='Proceed to checkout']")
	public WebElement proceed_checkout_button;

	WebDriver driver;
	SoftAssert softAssertion;
	JavascriptExecutor js;

	public ShoppingCartSummaryPage(WebDriver driver, SoftAssert softAssertion) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.softAssertion = softAssertion;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		js = (JavascriptExecutor) driver;

	}

	public void summary(String totalPrice) {
		// -----shoppiing cart summary--------------/
		softAssertion.assertEquals(summary_total_price.getText(), totalPrice);
		js.executeScript("arguments[0].scrollIntoView();", proceed_checkout_button);
		proceed_checkout_button.click();

	}

	public void Address() {
		/// adresss
		js.executeScript("arguments[0].scrollIntoView();", proceed_checkout_button);
		proceed_checkout_button.click();

	}

	public void shipping() {
		// Shipping
		accept_condition_checkbox.click();
		js.executeScript("arguments[0].scrollIntoView();", process_Carrier_button);
		process_Carrier_button.click();
	}

	public void payment(String totalPrice) {
		/////// payment --------//
		pay_bank_wire_button.click();
		confirm_order_Button.click();
		softAssertion.assertEquals(final_price.getText(), totalPrice);
	}
}
