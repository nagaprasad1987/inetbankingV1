package com.inetbanking.testCases;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.EditAccountPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.NewAccountPage;

public class TC_EditAccount_007 extends BaseClass {

	String newCustomerId = null;
	String newAccountNumber = null;
	@Test
	public void editAccount()
	{
		
		try
		{
			LoginPage lp = new LoginPage(driver);
			AddCustomerPage addCust = new AddCustomerPage(driver);
			NewAccountPage createAccount = new NewAccountPage(driver);
			EditAccountPage editAccount = new EditAccountPage(driver);

			lp.setUserName(username);
			logger.info("Entered username");

			lp.setPassword(password);
			logger.info("Entered password");

			lp.btnLogin();
			logger.info("clicked on login button");
			
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			//Create new customer
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
			
			
			//Create new account functionality
			Thread.sleep(3000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			createAccount.clickNewAccount();
			logger.info("Clicked on New Account link");
			
			Thread.sleep(3000);
			String actualmsg = createAccount.VerifyTextNewAccountForm();
			String expectedmsg = "Add new account form";
			
			if(actualmsg.equalsIgnoreCase(expectedmsg))
			{
				logger.info("Add new account form opened");
			}
			else
			{
				logger.info("Issue happened while opening add new account form");
			}
			
			createAccount.SetCustormerId(newCustomerId);
			logger.info("Entered customer id");
			
			createAccount.setAccountType("Savings");
			logger.info("Entered account type");
			
			createAccount.setInitialDeposit("500");
			logger.info("Entered initial deposit amount");
			
			createAccount.clickOnSubmit();
			logger.info("Clicked on submit button");
			
			Thread.sleep(3000);
			String accountGeneratedMsg = createAccount.verifyTextAccountGenereated();
			String expectedAccountGeneratedMsg = "Account Generated Successfully!!!";
			
			if(accountGeneratedMsg.equalsIgnoreCase(expectedAccountGeneratedMsg))
			{
				logger.info("New Acccount created successfully");
				newAccountNumber = createAccount.getNewAccountNumber();
				logger.info("New Account Number:"+newAccountNumber);
			}
			else
			{
				logger.info("create account failed");
				logger.info("Test failed....");
			}
			
			
			//Edit Account functionality
			Thread.sleep(3000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			editAccount.clickEditAccount();
			logger.info("Clicked on Edit Account");
			
			Thread.sleep(2000);
			
			String editAccountFormMsg = editAccount.verifyTitleAccoutEditForm();
			String expectedEditAccountFormMsg = "Edit Account Form";
			if(editAccountFormMsg.equalsIgnoreCase(expectedEditAccountFormMsg))
			{
				logger.info("Edit Account Form opened");
				editAccount.setAccountNumber(newAccountNumber);
				logger.info("Entered Account number");
				
				editAccount.clickSubmit();
				logger.info("clicked on submit button");
				
				Thread.sleep(2000);
				String accountEditEntryFormMsg = editAccount.verifyTitleEditAccountEntryForm();
				String expectedAccountEditEntryFormMsg = "Edit Account Entry Form";
				
				if(accountEditEntryFormMsg.equalsIgnoreCase(expectedAccountEditEntryFormMsg))
				{
					logger.info("Account Edit Entry Form opened");
					if(!editAccount.isCustomerIdEnabled())
					{
						logger.info("Customer Id is not editable. Expected");
					}
					else
					{
						logger.info("Customer Id is editable. Not expected");
						logger.info("Test failed.....");
					}
					
					editAccount.setAccountType("Current");
					logger.info("Entered Account type");
					
					if(!editAccount.isBalanceEnabled())
					{
						logger.info("Balance is not editable. Expected");
					}
					else
					{
						logger.info("Balance is editable.");
						logger.info("Test failed");
					}
					
					editAccount.clickOnSumbit();
					logger.info("Clicked on Submit button");
					
					Thread.sleep(2000);
					
					String accountDetailsUpdatedMsg = editAccount.verifyTitleAccountDetailsUpdated();
					String expectedaccountDetailsUpdatedMsg = "Account details updated Successfully!!!";
					
					if(accountDetailsUpdatedMsg.equalsIgnoreCase(expectedaccountDetailsUpdatedMsg))
					{
						logger.info("Account deatils updated.");
						logger.info("Test Passed...");
					}
					else
					{
						logger.info("Error in account details update");
						logger.info("Test failed");
					}
					
				}
				else
				{
					logger.info("Error in opening Account Edit form");
					logger.info("Test failed");
				}
				
			}
			else
			{
				logger.info("Error in opening Edit Account Form");
				logger.info("Test failed....");
			}
			
			
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


