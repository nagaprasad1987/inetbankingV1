package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
	WebDriver driver;
	
	public DeleteCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Delete Customer")
	@CacheLookup
	WebElement linkDeleteCustomer;
	
	@FindBy(xpath = "//p[contains(text(),'Delete Customer Form')]")
	@CacheLookup
	WebElement titleDeleteCustomerForm;
	
	@FindBy(name = "cusid")
	@CacheLookup
	WebElement txtCustid;
	
	@FindBy(name = "AccSubmit")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickDeleteCustomer()
	{
		linkDeleteCustomer.click();
	}
	
	public String verifyDeleteCustomerForm()
	{
		return titleDeleteCustomerForm.getText();
	}
	
	public void setCustomerId(String custId)
	{
		txtCustid.sendKeys(custId);
	}
	
	public void clickSubmitBtn()
	{
		btnSubmit.click();
	}
	
}
