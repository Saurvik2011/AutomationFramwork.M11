#Author Ramesh
Feature: Login To Vtiger Application
    
  Scenario: Login to Application with Valid Credentials
    Given I want to Launch the browser
    And Load the URL
    When Login Page is displayed enter the username and password
    And Click on login button
    Then Validate for Home Page
   