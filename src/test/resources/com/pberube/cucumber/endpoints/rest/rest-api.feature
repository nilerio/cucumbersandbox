Feature: Testing a REST API

 Scenario: A customer can ask online if a game is available
    Given The store has 5 copies in stock of "EldenRing"
    When  A customer ask i have "EldenRing"
    Then  The game is in stock