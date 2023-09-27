package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.Automation_Base;

public class Signup extends Automation_Base{
	By new_signup_label=By.xpath("//h2[text()='New User Signup!']");
	By signup_name = By.xpath("//input[@data-qa='signup-name']");
	By signup_email = By.xpath("//input[@data-qa='signup-email']");
	By signupbtn = By.xpath("//button[@data-qa='signup-button']");
	By acntinfo = By.xpath("//b[text()='Enter Account Information']");
	By email_already = By.xpath("//p[text()='Email Address already exist!']");
	By signup_title=By.xpath("//div[@id='uniform-id_gender2']");
	By name=By.xpath("//input[@id='name']");
	By email=By.xpath("//input[@id='email']");
	By pwd=By.xpath("//input[@id='password']");
	By days=By.xpath("//select[@id='days']");
	By month=By.xpath("//select[@id='months']");
	By year=By.xpath("//select[@id='years']");
	By checkbox_newsletter= By.xpath("//label[text()='Sign up for our newsletter!']");
	By addr_fname=By.xpath("//p[@class='required form-group']//child::input[@id='first_name']");
	By addr_lname=By.xpath("//p[@class='required form-group']//child::input[@id='last_name']");
	By company=By.xpath("//p[@class='form-group']//child::input[@id='company']");
	By address1=By.xpath("//p[@class='required form-group']//child::input[@id='address1']");
	By address2=By.xpath("//p[@class='required form-group']//child::input[@id='address2']");
	By findcountry=By.xpath("//select[@id='country']");
	By state=By.xpath("//p[@class='required form-group']//child::input[@id='state']");
	By city=By.xpath("//p[@class='required form-group']//child::input[@id='city']");
	By zipcode=By.xpath("//p[@class='required form-group']//child::input[@id='zipcode']");
	By mobile_number=By.xpath("//p[@class='required form-group']//child::input[@id='mobile_number']");
	By createaccount = By.xpath("//button[@data-qa='create-account']");
	By createdaccount = By.xpath("//b[text()='Account Created!']");
	By continuebutton =By.xpath("//a[text()='Continue']");


	public boolean verify_New_SignupPresent() {
		return driver.findElement(new_signup_label).isDisplayed();
	}
	public boolean verify_New_Signup_name_fieldPresent() {
		return driver.findElement(signup_name).isDisplayed();
	}
	public boolean verify_New_Signup_email_fieldPresent() {
		return driver.findElement(signup_email).isDisplayed();
	}
	public void enter_exiting_name_email_signuppage() {
		
		driver.findElement(signup_name).sendKeys(prop.getProperty("signupname"));
		driver.findElement(signup_email).sendKeys(prop.getProperty("signupemail"));
	}
	public void enter_new_name_email_signuppage() {
		
		driver.findElement(signup_name).sendKeys(prop.getProperty("newsignupname"));
		driver.findElement(signup_email).sendKeys(prop.getProperty("newsignupemail"));
	}
	public boolean verify_Signup_btn_Present() {
		return driver.findElement(signupbtn).isDisplayed();
	}
	public void click_Signup_Btn_() {
		driver.findElement(signupbtn).click();
	}
	public boolean verify_enter_account_info_label_Present() {
		return driver.findElement(acntinfo).isDisplayed();
	}
	
	public boolean verify_email_already_exist() {
		return driver.findElement(email_already).isDisplayed();
	}
	
	public void filldetails() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		//Fill details: Title, Name, Email, Password, Date of birth
		driver.findElement(signup_title).click();
		driver.findElement(name).sendKeys(prop.getProperty("signupname"));
		driver.findElement(email).isDisplayed();
		driver.findElement(pwd).sendKeys(prop.getProperty("pwd"));
		Select bdate =new  Select(driver.findElement(days));
		bdate.selectByValue(prop.getProperty("birthdate"));
		Select bmonth =new  Select(driver.findElement(month));
		bmonth.selectByValue(prop.getProperty("birthmonth"));
		Select byear =new  Select(driver.findElement(year));
		byear.selectByValue(prop.getProperty("birthyear"));
	}
	public void fill_details() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		scrolling();
		//Select checkbox 'Sign up for our newsletter!'
		driver.findElement(checkbox_newsletter).click();
		//Select checkbox 'Receive special offers from our partners!'
		By checkbox_offr= By.xpath("//input[@id='optin']");
		driver.findElement(checkbox_offr).click();
		//address info
		By address_info_label=By.xpath("//h2[@class='title text-center'] //child::b[text()='Address Information']");
		driver.findElement(address_info_label).isDisplayed();
		scrolling();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		//Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
		driver.findElement(addr_fname).sendKeys(prop.getProperty("addrfname"));
		driver.findElement(addr_lname).sendKeys(prop.getProperty("addrlname"));
		driver.findElement(company).sendKeys(prop.getProperty("company"));
		//address2
		driver.findElement(address1).sendKeys(prop.getProperty("address1"));
		driver.findElement(address2).sendKeys(prop.getProperty("address2"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
		Select country =new  Select(driver.findElement(findcountry));
		country.selectByValue(prop.getProperty("country"));
		//scrolling();
		driver.findElement(state).sendKeys(prop.getProperty("state"));
		driver.findElement(city).sendKeys(prop.getProperty("city"));
		driver.findElement(zipcode).sendKeys(prop.getProperty("zipcode"));
		driver.findElement(mobile_number).sendKeys(prop.getProperty("mobileno"));
	}
	public void click_create_account() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
		scrolling();
		driver.findElement(createaccount).click();	
	}
	
	public void verify_account_created() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
		driver.findElement(createdaccount).isDisplayed();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
		driver.findElement(continuebutton).isDisplayed();
		driver.findElement(continuebutton).click();

	}
}
