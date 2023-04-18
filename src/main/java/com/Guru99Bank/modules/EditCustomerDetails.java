package com.Guru99Bank.modules;

import org.junit.Assert;

import com.Guru99Bank.pageObject.EditCustomerPage;
import com.Guru99Bank.pageObject.HomePage;
import com.Guru99Bank.pageObject.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditCustomerDetails extends DriverSetUp{

	private DriverSetUp driverSetUp;
	private LoginPage login;
	private HomePage home;
	private EditCustomerPage editCustomer;
	String updatedAddress;

	public EditCustomerDetails(DriverSetUp driverSetUp) {
		super();
		this.driverSetUp = driverSetUp;
		login=new LoginPage(driverSetUp.driver);
	}
	
	@Given("login as manager and navigate to edit customer screen")
	public void login_as_manager_and_navigate_to_edit_customer_screen() {

		login.enterUserNameAndPassword(applicatioProperty.getUserName(), applicatioProperty.getPassword());
		log.info("User name entered");
		home=login.clickOnLogin();
		log.info("logged into the application");
		editCustomer=home.clickOnEditCustomerOption();
	}
	@When("edit customer details and submit")
	public void edit_customer_details_and_submit() {
		editCustomer.enterCustomerIdToEdit();
		log.info("customre id enterd");
		editCustomer.submitCustomerId();
		log.info("Submitted customer id to fetch customer details ");
		updatedAddress=editCustomer.enterUpdatedAddress();
		log.info("Address updated ");
		editCustomer.submitUpdatedDetails();
		log.info("Submitted updated details ");
		editCustomer.clickOnOkInAlert();
	}
	@Then("verify that customer details updated successfully")
	public void verify_that_customer_details_updated_successfully() {
		
		editCustomer.enterCustomerIdToEdit();
		log.info("customre id enterd again");
		editCustomer.submitCustomerId();
		log.info("Submitted customer id to fetch check details ");
		String addressDisplayed=editCustomer.getUpdatedAddress();
		Assert.assertEquals(updatedAddress, addressDisplayed);

	}
}
