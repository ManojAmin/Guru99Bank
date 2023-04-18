package com.Guru99Bank.pageObject;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Guru99Bank.utils.ReadDataFromExcel;

public class EditCustomerPage extends ParentPageObject {	

	private Map<String, String> data;
	
	@FindBy(name = "cusid")
	WebElement customerId;
	
	@FindBy(name = "AccSubmit")
	WebElement customerSearchSubmitButton;
	
	@FindBy(name = "addr")
	WebElement addressTextField;
	
	@FindBy(name = "sub")
	WebElement customerUpdateSubmitButton;
	
	public EditCustomerPage(WebDriver driver) {
		super(driver);
		data=new ReadDataFromExcel().editCustomerDetails();
	}
	
	public void enterCustomerIdToEdit()
	{
		log.debug(" Customer id : " +data.get("CustomerId"));
		customerId.sendKeys(data.get("CustomerId"));
	}
	
	public void submitCustomerId()
	{
		customerSearchSubmitButton.click();
	}
	
	public String enterUpdatedAddress()
	{
		addressTextField.clear();
		String address=data.get("Address");
		addressTextField.sendKeys(address);
		return address;
	}
	
	public String getUpdatedAddress()
	{
		return addressTextField.getText();
	}
	
	public void submitUpdatedDetails()
	{
		customerUpdateSubmitButton.click();
	}
	
	public void clickOnOkInAlert()
	{
		driver.switchTo().alert().accept();
	}
	
}
