package com.demo.utility;

import org.openqa.selenium.WebDriver;

public class StartUpInitilize {
	public static WebDriver driver;
	public static String envName;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		StartUpInitilize.driver = driver;
	}

	public static String getEnvName() {
		return envName;
	}

	public static void setEnvName(String envName) {
		StartUpInitilize.envName = envName;
	}
}