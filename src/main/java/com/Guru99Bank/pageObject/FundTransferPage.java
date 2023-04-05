package com.Guru99Bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundTransferPage extends ParentPageObject {

	@FindBy(name = "payersaccount1")
	WebElement payerAccountNoTextBox;
	
	@FindBy(name = "payeeaccount")
	WebElement payeeAccountNoTextBox;
	
	@FindBy(name = "ammount")
	WebElement amountTextBox;
	
	@FindBy(name = "desc")
	WebElement descriptionTextBox;
	
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	
	@FindBy(xpath = "//p[contains(text(),'Fund Transafer Details for Account No')]")
	WebElement fundTransferMessage;
	
	
	
	public FundTransferPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterPayeerAccountNumber()
	{
		payerAccountNoTextBox.sendKeys("120509");
	}
	
	public void enterPayeeAccountNumber()
	{
		payeeAccountNoTextBox.sendKeys("120510");
	}
	
	public void enterTransferAmount()
	{
		amountTextBox.sendKeys("500");
	}
	
	public void enterAmountTransferDescription()
	{
		descriptionTextBox.sendKeys("Personal");
	}
	public void clickOnSubmit()
	{
		submitButton.click();
	}

	public boolean getFundTransferMessage()
	{
		return fundTransferMessage.isDisplayed();
	}
	
}
