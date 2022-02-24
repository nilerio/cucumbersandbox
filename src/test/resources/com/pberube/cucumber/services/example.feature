Feature:
  Scenario: A customer buys a game i have in stock
    Given I use the inventory service
    And I have 5 copies in stock of "EldenRing"
    When A customer buys "EldenRing"
    Then I still have 4 "EldenRing"

  Scenario: A customer buys a game i dont have in stock
    Given I use the inventory service
    And I have 4 copies in stock of "JustDance"
    When A customer buys "EldenRing"
    Then I still have 0 "EldenRing"