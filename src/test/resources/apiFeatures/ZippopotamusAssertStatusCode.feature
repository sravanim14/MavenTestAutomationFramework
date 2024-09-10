Feature: Return OK status

  Scenario Outline: A valid API request should return an OK HTTP status code
    Given the user is requesting from <URL>
    When the user sends an API request
    Then the API should return a HTTP status code of "200"

    Examples:
      |URL                                 |
      |https://api.zippopotam.us/gb/wa12   |
