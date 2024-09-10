Feature: Square
  Scenario: User should be able square a number
    Given the calculator is open
    When the user enters a number
    And clicks square
    Then the number should be squared