package com.inetbanking.testCases;

import java.math.BigInteger;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_NewCustomer_003 extends BaseClass {
	
	String newCustomerId=null;

	@Test
	public void addCustomer()
	{
		try
		{
			LoginPage lp = new LoginPage(driver);
			AddCustomerPage addCust = new AddCustomerPage(driver);

			lp.setUserName(username);
			logger.info("Entered username");

			lp.setPassword(password);
			logger.info("Entered password");

			lp.btnLogin();
			logger.info("clicked on login button");
			
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			addCust.clickNewcustomer();
			logger.info("clicked on new customer");
			
			Thread.sleep(3000);

			addCust.setCustomerName("abcdef");
			logger.info("Entered customer name");

			addCust.setGender();
			logger.info("gender selected");

			addCust.setDOB("10", "10", "2000");
			logger.info("Entered DOB");
			
			Thread.sleep(3000);

			addCust.setAddress("abc street");
			logger.info("Entered address");

			addCust.setCity("Houston");
			logger.info("Entered City");

			addCust.setState("TEXAS");
			logger.info("Entered State");

			addCust.setPinNum("345865");
			logger.info("PIN No entered");

			addCust.setPhoneNum(generatePhonenumber());
			logger.info("Entered Phone number");

			addCust.setEmailId(genereateEmailId());
			logger.info("Entered Email Id");

			addCust.setPassword("hello");
			logger.info("Entered password");
			
			Thread.sleep(10000);

			addCust.clickSubmitBtn();
			logger.info("clicked on submit button");
			
			String actual = addCust.getCustomerRegisteredMessage();
			String expected = "Customer Registered Successfully!!!";
			Assert.assertEquals(actual, expected);
			logger.info("New customer registered successfully");
			newCustomerId = addCust.getNewCustomerId();
			logger.info("CustomerId:"+addCust.getNewCustomerId());
			logger.info("Test Passed");
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
			logger.info("Test failed");
		}


	}

	public String generatePhonenumber()
	{
		Random r = new Random();
		int s = 1 + r.nextInt(8);
		return s + RandomStringUtils.randomNumeric(9);
	}

	public String genereateEmailId()
	{
		return RandomStringUtils.randomAlphanumeric(5)+"@gmail.com";
	}
	
}
