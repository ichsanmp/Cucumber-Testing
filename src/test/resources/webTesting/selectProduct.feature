Feature: Select product at demoblaze.com

  @web_testing
  Scenario Outline: Select product on homepage
    Given homepage is displayed
    When click "<product>" on homepage
    Then "<product>" detailspage is displayed

    Examples:
      | product           |
      | Samsung galaxy s6 |
      | Sony vaio i5      |
      | Iphone 6 32gb     |

  @web_testing
  Scenario Outline: Select product sort by categories on homepage
    Given homepage is displayed
    When click "<categories>" for sorting the product
    And product is sort by categories
    When click "<product>" on homepage
    Then "<product>" detailspage is displayed

    Examples:
      | categories | product          |
      | Phones     | Nexus 6          |
      | Laptops    | Dell i7 8gb      |
      | Monitors   | Apple monitor 24 |