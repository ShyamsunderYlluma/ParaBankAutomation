package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.testbase.TestBase;

public class HomePage extends TestBase{

	public HomePage() {}
	WebElement userName = driver.findElement(By.name("username"));
	WebElement password = driver.findElement(By.name("password"));
	WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
	WebElement homePageLogo = driver.findElement(By.xpath("//img[@class=\"logo\"]"));
	WebElement logoCaption = driver.findElement(By.xpath("//p[@class=\"caption\"]"));
	WebElement aboutUsLink = driver.findElement(By.linkText("About Us"));
	public String login() {
		userName.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		String loginPageTitle = driver.getTitle();
		return loginPageTitle;
		
	}
	public String Login() {
		try {
			driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.xpath("//input[@value='Log In']")).click();
			String loginmessage = driver.findElement(By.xpath("//h1[@class='title']")).getText();
			Thread.sleep(3000);
			return loginmessage;
		}
		catch(Exception e) {
			//System.out.println("Login attempt failed. Error message"+e.getMessage());
			return "Login attempt failed. Error message";
		}
	}
		
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	public boolean homePageLogoDisplayed() {
		return homePageLogo.isDisplayed();
	}
	public String logoCaption() {
		return logoCaption.getText();
	}
	public AboutUsPage clickOnAboutUs() {
		aboutUsLink.click();
		return new AboutUsPage();
	}
	
}
