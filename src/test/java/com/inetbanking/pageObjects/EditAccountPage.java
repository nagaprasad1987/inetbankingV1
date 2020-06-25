package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {
	
	WebDriver driver;
	
	public EditAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Edit Account")
	@CacheLookup
	WebElement linkEditAccount;
	
	@FindBy(xpath = "//p[text()='Edit Account Form']")
	@CacheLookup
	WebElement titleEditAccountForm;
	
	@FindBy(name = "accountno")
	@CacheLookup
	WebElement txtAccountId;
	
	@FindBy(name = "AccSubmit")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(xpath = "//p[text()='Edit Account Entry Form']")
	@CacheLookup
	WebElement titleEditAccountEntryForm;
	
	@FindBy(name = "txtcid")
	@CacheLookup
	WebElement txtCustomerId;
	
	@FindBy(name = "a_type")
	@CacheLookup
	WebElement dropDownAccountType;
	
	@FindBy(name = "txtinitdep")
	@CacheLookup
	WebElement txtBalance;
	
	@FindBy(name = "AccSubmit")
	@CacheLookup
	WebElement btnAccountSubmit;
	
	@FindBy(xpath = "//p[text()='Account details updated Successfully!!!']")
	@CacheLookup
	WebElement titelAccontDetailsUpdated;
	
	
	public void clickEditAccount()
	{
		linkEditAccount.click();
	}
	
	public String verifyTitleAccoutEditForm()
	{
		return titleEditAccountForm.getText();
	}
	
	public void setAccountNumber(String accountNumber)
	{
		txtAccountId.sendKeys(accountNumber);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public String verifyTitleEditAccountEntryForm()
	{
		return titleEditAccountEntryForm.getText();
	}
	
	public boolean isCustomerIdEnabled()
	{
		return txtCustomerId.isEnabled();
	}
	
	public void setAccountType(String accountType)
	{
		Select accType = new Select(dropDownAccountType);
		accType.selectByValue(accountType);
	}
	
	public boolean isBalanceEnabled()
	{
		return txtBalance.isEnabled();
	}
	
	public void clickOnSumbit()
	{
		btnAccountSubmit.click();
	}
	
	public String verifyTitleAccountDetailsUpdated()
	{
		return titelAccontDetailsUpdated.getText();
	}

}
