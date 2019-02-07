package com.automationWorks.guiAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class AutomationTest {

	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test
	public void test1() {
		driver.navigate().to("http://www.google.com");
		System.out.println(driver.getTitle() + " of test1 method");
	}

	@Test
	public void test2() {
		driver.navigate().to("http://www.google.com");
		System.out.println(driver.getTitle() + " of test2 method");
	}

	@Test
	public void test3() {
		driver.navigate().to("http://www.google.com");
		System.out.println(driver.getTitle() + " of test3 method");
	}

}
