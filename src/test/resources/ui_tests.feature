Feature: InPost UI - Search Packages

  Scenario: Verify that status for parcel 520113014230722029585646 is delivered
    Given I open InPost tracking page
    When I enter tracking number "520113014230722029585646"
    And I click search
    Then I should see tracking details with status "Delivered"

