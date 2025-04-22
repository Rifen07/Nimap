
Feature: Feature to test Signup functionality
  I want to use this template for my feature file

  Scenario Outline: Check Signup functionality with Valid and Invalid Details
    Given Browser is open and Login page is open
    When User enters <Email> and <Password>
    And User clicks on Submit button
    And User Quits Browser

 
    Examples: 
      | Email  | Password |
      | rifengonsalvesbusiness@gmail.com |     Rifen07* |
      | rifengonsalvesbusiness@gmail.com |     !@% |
