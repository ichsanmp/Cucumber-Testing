Feature: Automation API Testing for get data from dummyapi.io

  @api_testing
  Scenario: to get all users data with input the api key
    Given prepare url for "GET_LIST_USERS"
    When hit api get users list data
    Then validation status code is equals 200
    Then validation response body get all list users data
    Then validation response json with JSONSchema "get_list_userSchema.json"

  @api_testing
  Scenario: create new user normal
    Given prepare url for "CREATE_NEW_USERS"
    When hit api post create new user
    Then validation status code is equals 200
    Then validation response body post create new user
    Then validation response json with JSONSchema "post_create_userSchema.json"

  @api_testing
  Scenario: update user normal
    Given prepare url for "CREATE_NEW_USERS"
    When hit api post create new user
    And validation status code is equals 200
    And validation response body post create new user
    When hit api update user
    And validation status code is equals 200

  @api_testing
  Scenario: delete user normal
    Given prepare url for "CREATE_NEW_USERS"
    When hit api post create new user
    And validation status code is equals 200
    And validation response body post create new user
    When hit api delete user
    Then validation status code is equals 200