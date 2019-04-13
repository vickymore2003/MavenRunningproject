package com.demo.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.actions.BaseClass;

public class LoginLocators extends BaseClass {

	public LoginLocators() {
		System.out.println(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//Input[@id=\"user_login\"]")
	public WebElement userName;
	@FindBy(xpath = "//Input[@id=\"user_pass\"]")
	public WebElement Password;
	@FindBy(xpath = "//Input[@type=\"password\"]")
	public WebElement Login;
}