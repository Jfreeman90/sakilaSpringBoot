Feature: Updating an actors first or last name
  Records may be saved incorrectly or a person has changed name or got married and needs their details updating.

  Scenario: update an actors first name
    Given the actors original name is James Bean
    When I change the first name to Harry
    Then I should be get Harry Bean from the first and last name getter

  Scenario: update an actors second name
    Given the actors original name is Richard Crane
    When I change the second name to Reid
    Then I should be get Richard Reid from the first and last name getter