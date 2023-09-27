package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.Checkout;
import com.automation.pages.Home;
import com.automation.pages.Login;
import com.automation.pages.Payment;
import com.automation.pages.Products;
import com.automation.pages.Signup;


public class LoginPageTest {
	SignupPageTest dd;
	Home home;
	Products prod;
	Signup signup;
	Checkout checkout;
	Payment pay;
	Login login;
	
	@BeforeMethod
	public void browserSetup() {
		login = new Login();
		login.initialization();
		login.verify_homePagePresent();
	}
	
	@Test(priority = 3)
	public void tc2_validLogin() {
		
		Assert.assertTrue(login.verify_Signup_login_Btn_Present());
		login.click_Signup_login_Btn_();
		Assert.assertTrue(login.verify_LogintoyouAccountPresent());
		login.enter_validloginpage();
		Assert.assertTrue(login.verify_Login_btn_Present());
		login.click_Login_Btn_();
		Assert.assertTrue(login.verify_Loggedasusename_Present());
		login.click_delete_acc_Btn_();
		Assert.assertTrue(login.verify_deleted_account_label_Present());
		
	}
	@Test
	public void tc3_invalidLogin() {
		
		Assert.assertTrue(login.verify_Signup_login_Btn_Present());
		login.click_Signup_login_Btn_();
		Assert.assertTrue(login.verify_LogintoyouAccountPresent());
		login.enter_invalidloginpage();
		Assert.assertTrue(login.verify_Login_btn_Present());
		login.click_Login_Btn_();
		Assert.assertTrue(login.verify_invalid_warning_msg());	
	}
	@Test(priority = 4)
	public void tc16_placeorderLoginbeforeCheckout() {
		Assert.assertTrue(login.verify_Signup_login_Btn_Present());
		login.click_Signup_login_Btn_();
		Assert.assertTrue(login.verify_LogintoyouAccountPresent());
		login.enter_validloginpage();
		Assert.assertTrue(login.verify_Login_btn_Present());
		home=login.click_Login_Btn_();
		Assert.assertTrue(login.verify_Loggedasusename_Present());
		prod=home.addtop();
		prod.clickviewcart();
		home.click_carts_Btn_Present();
		checkout=prod.clickproceedbtnPresent();
		checkout.verifyAddreesinCHeckout();
		checkout.verifyReviewOrderinCHeckout();
		checkout.entermsg();
		pay=checkout.clickplaceorder();	
		pay.enterpaymentdetails();
		pay.clickpayconfirmbtn();
		login.click_delete_acc_Btn_();
		Assert.assertTrue(login.verify_deleted_account_label_Present());
		
	}
	@Test(priority = 5)
	public void tc23_Verifyaddressdetailsincheckoutpage() {
		
		Assert.assertTrue(login.verify_Signup_login_Btn_Present());
		login.click_Signup_login_Btn_();
		Assert.assertTrue(login.verify_LogintoyouAccountPresent());
		login.enter_validloginpage();
		Assert.assertTrue(login.verify_Login_btn_Present());
		home=login.click_Login_Btn_();
		Assert.assertTrue(login.verify_Loggedasusename_Present());
		prod=home.addtop();
		prod.clickviewcart();
		home.click_carts_Btn_Present();
		checkout=prod.clickproceedbtnPresent();
		checkout.verifyAddreesinCHeckout();
		pay=checkout.clickplaceorder();	
		pay.enterpaymentdetails();
		pay.clickpayconfirmbtn();
		login.click_delete_acc_Btn_();
		Assert.assertTrue(login.verify_deleted_account_label_Present());	
		
	}
	@Test
	public void tc4_logout() {
		Assert.assertTrue(login.verify_Signup_login_Btn_Present());
		login.click_Signup_login_Btn_();
		Assert.assertTrue(login.verify_LogintoyouAccountPresent());
		login.enter_validloginpage();
		Assert.assertTrue(login.verify_Login_btn_Present());
		login.click_Login_Btn_();
		Assert.assertTrue(login.verify_Loggedasusename_Present());
		login.click_logout_acc_Btn_();
	}
	@AfterMethod
	public void closeBrowserSetup() {
		login.tearDown();
	}

}
