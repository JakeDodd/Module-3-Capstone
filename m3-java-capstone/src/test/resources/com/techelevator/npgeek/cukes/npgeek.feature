Feature: Fill the Survey Form

	Scenario: Complete Daily Survey
	Given I have a Survey Input Page
	When I choose my favorite national park
	And I choose my state
	And I enter my email address
	And I choose my activity level
	And I submit the Survey Form
	Then I get a Survey Results page with a list of peoples favorite national parks