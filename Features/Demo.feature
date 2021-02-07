Feature: Ordering a Product

  Scenario: For ordering a product form cart
    Given user is at Product page and clicks on Product and selects colors an quantity
    When user add to cart
    Then user can see same product name with same price with Quantity and Total Price should be same as per Qunatity
    And clicks on checkout button
    Then  checkout page must be displayed  and user complete the Address details ar per zip code