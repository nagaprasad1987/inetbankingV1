package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDTT(String user, String password) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username provided");
		
		lp.setPassword(password);
		logger.info("password provided");
		
		lp.btnLogin();
		logger.info("login button clicked");
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();// close the alert
			driver.switchTo().defaultContent();
//			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.logoutLink();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close the logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() // user create method to check alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", rowCount);
		
		String loginData[][] = new String[rowCount][colCount];
		
		for(int i = 1; i <= rowCount; i++)
		{
			for(int j = 0; j < colCount; j++)
			{
				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;
	}

}
