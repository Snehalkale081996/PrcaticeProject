package ExtendReportPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Test
public class ExtendReportDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		String path = System.getProperty("user.dir")+ "\\report\\index.html";
		
		//ExtentSparkReporter is used to create report
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation result");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Snehal Kale");
	}

	@Test
	public void intialDemo() {
		
		extent.createTest("intialDemo");
		
		System.setProperty("webdriver.chrome.driver",
				"E://WDAutomation//src//main//resources//executableFiles//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		extent.flush();
		
	}
}
