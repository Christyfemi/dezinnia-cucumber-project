Feature: dezlearn scenarios
	
	@P300
  Scenario: Validate order form functionality
    Given I am on dezlean home page
    And I navigate to Explicit Wait Exapmle page
    When I submit the order with follwoing details
      | Mayur | Deshmukh | mmm@dezlearn.com |
    Then I verify that the order number is generated
    