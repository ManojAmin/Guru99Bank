package com.Guru99Bank.modules;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.Guru99Bank.utils.ReadApplicationProperty;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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
	public void teardown(Scenario scenario) throws IOException {		
		
		String path=System.getProperty("user.dir")+"/test-output/screenshots/";
		if(scenario.isFailed())
		{
			TakesScreenshot ts = (TakesScreenshot) driveSetUp.driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		/*	File src = ts.getScreenshotAs(OutputType.FILE);
		    byte[] fileContent = FileUtils.readFileToByteArray(src); */
		    
			if((new File(path)).exists())
			{
				FileUtils.cleanDirectory(new File(path));
				scenario.attach(src, "image/png", scenario.getName());
			}
		}
		
		log.info("Close browser");
		//driveSetUp.driver.quit();
		
	}

}
