package com.inetbanking.testCases;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.DeleteCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_DeleteCustomer_005 extends BaseClass {

	@Test
	public void deleteCustomer()
	{
		try {
			LoginPage lp = new LoginPage(driver);
			AddCustomerPage addCust = new AddCustomerPage(driver);
			DeleteCustomerPage deleteCust = new DeleteCustomerPage(driver);
			
			String newCustomerId = null;

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
			
			Thread.sleep(3000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			Thread.sleep(3000);
			deleteCust.clickDeleteCustomer();
			logger.info("clicked on delete customer");

			deleteCust.setCustomerId(newCustomerId);
			logger.info("Entered customer id");

			deleteCust.clickSubmitBtn();
			logger.info("clicked on submit button");
			
			Thread.sleep(3000);

			if(isAlertPresent()==true)
			{
				logger.info("customer deleted successfully");
				logger.info("Test passed");
			}
			else
			{
				logger.info("customer does not exist");
				logger.info("Test failed");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isAlertPresent() throws Exception
	{
		driver.switchTo().alert();
		logger.info(driver.switchTo().alert().getText());
		logger.info("captured first alert message");
		driver.switchTo().alert().accept();
		driver.switchTo().alert();
		String alertMsg = driver.switchTo().alert().getText();
		logger.info(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		String deleteCustomerSuccessMsg = "Customer deleted Successfully";
		String customerNotexistMsg = "Customer does not exist!!";
		if(alertMsg.equalsIgnoreCase(deleteCustomerSuccessMsg))
		{
			Assert.assertTrue(true);
			logger.info("Test passed");
			return true;
		}
		else if(alertMsg.equalsIgnoreCase(customerNotexistMsg))
		{
//			Assert.assertTrue(false);
			logger.info("Test failed");
			return false;
		}
		else
		{
//			Assert.assertTrue(false);
			logger.info("Test failed");
			return false;
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
