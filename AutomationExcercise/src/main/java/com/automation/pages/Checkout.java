package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.base.Automation_Base;

public class Checkout extends Automation_Base {
	
	
By verifyaddress= By.xpath("//h3[text()='Your delivery address']");
By verifyrevieworder= By.xpath("//h2[text()='Review Your Order']");
By msg = By.xpath("//textarea[@name='message']");
By placeorder=By.xpath("//a[text()='Place Order']");
	public boolean verifyAddreesinCHeckout() {
	
			return driver.findElement(verifyaddress).isDisplayed();
	}
	public boolean verifyReviewOrderinCHeckout() {
		
		return driver.findElement(verifyrevieworder).isDisplayed();
}
public void entermsg() {
		
		 driver.findElement(msg).sendKeys("Test");
}
public Payment clickplaceorder() {
		
		driver.findElement(placeorder).click();
		return new Payment();
	
}


}
