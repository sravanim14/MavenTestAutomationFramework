Feature: Create timer
  Scenario: User should be able to set a timer
    Given the clock app is open
    When the user goes to the Timer tab
    And sets a 10 second timer
    And clicks the play button
    And waits 10 seconds
    Then the user will be prompted to stop the timer

  Scenario: Stopwatch finishes early (negative)
    Given the clock app is open
    When the user goes to the Timer tab
    And sets a 10 second timer
    And clicks the play button
    And waits 5 seconds
    Then the user will be prompted to stop the timer