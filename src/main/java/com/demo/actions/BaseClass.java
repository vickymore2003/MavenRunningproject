package com.demo.actions;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.demo.utility.ReadProperties;
import com.demo.utility.StartUpInitilize;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void initilizeSuite() {
		reports = new ExtentReports(System.getProperty("user.dir")+"//Report//Report.html");
	}

	@BeforeMethod
	@Parameters({ "envName", "browserName" })
	public void beforeMethod(String envName, String browserName, Method method) {
		StartUpInitilize startUp = new StartUpInitilize();
		ReadProperties prop = new ReadProperties();
		logger = reports.startTest(method.getName());
		InvokeBrowser(browserName);
		startUp.setDriver(driver);
		startUp.setEnvName(envName);
		String url = prop.getProperties("url");
		driver.get(url);
	}

	public void InvokeBrowser(String browserName) {
		String driverPath = System.getProperty("user.dir") + "//Drivers//";
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "Firefox":
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3500);
		reports.endTest(logger);
		driver.quit();
	}
	
	@AfterSuite
	public void cleanUpSuites() {
		reports.flush();
	}
}