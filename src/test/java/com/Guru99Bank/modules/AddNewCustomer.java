package com.Guru99Bank.modules;

import org.junit.Assert;

import com.Guru99Bank.pageObject.AddNewCustomerPage;
import com.Guru99Bank.pageObject.HomePage;
import com.Guru99Bank.pageObject.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewCustomer extends DriverSetUp {

	private DriverSetUp driverSetup;
	private LoginPage login;
	private HomePage home;
	private AddNewCustomerPage addCustomer;
	
	
	public AddNewCustomer(DriverSetUp driverSetup) {
		super();
		this.driverSetup = driverSetup;		
		login=new LoginPage(driverSetup.driver);
	}
	
	@Given("loginto application and navigate to new customer page")
	public void loginto_application_and_navigate_to_new_customer_page() {
		login.enterUSerNamePassword();
		log.info("User name entered");
		home=login.clickOnLogin();
		log.info("logged into the application");
		addCustomer=home.clickOnNewCustoomerOption();
	}
	
	@When("enter customer details and submit")
	public void enter_customer_details_and_submit(DataTable data) {			
		addCustomer.enterNewCustomerDetails(data);
		addCustomer.clickOnSubmit();
	}
	
	@Then("verify new customer created")
	public void verify_new_customer_created() {

		Assert.assertTrue(addCustomer.GetRegistartionSuccessfullMessage());
	}
}
