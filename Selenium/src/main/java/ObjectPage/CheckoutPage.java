package ObjectPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		

	}

	By result = By.cssSelector(".ta-results");
	
	@FindBy(xpath = "//input[@class='input txt text-validated ng-pristine ng-valid ng-touched']")
	WebElement mailId;
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement enterCountry;
	
	@FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted'][2]")
	WebElement selectCountry;
	
	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement clickPlaceOrder;



	public void enterEmailId(String id) {
		Actions a = new Actions(driver);
		a.sendKeys(mailId, id).build().perform();
	}
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(enterCountry, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public void submitOrder() {
		clickPlaceOrder.click();
	}
	

}
