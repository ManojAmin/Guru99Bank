package com.Guru99Bank.tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "src\\test\\resources\\features\\addNewCustomer.feature",
		glue = {"classpath:com.Guru99Bank.modules"},
		plugin = { "pretty", "html:target/cucumber-reports.html",
				"json:target/cucumber-reports/report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome =false,
		dryRun=false
		//tags="@Smoke"
)
public class Guru99BankRunner {

}
