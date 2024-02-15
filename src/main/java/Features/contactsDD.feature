Feature: Data Driven testing in the Contacts Using Examples

Scenario Outline: Contacts examples

Given User on the HomePage by using the <username> and <password> as creds
When User clicks on the Contacts button
Then User clicks on Create button and proceeds
Then user enters all the fields like <firstname>, <lastname>, <company>, <email> and clicks save
Then Verifies the contact name <firstname> and <lastname> which added

Examples: 

       | username | password | firstname | lastname | company | email |
       | dharmaraj.k3011@gmail.com | Iamrajuk@1234 | Raaj | KK | ddfh | 12haid@mail.com |
       | dharmaraj.k3011@gmail.com | Iamrajuk@1234 | chitti | bb | gen | kjaad7@mail.com |

