Feature: As a class manager I want to create new class
  Background: The user have to sign in as Class Manager first
    Given The Login is Opened
    Then The User attempt to login with "anhlh2@topica.edu.vn" and "topica123" information

  Scenario: Create class with mandatory information
    Given The Open Class windows already opened
    When The User attempt to create a single room
    And The class manager try to fill out the valid value to all fields before attempt to create a class
    Then The class manager will se the just created class on open class list