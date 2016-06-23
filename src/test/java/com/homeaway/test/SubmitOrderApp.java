package com.homeaway.test;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.homeaway.commonutils.CommonUtils;
import com.homeaway.models.BasicAccountInfo;
import com.homeaway.models.StoreLogin;

/**
 * @author mahendranPandurangan
 *
 */
public class SubmitOrderApp extends CommonUtils {

	WebDriver driver;
	private StoreLogin login;
	private BasicAccountInfo billing;

	@BeforeTest()
	public void storeLogin() {
		
		driver = getWebDriver("chrome");
	    login = new StoreLogin(driver);
        billing = new BasicAccountInfo(driver);
		login.navigateUrl("http://store.demoqa.com");
		login.clickMyAccount();
		login.typeUserName();
		login.typePassword();
		login.clickLogin();
		System.out.println("Login Successful");
	}

	@Test()
	public void testOrder() throws Exception {

		try {
			
			login.navigateUrl("http://store.demoqa.com/products-page/product-category/iphones/");
			clickElement(driver, 
					".//*[@id='default_products_page_container']/div[4]/div[2]/form/div[2]/div[1]/span/input");
			handlePopup(driver);
			clickElement(driver, ".//*[@id='fancy_notification_content']/a[1]");
			String getTotalPrice = getWebElementText(driver, 
					".//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[5]/span/span");

			System.out.println("Total Price of Apple Iphone 4 =" + getTotalPrice);
			clickElement(driver, ".//*[@id='checkout_page_container']/div[1]/a/span");
			Thread.sleep(1000);
			String verifyBillingLandingPage = getWebElementText(driver, ".//*[@id='wpsc_shopping_cart_container']/h2");
			System.out.println("Verified Billing Landing Page " +verifyBillingLandingPage);
			
			billing.typeEmail();
			billing.typeFirstName();
			billing.typeLastName();
			billing.typeAddress();
			billing.typeCity();
			billing.typePhone();
			String getCheckoutTotalPrice = getWebElementText(driver, ".//*[@id='checkout_total']/span");
			System.out.println("Total Price of Apple Iphone 4 =" + getCheckoutTotalPrice);
			Assert.assertEquals(getCheckoutTotalPrice, "$280.00");
			clickElement(driver, ".//*[@id='wpsc_shopping_cart_container']/form/div[4]/div/div/span/input");
			driver.close();
		} catch (Exception e) {
			File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
			FileUtils.copyFile(scrfile, new File("/HomeAwayExercise1/Screenshots/testOrder-Error.jpeg"));
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			System.out.println(stringWriter.toString());
		}

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
