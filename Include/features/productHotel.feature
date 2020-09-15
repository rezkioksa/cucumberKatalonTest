
@hotel
Feature: Hotel Transaction
As a user I want to
Create transaction with non-instant payment for xx guest and xx room and login using Facebook

  @hotelTransaction
  Scenario: Create transaction for hotel and login using facebook
    Given I am login using 'facebook' account using 'fb_data_1'
    And I choose 'hotel' to book
    And I fill 'Yogyakarta' as the destination city
    And I click the 'Object Repository/homePage/closeModal' button
    And I choose 2 room and 1 guest
    And I click the 'Object Repository/homePage/doneButton' button
    And I click the 'Object Repository/homePage/searchButton' button
    Then The hotel result will be shown
    Then I filter the hotel result based on the 'payAtHotel'
    Then I will see the filtered hotel result with 'payAtHotel'
    And I choose the hotel result number 1
    Then I move to tab 2
    And I book room number 1
    And I wait until 'Object Repository/resultPage/preBookingLoading' disappear
    And I choose my titel is 'Nona'
    And I fill the 'Object Repository/hotelDetailsPage/phoneNumberField' with data account 'phoneNumber'
    And I click the 'Object Repository/flightDetailsPage/toggleSameAsCustomer' button
    And I click the 'Object Repository/hotelDetailsPage/nextToPayment' button
    And I wait until 'Object Repository/resultPage/hotelbookingLoading' disappear
    Then I will land on the 'paymentMethodPage' page with element header 'Object Repository/paymentDetailsPage/pageTitle'
    And I click the 'Object Repository/paymentDetailsPage/atmPaymentButton' button
    Then I will able to see the 'Object Repository/paymentDetailsPage/totalPayment'
    Then I will able to see the 'Object Repository/paymentDetailsPage/routeAndOrderId'
    And I click the 'Object Repository/paymentDetailsPage/paymentNextButton' button
    Then I will land on the 'finishPaymentDetails' page with element header 'Object Repository/paymentDetailsPage/finishPaymentHeader'
    Then I will able to see the 'Object Repository/paymentDetailsPage/vaNumber'
    Then I will able to see the 'Object Repository/paymentDetailsPage/totalFinishPayment'
    Then I verify the 'Object Repository/paymentDetailsPage/totalFinishPayment' and 'Object Repository/paymentDetailsPage/totalFinishPayment1' is same