package com.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	
	WebDriver ldriver;
	
	public DashboardPage(WebDriver rdriver) {
		
		ldriver = rdriver;
	}
	
	public WebElement closeBtn() {
		
		WebElement closeBtn = ldriver.findElement(By.cssSelector(".fk-modal-visible ._2QfC02 button"));
		return closeBtn;
	}

	public WebElement searchText()
	{
		WebElement searchBox = ldriver.findElement(By.name("q"));
		return searchBox;
		
	}
	
	public WebElement searchBtn()
	{
		WebElement searchBtn = ldriver.findElement(By.cssSelector(".header-form-search button"));
		return searchBtn;
		
	}


}
