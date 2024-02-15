Feature: Free CRM Login Feature

#Scenario: Free CRM Login Test Scenario 

#Given User is on the Pre-Login Page
#When title of login page is FreeCRM
#Then User enters "dharmaraj.k3011@gmail.com" and User enters "Iamrajuk@1234"
#And User Clicks on Login
#And User is on HomePage 

Scenario Outline: Free CRM Login Test Scenario 

Given User is on the Pre-Login Page to login
When title of login page is FreeCRM
Then User enters <username> and User enters <password>
And User Clicks on Login
And User is on HomePage

Examples: 
      | username | password |
      | dharmaraj.k3011@gmail.com | Iamrajuk@1234 |
      | Raju | 1234gg |



Scenario: Create a new Contact on the Contact Page

Given User is on the HomePage 
When User clicks on the Contacts and Title is Contacts
Then User clicks on Create button
And user enters all the fields and clicks save
And Verifies the contact name which added
