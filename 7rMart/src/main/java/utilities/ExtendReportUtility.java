package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() { 
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); 
		reporter.config().setReportName("7martsupermarket"); // config().setReportName("7RMart Project") 2 methods in
																// ExtentSparkReporter
		extentReports.attachReporter(reporter); // attaching od extend report and extendssparkrep for report generation
		extentReports.setSystemInfo("Organization", "Obsqura"); // org name
		extentReports.setSystemInfo("Name", "Sree");// 
		return extentReports; 
	}

}
