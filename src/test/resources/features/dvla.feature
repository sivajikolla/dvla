Feature: Get the vehicle details

  Scenario Outline: Search for car details

    Given I navigated to the "https://www.gov.uk/get-vehicle-information-from-dvla"
    And I click the "Get Started" button
    And I am on the vehicle enquiry page
    When I enter the vehicle registration <number>
    And I click the continue button
    And I click the continue button on the confirmation page
    Then I should be able to see the following car details:
    |Make|
    |Color|

    Examples:
    |number|

