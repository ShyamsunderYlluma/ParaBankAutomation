package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.parabank.testbase.TestBase;

public class AboutUsPage extends TestBase {

	public AboutUsPage() {
		
	}
	WebElement AboutUsWelcomeMessage = driver.findElement(By.cssSelector("h1[class='title']"));
	
	public String AboutUsWelcomeMessage() {
		return AboutUsWelcomeMessage.getText();
	}
	public String GetAboutUsPageTitle() {
		return driver.getTitle();
	}
}
