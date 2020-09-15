import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import Helper as Helper
import org.openqa.selenium.JavascriptExecutor
//import org.openqa.selenium.WebDriver
//import org.openqa.selenium.WebElement
//import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
//import com.kms.katalon.core.webui.driver.DriverFactory


class stepDefinitons {
	Helper act = new Helper()
	WebDriver driver = DriverFactory.getWebDriver()



	@Given("I am login using '(.*)' account using '(.*)'")
	def I_login_by_socMed_account(String socMedType, String dataKey) {
		println socMedType
		println dataKey
		if(socMedType.toLowerCase().equals('facebook')){
			WebUI.callTestCase(findTestCase('Login using facebook'), ['dataId':dataKey], FailureHandling.STOP_ON_FAILURE)
		}
		else if (socMedType.toLowerCase().equals('google')){
			WebUI.callTestCase(findTestCase('Login using gmail'), ['dataId':dataKey], FailureHandling.STOP_ON_FAILURE)
		}
		else{
			KeywordUtil.markFailedAndStop('The title of page is not correct!')
		}
	}



	@And("I choose '(.*)' to book")
	def I_choose_target_to_book(String key) {
		key = key.toLowerCase()
		println key
		if(key.equals("hotel")){
			println("The value is hotel");
			WebUI.click(findTestObject('Object Repository/homePage/hotelButton'),FailureHandling.STOP_ON_FAILURE)
		}
		else if (key.equals('pesawat') || key.equals('plane')){
			println("The value is pesawat");
			WebUI.click(findTestObject('Object Repository/homePage/pesawatButton'),FailureHandling.STOP_ON_FAILURE)
		}
		else{
			println("Another Value...")
		}
	}

	@And("I fill the departure city with '(.*)'")
	def I_fill_the_departure_city(String city) {
		println city
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/homePage/pesawatFrom'), 0)
		WebUI.setText(findTestObject('Object Repository/homePage/pesawatFrom'), city)
		WebUI.delay(3)

		//		WebDriver driver = DriverFactory.getWebDriver()
		//		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/xpathTextElement',[('text') : city+', Indonesia']), 7)
		//		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		//		executor.executeScript('arguments[0].click()', element)

		act.clickButton(findTestObject('Object Repository/xpathTextElement',[('text') : city+', Indonesia']))

	}

	@And("I fill the destination city with '(.*)'")
	def I_fill_the_arrival_city(String city) {
		println city
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/homePage/pesawatTo'), 0)
		WebUI.setText(findTestObject('Object Repository/homePage/pesawatTo'), city)
		WebUI.delay(3)

		//		WebDriver driver = DriverFactory.getWebDriver()
		//		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/xpathTextElement',[('text') : city+', Indonesia']), 7)
		//		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		//		executor.executeScript('arguments[0].click()', element)

		act.clickButton(findTestObject('Object Repository/xpathTextElement',[('text') : city+', Indonesia']))
	}

	@And("I click the '(.*)' button")
	def I_click_the_button(String elementKey) {
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject(elementKey), 0)
		act.clickButton(findTestObject(elementKey))
	}

	@Then("The result will be shown")
	def The_result_will_be_shown() {
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/resultPage/chooseButton',[('number') : '1']), 0)
	}

	@Then("The hotel result will be shown")
	def The_hotel_result_will_be_shown() {
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/resultPage/hotelResult',[('number') : '1']), 0)
	}

	@And("I filter the result with '(.*)' transit")
	def I_choose_transit(String value) {
		println value
		WebUI.delay(3)
		def data = value.equals('langsung') || value.equals('direct') ? 'direct' :(value.equals('1') ? 'stop': (value.equals('2') ? 'stops': ''))
		println 'data = '+data
		WebUI.scrollToElement(findTestObject('Object Repository/resultPage/transitFilter',[('key') : data]), 0)

		//		WebDriver driver = DriverFactory.getWebDriver()
		//		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/resultPage/transitFilter',[('key') : data]), 7)
		//		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		//		executor.executeScript('arguments[0].click()', element)
		//
		act.clickButton(findTestObject('Object Repository/resultPage/transitFilter',[('key') : data]))
	}

	@And("I click the result number (\\d+)")
	def I_click_the_result_number(int data) {
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/resultPage/chooseButton',[('number') : data.toString()]), 0)
		//		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/resultPage/chooseButton',[('number') : data.toString()]), 7)
		//		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		//		executor.executeScript('arguments[0].click()', element)

		act.clickButton(findTestObject('Object Repository/resultPage/chooseButton',[('number') : data.toString()]))
	}

	@Then("I will land on the '(.*)' page with element header '(.*)'")
	def I_will_land_on_the_page(String data, String element) {
		WebUI.delay(3)
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/resultPage/loading'), 0)
		def translationData = act.getTransalationData(data)
		WebUI.verifyElementText(findTestObject(element), translationData)
	}

	@And("I choose my titel is '(.*)'")
	def I_choose_the_titel(String data) {
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/flightDetailsPage/titel'),FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/xpathTextElement',[('text') : data]),FailureHandling.STOP_ON_FAILURE)
	}

	@And("I fill the '(.*)' with data account '(.*)'")
	def I_fill_the_field_with_text(String element, String data) {
		WebUI.delay(3)
		String dataText = act.getData(data, GlobalVariable.dataIndex)
		WebUI.setText(findTestObject(element), dataText)
	}

	@And("I choose nationality with '(.*)'")
	def I_choose_natinality(String data) {
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/flightDetailsPage/nationality'), 0)
		WebUI.click(findTestObject('Object Repository/flightDetailsPage/nationality'),FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(findTestObject('Object Repository/flightDetailsPage/searchNationality'), data)
		WebUI.click(findTestObject('Object Repository/xpathTextElement',[('text') : data]),FailureHandling.STOP_ON_FAILURE)
	}

	@And("I will able to see the '(.*)'")
	def I_will_able_to_see(String element) {
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject(element), 0)
		//		def translationData = act.getTransalationData(data)
		//		WebUI.verifyElementText(findTestObject(element), translationData)
	}

	@Then("I verify the '(.*)' and '(.*)' is same")
	def I_verify_the_text_of_elements(String element1, String element2) {
		WebUI.delay(3)
		String data1 = WebUI.getText(findTestObject(element1))
		String data2 = WebUI.getText(findTestObject(element2))
		WebUI.verifyMatch(data1, data2, false)
	}

	@And("I fill '(.*)' as the destination city")
	def I_fil_the_destination(String city) {
		println city
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/homePage/hotelDestination'), 0)
		WebUI.setText(findTestObject('Object Repository/homePage/hotelDestination'), city)
		WebUI.delay(3)

		//		WebDriver driver = DriverFactory.getWebDriver()
		//		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/xpathTextElement',[('text') : city]), 7)
		//		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		//		executor.executeScript('arguments[0].click()', element)
		act.clickButton(findTestObject('Object Repository/xpathTextElement',[('text') : city]))

	}

	@And("I choose (\\d+) room and (\\d+) guest")
	def I_choose_the_number_of_room_and_guest(int room, int guest) {
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/homePage/hotelGuestRoomButton'), 0)
		WebUI.click(findTestObject('Object Repository/homePage/hotelGuestRoomButton'),FailureHandling.STOP_ON_FAILURE)
		def  i=1
		def j=1

		//		For Guest
		while(i<=guest-1){
			//		(1..guest-1).each {
//			println "Loop number = ${it}"
			WebUI.click(findTestObject('Object Repository/homePage/plusButton',[('number') : '1']),FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(1)
			i++
		}

		//		For Room
		while(j<=room-1){
			//		(1..room-1).each {
//			println "Loop Number = ${it}"
			WebUI.click(findTestObject('Object Repository/homePage/plusButton',[('number') : '2']),FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(1)
			j++
		}
	}


	@Then("I filter the hotel result based on the '(.*)'")
	def I_filter_the_result(String key) {
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/resultPage/otherFilter'),FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(2)
		def data = act.getTransalationData(key)
		WebUI.click(findTestObject('Object Repository/resultPage/hotel_filterChoice', [('text') : data]),FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/resultPage/hotelApplyFilter'),FailureHandling.STOP_ON_FAILURE)
	}


	@Then("I will see the filtered hotel result with '(.*)'")
	def I_will_see_filtered_result(String key) {
		WebUI.delay(3)
		def filterData = act.getTransalationData(key)
		WebUI.verifyElementText(findTestObject('Object Repository/resultPage/payAtHotel_result'), filterData)
	}

	@And("I choose the hotel result number (\\d+)")
	def I_click_the_hotel_result_number(int data) {
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/resultPage/hotelResult',[('number') : data.toString()]), 0)
		act.clickButton(findTestObject('Object Repository/resultPage/hotelResult',[('number') : data.toString()]))
		//		WebUI.click(findTestObject('Object Repository/resultPage/hotelResult',[('number') : data.toString()]),FailureHandling.STOP_ON_FAILURE)
	}

	@Then("I move to tab (\\d+)")
	def I_move_to_another_tab(int index) {
		WebUI.switchToWindowIndex(1)
	}

	@And("I book room number (\\d+)")
	def I_book_room_number(int data) {
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/resultPage/bookRoomButton',[('number') : data.toString()]), 0)
		act.clickButton(findTestObject('Object Repository/resultPage/bookRoomButton',[('number') : data.toString()]))
		//		WebUI.click(findTestObject('Object Repository/resultPage/bookRoomButton',[('number') : data.toString()]),FailureHandling.STOP_ON_FAILURE)
	}

	@And("I wait until '(.*)' disappear")
	def I_wait_until_element_disappear(String element) {
		WebUI.delay(3)
		WebUI.waitForElementNotPresent(findTestObject(element), 0)
	}





}