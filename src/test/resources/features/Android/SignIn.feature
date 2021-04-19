@signin
Feature: OpenMoney - Sign in

  As an user I want to create an account from OpenMoney App

  Scenario: verify Sign in Module
    Given I open the open money app
    Then I click the Sign in button
    And I verify "Welcome" is displayed
    Then I fill sign in form with valid credentials
    And I click the continue button for to sign in
    Then I create a secret code
    And I confirm secret code
    And I click the continue button
    And I click the continue button
    Then I verify "Connect your main account" is displayed