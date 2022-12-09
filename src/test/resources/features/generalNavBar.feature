Feature:
Background:
  Given I open url of homepage

#  @ASB-7 @regression
#  Scenario: Test nav buttons are displayed
#    Then Verify button "Get Support" is displayed
#    Then Verify button "Job Career" is displayed
#    Then Verify button "Feedback" is displayed
#    Then Verify button "English" is displayed
#    Then Verify button "Spanish" is displayed
#    Then Verify button "French" is displayed

    @ASB-7 @smoke @regression
      Scenario Outline: Test Nav Button are displayed with scenerio outline
      Then Verify button "<nav button>" is displayed
      Examples:
      |nav button|
      |Get Support|
      |Job Career |
      |Feedback   |
      |English    |
      |Spanish    |
      |French     |





