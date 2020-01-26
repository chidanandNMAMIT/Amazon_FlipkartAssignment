package com.flipkart.qa.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.qa.BaseClass.TestBase;

public class TestUtility extends TestBase{	

	public static long Page_Load_TimeOut = 20;
	public static long Implicit_Wait = 30;

	
	
	//Screenshot Utility.
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
	}

	
	public static void Wait_forElememt(WebDriver driver, By elements, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.presenceOfAllElementsLocatedBy(elements));
	}

	public static void displayElement()
	{
		boolean elementDisplayed=driver.findElement(By.xpath("")).isDisplayed();
		if(elementDisplayed)
		{
			System.out.println("Element is displayed");
		}
		else
		{
			System.out.println("Element is not displayed");
		}
	}

	public static void enableElement()
	{
		boolean enable=driver.findElement(By.xpath("")).isEnabled();
		if(enable)
		{
			System.out.println("Element is enabled in page");
		}
		else
		{
			System.out.println("Element is not enabled in page");
		}
	}


	public static String getSystemDate() 
	{
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
			

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	 
	//Set Date For Log4J.
	public static void setDateForLog4j() 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyy_hhmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}
}

	