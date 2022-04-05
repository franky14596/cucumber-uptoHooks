#Author: franky@flipkart.com
Feature: Television Validation

  Scenario: Hardcoded Values
    Given User launches Flipkart Application
    When User logins Flipkart
    When User searches Television
    And User clicks Telivision
    Then User validates Television Name

  Scenario: DataTableValuesbyList
    Given User launches Flipkart Application
    When User logins Flipkart
    When User searches Television by one dimensional List
      | Lg tv | Samsung tv | OnePlus tv | Mi tv |
    And User clicks Telivision
    Then User validates Television Name

  Scenario: DataTableValuesbyMap
    Given User launches Flipkart Application
    When User logins Flipkart
    When User searches Television by one dimensional Map
      | 1 | lg tv      |
      | 2 | samsung tv |
      | 3 | Mi tv      |
    And User clicks Telivision
    Then User validates Television Name
  @map
  Scenario Outline: 
    Given User launches Flipkart Application
    When User logins Flipkart
    When User searches Television "<TV>"
    And User clicks Telivision
    Then User validates Television Name

    Examples: 
      | TV         |
      | Mi tv      |
      | Samsung tv |
      | Oneplus tv |
