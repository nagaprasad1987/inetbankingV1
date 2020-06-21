package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Edit Customer")
	@CacheLookup
	WebElement clickEditCustomer;
	
	@FindBy(name = "cusid")
	@CacheLookup
	WebElement txtCustomerId;
	
	@FindBy(name = "AccSubmit")
	@CacheLookup
	WebElement clickSubmitBtn;
	
	@FindBy(xpath = "//p[contains(text(),'Edit Customer')]")
	@CacheLookup
	WebElement msgEditCustomer;
	
	@FindBy(name = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(name = "gender")
	@CacheLookup
	WebElement txtGender;
	
	@FindBy(name = "dob")
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
	WebElement txtPinNumber;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txtPhoneNumber;
	
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtEmailId;
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement SubmitBtn;
	
	@FindBy(xpath = "//p[contains(text(),'Customer details updated Successfully!!!')]")
	@CacheLookup
	WebElement msgUpdatedCustomerDetails;
	
	public void clickEditCustomerLink()
	{
		clickEditCustomer.click();
	}
	
	public void enterCustomerId(String customerId)
	{
		txtCustomerId.sendKeys(customerId);
	}
	
	public void clickSubmitButton()
	{
		clickSubmitBtn.click();
	}
	
	public String verifyEditCustomerMessage()
	{
		return msgEditCustomer.getText();
	}
	
	public Boolean editCustomerName()
	{
		return txtCustomerName.isEnabled();
	}
	
	public Boolean editGender()
	{
		return txtGender.isEnabled();
	}
	
	public Boolean editDob()
	{
		return txtDob.isEnabled();
	}
	
	public void editAddress(String address)
	{
		txtAddress.clear();
		txtAddress.sendKeys(address);
	}
	
	public void editCity(String city)
	{
		txtCity.clear();
		txtCity.sendKeys(city);
	}
	
	public void editState(String state)
	{
		txtState.clear();
		txtState.sendKeys(state);
	}
	
	public void editPin(String pin)
	{
		txtPinNumber.clear();
		txtPinNumber.sendKeys(pin);
	}
	
	public void editPhoneNumber(String phoneNumber)
	{
		txtPhoneNumber.clear();
		txtPhoneNumber.sendKeys(phoneNumber);
	}
	
	public void editEmailId(String emailId)
	{
		txtEmailId.clear();
		txtEmailId.sendKeys(emailId);
	}
	
	public void clickSubmit()
	{
		SubmitBtn.click();
	}
	
	public String getUpdatedCustomerMsg()
	{
		return msgUpdatedCustomerDetails.getText();
	}
}
