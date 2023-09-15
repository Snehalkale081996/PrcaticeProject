package ObjectPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Abstractcomponent.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css = ".cartSection h3")
	List <WebElement> productTitles;
	
	public Boolean verifyProductDisplay(String productName) {
		 Boolean match = productTitles.stream().anyMatch(cardProduct->cardProduct.getText().equalsIgnoreCase(productName));
	      return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
}
