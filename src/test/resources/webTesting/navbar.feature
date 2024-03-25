Feature: Select menu on navbar at demoblaze.com

  @web_testing
  Scenario Outline: selecting menu on navbar and page is displayed
    Given homepage is displayed
    When click "<menu>" on navbar
    Then "<menu>" page is displayed

    Examples:
      | menu |
      | Home |
      | Cart |

  Scenario Outline: selecting menu on navbar and content is displayed
    Given homepage is displayed
    When click "<menu>" on navbar
    Then content is displayed

    Examples:
      | menu     |
      | About us |
      | Contact  |
      | Log in   |
      | Sign up  |