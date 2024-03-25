Feature: Create order at demoblaze.com

  @web_testing
  Scenario: create order and fill the form order corectly when product is added to cart
    Given homepage is displayed
    When click "Nexus 6" on homepage
    And "Nexus 6" detailspage is displayed
    When click add to cart button
    And alert will display with text "Product added"
    And click OK on alert to continue
    When click "Cart" on navbar
    And "Cart" page is displayed
    When click place order button
    And content is displayed
    And fill "Name" text box with "tester1"
    And fill "Country" text box with "tester1"
    And fill "City" text box with "tester1"
    And fill "Card" text box with "1"
    And fill "Month" text box with "December"
    And fill "Year" text box with "1997"
    When click "Purchase" button
    Then notify is displayed with text "Thank you for your purchase!"
    Then click OK button

  @web_testing
  Scenario: create order and blank the form order when product is added to cart
    Given homepage is displayed
    When click "Nexus 6" on homepage
    And "Nexus 6" detailspage is displayed
    When click add to cart button
    And alert will display with text "Product added"
    And click OK on alert to continue
    When click "Cart" on navbar
    And "Cart" page is displayed
    When click place order button
    And content is displayed
    When click "Purchase" button
    Then alert will display with text "Please fill out Name and Creditcard."
    Then click OK on alert to continue

  @web_testing
  Scenario: create order when cart is empty
    Given homepage is displayed
    When click "Cart" on navbar
    And "Cart" page is displayed
    When click place order button
    Then notify will display with text "Add product to cart to create order."