package com.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SalesForceHomePage {

	WebDriver driver;
	public SalesForceHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	By tryFree =By.linkText("TRY FOR FREE");

	By login = By.xpath("//*[@id='globalnavbar-header-container']/div[2]/div/div[6]/div/div/div[1]/a");

	By userName = By.name("username");

	By password = By.id("password");
	By submitBtn = By.id("Login");

	public void tryForFree(WebDriver driver) {
		driver.findElement(tryFree).click();

		String  parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows) {
			if(!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
		driver.switchTo().window(parentWindow);
		driver.switchTo().defaultContent();
	}


	public void login(WebDriver driver, String uName, String pwd) {
		driver.findElement(login).click();
		driver.findElement(userName).sendKeys(uName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submitBtn).click();
	}


}
