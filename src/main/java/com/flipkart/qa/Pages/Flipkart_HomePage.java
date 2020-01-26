package com.flipkart.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.BaseClass.TestBase;

public class Flipkart_HomePage extends TestBase{

	public static String text = "Apple iPhone XR (64GB) - Yellow";
	
	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	WebElement Crossmark;
	
	@FindBy(xpath = "//a//img[@title='Flipkart']")
	WebElement Logo;
	
	@FindBy(name = "q")
	WebElement SeachBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit_btn;
	
	@FindBy(xpath = "//div[@class='_3O0U0u']//div[@class='_3wU53n']")
	WebElement Mobile_names;
	
	@FindBy(xpath = "//div[@class='_3O0U0u']//div[@class='_1vC4OE _2rQ-NK']")
	WebElement Mobile_Price;
	
	
	

	public Flipkart_HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyFlipkart_HomePageLogo() {
		return Logo.isDisplayed();
	}
	
	public void searchFor_mobiles() {
		SeachBox.sendKeys(text);
		Submit_btn.click();
		String mob_Name=Mobile_names.getText();
		System.out.println("MobileName in flipkart is :" + mob_Name);
		
		String mob_price=Mobile_Price.getText().replaceAll("[^0-9]", "");
		int Flipkart_price = Integer.parseInt(mob_price);
		System.out.println(" Mobile price in Flipkart --> " + Flipkart_price);
		
		if (Flipkart_price > Amzn_HomePage.Amazon_price) {
			System.out.println("less price mobile available in Amazon ---> " + Amzn_HomePage.Amazon_price);
		} else {
			System.out.println("less price mobile available in Flipkart --> " + Flipkart_price);
		}
	}
}
