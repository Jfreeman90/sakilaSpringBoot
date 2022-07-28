Feature: Getting and setting Actor first name and last name
  Records must be getting and setting the correct actor name

  Scenario: Name is correct
    Given the actor name is James Bean
    When I create a new actor called James Bean
    Then I should be get James bean from the getter


