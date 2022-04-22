Feature: Payment rest api testing

Scenario: Testing valid GET endpoint
Given url'https://localhost:8017/payment/1'
When method GET
Then status 200
And match response == expected

