package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.Home;
import com.automation.pages.Signup;

public class SignupPageTest {

	Home home;
	Signup signup;

	@BeforeMethod
	public void browserSetup() {
		// home = new Home();
		signup = new Signup();
		signup.initialization();
		signup.verify_homePagePresent();
	}

	@Test(priority = 1)
	public void tc1_new_Register_User() {
		Assert.assertTrue(signup.verify_Signup_login_Btn_Present());
		signup.click_Signup_login_Btn_();
		Assert.assertTrue(signup.verify_New_SignupPresent());
		Assert.assertTrue(signup.verify_New_Signup_name_fieldPresent());
		Assert.assertTrue(signup.verify_New_Signup_email_fieldPresent());
		signup.enter_new_name_email_signuppage();
		Assert.assertTrue(signup.verify_Signup_btn_Present());
		signup.click_Signup_Btn_();
		//Assert.assertFalse(signup.verify_Signup_btn_Present());
		signup.verify_enter_account_info_label_Present();
		signup.filldetails();
		signup.fill_details();
		signup.click_create_account();
		signup.verify_account_created();

	}

	@Test(priority = 2)
	public void tc5_existing_Register_User() {
		Assert.assertTrue(signup.verify_Signup_login_Btn_Present());
		signup.click_Signup_login_Btn_();
		Assert.assertTrue(signup.verify_New_SignupPresent());
		Assert.assertTrue(signup.verify_New_Signup_name_fieldPresent());
		Assert.assertTrue(signup.verify_New_Signup_email_fieldPresent());
		signup.enter_exiting_name_email_signuppage();
		Assert.assertTrue(signup.verify_Signup_btn_Present());
		signup.click_Signup_Btn_();
		Assert.assertTrue(signup.verify_email_already_exist());

	}
	@AfterMethod
	public void closeBrowserSetup() {
		signup.tearDown();
	}
}
