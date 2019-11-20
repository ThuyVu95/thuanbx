Feature: As a class manager I want to create new class
  Background: The user have to sign in as Class Manager first
    Given Login Xtool
    Then Go to in class VCRX
  Scenario: Create class with mandatory information
    Given Page VCRX already
    When Raise hand
    Then Display icon raise hand on listuser
