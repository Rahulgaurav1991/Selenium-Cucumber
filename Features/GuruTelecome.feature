Feature: User_abe to add Tariff in his account
 @Traffic
  Scenario: verify User able to add valid Tariff
    Given User is at "Guru99 Telecom" home page
    When  Add Tariff Plan to Customer should display at home Page
    Then User clicks on Add Tariff Plan to Customer
    Then user navigate to "Guru99 Add Tariff Plan to Customer"
    And User enter Customer id as "910691" and click on submit button
    Then it should navigate to traffic selection page
    And user able to verify "500" at Monthly Rental column and able to select Select Tariff Plans checkbox and click_on add traffic_plan to customer
    Then Verify the "Congratulation Tariff Plan assigned" is displayed



