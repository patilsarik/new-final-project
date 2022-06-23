package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports report() {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("extentReport.html");
		ExtentReports report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("regression testing","Zerodha kite");
		report.setSystemInfo("Browser","Chrome");
		report.setSystemInfo("enviroment","SIT");
		return report;
	}
}
