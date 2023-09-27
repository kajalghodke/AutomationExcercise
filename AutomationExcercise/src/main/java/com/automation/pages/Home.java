package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.base.Automation_Base;

public class Home extends Automation_Base{
	By scrollup= By.xpath("//a[@id='scrollUp']");
	By verify_fulllabel= By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']");
	 By selecttop= By.xpath("//p[text()='Stylish Dress']");
	 By addtop=By.xpath("//p[text()='Blue Top']//ancestor::div[@class='product-overlay']//descendant::a[text()='Add to cart']");
	 By presentcatgry = By.xpath("//h2[normalize-space()='Category']");
		By Womens = By.xpath("//a[normalize-space()='Women']");
		By Dress = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
		By TopPrdcts = By.xpath("//h2[normalize-space()='Women - Dress Products']");
		By Men = By.xpath("//a[normalize-space()='Men']");
		By shirts = By.xpath("//a[normalize-space()='Tshirts']");
		By recommadeditem=By.xpath("//h2[text()='recommended items']");
		 By addtocartrecomitem=By.xpath("//p[text()='Blue Top']//ancestor::div[@class='carousel-inner']//descendant::a[@data-product-id='1']");

		 public void clickaddtocartrecomitem() {
				driver.findElement(addtocartrecomitem).click();
				
			}
		 public boolean categorypresent() {
				return driver.findElement(presentcatgry).isDisplayed();
			}
		public boolean verifyrecommadeditem() {
			return driver.findElement(recommadeditem).isDisplayed();
		}
		public void click_on_Womenscatagory() {
			driver.findElement(Womens).click();
			
		}
		public void click_on_Dress() {
			driver.findElement(Dress).click();
			
		}
		public boolean Verify_Top_Products() {
			return driver.findElement(TopPrdcts).isDisplayed();
			
		}
		public void click_on_Men() {
			driver.findElement(Men).click();
		}
		public void click_on_shirts() {
			driver.findElement(shirts).click();
		}
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	public void scrolldown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js=(JavascriptExecutor) driver;

		//Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
	}
	public void scrollup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js=(JavascriptExecutor) driver;

		//Scroll up till the top of the page
	js.executeScript("arguments[0].scrollIntoView()",driver.findElement(verify_fulllabel));

		
	}
	
	public void click_Scrollup_arrowbtn() {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(scrollup));
	}
	public boolean verify_fulllabelafterscrollup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver.findElement(verify_fulllabel).isDisplayed();
		
	}
	public Products addtop() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView()",addtop);
		js.executeScript("arguments[0].click()",driver.findElement(addtop) );
		return new Products();

	}
	
	
	
}
