Feature: Mastercard Send API Simulation

Background:
  * url baseUrl
  * def Signer = Java.type('utils.MastercardSigner')

Scenario: Send Payment Handshake
  * def authHeader = Signer.getAuthHeader(baseUrl, 'POST', '{"amount": "10.00"}')
  * header Authorization = authHeader
  * request { amount: '10.00', currency: 'USD' }
  
  # Removing * path completely and using post method directly. 
  # If httpbin still requires an exact match, we call 'method post' on the base URL.
  * method post
  * status 200