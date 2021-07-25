@LoginFeature
Feature: Login Feature
  Description: This feature will be used to login to SawagLabs application

  @PositiveLogin @Sanity
  Scenario Outline: Verify that when user enters correct user name and password they should be able to login successfully
    Given User has opened the SawagLabs applications
    When User enters username "<UserName>"
    And User enters correct password "<Password>"
    And User clicks on Login button
    Then User should be landed on the Products Page

    Examples: 
      | UserName      | Password     |
      | standard_user | secret_sauce |
  
  @NegativeLogin
  Scenario Outline: Verify the error message when we give incorrect username and password
    Given User has opened the SawagLabs applications
    When User enters username "<UserName>"
    And User enters correct password "<Password>"
    And User clicks on Login button
    Then User Should be Getting the "<Error>"

    Examples: 
      | UserName      | Password      | Error                                                                     |
      | standard_user | secret_sauce1 | Epic sadface: Username and password do not match any user in this service |
