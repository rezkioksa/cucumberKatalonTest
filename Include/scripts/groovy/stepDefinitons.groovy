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



class stepDefinitons {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
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

	@And("I fill '(.*)' as the destination city")
	def I_fill_the_destination_city(String city) {
		println city
		//		println dataKey
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






	@When("I check for the (\\d+) in step")
	def I_check_for_the_value_in_step(int value) {
		println value
	}

	@Then("I verify the (.*) in step")
	def I_verify_the_status_in_step(String status) {
		println status
	}
}