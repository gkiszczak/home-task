Feature: InPost UI - Search Packages

  Scenario: Verify that status for parcel 520113014230722029585646 is delivered
    Given I open InPost tracking page
    When I enter tracking number 520113014230722029585646
    And I click search
    Then I should see tracking details with status Doreczona

  Scenario: Verify that status for parcel 520107010449991105638120 is delivered
    Given I open InPost tracking page
    When I enter tracking number 520107010449991105638120
    And I click search
    Then I should see tracking details with status Wydana do doreczenia

  Scenario: Verify that status for parcel 523000016696115042036670 is delivered
    Given I open InPost tracking page
    When I enter tracking number 523000016696115042036670
    And I click search
    Then I should see tracking details with status Etykieta anulowana

  Scenario: Verify that status for parcel 520000011395200025754311 is delivered
    Given I open InPost tracking page
    When I enter tracking number 520000011395200025754311
    And I click search
    Then I should see tracking details with status Doreczona
