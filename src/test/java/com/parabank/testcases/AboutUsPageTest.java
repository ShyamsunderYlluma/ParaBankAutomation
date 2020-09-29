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

public class AboutUsPageTest extends TestBase {

	public AboutUsPageTest() {
		super();
	}
	AboutUsPage aboutUsPage;
	HomePage homePage;
	

	@BeforeMethod
	public void setUp() {		
		setUpDriver();
		homePage = new HomePage();
		aboutUsPage = homePage.clickOnAboutUs();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	@Test
	public void GetAboutUsPageTitleTest() {
		Assert.assertEquals(aboutUsPage.GetAboutUsPageTitle(), "ParaBank | About Us", "AboutUs page title mismatch");
		ExtentTestManager.getTest().log(Status.INFO, "AboutUs page title validation successful");
	}
	@Test
	public void AboutUsWelcomeMessageTest() {
		Assert.assertEquals(aboutUsPage.AboutUsWelcomeMessage(), "ParaSoft Demo Website", "AboutUs page Welcome Message title mismatch");
		ExtentTestManager.getTest().log(Status.INFO, "AboutUs page welcome message title validation successful");
	}
}
