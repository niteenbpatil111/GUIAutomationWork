package com.automationWorks.guiAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class AutomationTestThreadLocal {

	private WebDriver driver;

	@Parameters({"browser"})
	@BeforeMethod
	public void beforeMethod(String browser) {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<" + System.getProperty("user.dir") + ">>>>>>>>>>>>>>>>>>");
		driver = DriverFactory.getInstance().getDriver(browser);
		//driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		DriverFactory.getInstance().removeDriver();
	}

	@Test
	public void test1() {
		driver.navigate().to("http://www.google.com");
		System.out.println(driver.getTitle() + " of test1 method");
	}
}