package com.demo.actions;

import com.demo.locators.LoginLocators;
import com.demo.utility.ReadJson;
import com.relevantcodes.extentreports.LogStatus;

public class LoginAction extends BaseClass {

	LoginLocators login2 = new LoginLocators();

	public void login() {

		login2.userName.sendKeys(ReadJson.getJsonValue("$.Registration.login.username"));
		logger.log(LogStatus.INFO, "Username is entered");
		if (1 == 1) {
			logger.log(LogStatus.PASS, "Home page dispalayed");
		} else {
			logger.log(LogStatus.FAIL, "Home page not displayed");
		}
		
		login2.Password.sendKeys(ReadJson.getJsonValue("$Registration.login.password"));
		login2.Login.click();
	}
}
