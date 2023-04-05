package com.Guru99Bank.modules;

import org.junit.Assert;

import com.Guru99Bank.pageObject.AddNewAccountPage;
import com.Guru99Bank.pageObject.HomePage;
import com.Guru99Bank.pageObject.LoginPage;
import com.Guru99Bank.utils.ReadApplicationProperty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewAccount extends DriverSetUp {

	private DriverSetUp driverSetUp;
	private LoginPage login;
	private HomePage home;
	private AddNewAccountPage addAccount;
	

	public AddNewAccount(DriverSetUp driverSetUp) {
		super();
		this.driverSetUp = driverSetUp;
		login=new LoginPage(driverSetUp.driver);
		
	}
	
	@Given("login to appplication and navigate to new account page")
	public void login_to_appplication_and_navigate_to_new_account_page() {
		login.enterUserNameAndPassword(applicatioProperty.getUserName(), applicatioProperty.getPassword());
		home=login.clickOnLogin();
		log.info("loged into application ");
		addAccount=home.clickOnNewAccountOption();
		log.info("navigated to new account creation page ");
	}
	@When("add required details to create new account")
	public void add_required_details_to_create_new_account() {
		
		addAccount.enterCustomerId();
		log.info("entered customer id");
		addAccount.selectAccountType();
		log.info("selected account type");
		addAccount.enterInitialdeposit();
		log.info("entered initial deposit");
		addAccount.clickOnSubmitButton();
		log.info("Submitted new account creation request");
	}
	@Then("submit the form and verify the account created")
	public void submit_the_form_and_verify_the_account_created() {
		
		Assert.assertTrue(addAccount.GetAccountCreatedSuccessfullMessage());
		log.info("Verified Account Creation Successfull Message");
	}
}
