package com.Guru99Bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPageObject{

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement newCustomerButton;	
	
	@FindBy(xpath = "//a[text()='New Account']")
	WebElement newAccountButton;
	
	@FindBy(xpath = "//a[text()='Fund Transfer']")
	WebElement fundTransferButton;
	
	@FindBy(xpath = "//a[text()='Edit Customer']")
	WebElement editCustomerButton;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public AddNewCustomerPage clickOnNewCustomerOption()
	{
		newCustomerButton.click();
		return new AddNewCustomerPage(driver);
	}	
	
	public AddNewAccountPage clickOnNewAccountOption()
	{
		newCustomerButton.click();
		return new AddNewAccountPage(driver);
	}
	
	public FundTransferPage clickOnFundTransferButton()
	{
		fundTransferButton.click();
		return new FundTransferPage(driver);
	}
	
	
	public EditCustomerPage clickOnEditCustomerOption()
	{
		editCustomerButton.click();
		return new EditCustomerPage(driver);
	}
}
