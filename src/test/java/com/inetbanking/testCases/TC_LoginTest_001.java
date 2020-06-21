package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter username");
		
		lp.setPassword(password);
		logger.info("Enter password");
		
		lp.btnLogin();
		logger.info("clicked on login button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test failed");
		}
			
		
	}

}
