Feature: Add new customer

#@Smoke
Scenario: Verify user can add new customer

Given loginto application and navigate to new customer page
When enter customer details and submit
|Name	|Gender	|Address	|City	|State		|Mobile		|Pin	|Email			|Password	|
|Manoj	|male	|Katapadi	|Udupi	|Karnataka	|98980678123	|574105	|manoj01@gmail.com|1234		|
Then verify new customer created
