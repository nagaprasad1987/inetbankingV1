package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_EditCustomer_004 extends BaseClass{
	
	@Test
	public void editCustomer()
	{
		try
		{
			LoginPage lp = new LoginPage(driver);
			EditCustomerPage editCust = new EditCustomerPage(driver);
			
			lp.setUserName(username);
			logger.info("Entered username");

			lp.setPassword(password);
			logger.info("Entered password");

			lp.btnLogin();
			logger.info("clicked on login button");
			
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			Thread.sleep(3000);
			editCust.clickEditCustomerLink();
			logger.info("clicked on Edit Customer");
			
			editCust.enterCustomerId("86041");
			logger.info("Entered Customer ID");
			
			editCust.clickSubmitButton();
			logger.info("clicked on submit button");
			
			String actual = editCust.verifyEditCustomerMessage();
			String expected = "Edit Customer";
			
			try {
				Assert.assertEquals(actual, expected);
				logger.info("Landed on edit customer page");
			} catch (Exception e) {
				Assert.assertTrue(false);
				logger.info("Problem in moving to edit customer page");
			}
			
			if(editCust.editCustomerName())
			{
				logger.info("Test failed : customer name should not be editable");
			}
			else
			{
				logger.info("Customer name is disabled");
			}
			
			if(editCust.editGender())
			{
				logger.info("Test failed : Customer gender should not be editable");
			}
			else
			{
				logger.info("Customer gender is disabled");
			}
			
			if(editCust.editDob())
			{
				logger.info("Test failed : customer DOB should not be editable");
			}
			else
			{
				logger.info("Customer DOB is disabled");
			}
			
			
			editCust.editAddress("wynchipet");
			logger.info("entered new address");
			
			editCust.editCity("Vijayawada");
			logger.info("entered new city");
			
			editCust.editState("Andhra Pradesh");
			logger.info("Entered new State");
			
			editCust.editPin(generatePinNumber());
			logger.info("Entered new Pin Number");
			
			editCust.editPhoneNumber(generatePhonenumber());
			logger.info("Entered new Phone number");
			
			editCust.editEmailId(genereateEmailId());
			logger.info("Entered new emailID");
			
			editCust.clickSubmit();
			logger.info("clicked on submit button present on edit customer page");
			
			Thread.sleep(3000);
			String actualMsg = editCust.getUpdatedCustomerMsg();
			String expectedMsg = "Customer details updated Successfully!!!";
			
			Assert.assertEquals(actualMsg, expectedMsg);
			logger.info("Test passed");
			
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
			logger.info("Test failed");
		}

	}
	
	public String generatePinNumber()
	{
		return RandomStringUtils.randomNumeric(6);
	}

	public String generatePhonenumber()
	{
		return RandomStringUtils.randomNumeric(10);
	}

	public String genereateEmailId()
	{
		return RandomStringUtils.randomAlphanumeric(5)+"@gmail.com";
	}
}
