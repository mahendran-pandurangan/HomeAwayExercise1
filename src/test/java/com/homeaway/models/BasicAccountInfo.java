package com.homeaway.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAccountInfo {
	
	

	WebDriver driver;

	By email = By.cssSelector("#wpsc_checkout_form_9");
	By firstName = By.cssSelector("#wpsc_checkout_form_2");
	By lastName = By.cssSelector("#wpsc_checkout_form_3");
	By address = By.cssSelector("#wpsc_checkout_form_4");
	By city = By.cssSelector("#wpsc_checkout_form_5");
	By phone = By.cssSelector("#wpsc_checkout_form_18");

	public BasicAccountInfo(WebDriver driver) {
		this.driver = driver;
	}

	public void typeEmail() {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys("write2mahen@gmail.com");
	}

	public void typeFirstName() {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys("Mahendran");

	}

	public void typeLastName() {
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys("Pandurangan");

	}

	public void typeAddress() {
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys("1168 Morse Ave");
	}

	public void typeCity() {
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys("Sunnyvale");
	}

	public void typePhone() {
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys("123-456-9999");
	}
	

}
