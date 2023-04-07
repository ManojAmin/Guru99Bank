Feature: Fund transfer from one account to another account

#@Smoke
Scenario: To verify that user can transfer fund from one account to another account

Given login to user account and navigate to fund transer screen
When enter required details to transfer fund and submit the request
Then verify fund transfer successfully