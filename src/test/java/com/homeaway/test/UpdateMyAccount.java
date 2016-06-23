package com.homeaway.test;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
public class UpdateMyAccount extends CommonUtils {
	WebDriver driver;
	

	BasicAccountInfo basic;

	@BeforeTest
	public void setUp() throws Exception {
	    
		driver = getWebDriver("firefox");
		basic = new BasicAccountInfo(driver);
		StoreLogin login = new StoreLogin(driver);
		login.navigateUrl("http://store.demoqa.com");
		login.clickMyAccount();
		login.typeUserName();
		login.typePassword();
		login.clickLogin();
		System.out.println("Login Successul");

	}

	@Test
	public void testMyAccount() throws Exception {
		try {
			clickElement(driver, ".//*[@id='post-31']/div/div/div/a[2]");
			Thread.sleep(3000);
			basic.typeFirstName();
			basic.typeLastName();
			basic.typeAddress();
			basic.typeCity();
			basic.typePhone();
			clickElement(driver, ".//*[@id='post-31']/div/div/form/table[3]/tbody/tr/td/input[2]");

			clickElement(driver, ".//*[@id='meta']/ul/li[2]/a");

			System.out.println("Entered all info and logging out");

			setUp();
			clickElement(driver, ".//*[@id='post-31']/div/div/div/a[2]");
			Thread.sleep(3000);
			System.out.println("Logging again");

			for (int count = 2; count < 6; count++) {
				String getUpdatedInfo = getAttributeValue(driver, ".//*[@id='wpsc_checkout_form_" + count + "']",
						"value");
				System.out.println(getUpdatedInfo);
			}
			driver.close();
		} catch (Exception e) {
			File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrfile, new File("/HomeAwayExercise1/Screenshots/UpdateAccount-Error.jpeg"));
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
