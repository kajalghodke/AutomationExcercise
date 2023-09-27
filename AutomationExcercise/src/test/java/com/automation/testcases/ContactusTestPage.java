package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.Contactus;
import com.automation.pages.Login;

public class ContactusTestPage {

	Contactus cont;
	
	@BeforeMethod
	public void browserSetup() {
		cont = new Contactus();
		cont.initialization();
		cont.verify_homePagePresent();
	}
	@Test(priority = 11)
	public void tc06_ContactUS() throws InterruptedException {
		
		cont.click_contactus_Btn_Present();
		Assert.assertTrue(cont.verify_getintouch());
		cont.fillcontactus();
		cont.uploadfile();
		cont.click_contact_submit();
		Assert.assertTrue(cont.verify_success());
		cont.click_homePage_Btn_();
		Assert.assertTrue(cont.verify_homePagePresent());

	}
	@AfterMethod
	public void closeBrowserSetup() {
		cont.tearDown();
	}
}
