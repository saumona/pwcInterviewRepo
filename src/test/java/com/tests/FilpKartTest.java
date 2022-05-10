package com.tests;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.locators.CartPage;
import com.locators.DashboardPage;
import com.locators.ProductPage;
import com.locators.ResultsPage;
import com.util.ReadConfig;

public class FilpKartTest extends BaseTest {

	@Test
	public void flipkartSearchTest() {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		DashboardPage dashPage = new DashboardPage(driver);
		ResultsPage resultPage = new ResultsPage(driver);
		ProductPage prod = new ProductPage(driver);
		CartPage cart = new CartPage(driver);

		driver.get(ReadConfig.readConfigFile().getProperty("baseUrl"));
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.flipkart.com/"), "Landed on incorrect url");

		// wait for the pop-up modal and close it
		wait.until(ExpectedConditions.visibilityOf(dashPage.closeBtn()));
		dashPage.closeBtn().click();

		// verify that search bar is present and search for "mobiles"
		Assert.assertTrue(dashPage.searchText().isDisplayed(), "Search bar is not present in dashboard page");
		dashPage.searchText().sendKeys(ReadConfig.readConfigFile().getProperty("searchCriteria"));
		dashPage.searchBtn().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("search?q=mobiles"), "Landed on incorrect url on search");
	
		// wait and click on the first two product
		wait.until(ExpectedConditions.elementToBeClickable(resultPage.product().get(0)));
		resultPage.product().get(0).click();
		resultPage.product().get(1).click();

		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				wait.until(ExpectedConditions.elementToBeClickable(prod.addToCart()));
				prod.addToCart().click();
				Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);	
			}
		}
		
		//validate cart page products
		Assert.assertTrue(cart.cartProd().size()>0, "Cart has no products");
		Assert.assertTrue(cart.cartProdTitles().get(0).getText().equalsIgnoreCase("SAMSUNG Galaxy F12 (Sea Green, 64 GB)"), "Incorrect product added to cart");
		Assert.assertTrue(cart.cartProdTitles().get(1).getText().equalsIgnoreCase("SAMSUNG Galaxy F12 (Sky Blue, 64 GB)"), "Incorrect product added to cart");
	}	

}
