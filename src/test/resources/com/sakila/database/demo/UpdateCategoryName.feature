Feature: Updating an category name
  Records may be saved incorrectly or a category needs renaming for clarity

  Scenario: update a categories name
    Given the original category is XXX
    When I change the category to Adult
    Then I should be get Adult from the category getter