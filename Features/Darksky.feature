Feature:  darksky whether page testing (darksky.net - whether forecasting website https://darksky.net/forecast/28.627,77.2154/us12/en )

#1
  Scenario: Verify Current Temperature should be equal to Temperature from Daily Timeline
    Given I am on Darksky Home Page "Dark Sky - Sansad Marg, New Delhi, Delhi"
    Then I verify current temp is equal to Temperature from Daily Timeline