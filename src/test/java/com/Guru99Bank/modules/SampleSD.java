package com.Guru99Bank.modules;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleSD extends  DriverSetUp{
	
	private DriverSetUp driverSetup;
	
	public SampleSD(DriverSetUp driverSetup) {
		super();
		this.driverSetup = driverSetup;
		
	}

	@Given("launch browser")
	public void launch_browser() {
		driverSetup.driver.get("https://www.demo.guru99.com/V4/index.php");
		log.info("In given");
	}
	@When("test condtion")
	public void test_condtion() {
		log.info("In when");
	}
	@Then("condtion")
	public void condtion() {
		log.info("In then");
	}
	
}
