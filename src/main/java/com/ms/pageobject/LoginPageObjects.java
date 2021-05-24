package com.ms.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Hello world!
 *
 */
public class LoginPageObjects 
{
	
	public WebDriver driver;
	
    public LoginPageObjects(WebDriver driver) {
    this.driver = driver;
	}

  
    //page objects in login page
    
    private By email = By.id("user_email");
    private By password = By.id("user_password");
    private By login = By.name("commit");
    private By vaildationMessage = By.cssSelector(".alert.alert-danger.alert-show.mb-5");
    
      
    
    
    //return methods for weblements
    
    public WebElement getEmail()
    {
		
    	WebElement user_emailId = driver.findElement(email);
    	return user_emailId;
    	
    }
    public WebElement getPassword()
    {
		
    	WebElement user_passWord = driver.findElement(password);
    	return user_passWord;
    	
    }
    public WebElement getLogin()
    {
		
    	WebElement clickLogin = driver.findElement(login);
    	return clickLogin;
    	
    }
    
    public WebElement getValidationMessage()
    {
    	WebElement validationErrorMessage = driver.findElement(vaildationMessage);
    	return validationErrorMessage;
    }
    
    
    
    
    
    
    
    
	
	
}
