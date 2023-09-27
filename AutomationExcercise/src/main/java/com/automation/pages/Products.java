package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.base.Automation_Base;

public class Products extends Automation_Base{
	 public By verify_All=By.xpath("//h2[text()='All Products']");
	 public By searchbox= By.xpath("//input[@id='search_product']");
	 public By searchbtn = By.xpath("//button[@id='submit_search']");
	 public  By searched= By.xpath("//h2[text()='Searched Products']");
	 public By whitetop1= By.xpath("//p[text()='Sleeves Printed Top - White']//parent::div[@class='productinfo text-center']");
	 public By whitetop2= By.xpath("//p[text()='Printed Off Shoulder Top - White']//parent::div[@class='productinfo text-center']");
	 By whitetop=By.xpath("//p[text()='Summer White Top']//parent::div[@class='productinfo text-center']");
	 public By addcart= By.xpath("//a[text()='Add to cart']");
	 By addtocartserchwhitetop2=By.xpath("//p[text()='Printed Off Shoulder Top - White']//ancestor::div[@class='product-overlay']//descendant::a[text()='Add to cart']");
	 By addcartbtnproduc= By.xpath("//button[@class='btn btn-default cart']");
	 By continuebtn =By.xpath("//button[text()='Continue Shopping']");
	 By viewcart = By.xpath("//u[text()='View Cart']");
	 public  By hover1st= By.xpath("//p[text()='Blue Top']");
	 By hover2nd= By.xpath("//p[text()='Men Tshirt']");
	By inputquantity= By.xpath("//input[@name='quantity']");
	By viewProduct= By.xpath("//a[text()='View Product']//ancestor::div[@class='choose']");
	 By productdetailsdescrip= By.xpath("//a[text()='Blue Top']");
	By proceedbtn=By.xpath("//a[text()='Proceed To Checkout']");
By continuecart= By.xpath("//button[text()='Continue On Cart']");
By signuploginbtn= By.xpath("//u[text()='Register / Login']");
By clickonproduct = By.xpath("//a[@href='/products']"); 
By navigatetoproducts = By.xpath("//h2[normalize-space()='All Products']");
By clickonviewprdct = By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");
By prdctdetailvisible = By.xpath("//h2[normalize-space()='Blue Top']");
By prdctcatagoryvisible = By.xpath("//p[normalize-space()='Category: Women > Tops']");
By priceisvisible = By.xpath("//span[normalize-space()='Rs. 500']");
By availability = By.xpath("//b[normalize-space()='Availability:']");
By condition = By.xpath("//b[normalize-space()='Condition:']");
By brand = By.xpath("//b[normalize-space()='Brand:']");
By productname = By.xpath("//input[@name='search']");
By inputprdctname= By.name("search");
By searchprdctvsbl = By.xpath("//h2[normalize-space()='Searched Products']");
By addtocart = By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]");
By polobrand = By.xpath("//a[text()='Polo']");
By verifypolobrand = By.xpath("//h2[normalize-space()='Brand - Polo Products']");
By writereview=By.xpath("//a[text()='Write Your Review']");
By name=By.xpath("//input[@placeholder='name']");
By email = By.xpath("//input[@name='email']");
By review= By.xpath("//textarea[@id='review']");
By submitbtn = By.xpath("//input[@id='button-review']");
By reviewresp=By.xpath("//a[text()='Thank you for your review.']");
public void selectbrandpolo() {
	driver.findElement(polobrand).click();
	}
	//a[text()='Proceed To Checkout']
	public boolean verifyallProducts() {
	return driver.findElement(verify_All).isDisplayed();
	}
	public boolean verifypolobranddisplayed() {
		return driver.findElement(verifypolobrand).isDisplayed();
		}
	public Home searchproduct() {
		driver.findElement(searchbox).sendKeys(prop.getProperty("searchproduct"));
		driver.findElement(searchbtn).click();
		return new Home();
	}
	public void addtocartserchwhitetop2() {
		driver.findElement(addtocartserchwhitetop2).click();
	}
	public boolean searchedproductPresent() {
		return driver.findElement(searched).isDisplayed();
	}
	public Checkout clickproceedbtnPresent() {
		 driver.findElement(proceedbtn).click();
		 return new Checkout();
	}
	public Signup clicksignuploginbtn() {
		 driver.findElement(signuploginbtn).click();
		 return new Signup();
	}
	public void verifylistofsearched() {
		driver.findElement(whitetop1).isDisplayed();
		driver.findElement(whitetop2).isDisplayed();
		driver.findElement(whitetop).isDisplayed();

	}
	public Products  hover1standaddtocart() {
		//Actions act =new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement menu1st=driver.findElement(hover1st);
	//	act.scrollToElement(menu1st).perform();
		JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView()",menu1st);
	js.executeScript("arguments[0].click()",driver.findElement(addcart) );
	return new Products();
	}
	public void  hover2ndandaddtocart() {
		//Actions act =new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js=(JavascriptExecutor) driver;

		WebElement menu2nd=driver.findElement(hover2nd);
		js.executeScript("arguments[0].scrollIntoView()",menu2nd);
		js.executeScript("arguments[0].click()",driver.findElement(addcart) );		
	}
	public void clickviewcart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(viewcart).click();
	}
	public void clickcontinueshpping() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",driver.findElement(continuebtn) );

		

	}
	
	public void increasequantit() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		JavascriptExecutor js=(JavascriptExecutor) driver;
		driver.findElement(viewProduct).click();
		//js.executeScript("arguments[0].click()",driver.findElement(viewProduct));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(inputquantity).clear();

		driver.findElement(inputquantity).sendKeys(prop.getProperty("quantity"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		js.executeScript("arguments[0].click()",driver.findElement(addcartbtnproduc) );		

	}
	public boolean verifyproductnamedetails() {
		return driver.findElement(hover1st).isDisplayed(); 
	}
	public String verifyproductqantitydetails() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		 return driver.findElement(inputquantity).getText(); 
	}
	public String actualqantity() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return prop.getProperty("quantity");
	}
	
	public boolean VerifyNavigateToAllProducts() {
	//	
			return driver.findElement(navigatetoproducts).isDisplayed();
		}
		public void prdctnameininput() {
			driver.findElement(inputprdctname).sendKeys(prop.getProperty("inputprdctname"));
			
		}
		public void ClickOnSearchButton() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   driver.findElement(searchbtn).click();   
		}
		public boolean searchprdctvisible() {
			return driver.findElement(searchprdctvsbl).isDisplayed();
			
		}
		public void TC8_ViewProduct() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Actions act = new Actions(driver);
			act.scrollByAmount(0, 500).perform();
			driver.findElement(clickonviewprdct).click();	
		}
		public boolean VerifyProductdetailIsVisible() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver.findElement(prdctdetailvisible).isDisplayed();
		}

		public boolean VerifyProductCategoryisvisible() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver.findElement(prdctcatagoryvisible).isDisplayed();	
		}
		public boolean VerifyPriceIsVisible() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   return driver.findElement(priceisvisible).isDisplayed();
			
		}
		public boolean VerifyAvailability() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver.findElement(availability).isDisplayed();
			
		}
		public boolean VarifyCondition() {
		return driver.findElement(condition).isDisplayed();
			
		}
		public boolean VerifyBrand() {
			return driver.findElement(brand).isDisplayed();
		}
		public void EnterProductName() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(productname).sendKeys(prop.getProperty("Productname"));
		}
		public void TC9_Products() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(clickonproduct).click();
		}
		public void clickviewProduct() {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.findElement(viewProduct).click();
		}
		public boolean vertifywritereviewdisplayed() {
			return driver.findElement(writereview).isDisplayed();
			}
		public boolean vertifyreviewdisplayed() {
			return driver.findElement(reviewresp).isDisplayed();
			}
		
		public void enterreviewdetails() {
			driver.findElement(name).sendKeys(prop.getProperty("contname"));
			driver.findElement(email).sendKeys(prop.getProperty("emailname"));
			driver.findElement(review).sendKeys(prop.getProperty("subject"));
		}
		public void clickreviewsubmit() {
			driver.findElement(submitbtn).click();
		}
}

