package com.automationWorks.guiAutomation;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentDemoUsingListener {
	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test
	public void extentReportsDemoPass() throws IOException {
		driver.get("https://www.google.co.in");
		Assert.assertEquals(driver.getTitle(), "Google");
	}

	@Test
	public void extentReportsDemoFail() throws IOException {
		driver.get("https://www.google.co.in");
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Google1"));
	}

	@Test
	public void extentReportsDemoSkip() throws IOException {
		driver.get("https://www.google.co.in");
		System.out.println(driver.getTitle());
	}

	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") + "\\screenshots\\" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}
}