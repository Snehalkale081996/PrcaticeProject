package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\report\\index.html";

		// ExtentSparkReporter is used to create report
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation result");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Snehal Kale");
		return extent;
	}

}
