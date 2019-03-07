package com.automationWorks.guiAutomation;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class ExtentDemo {
	public static ExtentTest test;
	public static ExtentReports report;
	public static WebDriver driver;

	@BeforeClass
	public static void startTest() {
		System.out.println("<<<<<<<<<<<<<" + System.getProperty("user.dir") + ">>>>>>>>>>>");
		report = new ExtentReports(System.getProperty("user.dir") + "\\extent-report\\ExtentReportResults.html");
		report.loadConfig(new File(System.getProperty("user.dir") + "\\config\\extent-config.xml"));
	}

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
		test = report.startTest("TestGoogle_Test1");
		driver.get("https://www.google.co.in");
		if (driver.getTitle().equals("Google")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + "Test Passed");
		}
		report.endTest(test);
	}

	@Test
	public void extentReportsDemoFail() throws IOException {
		test = report.startTest("TestGoogle_Test2");
		driver.get("https://www.google.co.in");
		if (driver.getTitle().equals("Google1")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + "Test Failed");
		}
		report.endTest(test);
	}

	@Test
	public void extentReportsDemoSkip() throws IOException {
		test = report.startTest("TestGoogle_Test3");
		driver.get("https://www.google.co.in");
		if (driver.getTitle().equals("Google1")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.SKIP, "Test Skipped");
		}
		report.endTest(test);
	}

	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") + "\\screenshots\\" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

	@AfterClass
	public static void endTest() {
		//report.endTest(test);
		report.flush();
	}
}