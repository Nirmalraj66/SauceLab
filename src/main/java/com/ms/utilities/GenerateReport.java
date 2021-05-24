package com.ms.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class GenerateReport extends Base implements ITestListener {
	
	// Generate Reports using ITestListener Interface methods	
	
		ExtentTest testHandler;
		CreateReport generateReport = new CreateReport();
		ExtentReports testReportMonitor = generateReport.genarateReports();
		
	// Sync the Extent Test object with ThreadLocal to generate report and take screen shot for respective tests 
	   ThreadLocal<ExtentTest> threadTestHandler = new ThreadLocal<ExtentTest>();
			
		
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			testReportMonitor.flush();
			
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
						
		}

		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub

			// fetching the driver object from failed test case class
			WebDriver driver = null;
			threadTestHandler.get().fail(result.getThrowable());
			try {

				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block

				System.out.println(driver);
				e.printStackTrace();
			}

			String testMethodName = result.getMethod().getMethodName();

			try {
				threadTestHandler.get().addScreenCaptureFromPath(getScreenShot(testMethodName, driver), testMethodName);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
			threadTestHandler.get().pass("Pass");
			
		}

		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
			testHandler = testReportMonitor.createTest(result.getMethod().getMethodName());
			testHandler.assignCategory("Smoke");
			threadTestHandler.set(testHandler);
			
				}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
		
		}


}
