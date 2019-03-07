package com.automationWorks.guiAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private String browserName;

	private DriverFactory() {
		// Do-nothing..Do not allow to initialize this class from outside
	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
	{
		@Override
		protected WebDriver initialValue() {
			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "browsers\\geckodriver.exe");
				return new FirefoxDriver(); // can be replaced with other browser drivers
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
				return new ChromeDriver(); // can be replaced with other browser drivers
			} else {
				System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
				return new ChromeDriver();
			}
		}
	};

	public WebDriver getDriver(String browser) // call this method to get the driver object and launch the browser
	{
		this.browserName = browser;
		return driver.get();
	}

	public void removeDriver() // Quits the driver and closes the browser
	{
		driver.get().quit();
		driver.remove();
	}
}