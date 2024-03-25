Feature: Login on demoblaze.com

  @web_testing
  Scenario: login with blank username and password
    Given homepage is displayed
    When click "Log in" on navbar
    And content is displayed
    When click "Log in" button
    Then alert will display with text "Please fill out Username and Password."
    Then click OK on alert to continue

  @web_testing
  Scenario: signup with blank username and password
    Given homepage is displayed
    When click "Sign up" on navbar
    And content is displayed
    When click "Sign up" button
    Then alert will display with text "Please fill out Username and Password."
    Then click OK on alert to continue

  @web_testing
  Scenario: login with registered username and password
    Given homepage is displayed
    When click "Sign up" on navbar
    And content is displayed
    And input username at sign up form
    And input password at sign up form
    When click "Sign up" button
    And alert will display with text "Sign up successful."
    And click OK on alert to continue
    And "Home" page is displayed
    When click "Log in" on navbar
    And content is displayed
    And input username at log in form
    And input password at log in form
    When click "Log in" button
    Then registered username will displayed on navbar

  @web_testing
  Scenario: login with unregister username and password
    Given homepage is displayed
    When click "Log in" on navbar
    And content is displayed
    And input username as "testData" at sign up form
    And input password as "yourTestData" at sign up form
    When click "Log in" button
    And alert will display with text "User does not exist."
    And click OK on alert to continue