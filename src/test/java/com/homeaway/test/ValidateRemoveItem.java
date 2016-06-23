package com.homeaway.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.homeaway.commonutils.CommonUtils;
import com.homeaway.models.StoreLogin;

/**
 * @author mahendranPandurangan
 *
 */

public class ValidateRemoveItem extends CommonUtils{
	
	WebDriver driver;
	StoreLogin login;
	
	@BeforeTest
	public void setUp() throws Exception  {
		driver = getWebDriver("firefox");
		login = new StoreLogin(driver);
		login.navigateUrl("http://store.demoqa.com");
		login.clickMyAccount();
		login.typeUserName();
		login.typePassword();
		login.clickLogin();
		System.out.println("Login Successul");
		
	}
	
	@Test
	public void testRemoveCartItem() throws Exception {
		    clickElement(driver, ".//*[@id='header_cart']/a/span[1]");
		    Thread.sleep(2000);
			if(driver.findElements( By.xpath(".//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[2]/a") ).size() != 0){
			clickElement(driver, ".//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[6]/form/input[4]");
			String getMessage = getWebElementText(driver, ".//*[@id='post-29']/div");
			Assert.assertEquals(getMessage, "Oops, there is nothing in your cart.");
		}
		else {
			System.out.println("No items in cart, please add one to check this functionality");
		}
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
