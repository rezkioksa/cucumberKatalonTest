import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import cucumber.api.java.Before
import cucumber.api.java.After



class Hooks {
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
//		println testCaseContext.getTestCaseId()
//		println testCaseContext.getTestCaseVariables()
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.url)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(5)
		def title = WebUI.getWindowTitle()
		if (!title.contains('tiket.com')) {
			KeywordUtil.markFailedAndStop('The title of page is not correct!')
		}
		
	}
	
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
//		println testCaseContext.getTestCaseId()
//		println testCaseContext.getTestCaseStatus()
//		WebUI.closeBrowser()
	}
	
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
	}
	
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
	}
	
	
//	------------------ Cucumber ------------------
	@Before
	def GotoUrl() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.url)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(5)
		def title = WebUI.getWindowTitle()
		if (!title.contains('tiket.com')) {
			KeywordUtil.markFailedAndStop('The title of page is not correct!')
		}
	}
	
	@After
	def tearDown() {
		WebUI.closeBrowser()
	}
	
}