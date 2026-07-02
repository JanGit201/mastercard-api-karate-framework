# Mastercard API Test Automation Framework

This repository contains an enterprise-level API test automation framework built using the **Karate Framework** and **Java**. It is engineered to perform robust integration and component testing against Mastercard Send APIs, ensuring proper status codes, accurate data payloads, and reliable schema validation.

## 🚀 Tech Stack & Tools
* **Automation Framework:** Karate Framework (BDD Style)
* **Programming Languages:** Java (43.3%) / Gherkin (37.6%) / JavaScript (19.1%)
* **Build Automation:** Maven
* **Reporting:** Native Karate HTML Reports

---

## 🏗️ Project Structure
```text
mastercard-api-karate-framework
├── src
│   ├── main
│   │   └── java
│   │       └── utils
│   │           └── MastercardSigner.java # Handles dynamic OAuth 1.0a payload signing
│   └── test
│       ├── java                         # Java Runner classes for executing test suites
│       └── resources
│           └── features                 # Karate .feature files containing BDD scenarios
├── .gitignore                           # Excludes target builds, IDE metadata, and private keys
├── pom.xml                              # Project dependencies and Karate version configuration
└── README.md
```
## 📝 Sample Test Scenario

Below is an example demonstrating how the Mastercard Send API scenarios are structured using clean Gherkin syntax within the framework:

```gherkin
Feature: Mastercard Account Verification API

  Background:
    * url baseUrl
    * configure headers = read('classpath:utils/headers.js')

  Scenario: Verify valid account routing and status
    Given path '/accounts/verify'
    And request { account_number: '123456789', routing_number: '987654321' }
    When method post
    Then status 200
    And match response.status == 'APPROVED'
    And match response.transactionId == '#notnull'
---
