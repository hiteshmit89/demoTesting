@AdyenFeature
Feature: Verify As a user I am able to onboard a practice to adyen payment service

# Author : pankaj.kumar@practicenumbers.com
# Jira Task Id: https://practicebynumbers.atlassian.net/browse/PUA-12

  @EnableAdyenToggle
  Scenario: Verify user is able to enable toggle for adyen service
    Given The User is able to login
    And The user is able to select practice
    And   The user in on HomePage
    When The user is able to click on Profile icon
    Then  The user is able to click on settings
    Then The user is able to enable checkbox for adyen




  @OnboardAdyen
  Scenario: Verify user is able to onboard practice for adyen service
    Given The User is able to login
    And   The user in on HomePage
    And User is able to select Practice with practice name
    When The user is able to click on Profile icon
    Then  The user is able to click on settings
    Then The user is able to click on Connect to Adyen Button
    Then The user is able to see the Start Onboarding Modal
    And The user is able to enter Organisational details  
    And The user is able to enter Organisational address
    And The user is able to click on Same as org address checkbox
    And The user is able to enter phone number
    Then The user is able to click on submit button on the modal
    And The user is able to redirect to the adyen

#Test data to onboard the practice
      | Legal name*          | Tester123       | Street 1*    | 155 Raynor Inlet | Country      | US              |
      |                      |                 | Street 2     | sdh              | State        | Alaska          |
      | Organisation Type*   | Private Company | City*        | Bournemouth      | Phone number | +1-443-307-1473 |
      | Registration number* | M12345678       | Postal Code* | 69717            |              |                 |


