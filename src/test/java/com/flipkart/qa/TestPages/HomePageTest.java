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

public class HomePageTest extends TestBase {

public static Amzn_HomePage amzonpage;

	public HomePageTest()
	{
		super();
	}
	
	@Parameters({"Browser","url"})
	@BeforeMethod
	public void setUp(String Browser,String url)
	{
		initialization(Browser, url);
		Log.info("Application Launched Successfully");
		amzonpage=new Amzn_HomePage();
		
	}
		
	@Test(priority=1)
	public void HomePageTitleTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		String title = amzonpage.verifyHomePageTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Log.info("AmazonHomePage Title Verified");
	}
	
	@Test(priority=2)
	public void amazonImageTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		boolean flag = amzonpage.verifyAmazonLogo();
		Assert.assertTrue(flag);
		Log.info("Amazon image Validated successfully ");
	}
	
	
	@Test(priority=3)
	public void Amazon_search_Test(Method method)
	{
		extentTest = extent.startTest(method.getName());
		amzonpage.search_Select_mobile();
		 Log.info("Mobile searched and selected successfully");
	}
	

	
	@Test(priority=4)
	public void flipkart_search_Test(Method method)
	{
		extentTest = extent.startTest(method.getName());
		 driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
		 driver.get("https://www.flipkart.com");
		 amzonpage.flipkart_search();
			 
	}


	
	
}
