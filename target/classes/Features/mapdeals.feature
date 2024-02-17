Feature: Data Driven testing Using the DataTables

Scenario: Adding deals on FreeCRM using DataTables

Given user is on the Pre-login Page of FreeCRM
When User user uses creds to login into the web app
     |ID | password |
     | dharmaraj.k3011@gmail.com | Iamrajuk@1234 |
     
And User will be on the HomePage of FreeCRM
And User clicks on the Deals nad create button

Then User adds the details in the fields and saves it
|title|company|product|contact|amount|commission|
|testdeal|Cogni|bottle|78304882|2534|887|
|testdata2|cogni|charger|89824742|982474|884|
|testdata3|cogni|keyboard|87663929|87224|74|

And User verifies it and closes the browser