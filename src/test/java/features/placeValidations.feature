Feature: Validating Place APIs
  @AddPlace

  Scenario Outline: Verify if Place is being successfully added using addPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When User Calls "AddPlaceAPI" with Post http request
    Then The API call is successful with Status Code 200
    And "status" is in response body is "OK"

    Examples:
    | name | language | address |
    | AAhouse | English | World cross center |
    | AnotherHouse | French | Das Address |
    | Test House 2 | British English | Unique Address |




