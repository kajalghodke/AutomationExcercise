package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import com.automation.base.Automation_Base;

public class Testcases extends Automation_Base {
	
	By t7=By.xpath("//u[text()='Test Case 7: Verify Test Cases Page']");
	By tclistlabel= By.xpath("//span[text()='Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:']");
	public boolean verifytcpage() {
		return driver.findElement(tclistlabel).isDisplayed();
	}
	public void  clicktestcase07() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(t7).click();
	}
}
