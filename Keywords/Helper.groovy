import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

public class Helper {
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	def getIndexKeyTestData(String testDataName, String id){
		String key = 'testData_'+GlobalVariable.env;
		List<List<Object>> allData = findTestData(key).getAllData();
		int dataSize = allData.size();
		Boolean foundData = false;
		int index = 1;
		for(int i=0; i < dataSize && !foundData; i++) {
			List<Object> data = allData.get(i);
			if(data.get(0) == id) {
				foundData = true;
				index = i+1;
			}
		}
		return index;
	}

	@Keyword
	def getData(String columnName, int row){
		String data
		String key = 'testData_'+GlobalVariable.env;
		data = findTestData(key).getValue(columnName, row)
		return data
	}
	@Keyword
	def getTransalationData(String elementId){
		String dataTranslation
		String key = 'translationData_'+GlobalVariable.env;
		List<List<Object>> allData = findTestData(key).getAllData();
		int dataSize = allData.size();
		Boolean foundData = false;
		int index = 1;
		for(int i=0; i < dataSize && !foundData; i++) {
			List<Object> data = allData.get(i);
			if(data.get(0) == elementId) {
				foundData = true;
				index = i+1;
			}
		}

		dataTranslation = findTestData(key).getValue(GlobalVariable.language, index)
		return dataTranslation
	}
	
	def clickButton(TestObject elementData){
		WebElement element = WebUiCommonHelper.findWebElement(elementData, 7)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript('arguments[0].click()', element)
	}
	
}
