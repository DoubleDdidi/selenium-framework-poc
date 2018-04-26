Feature: Access to the first sport story news in a website
  As Developer team
  I want to select to the first sport story news
  So that I can verify the users reach to that story's page

  Scenario Outline: Select the fist sport story
    Given I navigate to the 'bbc' website
    When I go to the <sport_type> section
    And I select the first news story
    Then I should see the first story page

    Examples:
      | sport_type |
      | football   |
      | tennis     |

