package com.neosoft.test.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neosoft.test.pages.HomePage;
import com.neosoft.test.pages.LoginPage;
import com.neosoft.test.pages.ProductListPage;
import com.neosoft.test.pages.ShoppingCartSummaryPage;

public class NewTest {
	public WebDriver driver;
	public SoftAssert softAssertion= new SoftAssert();
	public String driverPath = "D:\\eclipse project\\com.neosoft.test\\src\\main\\resources\\chromedriver_exe\\chromedriver.exe";
	public String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	LoginPage ologinPage;
	HomePage ohomePage;
	ProductListPage oProductPage;
	ShoppingCartSummaryPage oShoppingCartSummaryPage;

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Launching Chrome !!");
		driver.get(URL);

	}

	@Test
	public void buyProduct() {
		ologinPage = new LoginPage(driver);
		ologinPage.loginApplication();

		ohomePage = new HomePage(driver);
		ohomePage.goToSummerDresses();
		oProductPage = new ProductListPage(driver, softAssertion);
		oProductPage.selectProduct();
		String totalPrice = oProductPage.addToCartAndCheckout();
		oShoppingCartSummaryPage = new ShoppingCartSummaryPage(driver, softAssertion);
		oShoppingCartSummaryPage.summary(totalPrice);
		oShoppingCartSummaryPage.Address();
		oShoppingCartSummaryPage.shipping();
		oShoppingCartSummaryPage.payment(totalPrice);
		ohomePage.logout();
		softAssertion.assertAll();

	}

	@AfterTest

	public void closeBroswer() {
		driver.close();

	}
}
