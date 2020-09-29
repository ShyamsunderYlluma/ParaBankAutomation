package com.parabank.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.parabank.pages.AboutUsPage;
import com.parabank.pages.HomePage;
import com.parabank.testbase.TestBase;
import com.parabank.utilities.ExtentTestManager;

public class HomePageTest extends TestBase{
	public HomePageTest() {
		super();
	}
	HomePage homepage;
	AboutUsPage aboutUsPage;
	
	@BeforeMethod
	public void setUp() {		
		setUpDriver();			
		homepage = new HomePage();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	@Test(priority=0)
	public void HomePageTitleTest() {
		Assert.assertEquals(homepage.getHomePageTitle(),"ParaBank | Welcome | Online Banking", "Title validation failed due to mismatch");
		ExtentTestManager.getTest().log(Status.INFO, "Homepage title validation successful");
	}
	@Test
	public void LoginTestWithLoginMessage() {
		String message= homepage.Login();
		System.out.println("LoginMessage : "+message);
		Assert.assertEquals(message, "Accounts Overview", "LoginPage login message mismatch");
		ExtentTestManager.getTest().log(Status.INFO, "User has been logged in successfully");
	}
	@Test
	public void LoginTestWithLoginPageTitle() {
		String loginPageTitle = homepage.login();
		Assert.assertEquals(loginPageTitle, "ParaBank | Accounts Overview", "LoginPage title mismatch");
		ExtentTestManager.getTest().log(Status.INFO, "User has been logged in successfully");
	}
	@Test
	public void HomePageLogoTest() {	
		Assert.assertTrue(homepage.homePageLogoDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Homepage logo has displayed");
	}
	@Test
	public void LogoCaptionTest() {
		Assert.assertEquals(homepage.logoCaption(), "Experience the difference", "Logo Caption mismatch");
		ExtentTestManager.getTest().log(Status.INFO, "Logo Caption validation successful");
	}
	@Test
	public void ClickOnAboutUsLinkTest() {
		aboutUsPage = homepage.clickOnAboutUs();
	}
	
	
}
