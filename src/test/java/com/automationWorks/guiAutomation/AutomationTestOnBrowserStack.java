package com.automationWorks.guiAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class AutomationTestOnBrowserStack {

	public static WebDriver driver;
	public static final String USERNAME = "nitin447";
	public static final String AUTOMATE_KEY = "1htkVdUqCqr2Jxca1kMb";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static String strDate = "";

	@BeforeSuite
	public void setupSuite() {
		getCurrentDataTime();
		System.out.println(strDate);
	}

	@Parameters({ "platform", "browser", "deviceName" })
	@BeforeTest
	public void setupTest(String platform, String browser, String deviceName) {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.networkLogs", "true");
		caps.setCapability("project", "MyIPhoneTestProject");
		caps.setCapability("build", "Build-" + strDate);
		System.out.println("Inside BeforeTest method: " + strDate);
		caps.setCapability("name", "TestCaseToPrintTitle");

		switch (platform.toLowerCase()) {
		case "windows":
			caps.setPlatform(Platform.WINDOWS);
			break;
		case "windows8":
			caps.setPlatform(Platform.WIN8);
			break;
		case "windows10":
			caps.setPlatform(Platform.WIN10);
			break;
		case "ios":
			caps.setCapability("real_mobile", "true");
			caps.setCapability("os_version", "10");
			caps.setPlatform(Platform.IOS);
			break;
		case "linux":
			caps.setPlatform(Platform.LINUX);
			break;
		case "android":
			caps.setCapability("real_mobile", "true");
			caps.setCapability("os_version", "6.0");
			caps.setPlatform(Platform.ANDROID);
			break;
		case "unix":
			caps.setPlatform(Platform.UNIX);
			break;
		default:
			caps.setPlatform(Platform.WINDOWS);
			break;
		}

		switch (browser.toLowerCase()) {
		case "firefox":
			caps = DesiredCapabilities.firefox();
			break;
		case "internet explorer":
			caps = DesiredCapabilities.internetExplorer();
			break;
		case "safari":
			caps = DesiredCapabilities.safari();
			break;
		case "opera":
			caps = DesiredCapabilities.operaBlink();
			break;
		case "chrome":
			caps = DesiredCapabilities.chrome();
			break;
		case "android":
			caps = DesiredCapabilities.android();
			break;
		default:
			caps = DesiredCapabilities.firefox();
			break;
		}

		switch (deviceName.toLowerCase()) {
		case "iphone6s":
			caps.setCapability("device", "iPhone 6S");
			break;
		case "samsunggalaxys8":
			caps.setCapability("device", "Samsung Galaxy Note 8");
			break;
		}

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			// driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getCurrentDataTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		strDate = sdf.format(now);
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
