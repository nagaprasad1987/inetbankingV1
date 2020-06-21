package com.inetbanking.testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.DeleteCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_DeleteCustomer_005 extends BaseClass {

	@Test (dependsOnMethods = "TC_NewCustomer_003.addCustomer")
	public void deleteCustomer()
	{
		try {
			LoginPage lp = new LoginPage(driver);
			DeleteCustomerPage deleteCust = new DeleteCustomerPage(driver);
			TC_NewCustomer_003 newCust = new TC_NewCustomer_003();

			/*
			 * lp.setUserName(username); logger.info("Entered username");
			 * 
			 * lp.setPassword(password); logger.info("Entered password");
			 * 
			 * lp.btnLogin(); logger.info("clicked on login button");
			 * 
			 * Thread.sleep(3000); JavascriptExecutor js = (JavascriptExecutor) driver;
			 * js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 */


			Thread.sleep(3000);
			deleteCust.clickDeleteCustomer();
			logger.info("clicked on delete customer");

			deleteCust.setCustomerId(newCust.newCustomerId);
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

}
