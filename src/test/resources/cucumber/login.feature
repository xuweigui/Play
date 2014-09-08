Feature: Different type of users redirected to different home page.
  A normal user should log in to the user detail page, while a manager
  should log in to user list page.

  Scenario: normal user
    Given a normal user
    When login
    Then should show user detail page