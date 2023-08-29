Feature: Assignment

Scenario: Get mobile plan
  Given I go to mobile menu
  And I go to Mobile Rate Plans menu
  When I select Rs600 plan
  And I click select plan button
  Then I select Foreigner at Identity Verification screen
  And I enter passport number as "C9342929"
  And I click continue button
  And I enter mobile number as "0768425364"
  When I click continue button again
  Then I should be able to see OTP Verification popup
