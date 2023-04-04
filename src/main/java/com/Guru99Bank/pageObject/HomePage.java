package com.Guru99Bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPageObject{

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement newCustomerButton;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public AddNewCustomerPage clickOnNewCustoomerOption()
	{
		newCustomerButton.click();
		return new AddNewCustomerPage(driver);
	}
}
