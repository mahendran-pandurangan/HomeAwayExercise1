package com.homeaway.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoreLogin {
	WebDriver driver;

	By myAccount = By.id("account");
	By username = By.id("log");
	By password = By.id("pwd");
	By login = By.id("login");

	public StoreLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void clickMyAccount() {
		driver.findElement(myAccount).click();
	}

	public void typeUserName() {
		driver.findElement(username).sendKeys("qatestdemo");

	}

	public void typePassword() {
		driver.findElement(password).sendKeys("test123$$");

	}

	public void clickLogin() {
		driver.findElement(login).click();
	}

}
