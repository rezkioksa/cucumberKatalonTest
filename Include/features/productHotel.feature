#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario outline
    Given I am login using "facebook" account using "data_1"
    And I choose 'hotel' to book
    #And I choose book "lala"
    #And I choose "plane" to book
    #And I fill "Yogyakarta" as the destination city
    #And I choose check in date "30/10/2020"
    #And I choose check out date "30/11/2020"
    #And I choose the 2 guest and 2 rooms
    #And I submit the search
    #Then The search results will be displayed
    #And I filter the result based on the "Total Harga"
    #Then The search results price will be displayed in "Total Harga"
    
    
