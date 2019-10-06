Feature: Ebay Home Page Scenario

  @P11
  Scenario: Validate ebay Search Navigation
    Given I am on Ebay home page
    When I click on search button
    Then I verify that home page is navigated to Search page