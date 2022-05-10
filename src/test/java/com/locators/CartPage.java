package com.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	
WebDriver ldriver;
	
	public CartPage(WebDriver rdriver) {
		
		ldriver = rdriver;
	}
		
	public List<WebElement> cartProd()
	{
		List<WebElement> products = ldriver.findElements(By.xpath("//a[contains(text(),'SAMSUNG Galaxy')]"));
		return products;
		
	}
	
	public List<WebElement> cartProdTitles()
	{
		List<WebElement> productTitle = ldriver.findElements(By.cssSelector(".zab8Yh ._2-uG6-"));
		return productTitle;
		
	}
	
	


}
