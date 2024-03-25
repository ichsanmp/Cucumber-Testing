Feature: Add product to cart at demoblaze.com

  @web_testing
  Scenario Outline: add all product to cart sort by categories
    Given homepage is displayed
    When click "<categories>" for sorting the product
    And product is sort by categories
    When click "<product>" on homepage
    And "<product>" detailspage is displayed
    When click add to cart button
    And alert will display with text "Product added"
    And click OK on alert to continue
    When click "Cart" on navbar
    Then "<product>" is displayed on cart page

    Examples:
      | categories | product        |
      | Phones     | Sony xperia z5 |
      | Laptops    | Dell i7 8gb    |
      | Monitors   | ASUS Full HD   |