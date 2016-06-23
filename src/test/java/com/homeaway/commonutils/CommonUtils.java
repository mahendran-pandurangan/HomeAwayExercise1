package com.homeaway.commonutils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class CommonUtils {
	WebDriver driver;

	public WebDriver getWebDriver(String browser) {
		if (browser.equals("safari")) {
			driver = new SafariDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"src/test/resources/chromedriver");
			driver = new ChromeDriver();
			
		} else if (browser.equals("headless")) {
			driver = new HtmlUnitDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public void clickElement(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		element.click();
	}

	public void handlePopup(WebDriver driver) {
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);

		driver.switchTo().window(parentWindowHandler);
	}

	public String getWebElementText(WebDriver driver, String webElementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(webElementLocator)));
		return element.getText();

	}

	public String getAttributeValue(WebDriver driver, String attributeLocator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(attributeLocator)));
		return element.getAttribute(value);
	}

	@AfterSuite
	public void tearDownSuite() {
		driver.quit();
	}

}
