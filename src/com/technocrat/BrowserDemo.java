package com.technocrat;
import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserDemo {

	
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		BrowserDemo demo = new BrowserDemo();
		driver = demo.browserLaunch("chrome");
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(3000);
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div/div/button"))));
		//driver.findElement(By.cssSelector("input#identifierId")).sendKeys("rathodanil.s");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		driver.findElement(By.cssSelector("a._1_3w1N")).click();
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("D:\\Execution_Rep\\FlipkartLogin.jpeg");
		org.openqa.selenium.io.FileHandler.copy(srcFile, destFile);*/
		
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow.toString());		
		driver.findElement(By.linkText("TRY FOR FREE")).click();
		
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows) {
			System.out.println(window);
			if(!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Narendra");
		driver.findElement(By.name("UserLastName")).sendKeys("Modi");
		
		Select select = new Select(driver.findElement(By.name("UserTitle")));
		select.selectByValue("Sales_Manager_AP");
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
		
		
	}
	
	
	public WebDriver browserLaunch( String browserName) {
		WebDriver driver=null;
		
		if(browserName=="chrome") {
			String projetPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projetPath+"\\driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}else if(browserName.equals("firefox")) {
			String projetPath = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", projetPath+"\\driver\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
	        options.setHeadless(true);
			driver = new FirefoxDriver();
		}else if(browserName.equals("ie")) {
			String projetPath = System.getProperty("user.dir");
			System.setProperty("webdriver.ie.driver", projetPath+"\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		return driver;
	}
	
	
}
