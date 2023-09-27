package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.Cart;
import com.automation.pages.Home;
import com.automation.pages.Products;

public class CartTestPage {
	Home home;
	Products prod;
	Cart cart;
	@BeforeMethod
	public void browserSetup() {
		cart = new Cart();
		cart.initialization();
		cart.verify_homePagePresent();
	}
	@Test
	public void tc11_VerifySubscriptioninCart() {
		cart.click_carts_Btn_Present();
		Assert.assertTrue(cart.subscriptionCart());
		Assert.assertTrue(cart.subscriptionHome());
		cart.enteremailsubscription();
		cart.click_subscribebtn();
		Assert.assertTrue(cart.verify_success_subscripation());

	}
	@AfterMethod
	public void closeBrowserSetup() {
		cart.tearDown();
	}
	

}
