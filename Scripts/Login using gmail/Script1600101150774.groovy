import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import Helper as Helper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Helper act = new Helper()
int login_id = act.getIndexKeyTestData('testData', dataId)

WebUI.click(findTestObject('homePage/loginButton'),FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('Object Repository/loginPage/signUpTitle'), 0)

def loginTitle = act.getTransalationData('loginDaftarPageTitle')
title = WebUI.getText(findTestObject('Object Repository/loginPage/signUpTitle'))
assert title == loginTitle : "The expected title is "+loginTitle

WebUI.click(findTestObject('Object Repository/loginPage/loginGoogleButton'),FailureHandling.STOP_ON_FAILURE)

def appPermissionName = WebUI.getText(findTestObject('Object Repository/loginPage/google/appNameInLoginPage'))
if (!(appPermissionName.contains('tiket.com'))) {
	KeywordUtil.markFailedAndStop('The Application that ask permission is not Tiket.com !')
}

loginTitle = WebUI.getWindowTitle()
if (!(loginTitle.contains('Google'))) {
	KeywordUtil.markFailedAndStop('The Socmed is not Google !')
}

String username = act.getData('username', login_id)
WebUI.setText(findTestObject('Object Repository/loginPage/google/emailField'), username)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/loginPage/google/nextButton'),FailureHandling.STOP_ON_FAILURE)

def emailIdentifier = WebUI.getText(findTestObject('Object Repository/loginPage/google/emailIdentifier'))
assert emailIdentifier == username.toLowerCase() : "The expected email is "+username

def password = act.getData('password', login_id)
WebUI.setText(findTestObject('Object Repository/loginPage/google/passwordField'), password)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/loginPage/google/nextButton'),FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/homePage/accountLabel'), 0)
