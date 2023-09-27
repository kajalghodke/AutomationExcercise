package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.base.Automation_Base;

public class Contactus extends Automation_Base {

	By contactus_btn = By.xpath("//a[text()=' Contact us']");
	By getintouchlabel =By.xpath("//h2[text()='Get In Touch']");
	By name=By.xpath("//input[@placeholder='Name']");
	By email = By.xpath("//input[@name='email']");
	By subject = By.xpath("//input[@name='subject']");
	By message= By.xpath("//textarea[@id='message']");
	By uploadfile= By.xpath("//input[@type='file']");
	By submitbtn = By.xpath("//input[@type='submit']");
	By sucesslabel = By.xpath("//div[text()='Success! Your details have been submitted successfully.']");
	
	public boolean verify_getintouch() {
		return driver.findElement(getintouchlabel).isDisplayed();
	}
	
	public void fillcontactus() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		driver.findElement(name).sendKeys(prop.getProperty("contname"));
		driver.findElement(email).sendKeys(prop.getProperty("emailname"));
		driver.findElement(subject).sendKeys(prop.getProperty("subject"));
		driver.findElement(message).sendKeys(prop.getProperty("message"));
	
		//Alert al=driver.switchTo().alert();//switch main window to alert window
		//al.dismiss();
		Actions act =new Actions(driver);
		act.scrollByAmount(0, 200).perform();//perform 

	}
	public  void uploadfile() throws InterruptedException {	
		WebElement broswer_btn =driver.findElement(uploadfile);
		broswer_btn.sendKeys(prop.getProperty("browsefile"));

	}
	public void click_contact_submit() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		scrollingdown();
		driver.findElement(submitbtn).click();
		Alert al=driver.switchTo().alert();//switch main window to alert window
		al.accept();//for accepting  for ok button on alert
	}
	public boolean verify_success() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver.findElement(sucesslabel).isDisplayed();	
	}
public void scrollingdown() {
		
		Actions act =new Actions(driver);
		//scrol 2 parmeters
		//first parameter:scroll left or right a negative value scrolls for left
		//second parameter :scrolls  top or bottom,a negative value scrolls up
		//act.scrollByAmount(0, 900).perform();//perform 
		//scroll to specified element
		WebElement menu=driver.findElement(submitbtn);
		act.scrollToElement(menu).perform();
	}
	
	

}
