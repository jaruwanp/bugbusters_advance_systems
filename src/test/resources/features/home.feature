Feature: Home page tests

  Background: Navigate to Home Page
    Given I open url of homepage

#  @ASB-6 @regression @smoke
#  Scenario: Test header of the home page
#    Then Verify header text is "Advance Systems - Home"

#  @ASB-12A @regression
#  Scenario: Verify the testimonials section is displayed as expected
#    When I scroll down to Testimonials Section
#    Then Verify "Words from our Clients" is displayed
#    And Verify clients' picture and actual testimonial different from others is displayed
#    And Verify clients' locations are displayed as a state
#
#  @SB-12B @smoke @regression
#  Scenario: Verify buttons in the testimonials section are enable as expected
#    When I scroll down to Testimonials Section
#    Then Verify "prevBtn" is enable
#    And Verify "nextBtn" is enable


#  @ASB-16 @regression
#  Scenario Outline:  Social media buttons displayed in the footer section
#    Then Verify "<socialMediaBtn>" is displayed
#    And Verify "<socialMediaBtn>" matches to related "<URL>"
#    Examples:
#      | socialMediaBtn       | URL                         |
#      | https://facebook.com | https://www.facebook.com/   |
#      | https://twitter.com  | https://twitter.com/        |
#      | https://skype.com    | https://www.skype.com/en/   |
#      | https://linkedin.com | https://www.linkedin.com/   |

  @ASB-18 @smoke @regression
  Scenario: Verify button in the bottom right corner of the page that would scroll the window to top content once clicked
    When I scroll down the page
    And I click button "upArrowBtn"
    Then Verify the window is scrolled up top content