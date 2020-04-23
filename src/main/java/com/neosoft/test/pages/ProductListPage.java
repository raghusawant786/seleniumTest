package com.neosoft.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.asserts.SoftAssert;

public class ProductListPage {

	@FindBy(xpath = "//*[@class='btn btn-default btn-facebook']")
	public WebElement facebook_share;

	@FindBy(id = "quantity_wanted")
	public WebElement quantity_input;

	@FindBy(xpath = "//*[@title='Close']")
	public WebElement close_button;

	@FindBy(id = "wishlist_button")
	public WebElement wishlist_button;

	@FindBy(id = "add_to_cart")
	public WebElement add_to_cart_button;

	@FindBy(id = "layer_cart_product_price")
	public WebElement product_price;

	@FindBy(xpath = "//*[@title='Proceed to checkout']")
	public WebElement after_Cart_Proceed_checkout_button;

	@FindBy(xpath = "//*[@name='processCarrier']")
	public WebElement process_Carrier_button;

	@FindBy(xpath = "//*[text()='Proceed to checkout']")
	public WebElement Proceed_checkout_button;

	@FindBy(xpath = "//*[@class='ajax_block_cart_total']")
	public WebElement add_to_cart_total_price;

	WebDriver driver;
	SoftAssert softAssertion;
	JavascriptExecutor js;

	public ProductListPage(WebDriver driver, SoftAssert softAssertion) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.softAssertion = softAssertion;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		js = (JavascriptExecutor) driver;

	}

	public void selectProduct() {
		boolean flag = false;
		List<WebElement> totalDress = driver.findElements(By.xpath("//*[@class='product_list row list']/li"));

		for (int j = 1; j <= totalDress.size(); j++) {
			List<WebElement> totalColour = driver.findElements(By.xpath(
					"//*[@class='product_list row list']//li[" + j + "]//*[@class='color_to_pick_list clearfix']/li"));

			for (int i = 1; i <= totalColour.size(); i++) {
				String Color = driver
						.findElement(By.xpath("//*[@class='product_list row list']//li[" + j
								+ "]//*[@class='color_to_pick_list clearfix']/li[" + i + "]/a"))
						.getCssValue("background-color");
				System.out.println(Color);
				if (Color.equals("rgba(93, 156, 236, 1)")) {
					js.executeScript("arguments[0].scrollIntoView();",
							driver.findElement(By.xpath("//*[@class='product_list row list']/li[" + j
									+ "]//a[@title='Printed Summer Dress']/img")));

					driver.findElement(By.xpath(
							"//*[@class='product_list row list']/li[" + j + "]//a[@title='Printed Summer Dress']/img"))
							.click();
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}

	}

	public String addToCartAndCheckout() {

		driver.switchTo().frame(0);
		facebook_share.click();
		String your_title = "Facebook";
		String currentWindow = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println(driver.switchTo().window(winHandle).getTitle());
			if (driver.switchTo().window(winHandle).getTitle().equals(your_title)) {
				break;
			}
		}
		softAssertion.assertEquals(driver.getTitle(), your_title);
		driver.close();
		driver.switchTo().window(currentWindow);
		driver.switchTo().frame(0);
		quantity_input.clear();
		quantity_input.sendKeys("2");
		wishlist_button.click();
		close_button.click();
		add_to_cart_button.click();
		softAssertion.assertEquals(add_to_cart_total_price.getText(), "$59.96");
		driver.switchTo().defaultContent();
		after_Cart_Proceed_checkout_button.click();
		return add_to_cart_total_price.getText();
	}
}
