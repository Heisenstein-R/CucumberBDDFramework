Feature: Data Driven testing Using the DataTables

Scenario: Adding deals on FreeCRM using DataTables

Given user is on the Pre-login Page of FreeCRM
When User user uses creds to login into the web app
     | dharmaraj.k3011@gmail.com | Iamrajuk@1234 |
And User will be on the HomePage of FreeCRM
And User clicks on the Deals nad create button
Then User adds the details in the fields and saves it
|testdeal|Cogni|bottle|78304882|2534|887|
And User verifies it and closes the browser