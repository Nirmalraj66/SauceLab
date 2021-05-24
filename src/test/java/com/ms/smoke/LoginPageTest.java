package com.ms.smoke;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ms.pageobject.LoginPageObjects;
import com.ms.utilities.Base;



public class LoginPageTest {
	
	public WebDriver driver;
	Base base = new Base();
	LoginPageObjects loginPageObject;
	
	@BeforeTest
	public void getLoginURL() throws IOException
	{
		driver = base.initialziecChromeDriver();
		driver.get(base.getLoginURL());
		loginPageObject = new LoginPageObjects(driver);
		
	}
	
	// @Test(dataProvider ="verifyUserLogin", retryAnalyzer = udemy.login.base.RetryFailedCase.class)
	@Test
	public void verifyUserLogin1()
	{
		try {
		loginPageObject.getEmail().sendKeys("prabhu@mail.com");
		loginPageObject.getPassword().sendKeys("password");
		loginPageObject.getLogin().click();
		String expectedValidationMessage = "Invalid email or password.1";
		String actualValidationMessage = loginPageObject.getValidationMessage().getText();
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
		loginPageObject.getEmail().clear();
		loginPageObject.getPassword().clear();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyUserLogin2()
	{
		try {
		loginPageObject.getEmail().sendKeys("nirmal.accet@mail.com");
		loginPageObject.getPassword().sendKeys("password");
		loginPageObject.getLogin().click();
		String expectedValidationMessage = "Invalid email or password.";
		String actualValidationMessage = loginPageObject.getValidationMessage().getText();
		System.out.println(actualValidationMessage+" "+expectedValidationMessage);
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
		loginPageObject.getEmail().clear();
		loginPageObject.getPassword().clear();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyUserLogin3()
	{
		try {
		loginPageObject.getEmail().sendKeys("renu@mail.com");
		loginPageObject.getPassword().sendKeys("password");
		loginPageObject.getLogin().click();
		String expectedValidationMessage = "Invalid email or password.1";
		String actualValidationMessage = loginPageObject.getValidationMessage().getText();
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
		loginPageObject.getEmail().clear();
		loginPageObject.getPassword().clear();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyUserLogin4()
	{
		try {
		loginPageObject.getEmail().sendKeys("ganesh@mail.com");
		loginPageObject.getPassword().sendKeys("password");
		loginPageObject.getLogin().click();
		String expectedValidationMessage = "Invalid email or password.";
		String actualValidationMessage = loginPageObject.getValidationMessage().getText();
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
		loginPageObject.getEmail().clear();
		loginPageObject.getPassword().clear();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyUserLogin5()
	{
		try {
		loginPageObject.getEmail().sendKeys("ramesh@mail.com");
		loginPageObject.getPassword().sendKeys("password");
		loginPageObject.getLogin().click();
		String expectedValidationMessage = "Invalid email or password.";
		String actualValidationMessage = loginPageObject.getValidationMessage().getText();
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
		loginPageObject.getEmail().clear();
		loginPageObject.getPassword().clear();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}

}
