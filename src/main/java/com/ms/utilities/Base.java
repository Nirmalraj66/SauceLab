package com.ms.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
	
	public WebDriver driver;
	Properties prop;
	
	public WebDriver initialziecChromeDriver() throws IOException
	{
		prop = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"//config.properties"));
		prop = new Properties();
		prop.load(reader);
		
		  final String URL = "https://nirmalraj66:a85b1186-16d7-4334-8e66-d4cb4d19b0b1@ondemand.us-west-1.saucelabs.com:443/wd/hub";
		 
		  MutableCapabilities sauceOptions = new MutableCapabilities();

		  ChromeOptions browserOptions = new ChromeOptions();
		  browserOptions.setExperimentalOption("w3c", true);
		  browserOptions.setCapability("platformName", "Windows 10");
		  browserOptions.setCapability("browserVersion", "90.0");
		  browserOptions.setCapability("sauce:options", sauceOptions);

         	  
		  browserOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		  browserOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		  WebDriver driver=new RemoteWebDriver(new URL(URL), browserOptions);

		
		
		//driver = new ChromeDriver(caps);
		
		// Setting implicit wait to the driver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public String getLoginURL()
	{
	String loginURL = prop.getProperty("url");
	return loginURL;
	
	}

	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File screenshot = takeScreenShot.getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";

		FileUtils.copyFile(screenshot, new File(filePath));
		return filePath;

	}
	
}
