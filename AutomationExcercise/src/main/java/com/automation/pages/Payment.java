package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.base.Automation_Base;

public class Payment extends Automation_Base {
	
	By payment=By.xpath("//h2[text()='Payment']");
	By nameofcard=By.xpath("//input[@name='name_on_card']");
	By cardno= By.xpath("//input[@name='card_number']");
	By cvc=By.xpath("//input[@name='cvc']");
	By expirationmm = By.xpath("//input[@name='expiry_month']");
	By expiryyear= By.xpath("//input[@name='expiry_year']");
	By confirmbtn=By.xpath("//button[text()='Pay and Confirm Order']");
	By orderplaced=By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
	By downloadinvoice= By.xpath("//a[text()='Download Invoice']");
	By continuebtn= By.xpath("//a[text()='Continue']");
	
	public void enterpaymentdetails() {
		driver.findElement(nameofcard).sendKeys(prop.getProperty("nameofcard"));
		driver.findElement(cardno).sendKeys(prop.getProperty("cardno"));
		driver.findElement(cvc).sendKeys(prop.getProperty("cvc"));
		driver.findElement(expirationmm).sendKeys(prop.getProperty("expirationmm"));
		driver.findElement(expiryyear).sendKeys(prop.getProperty("expiryyear"));

		
	}
	public void clickpayconfirmbtn() {
		driver.findElement(confirmbtn).click();
	}
	public void downloadinvoice() {
		driver.findElement(downloadinvoice).click();

	}
	

	
}
