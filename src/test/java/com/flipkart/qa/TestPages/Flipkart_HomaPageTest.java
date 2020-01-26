package com.flipkart.qa.TestPages;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.qa.BaseClass.TestBase;
import com.flipkart.qa.Pages.Amzn_HomePage;
import com.flipkart.qa.Pages.Flipkart_HomePage;

public class Flipkart_HomaPageTest extends TestBase{

	public static Amzn_HomePage amzonpage;
	public static Flipkart_HomePage flipkart;
	public Flipkart_HomaPageTest() {
		super();
	}
	
	@Parameters({"Browser","url"})
	@BeforeMethod
	public void setUp(String Browser,String url)
	{
		initialization(Browser, url);
		Log.info("Application Launched Successfully");
		amzonpage=new Amzn_HomePage(); 
		Flipkart_HomePage flipkart=new Flipkart_HomePage();
	}
	
	@Test(priority=1)
	public void HomePageTitleTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		 driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
		 driver.get("https://www.flipkart.com");
		String title = flipkart.verifyHomePageTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books &amp; More. Best Offers!");
		Log.info("AmazonHomePage Title Verified");
	}
	
	@Test(priority=2)
	public void FlipkartImageTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		 driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
		 driver.get("https://www.flipkart.com");
		boolean flag = flipkart.verifyFlipkart_HomePageLogo();
		Assert.assertTrue(flag);
		Log.info("Amazon image Validated successfully ");
	}
	
	
	@Test(priority=3)
	public void Flipkart_search_Test(Method method)
	{
		extentTest = extent.startTest(method.getName());
		 driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
		 driver.get("https://www.flipkart.com");
		flipkart.searchFor_mobiles();
		 Log.info("Mobile searched and selected successfully");
	}
}
