Feature: Home page tests

  Background: Navigate to Home Page
    Given I open url of homepage

  @ASB-3 @regression
  Scenario: Verify address and phone number are displayed under the main navigation bar on top of the page
    Then Verify "10090 Main Street Fairfax, VA, USA" is displayed
    Then Verify "703-831-3217" is displayed

  @ASB-6 @regression @smoke
  Scenario: Test header of the home page
    Then Verify header text is "Advance Systems - Home"

  @ASB-7 @regression @smoke
  Scenario Outline: Verify navigation bar on the top right is displayed and enable
    Then Verify "<topNavBtn>" is displayed
    Then Verify "<topNavBtn>" is enable
    Examples:
      | topNavBtn   |
      | Get Support |
      | Job Career  |
      | Feedback    |
      | English     |
      | Spanish     |
      | French      |

  @ASB-8 @regression @smoke
  Scenario Outline: Verify Join Now is displayed and enable
    Then Verify "<joinNow>" is displayed
    Then Verify "<joinNow>" is enable
    Then Verify destination window as url as "<url>"
    Examples:
      | joinNow  | url                                                               |
      | Join Now | https://tla-batch-6.github.io/advance-systems-test-b6/joinUs.html |

  @ASB-9 @regression @smoke
  Scenario Outline: Verify second navigation bar on the top right is displayed and enable.
    Then verify "<navBar2>" is displayed when scroll down
    Then Verify "<navBar2>" navigate to window as url as "<url>"
    Examples:
      | navBar2    | url                                                                 |
      | Home       | https://tla-batch-6.github.io/advance-systems-test-b6/index.html    |
      | About Us   | https://tla-batch-6.github.io/advance-systems-test-b6/about.html    |
      | Services   | https://tla-batch-6.github.io/advance-systems-test-b6/services.html |
      | Clients    | https://tla-batch-6.github.io/advance-systems-test-b6/clients.html  |
      | Join Us    | https://tla-batch-6.github.io/advance-systems-test-b6/joinUs.html   |
      | Contact Us | https://tla-batch-6.github.io/advance-systems-test-b6/contact.html  |

  @ASB-10 @regression @smoke
  Scenario Outline: Verify social media is displayed and enable
    Then Verify "<socialMediaTop>" icon is displayed
    And Verify "<socialMediaTop>" direct to window as url as "<url>"
    Examples:
      | socialMediaTop       | url                       |
      | https://facebook.com | https://www.facebook.com/ |
      | https://twitter.com  | https://twitter.com/      |
      | https://google.com   | https://www.google.com/   |
      | https://linkedin.com | https://www.linkedin.com/ |

  @ASB-11 @regression
  Scenario Outline: Verify these section is displayed
    Then Verify "<fiveBox>" is displayed
    Examples:
      | fiveBox                       |
      | Leadership Development        |
      | Capability Building           |
      | Rewards & Benefits            |
      | Employee & Employer Relations |
      | Excellent Customer Service    |

  @ASB-14 @regression
  Scenario Outline: Verify footer contact info is displayed
    Then Verify "<contactInfo>" is displayed
    Examples:
      | contactInfo                         |
      | Address: 10090 Main St, Fairfax, VA |
      | Phone: +1 703-831-3217              |
      | Email: Info@advancesystems.us       |
      | Mon to Sat: 9.00 am to 5:00 pm      |

  @ASB-16 @regression @smoke
  Scenario Outline:  Social media buttons displayed in the footer section
    Then Verify "<socialMediaBtn>" is displayed
    And Verify "<socialMediaBtn>" link to window as url as "<url>"
    Examples:
      | socialMediaBtn       | url                       |
      | https://facebook.com | https://www.facebook.com/ |
      | https://twitter.com  | https://twitter.com/      |
      | https://skype.com    | https://www.skype.com/en/ |
      | https://linkedin.com | https://www.linkedin.com/ |

  @ASB-4 @ASB-4A @regression @smoke
  Scenario Outline: Test dynamic content in Parallax section
    Then Verify the content in the Parallax will be dynamically changed every "<sec>" seconds
    Examples:
      | sec |
      | 10  |
      | 12  |

  @ASB-4 @ASB-4B @regression @smoke
  Scenario Outline: Test Read More buttons will take user to "Services" Page
    When I wait for a header "<header>" to be presented
    And I click a LinkText "<link>"
    Then Verify that the button will take user to "<page>" Page
    Examples:
      | header                                  | link         | page     |
      | A bright career is - waiting for you... | Read More    | Services |
      | Think Big. - Achieve Bigger.            | Read More(2) | Services |

  @ASB-15 @regression @smoke
  Scenario:Test Footer quick links displayed and work as expected
    When I scroll down to the footer of the homepage
    Then Verify the following links that will contain its title
      | Home           | Advance Systems - Home |
      | About Us       | About Us               |
      | Services       | Services               |
      | Clients        | Clients                |
      | Contact Us     | Contact Us             |


  @ASB-13 @regression
  Scenario: Test the list of company names displayed in 1 row
    When I scroll down to the footer of the homepage
    Then Verify that the list of the following company names display in one row
      | SOLVE   | 1.png |
      | Forbes  | 2.png |
      | Infra   | 3.png |
      | perlinX | 4.png |
      | Alstom  | 5.png |
      | Hasting | 6.png |


  @ASB-20 @regression
  Scenario: Verify specific headers and text are displayed as expected
    Then Verify "Welcome to Advance Systems LLC." is displayed
    Then Verify "Our Mission is simple, deliver very honest recruitment services to every customer." is displayed
    Then Verify text is displayed under the above headers.