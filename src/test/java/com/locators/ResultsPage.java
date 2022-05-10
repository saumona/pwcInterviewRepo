package com.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {
	
WebDriver ldriver;
	
	public ResultsPage(WebDriver rdriver) {
		
		ldriver = rdriver;
	}
	
	public List<WebElement> product()
	{
		List<WebElement> pro = ldriver.findElements(By.cssSelector("._3Mn1Gg ._1AtVbE.col-12-12 ._13oc-S a ._4rR01T"));
		return pro;
		
	}

}
