package com.flipkart.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.flipkart.qa.BaseClass.TestBase;

public class Amzn_HomePage extends TestBase {

	public static String text = "Apple iPhone XR (64GB) - Yellow";
	public static int Amazon_price;

	@FindBy(id = "twotabsearchtextbox")
	WebElement SearchLink;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement Submit;

	@FindBy(id = "nav-logo")
	WebElement Logo;

	public Amzn_HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyAmazonLogo() {
		return Logo.isDisplayed();
	}

	public void search_Select_mobile() {

		SearchLink.sendKeys(text);
		Submit.click();

		String elements = "//span[@cel_widget_id='SEARCH_RESULTS-SEARCH_RESULTS']//div[@class='s-include-content-margin s-border-bottom']//a[@class='a-link-normal a-text-normal']";
		List<WebElement> options = driver.findElements(By.xpath(elements));
		int size1 = options.size();

		for (int i = 0; i < size1; i++) {
			String temp = options.get(i).getText();
			System.out.println("Mobile name : " + temp);
			if (temp.contains(text)) {
				String price = driver
						.findElement(By.xpath("//div[@data-index='" + i + "']//span[@class='a-price-whole']")).getText()
						.replaceAll("[^0-9]", "");
				Amazon_price = Integer.parseInt(price);
				System.out.println("Mobile Price Amazon --> " + Amazon_price);
				break;
			}
		}
	}

	public void flipkart_search() {

		WebElement crossmark = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		crossmark.click();

		WebElement Searchbox = driver.findElement(By.name("q"));
		Assert.assertEquals(Searchbox.isDisplayed(), true);
		Searchbox.sendKeys(text);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String MobilesName = driver.findElement(By.xpath("//div[@class='_3O0U0u']//div[@class='_3wU53n']")).getText();
		System.out.println("MobileName in flipkart is :" + MobilesName);
		String Mobileprice = driver.findElement(By.xpath("//div[@class='_3O0U0u']//div[@class='_1vC4OE _2rQ-NK']"))
				.getText().replaceAll("[^0-9]", "");
		int Flipkart_price = Integer.parseInt(Mobileprice);
		System.out.println(" Mobile price in Flipkart --> " + Flipkart_price);

		if (Flipkart_price > Amazon_price) {
			System.out.println("less price mobile available in Amazon ---> " + Amazon_price);
		} else {
			System.out.println("less price mobile available in Flipkart --> " + Flipkart_price);
		}
	}

}
