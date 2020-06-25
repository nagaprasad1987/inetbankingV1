package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	
	WebDriver driver;
	
	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "New Account")
	@CacheLookup
	WebElement linkNewAccount;
	
	@FindBy(xpath = "//p[text() = 'Add new account form']")
	@CacheLookup
	WebElement txtNewAccountForm;
	
	@FindBy(name = "cusid")
	@CacheLookup
	WebElement txtCustomerId;
	
	@FindBy(name = "selaccount")
	@CacheLookup
	WebElement accountType_dropdown;
	
	@FindBy(name = "inideposit")
	@CacheLookup
	WebElement txtInitialDeposit;
	
	@FindBy(name = "button2")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(xpath = "//p[text() = 'Account Generated Successfully!!!']")
	@CacheLookup
	WebElement txtAccountGenerated;
	
	@FindBy(xpath = "//table/tbody/tr[4]/td[2]")
	@CacheLookup
	WebElement newAccountId;
	
	public void clickNewAccount()
	{
		linkNewAccount.click();
	}
	
	public String VerifyTextNewAccountForm()
	{
		return txtNewAccountForm.getText();
	}
	
	public void SetCustormerId(String customerId)
	{
		txtCustomerId.sendKeys(customerId);
	}
	
	public void setAccountType(String accountType)
	{
		Select accountTypeDropdown = new Select(accountType_dropdown);
		accountTypeDropdown.selectByVisibleText(accountType);
	}
	
	public void setInitialDeposit(String amount)
	{
		txtInitialDeposit.sendKeys(amount);
	}
	
	public void clickOnSubmit()
	{
		btnSubmit.click();
	}
	
	public String verifyTextAccountGenereated()
	{
		return txtAccountGenerated.getText();
	}
	
	public String getNewAccountNumber()
	{
		return newAccountId.getText();
	}

}
