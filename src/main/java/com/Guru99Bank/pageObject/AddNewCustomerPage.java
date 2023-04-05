package com.Guru99Bank.pageObject;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.datatable.DataTable;

public class AddNewCustomerPage extends ParentPageObject{

	@FindBy(name = "name")
	WebElement customerNameTextBoc;
	
	@FindBy(xpath = "//input[@type='radio' and @value='m']")
	WebElement genderMaleRadioButton;
	
	@FindBy(xpath = "//input[@type='radio' and @value='f']")
	WebElement genderFemaleRadioButton;
	
	@FindBy(id = "dob")
	WebElement calenderIcon;
	
	@FindBy(name = "addr")
	WebElement addressTextField;
	
	@FindBy(name = "city")
	WebElement cityTestBox;
	
	@FindBy(name = "state")
	WebElement stateTestBox;
	
	@FindBy(name = "pinno")
	WebElement pinTestBox;
	
	@FindBy(name = "telephoneno")
	WebElement mobileNoTestBox;
	
	@FindBy(name = "emailid")
	WebElement emailTestBox;
	
	@FindBy(name = "password")
	WebElement passwordTestBox;
	
	@FindBy(name = "sub")
	WebElement SubmitButton;
	
	@FindBy(xpath = "//table[@id=\"customer\"] //p[@class='heading3']")
	WebElement registrationSuccefullMessage;
	
	public AddNewCustomerPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterNewCustomerDetails(DataTable data)
	{
		for (Map<Object, Object> m : data.asMaps(String.class, String.class)) {
			customerNameTextBoc.sendKeys((String) m.get("Name"));	
			WebElement gender=(((String) m.get("Gender")).equalsIgnoreCase("male"))?genderMaleRadioButton :genderFemaleRadioButton;
			gender.click();
			selectDate();
			addressTextField.sendKeys((String) m.get("Address"));
			cityTestBox.sendKeys((String) m.get("City"));
			stateTestBox.sendKeys((String) m.get("State"));
			pinTestBox.sendKeys((String) m.get("Pin"));
			mobileNoTestBox.sendKeys((String) m.get("Mobile"));
			emailTestBox.sendKeys((String) m.get("Email"));
			passwordTestBox.sendKeys((String) m.get("Password"));
		}
	}
	
	public void clickOnSubmit()
	{
		SubmitButton.click();
	}
	
	public void selectDate()
	{		
		calenderIcon.sendKeys("05");
		calenderIcon.sendKeys("06");
		calenderIcon.sendKeys("1995");		
	}
	
	public boolean GetRegistartionSuccessfullMessage()
	{
		return registrationSuccefullMessage.isDisplayed();
	}

}
