package com.ms.smoke;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://smallpdf.com/pdf-to-word");
		
		driver.findElement(By.cssSelector(".l3tlg0-0.hrcxSS")).sendKeys("D:\\Test\\ECard (1).pdf");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sc-1mszb21-1.dCFgAk")));
		
		driver.findElement(By.cssSelector(".sc-1mszb21-1.dCFgAk")).click();
		
		driver.findElement(By.cssSelector(".sc-1mvwhop-0.bqmdbl"));
		
		
		
	

	}

}
