package com.parabank.utilities;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager extends com.parabank.testbase.TestBase {

	static Map extentTestMap = new HashMap();
	static ExtentReports extent = generateHTMLReport();
	static ExtentTest test;
	public static synchronized ExtentTest getTest() {
		test = (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
		return test;
	}
	public static synchronized void endTest() {
		extent.flush();
	}
	@SuppressWarnings("unchecked")
	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
}

