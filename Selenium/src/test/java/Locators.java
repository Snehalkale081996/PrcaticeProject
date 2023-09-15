import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"E://WDAutomation//src//main//resources//executableFiles//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		String password = getPassword(driver);
		
		driver.findElement(By.cssSelector("button[class='go-to-login-btn']")).click();
		
		driver.findElement(By.xpath("//*[@id='inputUsername']")).sendKeys("rahul");
		
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
		
		driver.findElement(By.cssSelector("button[class='submit signInBtn']")).click();
		
		

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		Thread.sleep(2000);
		String passwordText = driver.findElement(By.xpath("//div[@class='form-container sign-up-container']//p")).getText();
		System.out.println(passwordText);
		//Please use temporary password 'rahulshettyacademy' to Login.
		String pass1 = passwordText.split("'")[1];
		return pass1;
	}

}
