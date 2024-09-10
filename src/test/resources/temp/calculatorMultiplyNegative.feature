Feature: Multiply
  Scenario: User should be able multiply two numbers together (negative)
    Given the calculator is open
    When the user multiplies two numbers
    And clicks equals
    Then the two numbers should be multiplied correctly (negative)