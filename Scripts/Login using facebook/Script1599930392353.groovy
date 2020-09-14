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

WebUI.click(findTestObject('Object Repository/loginPage/loginFacebookButton'),FailureHandling.STOP_ON_FAILURE)

def fb_emailLabel = act.getTransalationData('fb_emailLabel')
def fb_passwordLabel = act.getTransalationData('fb_passwordLabel')
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/loginPage/facebook/emailLabel')), fb_emailLabel, false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/loginPage/facebook/passwordLabel')), fb_passwordLabel, false)

def username = act.getData('username', login_id)
def password = act.getData('password', login_id)
WebUI.setText(findTestObject('Object Repository/loginPage/facebook/emailField'), username)
WebUI.setText(findTestObject('Object Repository/loginPage/facebook/passwordField'), password)

WebUI.click(findTestObject('Object Repository/loginPage/facebook/loginButton'),FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)
loginTitle = WebUI.getWindowTitle()
assert loginTitle == 'Log in with Facebook' : "The expected title is Log in with Facebook"

def appPermissionName = WebUI.getText(findTestObject('Object Repository/loginPage/facebook/appNameInLoginPage'))
if (!(appPermissionName.equals('Tiket.com Apps'))) {
	KeywordUtil.markFailedAndStop('The Application that ask permission is not Tiket.com !')
}

def firstName = act.getData('firstName', login_id)
def loginFirstName = WebUI.getText(findTestObject('Object Repository/loginPage/facebook/continueAsButton'))
if (!(loginFirstName.contains(firstName))) {
	KeywordUtil.markFailedAndStop('The user is not '+firstName)
}

WebUI.click(findTestObject('Object Repository/loginPage/facebook/continueAsButton'),FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/homePage/accountLabel'), 0)


