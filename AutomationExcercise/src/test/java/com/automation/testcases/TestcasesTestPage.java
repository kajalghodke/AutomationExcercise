package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.Testcases;

public class TestcasesTestPage {
Testcases tc;
	
	@BeforeMethod
	public void browserSetup() {
		tc = new Testcases();
		tc.initialization();
		tc.verify_homePagePresent();
	}
	
	@Test(priority = 10)
	public void tc07_testcases() {
		tc.click_testcases_Btn_Present();
		Assert.assertTrue(tc.verifytcpage());
		tc.clicktestcase07();
	}
	@AfterMethod
	public void closeBrowserSetup() {
		tc.tearDown();
	}
}
