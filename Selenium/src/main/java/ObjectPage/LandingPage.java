package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import Abstractcomponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	 private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	 public WebDriver getDriver() {
	        return driverThreadLocal.get();
	    }
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	
	@FindBy(xpath="//*[@id='toast-container']//div//div")
	WebElement errorMessage;
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		 
	}
	
	public void loginApplication(String userName, String passowrd) {
		userEmail.sendKeys(userName);
		password.sendKeys(passowrd);
		login.click();
		System.out.println("Hello");
	}
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	

}
