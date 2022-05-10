package com.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	
WebDriver ldriver;
	
	public ProductPage(WebDriver rdriver) {
		
		ldriver = rdriver;
	}
	
	
	public WebElement addToCart()
	{
		WebElement atcBtn = ldriver.findElement(By.cssSelector("._1p3MFP button"));
		return atcBtn;
		
	}
	
	public WebElement goToCart()
	{
		WebElement gtcBtn = ldriver.findElement(By.cssSelector("._1p3MFP ._3v1-ww"));
		return gtcBtn;
		
	}
	
}
