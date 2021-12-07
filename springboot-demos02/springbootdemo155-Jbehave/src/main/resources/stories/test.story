Meta:

Narrative:
As a user
I want to login into system and i will own my right

Scenario: system admin login
Given uid is v3admin@v3 and password is 123456
When i login
Then i have role manager


Scenario: company admin login
Given uid is chenshengli@zyqckjcd and password is 123456
When i login
Then i have role company_manager