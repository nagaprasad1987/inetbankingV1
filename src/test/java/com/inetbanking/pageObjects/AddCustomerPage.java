package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement NewCustomer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtcustomerName;
	
	@FindBy(xpath = "//input[@name='rad1' and @value='m']")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(id = "dob")
	@CacheLookup
	WebElement txtDob;
	
	@FindBy(name = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement txtPinNum;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txtPhoneNum;
	
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtEmailId;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(xpath = "//p[contains(text(),'Customer Registered Successfully!!!')]")
	@CacheLookup
	WebElement CustRegistedSuccess;
	
	@FindBy(xpath = "//table/tbody/tr[4]/td[2]")
	@CacheLookup
	WebElement txtNewCustomerId;
	
	public void clickNewcustomer()
	{
		NewCustomer.click();
	}

	public void setCustomerName(String customerName) {
		txtcustomerName.sendKeys(customerName);
	}

	public void setGender() {
		rdGender.click();
	}

	public void setDOB(String mm, String dd, String yyyy) {
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yyyy);
	}

	public void setAddress(String Address) {
		txtAddress.sendKeys(Address);
	}

	public void setCity(String city) {
		txtCity.sendKeys(city);
	}

	public void setState(String State) {
		txtState.sendKeys(State);
	}

	public void setPinNum(String PinNum) {
		txtPinNum.sendKeys(PinNum);
	}

	public void setPhoneNum(String PhoneNum) {
		txtPhoneNum.sendKeys(PhoneNum);
	}

	public void setEmailId(String EmailId) {
		txtEmailId.sendKeys(EmailId);
	}

	public void setPassword(String Password) {
		txtPassword.sendKeys(Password);
	}

	public void clickSubmitBtn() {
		btnSubmit.click();
	}
	
	public String getCustomerRegisteredMessage()
	{
		return CustRegistedSuccess.getText();	
    }
	
	public String getNewCustomerId()
	{
		return txtNewCustomerId.getText();
	}
}
