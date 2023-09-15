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

public class StandAloneTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"E://WDAutomation//src//main//resources//executableFiles//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Go to Login Page
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");

		//Enter Details
		driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("kalesnehal2013@gmail.com");
		driver.findElement(By.xpath("//*[@id='userPassword']")).sendKeys("Iamsupergirl@123");
		driver.findElement(By.id("login")).click();
		
		String productName = "ZARA COAT 3";

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream().filter(product->

		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
        
        try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        List<WebElement> cardProducts= driver.findElements(By.cssSelector(".cartSection h3"));
        
       boolean match = cardProducts.stream().anyMatch(cardProduct->cardProduct.getText().equalsIgnoreCase(productName));
       
       Assert.assertTrue(match);

       driver.findElement(By.cssSelector(".totalRow button")).click();
       
       Actions a = new Actions(driver);
       a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
       
       driver.findElement(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted'][2]")).click();
       driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
       
       String caption = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
       
       Assert.assertEquals(caption, "THANKYOU FOR THE ORDER.");

		

	
}
}
