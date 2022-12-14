Feature: Homepage tests

  Background:
    Given I open url of homepage

  @ASB-6 @regression
  Scenario: Verify header of current project
    Then Verify title of the homepage should be "Advance Systems - Home"



  @ASB-7C @regression @smoke
  Scenario Outline: Test languange Nav Button are displayed with scenerio outline
#      When I click top menu "<nav top botton>"
    Then Verify button "<nav top botton>" is display
    Then Verify button "<nav top botton>" is enable
    Examples:
      |nav top botton|
      |Get Support   |
      |Job Career    |
      |Feedback      |
      |English      |
      |Spanish      |
      |French       |


