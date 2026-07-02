Feature: Mastercard Send API Testing

  Background:
    * def Signer = Java.type('utils.MastercardSigner')
    * def auth = Signer.getAuthHeader('https://sandbox.api.mastercard.com/send/payments', 'GET', '')

Scenario: Test Mastercard Send API
  Given url 'https://sandbox.api.mastercard.com/send/payments'
  And header Authorization = auth
  When method get
  Then status 400