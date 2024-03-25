Feature: Count total payment on cartPage at demoblaze.com

  @web_testing
  Scenario: Check total payment on cart
    Given homepage is displayed
    When click "Nexus 6" on homepage
    And "Nexus 6" detailspage is displayed
    When click add to cart button
    And alert will display with text "Product added"
    And click OK on alert to continue
    When click add to cart button
    And alert will display with text "Product added"
    And click OK on alert to continue
    When click "Cart" on navbar
    Then "Cart" page is displayed
    Then total payment on cartpage is equal with cart detail displayed