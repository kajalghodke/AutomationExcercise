package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.Cart;
import com.automation.pages.Checkout;
import com.automation.pages.Home;
import com.automation.pages.Login;
import com.automation.pages.Payment;
import com.automation.pages.Products;
import com.automation.pages.Signup;
public class HomeTestPage {
	SignupPageTest dd;
	Home home;
	Products prod;
	Signup signup;
	Checkout checkout;
	Payment pay;
	Login login;
	Cart cart;
	@BeforeMethod
	public void browserSetup() {
		home = new Home();
		cart=new Cart();
		login= new Login();
		signup= new Signup();
		prod= new Products();
		checkout= new Checkout();
		home.initialization();
		home.verify_homePagePresent();
	}
	@Test
	public void tc10_VerifySubscriptioninHome() {
		
		home.click_homePage_Btn_();
		Assert.assertTrue(home.subscriptionHome());
		home.enteremailsubscription();
		home.click_subscribebtn();
		Assert.assertTrue(home.verify_success_subscripation());

	}
	@Test(priority = 3)
	public void tc14_placeorderRegisterwhileCheckout() {

		prod=home.addtop();
		prod.clickviewcart();
		prod.clickproceedbtnPresent();
		signup= prod.clicksignuploginbtn();
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
	@Test(priority = 3)
	public void tc15_placeorderRegisterbeforeCheckout() {

	
		signup= home.click_Signup_login_Btn_();
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
	
	@Test(priority = 9)
	public void tc24_downloadinvoice() {

		prod=home.addtop();
		prod.clickviewcart();
		prod.clickproceedbtnPresent();
		signup= prod.clicksignuploginbtn();
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
		home.click_carts_Btn_Present();
		checkout=prod.clickproceedbtnPresent();
		checkout.verifyAddreesinCHeckout();
		checkout.verifyReviewOrderinCHeckout();
		checkout.entermsg();
		pay=checkout.clickplaceorder();	
		pay.enterpaymentdetails();
		pay.clickpayconfirmbtn();
		pay.downloadinvoice();
		pay.clickpayconfirmbtn();
		login.click_delete_acc_Btn_();
		Assert.assertTrue(login.verify_deleted_account_label_Present());
		
		
	}
	@Test (priority = 6)
	public void tc17_RemoveitemfromCart() {
		prod=home.addtop();
		prod.clickviewcart();
		home.click_carts_Btn_Present();
		cart.varifycartpage();
		cart.remove_product();
		Assert.assertTrue(cart.verifyaddtoppresent());
		
	}
	@Test(priority = 4)
	public void tc18_ViewCategoryProducts() {
		Assert.assertTrue(home.categorypresent());
		home.click_on_Womenscatagory();
		home.click_on_Dress();
		Assert.assertTrue(home.Verify_Top_Products());
	}
	
	@Test(priority = 5)
	public void tc22_AddtocartfromRecommendeditems() {
		Assert.assertTrue(home.verifyrecommadeditem());
		home.clickaddtocartrecomitem();
		prod.clickviewcart();
		Assert.assertTrue(cart.verifyaddtoppresent());
		
	}
	@Test
	public void tc25_VerifySrollupusingarrowbtn() {
		home.click_homePage_Btn_();
		home.scrolldown();
		Assert.assertTrue(home.subscriptionHome());//5. Verify 'SUBSCRIPTION' is visible
		home.click_Scrollup_arrowbtn();
		Assert.assertTrue(home.verify_fulllabelafterscrollup());	
	}
	@Test
	public void tc26_VerifySrollupwithoutbtn() {
		
		home.click_homePage_Btn_();
		home.scrolldown();
		Assert.assertTrue(home.subscriptionHome());//5. Verify 'SUBSCRIPTION' is visible
		home.scrollup();
		Assert.assertTrue(home.verify_fulllabelafterscrollup());	
	}
	@AfterMethod
	public void closeBrowserSetup() {
		cart.tearDown();
	}
	

}
