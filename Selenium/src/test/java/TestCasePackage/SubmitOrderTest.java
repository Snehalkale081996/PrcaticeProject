package TestCasePackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectPage.CartPage;
import ObjectPage.CheckoutPage;
import ObjectPage.ConfirmationPage;
import ObjectPage.LandingPage;
import ObjectPage.OrderPage;
import ObjectPage.ProductCatalogue;
import TestComponent.BaseTest;
//import customer.CustomerPage;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void SubmitOrder(HashMap<String, String> input) throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);

		// driver = BaseTest.initializeDriver();

		String productName = "ZARA COAT 3";

		// Enter Login details
		landingPage.goTo();
		landingPage.loginApplication(input.get("email"), input.get("password"));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		List<WebElement> prod = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		productCatalogue.goToCart();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		Boolean match = cartPage.verifyProductDisplay(input.get("product"));

		Assert.assertTrue(match);

		cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		checkoutPage.submitOrder();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		String confirmMessage = confirmationPage.verifyConfirmationMessage();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\Data\\PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
}
