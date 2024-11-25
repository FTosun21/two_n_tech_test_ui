Feature: As a user, I should be able to fill form successfully

  @wip
  Scenario: The user completes the form and submits it successfully
    Given The user navigates to "2ntechhr_" url
    When The user fill form with valid details
    Then The user verifies that form submit massage is "Form Başarı ile gönderildi. Katıldığınız için teşekkür ederiz."