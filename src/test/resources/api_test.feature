Feature: InPost API - Fetch Points in Kraków

  Scenario: Verify all InPost points in Kraków can be retrieved
    Given I fetch all points in "Kraków"
    Then the response contains at least 1 point
    Then the response is saved to file points-Krakow.json