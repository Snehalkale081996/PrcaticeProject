package TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.lang.ThreadLocal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ObjectPage.LandingPage;

public class BaseTest {

	public WebDriver driver;
	//public LandingPage landingPage;
	
	//
	@BeforeMethod(alwaysRun = true)
	public WebDriver initializeDriver() throws IOException{

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		// WebDriver driver = null;

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"E:\\seleniumGrid\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			// firefox
		} else if (browserName.equalsIgnoreCase("edge")) {
			// edge
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		return driver;

	}
	
	
public  List<HashMap<String ,String>> getJsonDataToMap(String filePath) throws IOException {
		
		//Read json to string
		
		String jsonContent = FileUtils.readFileToString(new File(filePath));
		
		//String  to HashMap 
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String ,String>>>(){
			
		});
		return data;
		
		
		
		
	}

	public void launchApplication() throws IOException {
		initializeDriver();
		goTo();

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	
	public String getScreenShorts(String testcasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+ testcasename +".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "//reports//" + testcasename+".png";
		
	}

}
