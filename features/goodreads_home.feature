Feature: Goodreads Home Page Scenarios

 	Background: Test Background
 	Given I do this
 	
 	@P0 @P1 @T1 @SP
  Scenario: Validate Remember Me Checkbox
    Given I am on Goodreads home page
    When I check the status of Remember Me checkbox
    Then I verify that Remember Me checkbox is checked
	
	@P2 @T2 @SP @T1
  Scenario: Validate Arts link
    Given I am on Goodreads home page
    When I click on 'Arts' link
    Then I verify that website navigates to 'Arts' page

	@P3
  Scenario: Validate Music link
    Given I am on Goodreads home page
    When I click on 'Music' link
    Then I verify that website navigates to 'Music' page
	
	@P2
  Scenario: Validate search function
    Given I am on Goodreads home page
    When I search by author 'Chetan Bhagat' in search field
    Then I verify that first author from search results is 'Chetan Bhagat'

	@P30
  Scenario: Validate wrong creds
    Given I am on Goodreads home page
    When I log in with wrong creds
      | Email         | Password |
      | aaa@gmail.com | password |
    Then I verify log in error msg
	
	@P5
  Scenario Outline: Validate Multiple Links
    Given I am on Goodreads home page
    When I click on '<link>'
    Then I verify that website navigates to '<url>'
    And I verify that new page title is '<title>'

    Examples: 
      | link     | url                                       | title          |
      | History  | https://www.goodreads.com/genres/history  | History Books  |
      | Poetry   | https://www.goodreads.com/genres/poetry   | Poetry Books   |
      | Business | https://www.goodreads.com/genres/business | Business Books |
      | Sports   | https://www.goodreads.com/genres/sports   | Sports Books   |
