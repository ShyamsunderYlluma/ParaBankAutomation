package com.parabank.utilities;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.parabank.testbase.TestBase;

public class Listener implements ITestListener{
	
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " end ***"));
		ExtentTestManager.endTest();
		ExtentTestManager.generateHTMLReport().flush();
	}

	public void onTestStart(ITestResult test) {
		Reporter.log(test.getName()+" test started successfully.");
		ExtentTestManager.startTest(test.getMethod().getMethodName());
	 }
	public void onTestSuccess(ITestResult test) {
		Reporter.log(test.getName()+" test passed successfully.");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}
	public void onTestFailure(ITestResult test) {
		Reporter.log(test.getName()+" test failed");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		String screenshotName = test.getName() + System.currentTimeMillis();
		TestBase.getScreenshot(screenshotName);
		String path = System.getProperty("user.dir")+File.separator+"/Screenshots/"+screenshotName+".png" ;
		try {
			ExtentTestManager.getTest().addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
