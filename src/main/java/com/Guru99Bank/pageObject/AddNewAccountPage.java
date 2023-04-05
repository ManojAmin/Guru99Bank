package com.Guru99Bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewAccountPage extends ParentPageObject {

	public AddNewAccountPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(name = "cusid")
	WebElement customerIDTextBox;
	
	@FindBy(name = "selaccount")
	WebElement accountTypeDropDown;	
	
	@FindBy(name = "inideposit")
	WebElement initialdepositTextBox;	
	
	@FindBy(name = "button2")
	WebElement submitbutton;
	
	@FindBy(xpath = "//table[@id=\"account\"] //p[@class='heading3']")
	WebElement accountCreatedSuccefullMessage;
	
	
	public void enterCustomerId()
	{
		customerIDTextBox.sendKeys("77758");
	}
	
	public void selectAccountType()
	{
		Select drop=new Select(accountTypeDropDown);		
		drop.selectByValue("Savings");
	}
	
	public void enterInitialdeposit()
	{
		initialdepositTextBox.sendKeys("10000");
	}
	
	public void clickOnSubmitButton()
	{
		submitbutton.click();
	}
	
	public boolean GetAccountCreatedSuccessfullMessage()
	{
		return accountCreatedSuccefullMessage.isDisplayed();
	}

}
