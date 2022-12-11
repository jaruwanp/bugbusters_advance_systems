Feature: Homepage tests

  Background:
    Given I open url of homepage

  @ASB-6 @regression
  Scenario: Verify header of current project
    Then Verify title of the homepage should be "Advance Systems - Home"





  @ASB-7a  @regression
  Scenario Outline: Test Nav Button are displayed with scenerio outline
#      When I click menu "<nav button>"
    Then I Verify button "<nav button>" is enabled
    Then Verify button "<nav button>" is displayed
    Examples:
      |nav button|
      |Get Support|
      |Job Career |
      |Feedback   |


  @ASB-7b  @regression
  Scenario Outline: Test languange Nav Button are displayed with scenerio outline
    When I click button English
    Then Verify button "<nav lang button>" is enabled
    Then Verify button "<nav lang button>" is displayed
    Examples:
      |nav lang button|
      |English    |
      |Spanish    |
      |French     |

    @ASB-7C @regression
      Scenario Outline: Test languange Nav Button are displayed with scenerio outline
      When I click top menu "<nav menu botton>"
      Then Verify button "<nav top botton >" is display
      Then Verify button "<nav top botton>" is enable
      Examples:
      |nav top botton|
      |Get Support   |
      |Job Career    |
      |Feedback      |
      |English      |
      |Spanish      |
      |French       |







