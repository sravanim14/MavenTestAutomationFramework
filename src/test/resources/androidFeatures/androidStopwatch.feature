Feature: Create stopwatch
  Scenario: User should be able to time laps with a stopwatch
    Given the clock app is open
    When the user goes to the Stopwatch tab
    And clicks the play button
    And presses lap "1" times
    Then the timer will be on lap "2"

