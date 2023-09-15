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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectPage.CartPage;
import ObjectPage.CheckoutPage;
import ObjectPage.ConfirmationPage;
import ObjectPage.LandingPage;
import ObjectPage.OrderPage;
import ObjectPage.ProductCatalogue;
import TestComponent.BaseTest;
import customer.CustomerPage;

public class Test1 extends BaseTest {
	
	
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

	//	driver = BaseTest.initializeDriver();

		String productName = "ZARA COAT 3";

		// Enter Login details
		landingPage.goTo();
		landingPage.loginApplication("kalesnehal2013333@gmail.com", "Iamsupergirl@123");
		Assert.assertEquals("Incorrect email or password.111111111", landingPage.getErrorMessage());
	}

//	@Test
//	public void OrderHistoryTest() throws IOException {
//
//		LandingPage landingPage = new LandingPage(driver);
//		OrderPage orderPage = new OrderPage(driver);
//
//		// driver = BaseTest.initializeDriver();
//
//		String productName = "ZARA COAT 3";
//
//		// Enter Login details
//		landingPage.goTo();
//		landingPage.loginApplication("kalesnehal2013@gmail.com", "Iamsupergirl@123");
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//
//		orderPage.goToOrderPage();
//		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
//
//	}
//
//	@Test
//	public void productErrorValidation() throws IOException {
//
//		LandingPage landingPage = new LandingPage(driver);
//		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
//		CartPage cartPage = new CartPage(driver);
//		CheckoutPage checkoutPage = new CheckoutPage(driver);
//		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
//
//		// driver = BaseTest.initializeDriver();
//
//		String productName = "ZARA COAT 3";
//
//		// Enter Login details
//		landingPage.goTo();
//		landingPage.loginApplication("kalesnehal2013@gmail.com", "Iamsupergirl@123");
//
//		List<WebElement> prod = productCatalogue.getProductList();
//		productCatalogue.addProductToCart(productName);
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//		productCatalogue.goToCart();
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//
//		Boolean match = cartPage.verifyProductDisplay(productName);
//
//		Assert.assertTrue(match);
//
//		cartPage.goToCheckout();
//		checkoutPage.selectCountry("india");
//		checkoutPage.submitOrder();
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//
//		String confirmMessage = confirmationPage.verifyConfirmationMessage();
//		System.out.println(confirmMessage);
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//
//	}
}
