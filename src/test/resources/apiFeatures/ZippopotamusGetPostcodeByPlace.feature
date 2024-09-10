Feature: Fetch postcode

  Scenario Outline: User should be able to retrieve the postcode of a place by its name
    Given the user is requesting from <URL>
    When the user sends an API request
    Then the API should return details for <placeName>
    And the API should return the postcode <postCode>

    Examples:
    |URL                                           |placeName  |postCode |
    |https://api.zippopotam.us/gb/eng/earlestown   |Earlestown |WA12     |
    |https://api.zippopotam.us/gb/eng/chorley      |Chorley    |PR7      |