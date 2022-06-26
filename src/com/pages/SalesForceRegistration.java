package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SalesForceRegistration {
	
	public SalesForceRegistration (WebDriver driver){
		this.driver = driver;
	}

	WebDriver driver;
	
	By firstName = By.name("UserFirstName");
	
	By lastName = By.name("UserLastName");
	By email = By.xpath("//*[@name='UserEmail']");
	
	//By userTitle = By.name("UserTitle");
	
	public void registration(WebDriver driver,String FirstName, String LastName,String Email, String Title) {
		driver.findElement(firstName).sendKeys(FirstName);
		driver.findElement(lastName).sendKeys(LastName);
		driver.findElement(email).sendKeys(Email);
		Select jobTitle = new Select(driver.findElement(By.name("UserTitle")));
		
		jobTitle.selectByVisibleText(Title);
		
		
	}
	
}
