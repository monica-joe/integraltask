@ValidateSubscriptionPackages @RegressionTest
Feature: User can Validate the Subscription Packages for each country

  Scenario: Select country and validate the type , price and currency
    When open the website and validate the default country is saudi arabia
    And check the plan types
    Then validate the Price and currency for each type in saudi
    And switch the country to Bahrain
    And check the plan types
    Then validate the Price and currency for each type in bahrain
    And switch the country to Kuwait
    And check the plan types
    Then validate the Price and currency for each type in kuwait

  Scenario: API call to add new device
    Given I make a post request to add new device
    Then validate the response
    And Validate id and createdAt should not be null