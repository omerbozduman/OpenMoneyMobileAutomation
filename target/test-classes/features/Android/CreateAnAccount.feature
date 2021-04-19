@createanaccount
Feature: OpenMoney - Create An Account

  As an user I want to create an account an OpenMoney app.

  Background:
    Given I open the open money app
    Then I click the create an account button

  Scenario: verify create an account

    Then I fill the sign up form with valid credentials
    And I click the terms and conditions confirm button
    Then I click the continue button



  @negative
  Scenario Outline: verify create an account <type>
    And I fill the sign up form with "<username>" "<password>" "<terms and conditions>"
    Then I verify the "<error message>"

    Examples:
      | type                                  | username                | password    | terms and conditions | error message                                  |
      | email address isblank                 |                         | 123456?Odf  | select               | Please enter an email address.                 |
      | email address is without @            | open.com                | 123456?Odf  | select               | The Email field is not a valid e-mail address. |
      | email address is without .com         | open@money              | 123456?Odf  | select               | The Email field is not a valid e-mail address. |
      | password is blank                     | open44@money44.com      |             | select               | Please enter a password.                       |
      | password is less than 8 digit         | open44@money44.com      | 1234Om?     | select               | verify continue button is not clickable        |
      | password is without special character | open44@money44.com      | 1234Om1234  | select               | verify continue button is not clickable        |
      | password is without Uppercase         | open44@money44.com      | 1234m?1234  | select               | verify continue button is not clickable        |
      | password is without lowercase         | open44@money44.com      | 1234O?1234  | select               | verify continue button is not clickable        |
      | with exist user credentials           | omer.bozduman@yahoo.com | 130179?Ob   | select               | The user already exists.                       |
      | terms and conditions is not selected  | open44@money44.com      | 1234Om?1234 | not select           | verify continue button is not clickable      |











  #  Then I create a secret code
  #  And I confirm secret code
  #  Then I select the stay in the loop options
  #  Then I click the continue button
  #  And I enter my first name
  #  And I enter my last name
  #  And I enter my birth date
  #  Then I click continue button
  #  And I verify "Connect your main account" is displayed
