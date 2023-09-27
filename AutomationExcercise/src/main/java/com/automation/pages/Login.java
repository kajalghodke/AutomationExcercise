package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import com.automation.base.Automation_Base;

public class Login extends Automation_Base{
	
	By loggedname=By.xpath("//a[text()=' Logged in as ']");
	By login_email = By.xpath("//input[@data-qa='login-email']");
	By login_pwd = By.xpath("//input[@data-qa='login-password']");
	By new_signup_label=By.xpath("//h2[text()='Login to your account']");
	By login_btn = By.xpath("//button[@data-qa='login-button']");
	By deleteacc=By.xpath("//a[text()=' Delete Account']");
	By deletedaccountlabel=By.xpath("//b[text()='Account Deleted!']");
	By invalidloginwarning =By.xpath("//p[text()='Your email or password is incorrect!']");
	By logoutbtn = By.xpath("//a[text()=' Logout']");
	public boolean verify_LogintoyouAccountPresent() {

		return driver.findElement(new_signup_label).isDisplayed();
	}
	public boolean verify_New_Signup_name_fieldPresent() {
		
		return driver.findElement(login_email).isDisplayed();
	}
	public boolean verify_New_Signup_email_fieldPresent() {

		return driver.findElement(login_pwd).isDisplayed();
	}
	public Signup enter_validloginpage() {
		driver.findElement(login_email).sendKeys(prop.getProperty("loginemail"));
		driver.findElement(login_pwd).sendKeys(prop.getProperty("loginpwd"));
		return new Signup();
	}
	public void enter_invalidloginpage() {
		driver.findElement(login_email).sendKeys(prop.getProperty("invalidloginemail"));
		driver.findElement(login_pwd).sendKeys(prop.getProperty("invalidloginpwd"));
	}
	public boolean verify_Login_btn_Present() {
		return driver.findElement(login_btn).isDisplayed();
	}
	public Home click_Login_Btn_() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(login_btn).click();
		return new Home();
	}
	public boolean verify_Loggedasusename_Present() {
		return driver.findElement(loggedname).isDisplayed();
	}
	public void click_delete_acc_Btn_() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(deleteacc).click();
	}
	public boolean verify_deleted_account_label_Present() {
		return driver.findElement(deletedaccountlabel).isDisplayed();
	}

	public boolean verify_invalid_warning_msg() {
		return driver.findElement(invalidloginwarning).isDisplayed();
	}
	public void click_logout_acc_Btn_() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(logoutbtn).click();
	}
}
