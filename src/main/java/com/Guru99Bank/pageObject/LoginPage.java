package com.Guru99Bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Guru99Bank.utils.ReadApplicationProperty;

public class LoginPage extends ParentPageObject{

	private ReadApplicationProperty applicatioProperty;
	
	@FindBy(name = "uid")
	WebElement userIdTextBox;
	
	@FindBy(name = "password")
	WebElement passwordTextBox;

	@FindBy(name = "btnLogin")
	WebElement LoginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);	
		applicatioProperty=new ReadApplicationProperty();
	}
	
	public void enterUSerNamePassword()
	{
		String userName=applicatioProperty.getUserName();
		String password=applicatioProperty.getPassword();
		log.debug("user name: "+userName+ " Password :"+password );
		userIdTextBox.sendKeys(applicatioProperty.getUserName());
		passwordTextBox.sendKeys(applicatioProperty.getPassword());
	}
	
	public HomePage clickOnLogin()
	{
		LoginButton.click();
		return new HomePage(driver);
	}
}
