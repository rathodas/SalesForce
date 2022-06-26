package com.technocrat;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {
	WebDriver driver= null;
	
	@Test(priority=0)
	public void salesforceLogin() throws Exception {
				
		driver.get("http://www.salesforce.com");
		Reporter.log("Navigate to URL");
		String title = driver.getTitle();
		System.out.println(title);
		Reporter.log("<B>Title: </B>"+title);
		String  parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);

		driver.findElement(By.partialLinkText("TRY FOR")).click();
		Thread.sleep(5000);
		
		
		
		Set<String> windows = driver.getWindowHandles();
		
		
		for(String window:windows) {
			if(!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Narendra");
		driver.findElement(By.name("UserLastName")).sendKeys("Modi");
		driver.findElement(By.xpath("//*[@name='UserEmail']")).sendKeys("narendra.modi@gmail.com");
		Thread.sleep(5000);
		
		Select jobTitle = new Select(driver.findElement(By.name("UserTitle")));
		
		//jobTitle.selectByVisibleText("IT Manager");
		//jobTitle.selectByIndex(1);
		jobTitle.selectByValue("IT_Manager_AP");
		Thread.sleep(5000);
		
		
	}
	
	/*@Test(priority=1)
	public void gmail() throws Exception {
		driver.get("http://www.gmail.com");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Gmail");
		
		
	}*/
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	@BeforeTest
	public void launchBrowser() {
		
		BrowserDemo browserDemo = new BrowserDemo();
		driver = browserDemo.browserLaunch("chrome");
	}
	
	
}
