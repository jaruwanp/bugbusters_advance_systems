Feature: Division Page Test

  Background: I navigate to Service page to get each Division page
    Given I open url of homepage
    And I click button "Services"

  @ASB-36 @regression
  Scenario Outline: Verify each Division page displays a section with our address and phone number
    When I click button "<division>"
    Then verify address and phone number are displayed
    Examples:
      | division               |
      | Finance                |
      | Information Technology |
      | Healthcare             |
      | Government Projects    |
      | Others                 |