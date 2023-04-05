package com.Guru99Bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Guru99Bank.utils.ReadApplicationProperty;

public class LoginPage extends ParentPageObject{
	
	@FindBy(name = "uid")
	WebElement userIdTextBox;
	
	@FindBy(name = "password")
	WebElement passwordTextBox;

	@FindBy(name = "btnLogin")
	WebElement LoginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);	
	}
	
	public void enterUserNameAndPassword(String userName,String password)
	{

		log.debug("user name: "+userName+ " Password :"+password );
		userIdTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
	}
	
	public HomePage clickOnLogin()
	{
		LoginButton.click();
		return new HomePage(driver);
	}
}
