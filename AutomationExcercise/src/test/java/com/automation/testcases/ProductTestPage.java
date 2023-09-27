package com.automation.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.Cart;
import com.automation.pages.Home;
import com.automation.pages.Login;
import com.automation.pages.Products;


public class ProductTestPage {
	
	Products pd;
	Home home;
	Cart cart;
	Login login;
	@BeforeMethod
	public void browserSetup() {
		pd = new Products();
		home= new Home();
		cart= new Cart();
		login= new Login();
		pd.initialization();
		pd.verify_homePagePresent();
	}
	@Test(priority = 6)
	public void tc08_Products() {
	pd.TC9_Products();
	Assert.assertTrue(pd.VerifyNavigateToAllProducts());
	pd.TC8_ViewProduct();
	Assert.assertTrue(pd.VerifyProductCategoryisvisible());
	Assert.assertTrue(pd.VerifyPriceIsVisible());
	Assert.assertTrue(pd.VerifyAvailability());
	Assert.assertTrue(pd.VarifyCondition());
	Assert.assertTrue(pd.VerifyBrand());
	pd.EnterProductName();
	pd.ClickOnSearchButton();
	
	}
	@Test(priority = 5)
	public void tc09searchproduct() {
		
		pd.click_products_Btn_Present();
		Assert.assertTrue(pd.verifyallProducts());
		pd.searchproduct();
		pd.verifylistofsearched();
		pd.addtocartserchwhitetop2();
	
		
	}
	
	@Test(priority = 6)
	public void tc12_addproduct() {
		pd.click_products_Btn_Present();
		pd.scrolling();
		pd.hover1standaddtocart();
		pd.clickcontinueshpping();
		pd.hover2ndandaddtocart();
		pd.clickviewcart();
	}
	@Test(priority = 7)
	public void tc13_VerifyProductquantityinCart() {
		
		pd.click_products_Btn_Present();
		pd.scrolling();
		//pd.clickviewcart();
		pd.increasequantit();
		pd.clickviewcart();
		String actTitle = (String) pd.verifyproductqantitydetails();
		String expTitle = pd.actualqantity();	
		Assert.assertEquals(actTitle, expTitle);
	}
	@Test
	public void tc19_ViewCartBrandProducts(){
		
		pd.click_products_Btn_Present();
		pd.VerifyBrand();
		pd.selectbrandpolo();
			
	}
	@Test(priority = 7)
	public void tc20SearchProductsVerifyCartAfterLogin()
	{
		pd.click_products_Btn_Present();
		Assert.assertTrue(pd.verifyallProducts());
		pd.searchproduct();
		pd.verifylistofsearched();
		home.click_carts_Btn_Present();
		home.click_Signup_login_Btn_();
		login.enter_validloginpage();
		Assert.assertTrue(login.verify_Login_btn_Present());
		login.click_Login_Btn_();
		cart.verifycartafterlogin();
	}
	@Test(priority = 8)
	public void tc21_Addreviewonproduct() {
		pd.click_products_Btn_Present();
		Assert.assertTrue(pd.verifyallProducts());
		pd.clickviewProduct();
		Assert.assertTrue(pd.vertifywritereviewdisplayed());
		pd.enterreviewdetails();
		pd.clickreviewsubmit();
		Assert.assertTrue(pd.vertifyreviewdisplayed());

	}
	
}

