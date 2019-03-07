package com.automationWorks.guiAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

/**
 * 
 * @author Nitin_Patil
 * This test is to explore the test execution on Docker
 * Prequisite for this: Docker Server should be running, latest selenium/hub, selenium/nodes for firefox and chorme etc.
 * images should be installed
 * 
 * */
public class AutomationTestOnDocker {

	public static WebDriver driver;

	@BeforeTest
	public void beforeTest() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps = DesiredCapabilities.chrome();
		caps.setPlatform(Platform.LINUX);

		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<" + System.getProperty("user.dir") + ">>>>>>>>>>>>>>>>>>");

		try {
			//driver = new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"), caps);
			//Below link is to run the test case 
			driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		//driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() {
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
