package com.technocrat;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiWnindowDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriver driver=null;
		
		try {

			BrowserDemo browserDemo = new BrowserDemo();
			
			driver = browserDemo.browserLaunch("chrome");
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			
			driver.manage().window().maximize();
			
			driver.get("http://www.salesforce.com");
			String title = driver.getTitle();
			System.out.println(title);
			
			String  parentWindow = driver.getWindowHandle();
			System.out.println(parentWindow);

			driver.findElement(By.partialLinkText("TRY FOR")).click();
			Thread.sleep(5000);
			
			
			
			Set<String> windows = driver.getWindowHandles();
			
			
			for(String window:windows) {
				System.out.println(window);
				if(!parentWindow.equals(window)) {
					driver.switchTo().window(window);
				}
			}
			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.name("UserFirstName"))));
			
			driver.findElement(By.name("UserFirstName")).sendKeys("Narendra");
			driver.findElement(By.name("UserLastName")).sendKeys("Modi");
			driver.findElement(By.xpath("//*[@name='UserEmail']")).sendKeys("narendra.modi@gmail.com");
			Thread.sleep(5000);
			
			Select jobTitle = new Select(driver.findElement(By.name("UserTitle")));
			
			//jobTitle.selectByVisibleText("IT Manager");
			//jobTitle.selectByIndex(1);
			jobTitle.selectByValue("IT_Manager_AP");
			Thread.sleep(5000);
			
			/*driver.switchTo().window(parentWindow);
			
			driver.findElement(By.xpath("//*[@id='globalnavbar-header-container']/div[2]/div/div[6]/div/div/div[1]/a")).click();
			Thread.sleep(5000);*/
			
			/*
			driver.findElement(By.cssSelector("input#identifierId")).sendKeys("rathodanil.s");
			Thread.sleep(5000);*/
			/*driver.findElement(By.id("identifierId")).sendKeys("rathodanil.s@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().forward();*/
			
			driver.close();
			driver.quit();
			
		}catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}
		
	}
}
