package com.Guru99Bank.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPageObject {

	protected WebDriver driver;
	public static Logger log;

	public ParentPageObject(WebDriver driver) {
		this.driver = driver;
		log=Logger.getLogger("Guru99Bank");
		PageFactory.initElements(driver, this);
	}
	
	
}
