package com.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.automation.pages.Cart;
import com.automation.pages.Contactus;
import com.automation.pages.Products;
import com.automation.pages.Signup;
import com.automation.pages.Testcases;


public class Automation_Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	By home=By.xpath("//a[text()=' Home']");
	By signup_login_btn=By.xpath("//a[text()=' Signup / Login']");
	By products_btn=By.xpath("//a[text()=' Products']");
	By apitesting_btn=By.xpath("//a[text()=' API Testing']");
	By testcases_btn=By.xpath("//a[text()=' Test Cases']");
	By carts_btn=By.xpath("//a[text()=' Cart']");
	By contactus=By.xpath("//a[text()=' Contact us']");
	public By sublabel= By.xpath("//h2[text()='Subscription']");
	By subinput = By.xpath("//input[@id='susbscribe_email']");
	By subbtn= By.xpath("//button[@id='subscribe']");
	By successlabel= By.xpath("//div[@id='success-subscribe']//div[text()='You have been successfully subscribed!']");

	public void initialization() {
		readPropertyFile();
		// how to read the browser variable?
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(prop.getProperty("url"));
		
	}
	
	
	public void tearDown() {
		driver.close();
	}
	public void readPropertyFile() {
		prop = new Properties();
		String propFilePath = "./src/main/java/com/automation/config/config.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
public static void scrolling() {
		
		Actions act =new Actions(driver);
		//scrol 2 parmeters
		//first parameter:scroll left or right a negative value scrolls for left
		//second parameter :scrolls  top or bottom,a negative value scrolls up
		act.scrollByAmount(0, 900).perform();//perform 
		//scroll to specified element
		//WebElement menu=driver.findElement(By.xpath("//h4[text()='DEALS ON TOP BRANDS']"));
		//act.scrollToElement(menu).perform();
	}
	public boolean verify_homePagePresent() {
		return driver.findElement(home).isDisplayed();
	}
	public void click_homePage_Btn_() {

		driver.findElement(home).click();
	}
	public boolean verify_Signup_login_Btn_Present() {

		return driver.findElement(signup_login_btn).isDisplayed();
	}
	public Signup click_Signup_login_Btn_() {

		driver.findElement(signup_login_btn).click();
		return new Signup();
	}
	public boolean verify_products_Btn_Present() {

		return driver.findElement(products_btn).isDisplayed();
	}
	public Products click_products_Btn_Present() {

		driver.findElement(products_btn).click();
		return new Products();
	}
	public  void click_carts_Btn_Present() {

		driver.findElement(carts_btn).click();
		//return new Cart();
	}
	public Testcases click_testcases_Btn_Present() {

		driver.findElement(testcases_btn).click();
		return new Testcases();
	}
	public void click_apitesting_Btn_Present() {	

		driver.findElement(apitesting_btn).click();
	}
	public Contactus click_contactus_Btn_Present() {

		driver.findElement(contactus).click();
		return new Contactus();

	}
	
	public boolean subscriptionHome() {	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		scrolling();
		return driver.findElement(sublabel).isDisplayed();	
	}
	public void enteremailsubscription() {	
		
		 driver.findElement(subinput).sendKeys(prop.getProperty("subscribeemail"));	
	}
	public void click_subscribebtn() {	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		 driver.findElement(subbtn).click();}

	public boolean verify_success_subscripation() {	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	return driver.findElement(successlabel).isDisplayed();	
	}
	
	 
}
