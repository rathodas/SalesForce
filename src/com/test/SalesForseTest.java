package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.SalesForceHomePage;
import com.pages.SalesForceRegistration;
import com.technocrat.BrowserDemo;

public class SalesForseTest {
	WebDriver driver;
	
	@Test
	public void registration() {
		
		SalesForceHomePage homePage = new SalesForceHomePage(driver);
		homePage.login(driver, "anil","anil");
		
		/*SalesForceRegistration registration = new SalesForceRegistration(driver);
		registration.registration(driver, "ANIL", "KUMAR", "rathodanil.s@gmail.com", "IT Manager");
		driver.quit();*/
	}
	
	@BeforeTest
	public void launchBrowser() {

		BrowserDemo browserDemo = new BrowserDemo();
		driver = browserDemo.browserLaunch("chrome");
		driver.get("http://www.salesforce.com");
	}
		
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
