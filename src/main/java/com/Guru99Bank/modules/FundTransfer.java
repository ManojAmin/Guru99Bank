package com.Guru99Bank.modules;

import org.junit.Assert;

import com.Guru99Bank.pageObject.FundTransferPage;
import com.Guru99Bank.pageObject.HomePage;
import com.Guru99Bank.pageObject.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FundTransfer extends DriverSetUp {

	private DriverSetUp driverSetUp;
	private LoginPage login;
	private HomePage home;
	private FundTransferPage fundTransfer;

	public FundTransfer(DriverSetUp driverSetUp) {
		super();
		this.driverSetUp = driverSetUp;
		login=new LoginPage(driverSetUp.driver);
	}
	
	@Given("login to user account and navigate to fund transer screen")
	public void login_to_user_account_and_navigate_to_fund_transer_screen() {
		login.enterUserNameAndPassword("77758", "1234!");
		home=login.clickOnLogin();
		log.info("Logged into user account to transfer fund");
		fundTransfer=home.clickOnFundTransferButton();
		log.info("navigated to fund transfer screen");
	}
	@When("enter required details to transfer fund and submit the request")
	public void enter_required_details_to_transfer_fund_and_submit_the_request() {
		fundTransfer.enterPayeerAccountNumber();
		fundTransfer.enterPayeeAccountNumber();
		fundTransfer.enterTransferAmount();
		fundTransfer.enterAmountTransferDescription();
		log.info("Entered all the required details");
		fundTransfer.clickOnSubmit();
		log.info("Submited fund transfer request");
	}
	@Then("verify fund transfer successfully")
	public void verify_fund_transfer_successfully() {

		Assert.assertTrue(fundTransfer.getFundTransferMessage());
		log.info("Verified fund transfer success message");
	}

	    
}
