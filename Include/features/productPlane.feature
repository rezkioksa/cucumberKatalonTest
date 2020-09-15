
@flight
Feature: Flight Transaction
  As a user I want to
  Create transaction with Virtual Account for domestic round trip with xx transit and login with email
 
  @flightTransaction
  Scenario: Title of your scenario outline
    Given I am login using 'google' account using 'google_data_1'
    And I choose 'plane' to book
    And I fill the departure city with 'Jakarta'
    And I fill the destination city with 'Yogyakarta'
    #because the flight at the same day
    And I click the 'Object Repository/homePage/closeModal' button
    And I click the 'Object Repository/homePage/flightReturn' button
    And I click the 'Object Repository/homePage/searchButton' button
    And I click the 'Object Repository/resultPage/uderstandCoachMarkButton' button
    Then The result will be shown
    And I filter the result with '2' transit
    Then The result will be shown
    And I click the result number 1
    Then I will land on the 'oredererDetails' page with element header 'Object Repository/flightDetailsPage/headerPage'
    And I choose my titel is 'Nona'
    And I fill the 'Object Repository/flightDetailsPage/fullNameField' with data account 'fullName'
    And I fill the 'Object Repository/flightDetailsPage/emailField' with data account 'username'
    And I fill the 'Object Repository/flightDetailsPage/phoneNumberField' with data account 'phoneNumber'
    And I click the 'Object Repository/flightDetailsPage/toggleSameAsCustomer' button
    #And I choose nationality with 'Indonesia'
    And I click the 'Object Repository/flightDetailsPage/checklistTravelProtection' button
    And I click the 'Object Repository/flightDetailsPage/nextToPayment' button
    And I click the 'Object Repository/flightDetailsPage/yesNextButton' button
    Then I will land on the 'paymentMethodPage' page with element header 'Object Repository/paymentDetailsPage/pageTitle'
    And I click the 'Object Repository/paymentDetailsPage/mandiriVirtualAccountButton' button
    Then I will able to see the 'Object Repository/paymentDetailsPage/totalPayment'
    Then I will able to see the 'Object Repository/paymentDetailsPage/routeAndOrderId'
    And I click the 'Object Repository/paymentDetailsPage/paymentNextButton' button
    Then I will land on the 'finishPaymentDetails' page with element header 'Object Repository/paymentDetailsPage/finishPaymentHeader'
    Then I will able to see the 'Object Repository/paymentDetailsPage/bankMerchant'
    Then I will able to see the 'Object Repository/paymentDetailsPage/vaNumber'
    Then I will able to see the 'Object Repository/paymentDetailsPage/totalFinishPayment'
    Then I verify the 'Object Repository/paymentDetailsPage/totalFinishPayment' and 'Object Repository/paymentDetailsPage/totalFinishPayment1' is same 
    
