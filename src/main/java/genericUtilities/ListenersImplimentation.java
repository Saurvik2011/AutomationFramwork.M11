package genericUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
  //capture the data
	Date d= new Date();
	SimpleDateFormat form = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
	
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "--------test execution started------------");
	
		//Create a test for @Test in Extent Reports
		test = report.createTest(methodName);
	}

	
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "--------Test PASS------------");
	}

	
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "--------Test FAIL------------");
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		String ScreenShotName = methodName+"_"+j.getDate();
		try {
			String path = s.captureScreenshot(BaseClass.sdriver, ScreenShotName);
			//Attaching Screenshots for Extent Reports
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "--------Test SKIP------------");
		//Log the skipped status in Extent Report
		test.log(Status.SKIP, methodName+ "--------Test SKIP------------");
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		
		System.out.println( "--------Suite execution started------------");
		//Configure extent report
				ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
				rep.config().setDocumentTitle("Execution Report");
				rep.config().setTheme(Theme.DARK);
				rep.config().setReportName("vtiger Execution report");
				
		 report = new ExtentReports();
				report.attachReporter(rep);
				report.setSystemInfo("NAME", "vtiger Execution report");
				report.setSystemInfo("Base Browser", "Chrome");
				report.setSystemInfo("Base Platform", "Testing");
				report.setSystemInfo("Base OS", "windows");
				report.setSystemInfo("Base url", "https://localhost:8888");
				
				
	}


	public void onFinish(ITestContext context) {
		System.out.println( "--------Suite execution finished------------");
		
		
		//generate extent report
		
		report.flush();
	}
	
	

}
