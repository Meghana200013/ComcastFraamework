package com.vtiger.framework.generic.listenerutility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import baseClass_Implementation.BaseClass;



public class ListImpClass implements ITestListener, ISuiteListener {
	public static ExtentReports report;
    public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration"); 
		String time= new Date().toString().replace(" ","_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
        spark.config().setReportName("VTiger Automation Report");
        spark.config().setDocumentTitle("CRM Test Suit Report");
        spark.config().setTheme(Theme.DARK);

        report = new ExtentReports();
        report.attachReporter(spark);

        System.out.println("Report initialized");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup"); 
		report.flush();
	}
	
	 public void onTestStart(ITestResult result) {
	       
	        test=report.createTest(result.getMethod().getMethodName());
	        
	    }

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		
				
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
	     String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time= new Date().toString().replace(" ","_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName());
	}
	
}
