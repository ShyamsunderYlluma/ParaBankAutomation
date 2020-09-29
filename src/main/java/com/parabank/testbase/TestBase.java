package com.parabank.testbase;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.parabank.utilities.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	static long PageLoadTimeOut=60;
	static long ImplicitWaitTimeOut = 30;
	public static String userDir = System.getProperty("user.dir");
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReporter;
	final static String reportDir = System.getProperty("user.dir")+File.separator+"/target/ExtentReport_"+getCurrentTime()+".html";
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream file = new FileInputStream(userDir+File.separator+"\\src\\main\\java\\com\\parabank\\config\\Config.properties");
			prop.load(file);

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void setUpDriver(){
		String browser = prop.getProperty("browser");
		String URL = prop.getProperty("URL");		
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}
		else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ImplicitWaitTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
	}
	
	public synchronized static ExtentReports generateHTMLReport() {
		report = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(reportDir);
		report.attachReporter(htmlReporter); 	
		return report;			
	}
	public static String getCurrentTime()
	{
	    return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	}
	public static void getScreenshot(String filename) {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Screenshots/"+filename+".png"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
