Feature: Create board
  Scenario: User should be able to go to create a new board from the dashboard page
    Given the user is on the dashboard page
    When the user clicks on the create board button
    And enters a name for the board
    And clicks the second create button
    Then a board should be created and the user should be taken to the board page