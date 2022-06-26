package com.technocrat;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotDemo {

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		try {
			
			BrowserDemo browserDemo = new BrowserDemo();
			
			driver = browserDemo.browserLaunch("firefox");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.navigate().to("http://www.flipkart.com");
			driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
			driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div[3]/a/div[1]/div1/img")).click();
			driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[2]/div[2]/div[1]/div/div/div/div[1]/div/div[1]/div/a/p")).click();

			driver.quit();

		}catch (Exception e) {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			File destFile = new File("D:\\Execution_Rep\\flipkart.png");

			FileHandler.copy(srcFile, destFile);

			e.printStackTrace();
			driver.quit();
		}


	}
}
