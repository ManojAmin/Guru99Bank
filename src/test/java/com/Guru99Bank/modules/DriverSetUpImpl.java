package com.Guru99Bank.modules;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.Guru99Bank.utils.ReadApplicationProperty;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetUpImpl extends DriverSetUp {

	private DriverSetUp driveSetUp;
	private ReadApplicationProperty applicatioProperty;

	public DriverSetUpImpl(DriverSetUp driveSetUp) {
		super();
		this.driveSetUp = driveSetUp;
		applicatioProperty=new ReadApplicationProperty();
		
	}

	@Before
	public void setUp()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driveSetUp.driver=new ChromeDriver(options);		
		driveSetUp.driver.manage().window().maximize();
		driveSetUp.driver.get(applicatioProperty.getUrl());
		driveSetUp.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@After
	public void teardown() {
		log.info("Close browser");
		//driveSetUp.driver.quit();
	}
}
