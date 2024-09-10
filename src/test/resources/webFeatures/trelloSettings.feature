Feature: Open Settings
  Scenario: User should be able to go to account settings using the account dropdown menu
    Given the user is on the dashboard page
    When the user clicks on the account dropdown button
    And clicks settings
    Then the user should be taken to the settings page