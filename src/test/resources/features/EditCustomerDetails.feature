Feature: Edit customer details

@Smoke
Scenario: Verify that manager can edit customer details

Given login as manager and navigate to edit customer screen
When edit customer details and submit
Then verify that customer details updated successfully