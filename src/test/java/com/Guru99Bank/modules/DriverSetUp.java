package com.Guru99Bank.modules;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetUp {

	public WebDriver driver;

	public static Logger log;

	public DriverSetUp() {
		log=Logger.getLogger("Guru99Bank");
		//PropertyConfigurator.configure("Log4j.properties");
	}
	
	
	
}
