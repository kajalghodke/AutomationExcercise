package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.automation.base.Automation_Base;

public class Cart extends Automation_Base{

		By cartpresent =By.xpath("//li[text()='Shopping Cart']");
		By removecartitem = By.xpath("//a[text()='Blue Top']//ancestor::tr//descendant::a[@class='cart_quantity_delete']");
		By removemark= By.xpath("//a[@class='cart_quantity_delete']");
	//	By addtop=By.xpath("//p[text()='Blue Top']//ancestor::div[@class='product-overlay']//descendant::a[text()='Add to cart']");
		 By addtop=By.xpath("//p[text()='Blue Top']//ancestor::div[@class='product-overlay']//descendant::a[text()='Add to cart']");
		 public By whitetop2= By.xpath("//p[text()='Printed Off Shoulder Top - White']//parent::div[@class='productinfo text-center']");

		By addcartitem = By.xpath("");
		public Cart remove_product() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			JavascriptExecutor js=(JavascriptExecutor) driver;
			//js.executeScript("arguments[0].scrollIntoView()",addtop);
			js.executeScript("arguments[0].click()",driver.findElement(removecartitem) );
			return new Cart();

		}
		public boolean verifycartafterlogin() {
			return driver.findElement(whitetop2).isDisplayed();
		}
		public boolean subscriptionCart() {	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			scrolling();
			return driver.findElement(cartpresent).isDisplayed();	
		}
		public Cart removeitemfromcart() {
			driver.findElement(removemark).click();
			return new Cart();
		}
		public boolean varifycartpage() {
			return driver.findElement(cartpresent).isDisplayed();
		}
		public boolean verifyaddtoppresent() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			return driver.findElement(addtop).isDisplayed();
		}
		

}
