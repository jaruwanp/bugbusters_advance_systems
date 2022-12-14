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
<<<<<<< HEAD
=======
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
>>>>>>> 07d6b10b061a106b1763b2b25c346605330e2c57
      |nav top botton|
      |Get Support   |
      |Job Career    |
      |Feedback      |
      |English      |
      |Spanish      |
      |French       |
<<<<<<< HEAD
=======





>>>>>>> 07d6b10b061a106b1763b2b25c346605330e2c57


