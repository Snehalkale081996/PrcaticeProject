package ParallelTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectPage.CartPage;
import ObjectPage.CheckoutPage;
import ObjectPage.ConfirmationPage;
import ObjectPage.LandingPage;
import ObjectPage.ProductCatalogue;
import TestComponent.BaseTest;
import customer.CustomerPage;

public class Test3 extends BaseTest {

	LandingPage landingPage ;
	ProductCatalogue productCatalogue;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	ConfirmationPage confirmationPage ;
	private WebDriver driver;
	
	@Test
	public void loginErrorRevalidation() throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);

		 //driver = BaseTest.initializeDriver();

		String productName = "ZARA COAT 3";

		// Enter Login details
		landingPage.goTo();
		landingPage.loginApplication("kalesnehal2013333@gmail.com", "Iamsupergirl@123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());


	}
}
