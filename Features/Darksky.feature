
@Rahul
Feature:  darksky whether page testing (darksky.net - whether forecasting website https://darksky.net/forecast/28.627,77.2154/us12/en )


  Scenario: Verify Current Temperature should be equal to Temperature from Daily Timeline
    Given I am on Darksky Home Page "Dark Sky - Sansad Marg, New Delhi, Delhi"
    Then I verify current temp is equal to Temperature from Daily Timeline


  Scenario: Verify timeline is displayed in correct format
    Given I am on Darksky Home Page "Dark Sky - Sansad Marg, New Delhi, Delhi"
    Then I verify timeline is displayed with two hours incremented


@Rahul
  Scenario: Verify individual day temp timeline
    Given I am on Darksky Home Page "Dark Sky - Sansad Marg, New Delhi, Delhi"
    Then I verify today's lowest and highest temp is displayed correctly