Feature: InPost API - Search Parcel Lockers

  Scenario: Verify all InPost points in Gdynia can be retrieved
    Given I fetch all points in "Gdynia"
    Then the response contains at least 1 point
    Then the response is saved to file with "Gdynia" in the name
    