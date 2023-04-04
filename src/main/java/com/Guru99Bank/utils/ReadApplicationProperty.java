package com.Guru99Bank.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ReadApplicationProperty {

	private Properties pro;
	private FileInputStream file;
	public static Logger log = Logger.getLogger("Guru99Bank");

	public ReadApplicationProperty() {
		PropertyConfigurator.configure("Log4j.properties");
		try {
			file=new FileInputStream("C:\\Automation\\Guru99Bank\\src\\test\\resources\\application.properties");
			pro=new Properties();
			pro.load(file);
		} catch (IOException e) 
		{			
			log.error(e);		
		}	
	}
	
	public String getUrl()
	{
		return pro.getProperty("url");
	}
	
	public String getUserName()
	{
		return pro.getProperty("user");
	}
	
	public String getPassword()
	{
		return pro.getProperty("password");
	}
}
