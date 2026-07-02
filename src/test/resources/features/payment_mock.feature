Feature: Mastercard Send API Mock Server Simulation

Scenario: pathMatches('/anything') && method == 'POST'
    * def response = { status: "SUCCESS", transactionId: "MOCK-KVN9832472", amount: "10.00", currency: "USD" }
    * def responseStatus = 200