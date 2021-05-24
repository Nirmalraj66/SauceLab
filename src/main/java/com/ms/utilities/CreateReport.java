package com.ms.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateReport {
	
	// Creating Reports	
		public ExtentReports reportModifier;
		
		public ExtentReports genarateReports() {
			
				//Creating Report File
				String reportPath = System.getProperty("user.dir")+"//Reports/index.html";
				ExtentSparkReporter reportCreater = new ExtentSparkReporter(reportPath);
				reportCreater.config().setDocumentTitle("Login Test Results");
				reportCreater.config().setReportName("Login Test Results");
				
				//Adding the information to the report
				
				ExtentReports reportModifier = new ExtentReports();
				reportModifier.attachReporter(reportCreater);
				reportModifier.setSystemInfo("Tester","NPS");
				
			
			
			return reportModifier;	
			
		}

}
