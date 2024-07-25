Feature: To Validate MakeMyTrip Search Page for Flight Functionality
	Scenario: To Verify  MakeMyTrip Search Page of Flight with Valid Values
		Given I Launch The Browser and Enter URL
		When I Close the Popup 
		And I Click the From Location
		And I Select the From Location
		And I Click the To Location
		And I Select the To Location
		And I Select Depature Date
		And I Select Treavellers and Class
		And I Select Fare Type as Regular
		Then I Search with Valid Values.
		
	Scenario: To Verify  MakeMyTrip Search Page of Flight with Valid Values Student
		Given I Launch The Browser and Enter URL
		When I Close the Popup 
		And I Click the From Location
		And I Select the From Location
		And I Click the To Location
		And I Select the To Location
		And I Select Depature Date
		And I Select Treavellers and Class
		And I Select Fare Type as Student
		Then I Search with Valid Values.
		
	