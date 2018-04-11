package utility;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import locators.CommonLocators;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Reporting.ExecutionLog;
import Reporting.ExtentManager;
import Reporting.ExtentTestManager;
import excelDataBinding.Excel_Reader;
import excelDataBinding.TestData;


public class DriverHelper extends TestListenerAdapter implements TestData,CommonLocators{


	public WebDriver driver;
	/**
	 * className : It is used which excel file need to be accessed for Test Data
	 * e.g: AM_TestData.xlsx for AM related test classes
	 * RI_TestData.xlsx for RI related test classes
	 */
	public static ExtentReports report;

	public String className;
	public Class<?> classObject;
	public static Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\TestData.xlsx");
	public static Excel_Reader scriptConfig = new Excel_Reader(System.getProperty("user.dir") + "\\Config\\ScriptConfig.xlsx");
	public String ClientData = PropertyReader.readApplicationFile("Environment");
	public String SuiteType = PropertyReader.readApplicationFile("SuiteType");


	public String downloadPath = "C:\\Downloads";
	public String ClientName   =  PropertyReader.readApplicationFile("Environment");
	public String URL          =  scriptConfig.getCellData("Login", ClientData, 2);
	public String Browser      =  PropertyReader.readApplicationFile("Browser");

	public static Excel_Reader Current_xls ;
	public static List<String> ActualDropdownValues = new ArrayList<String>();
	public static List<String> ExpectedDropdownValues = new ArrayList<String>();
	public static int ImageNameForFramesFailures = 0;
	public static int ScreenshotFailureNumber = 0;
		
	public static Date date = new Date();
	public static SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
	public String formattedDate = sdf.format(date);
	public String testCaseName ;
	public Hashtable<String, String> Tabs_AutomationStatus = new Hashtable<String, String>();
	public String Tab_AutomationStatus ;
	public static String TC_Status;

	@BeforeSuite(alwaysRun=true)
	public void startLog(){
		if(SuiteType.contains("Smoke")) {
			report = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\AdvanceReport\\RB_Smoke_" + ClientName + "_" +getDateStamp().replace("/", "") + ".html");
		} else if(SuiteType.contains("Regression")) {
			report = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\AdvanceReport\\RB_Regression_" + ClientName + "_" +getDateStamp().replace("/", "") + ".html",true);
		} else {
			report = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\AdvanceReport\\" + className + "_" + ClientName + "_" +getDateStamp().replace("/", "") + ".html", true);
		}

		ExecutionLog.Log("********************Started Executiong the Test Suite at " + getTimeStamp()  +"******************");
	}

	public DriverHelper() {

	}
	
	public static String color(String color, String text) {
		String coloredtext  = "<span style=\"color:"+ color + ";\">"+text+"</span>";
		return coloredtext;
	}
  
	@BeforeMethod(alwaysRun=true)	
    public void getBrowser(Method method) throws Exception {
		TC_Status = "Passed";
		Runtime.getRuntime().exec("cmd /c Taskkill /IM chrome.exe /F");
//		Runtime.getRuntime().exec("cmd /c Taskkill /IM firefox.exe /F");
		Runtime.getRuntime().exec("cmd /c Taskkill /IM iexplore.exe /F");
		sleepTime(2);


		ExtentTestManager.startTest(method.getName());
		
		Current_xls	= new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\TestData.xlsx");
		

		if (Browser.equalsIgnoreCase("firefox")) {
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("default");
			ffprofile.setEnableNativeEvents(false);
			ffprofile.setPreference("browser.download.folderList", 2);
			ffprofile.setPreference("browser.download.manager.showWhenStarting", false);
			ffprofile.setPreference("browser.download.dir", downloadPath);
			ffprofile.setPreference("browser.helperApps.neverAsk.openFile",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			ffprofile.setPreference("browser.helperApps.alwaysAsk.force", false);
			ffprofile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			ffprofile.setPreference("browser.download.manager.focusWhenStarting", false);
			ffprofile.setPreference("browser.download.manager.useWindow", false);
			ffprofile.setPreference("browser.download.manager.showAlertOnComplete", false);
			ffprofile.setPreference("browser.download.manager.closeWhenDone", false);
			driver = new FirefoxDriver(ffprofile);
			} else if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + System.getProperty("file.separator") +  "chromedriver.exe");
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadPath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
		} else if (Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + System.getProperty("file.separator") + "IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			//caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
			//caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability("unexpectedAlertBehaviour", "accept");
			caps.setCapability("ignoreProtectedModeSettings", true);
			caps.setCapability("enablePersistentHover", false);
			caps.setCapability("requireWindowFocus", true);
			caps.setCapability("disable-popup-blocking", true);
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("nativeEvents",false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			driver = new InternetExplorerDriver();
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// Initialization of global variables
		// read the URL from prop file if Client name is not passed through Jenkins
		try {
			if(!PropertyReader.readApplicationFile("URL").contains("env.URL")) {
				// get the url, user and pass from the properties file instead excel file As they are being passed from Jenkins
				URL =  PropertyReader.readApplicationFile("URL");
			} 

		} catch (Exception e) {
			// TODO: handle exception
		}

		ExecutionLog.Log("Environment: " + ClientName);
		ExecutionLog.Log("URL: " + URL);
		driver.navigate().to(URL);
		
		
		/*try {
			Assert.assertTrue(isElementPresent("RL_Logo_Img"));
		}catch (AssertionError e) {
			ExecutionLog.Log("Login Failure");
			getScreenShotOnCheckpointFailure("LoginFailed" + ScreenshotFailureNumber);
			ScreenshotFailureNumber++;
			Assert.assertTrue(false);
		}*/
	

	}	

	public String getTimeStamp()
	{
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();	
		String dateTime =  dateFormat.format(cal.getTime());
		return dateTime;
	}

	public void getScreenShotOnCheckpointFailure(String Methodname) throws IOException { 
		Methodname = Methodname.replace("*", "").replace(":", "").replace(":", "").replace("+", "").replace(" ", "");
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMyyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("MM-dd-yyyy h-mm-ss a");
		String formattedDate1 = sdf1.format(date);
		String formattedDate2 = sdf2.format(date);
		String formattedDate3 = sdf3.format(date);
		String fileSeperator = System.getProperty("file.separator");

		String folderName1= formattedDate1;
		String folderName2= formattedDate2;
		String imagePath1 = System.getProperty("user.dir")+"\\Screenshots\\"+ folderName1+fileSeperator;
		String imagePath2 = System.getProperty("user.dir")+"\\Screenshots\\"+ folderName1+fileSeperator+"\\"+folderName2+fileSeperator;
		String imagePath3 = System.getProperty("user.dir")+"\\test-output\\AdvanceReport\\Screenshots\\";

		String imageName=Methodname.replace("*", "")+"_CheckpointFailure_"+formattedDate3+".jpg";


		File file1 = new File(imagePath1);
		if (!file1.exists()) {
//			ExecutionLog.Log("File created " + file1);
			file1.mkdir();

			File file2 = new File(imagePath2);
			if (!file2.exists()) {
//				ExecutionLog.Log("File created " + file2);
				file2.mkdir();
			}
		}

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, new File(imagePath2+imageName)); 
		FileUtils.copyFile(scrFile, new File(imagePath3+imageName));
		ExecutionLog.Log("ScreenShot of CheckPoint Failure: " + imagePath2+imageName);
		ExtentTestManager.getTest().log(LogStatus.FAIL, Methodname + "'s Snapshot below: " + ExtentTestManager.getTest().addScreenCapture("./Screenshots/"+imageName));
		Reporter.log("<html><body><a href=\""+ imagePath2+imageName +"\"><img src=\"file:///" + imagePath2+imageName + "\" alt=\"\""+ "height='120' width='120'/></a> "+"<br></br></html></body>");

	} 

	public void clickOn(String Locator, String WebElementNameOfLocator) throws IOException {

		try {
			
				driver.findElement(ByLocator(Locator)).click();
				ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "'");
			
		}
		catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
			e.printStackTrace();
		}

	}

	public void clickOn(WebElement element, String WebElementName, Object... checkStatusFromExcel) throws IOException {

		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				element.click();
				ExecutionLog.Log("Clicked on the '" + WebElementName + "'");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			try {
				// Click the object if nothing is passed in the clickStatus
				element.click();
				ExecutionLog.Log("Clicked on the '" + WebElementName + "'");
			} catch (Exception e1) {
				ExecutionLog.Log("====Failed==== \"" + WebElementName + "\" field is not present'");
				getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
				e1.printStackTrace();
			}

		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementName + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
			e.printStackTrace();
		}

	}

	public void clickOnDisplayedElement(String Locator, String WebElementNameOfLocator, Object... checkStatusFromExcel) {
		List<WebElement> allElements = driver.findElements(ByLocator(Locator));
		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				for(WebElement elem : allElements){
					if(elem.isDisplayed()){
						elem.click();
						ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "'");
						break;
					}
				}

			}
		} catch (IndexOutOfBoundsException e) {
			// Click the object if nothing is passed in the clickStatus
			driver.findElement(ByLocator(Locator)).click();
			ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "'");
		}

	}

	public static By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("name=")) {
			result = By.name(locator.replace("name=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.partialLinkText(locator.replace("partialLink=", ""));
		}else {
			result = By.id(locator);
		}
		return result;
	}

	public void sendKeys(String Locator, String TestData, String WebElementNameOfLocator) throws Exception {

			try {
				Assert.assertTrue(isElementPresent(Locator));

				WebElement elem;
				try {
					elem = driver.findElement(ByLocator(Locator));
					elem.clear();
				} catch (Exception e) {

				}
				elem = driver.findElement(ByLocator(Locator));
				elem.sendKeys(TestData);
				ExecutionLog.Log("Entered \"" + TestData + "\" in field '" + WebElementNameOfLocator + "'");

			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;
			} catch (Exception e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;

			}

		}
	
	public void Clear(String Locator,String WebElementNameOfLocator) throws Exception {

		try {
			Assert.assertTrue(isElementPresent(Locator));

			WebElement elem;
			try {
				elem = driver.findElement(ByLocator(Locator));
				elem.clear();
			} catch (Exception e) {

			}
			

		} catch (AssertionError e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
			e.printStackTrace();;
		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
			e.printStackTrace();;

		}

	}

	public void sendKeys_WithoutClear(String Locator, String TestData, String WebElementNameOfLocator, String LabelNameFromExcel) throws Exception {

		if(!LabelNameFromExcel.contains("N/A")){
			try {
				Assert.assertTrue(isElementPresent(Locator));
				WebElement elem = driver.findElement(ByLocator(Locator));
				elem.sendKeys(TestData);
				ExecutionLog.Log("Entered \"" + TestData + "\" in field '" + WebElementNameOfLocator + "'");

			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;
			} catch (Exception e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;

			}

		}
	}

	public void clickUsingJSExecutor(String Locator, String WebElementNameOfLocator, Object... checkStatusFromExcel) throws IOException {
		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click(true)",driver.findElement(ByLocator(Locator)));
				ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "' using JS Executor");
			}
		} catch (IndexOutOfBoundsException e) {			
			try {
				// Click the object if nothing is passed in the clickStatus
				((JavascriptExecutor) driver).executeScript("arguments[0].click()",driver.findElement(ByLocator(Locator)));
				ExecutionLog.Log("Clicked on the '" + WebElementNameOfLocator + "' using JS Executor");
			} catch (Exception e1) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e1.printStackTrace();
			} 
		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
			e.printStackTrace();
		}

	}

	public void moveMouse(String Locator, String WebElementNameOfLocator)throws Exception{

		try {
				Actions act = new Actions(driver);
				WebElement elem = driver.findElement(ByLocator(Locator));
				act.moveToElement(elem).build().perform();
				ExecutionLog.Log("Moved Mouse over '" + WebElementNameOfLocator + "'");
			
		} catch (IndexOutOfBoundsException e) {			
			try {
				Actions act = new Actions(driver);
				WebElement elem = driver.findElement(ByLocator(Locator));
				act.moveToElement(elem).build().perform();
				ExecutionLog.Log("Moved Mouse over '" + WebElementNameOfLocator + "'");
			} catch (Exception e1) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e1.printStackTrace();
			} 
		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
			e.printStackTrace();
		}
	}

	public void doubleClick(String Locator, String WebElementNameOfLocator, Object... checkStatusFromExcel) throws Exception {


		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				Actions act = new Actions(driver);
				WebElement elem = driver.findElement(ByLocator(Locator));
				act.doubleClick(elem).build().perform();
				ExecutionLog.Log("Double clicked on '" + WebElementNameOfLocator + "'");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			try {
				Actions act = new Actions(driver);
				WebElement elem = driver.findElement(ByLocator(Locator));
				act.doubleClick(elem).build().perform();
				ExecutionLog.Log("Double clicked on '" + WebElementNameOfLocator + "'");
			} catch (Exception e2) {  
				// If the locator is not foundExecutionLog.Log("Could not find the locator: " + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;

			}

		} catch (Exception e) { // If the locator is not found
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
			e.printStackTrace();
		}

	}

	public void doubleClick(WebElement element, String WebElementName, Object... checkStatusFromExcel) throws IOException {

		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				Actions act = new Actions(driver);
				act.doubleClick(element).build().perform();
				ExecutionLog.Log("Double clicked on '" + WebElementName + "'");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			try {
				// Click the object if nothing is passed in the clickStatus
				Actions act = new Actions(driver);
				act.doubleClick(element).build().perform();
				ExecutionLog.Log("Double clicked on '" + WebElementName + "'");
			} catch (Exception e1) {
				ExecutionLog.Log("====Failed==== \"" + WebElementName + "\" field is not present'");
				getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
				e1.printStackTrace();
			}

		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementName + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementName.replace("*", ""));
			e.printStackTrace();
		}

	}

	public Boolean isElementPresent(String Locator) {
		boolean flag = false;
		List<WebElement> elemList = driver.findElements(ByLocator(Locator));
		if(elemList.size()>0) {
			flag = true;
		}
		return flag;

	}

	public void verifyElementPresent(String Locator, String NameOfLocator) throws Exception {
		
				try {
					Assert.assertTrue(isElementPresent(Locator));
					ExecutionLog.Log ("Verified that \"" + NameOfLocator + "\" is Present");
				} catch (AssertionError e) {
					ExecutionLog.Log("====Failed==== \""+NameOfLocator+"\"  does not exist.");
					getScreenShotOnCheckpointFailure(NameOfLocator);
					e.printStackTrace();
				}
			}

	public Boolean isElementDisplayed(String Locator, String ElementName) throws Exception {
		Boolean elemDisplayStatus = false;
			try {
				if(isElementPresent(Locator)) {

					try {
						Assert.assertTrue(driver.findElement(ByLocator(Locator)).isDisplayed());
						ExecutionLog.Log ("Verified that Expected value :["+ElementName+"] is displayed");
						elemDisplayStatus = true;

					} catch (AssertionError e) {
						ExecutionLog.Log("====Failed==== Expected value is:["+ElementName+"] is not displayed" );
						getScreenShotOnCheckpointFailure(ElementName);
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				ExecutionLog.Log("====Failed====\"" + ElementName + "\" is not Present");
				getScreenShotOnCheckpointFailure(ElementName);
				e.printStackTrace();
			}

			
		return elemDisplayStatus;
	}

	public void verifyElementDisplayed(String Locator, String ElementName) throws Exception {
		
			try {
				if(isElementPresent(Locator)) {

					try {
						Assert.assertTrue(driver.findElement(ByLocator(Locator)).isDisplayed());
						ExecutionLog.Log ("Verified that Expected value :["+ElementName+"] is displayed");

					} catch (AssertionError e) {
						ExecutionLog.Log("====Failed==== Expected value is:["+ElementName+"] is not displayed" );
						getScreenShotOnCheckpointFailure(ElementName);
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				ExecutionLog.Log("====Failed====\"" + ElementName + "\" is not Present");
				getScreenShotOnCheckpointFailure(ElementName);
				e.printStackTrace();
			}

		
	}

	public void verifyElementNotDisplayed(String Locator, String ElementName) throws Exception {
		
			try {
				try {
					Assert.assertFalse(driver.findElement(ByLocator(Locator)).isDisplayed());
					ExecutionLog.Log ("Verified that ["+ElementName+"] is not displayed");

				} catch (AssertionError e) {
					ExecutionLog.Log("====Failed==== ["+ElementName+"] is displayed" );
					getScreenShotOnCheckpointFailure(ElementName);
					e.printStackTrace();
				}
			} catch (Exception e) {
				ExecutionLog.Log("====Failed====\"" + ElementName + "\" is Present OR Locator Issue");
				getScreenShotOnCheckpointFailure(ElementName);
				e.printStackTrace();
			}

	}

	public void verifyFieldValueOfHeader(String Locator, String Expected , String WebElementNameOfLocator, String HeaderNameFromExcel) throws Exception {
		String ActualText = "";
		if(!HeaderNameFromExcel.contains("N/A")){
			if(Expected.length()==0){
				try {
					Assert.assertTrue(isElementPresent(Locator));
					ActualText = getText(Locator);
					Assert.assertTrue(ActualText.length()==0);
					ExecutionLog.Log("Verified that \"" + WebElementNameOfLocator + "\" is blank");
				} catch (AssertionError e) {
					ExecutionLog.Log("====Failed====\"Either Expected Value of '" + WebElementNameOfLocator + "' is not given OR '" + WebElementNameOfLocator + "'\" Element is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (Exception e) {
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else {

				try {
					Assert.assertTrue(isElementPresent(Locator));  // Will throw Assertion Error if failed
					ActualText = getText(Locator);// Will throw Exception if failed
					Assert.assertTrue(ActualText.contains(Expected)); // Will throw Assertion Error if failed
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");
				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + WebElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}


	}

	public void verifyFieldValueOfHeader(String Locator, String Expected, String WebElementNameOfLocator, String HeaderNameFromExcel, String attributeValue) throws Exception {
		String ActualText = "";
		if(!HeaderNameFromExcel.contains("N/A")){
			if(Expected.length()==0){
				try {
					Assert.assertTrue(isElementPresent(Locator));
					ActualText = getAttribute(Locator,attributeValue);
					if(ActualText.equals("<!---->")) {
						ActualText = "";
					}
					Assert.assertTrue(ActualText.length()==0);
					ExecutionLog.Log("Verified that \"" + WebElementNameOfLocator + "\" is blank");
				} catch (AssertionError e) {
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (Exception e) {
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else {
				try {
					Assert.assertTrue(isElementPresent(Locator));  // Will throw Assertion Error if failed
					ActualText = getAttribute(Locator,attributeValue).replace("amp;", "").replace("&gt;", "");// Will throw Exception if failed
					if(!Expected.equals("null") ) {
						Assert.assertTrue(ActualText.contains(Expected)); // Will throw Assertion Error if failed
						ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
						ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");

					}
					else if(Expected.equals("null") ) { // Is very useful for the verification of check boxes at deal agreement
						ActualText = ActualText + "";
						boolean conditionCheck =false;
						if(ActualText.equals("null")) {
							conditionCheck = true;
						}
						Assert.assertTrue(conditionCheck);
						ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
						ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");

					}

				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + WebElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}
	}

	public void verifyFieldValueOfHeader(WebElement elem, String Expected, String WebElementNameOfLocator, String HeaderNameFromExcel, String attributeValue) throws Exception {
		String ActualText = "";
		if(!HeaderNameFromExcel.contains("N/A")){
			if(Expected.length()==0){
				try {

					ActualText = elem.getAttribute(attributeValue);
					if(ActualText.equals("<!---->")) {
						ActualText = "";
					}
					Assert.assertTrue(ActualText.length()==0);
					ExecutionLog.Log("Verified that \"" + WebElementNameOfLocator + "\" is blank");
				} catch (AssertionError e) {
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (Exception e) {
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else {

				try {
					ActualText = elem.getAttribute(attributeValue);// Will throw Exception if failed
					if(!Expected.equals("null") ) {
						Assert.assertTrue(ActualText.contains(Expected)); // Will throw Assertion Error if failed
						ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
						ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");

					}
					else if(Expected.equals("null") ) { // Is very useful for the verification of check boxes at deal agreement
						ActualText = ActualText + "";
						boolean conditionCheck =false;
						if(ActualText.equals("null")) {
							conditionCheck = true;
						}
						Assert.assertTrue(conditionCheck);
						ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
						ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is matched with Actual value :["+ActualText+"]");

					}

				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + WebElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + WebElementNameOfLocator);
					ExecutionLog.Log("====Failed====\"" + WebElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}
	}

	public void verifyTextMatches(String locator, String webElementNameOfLocator, String expected, String attributeValue) throws Exception {
		String ActualText = "";
		if(!expected.contains("N/A")){
			if(expected.length()==0){
				try {
					Assert.assertTrue(isElementPresent(locator));
					ActualText = getAttribute(locator,attributeValue);
					if(ActualText.equals("<!---->")) {
						ActualText = "";
					}
					Assert.assertTrue(ActualText.length()==0);

				} catch (AssertionError e) {
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (Exception e) {
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else { 

				try {
					Assert.assertTrue(isElementPresent(locator));  // Will throw Assertion Error if failed
					ActualText = getAttribute(locator,attributeValue);// Will throw Exception if failed
					Assert.assertTrue(ActualText.replace("amp;", "").contains(expected)); // Will throw Assertion Error if failed
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					ExecutionLog.Log ("Verified that Expected value :["+expected+"] is matched with Actual value :["+ActualText+"]");
				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					ExecutionLog.Log("====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}
	}

	public void verifyTextMatches(String locator, String webElementNameOfLocator, String expected) throws Exception {
		String ActualText ="";
		if(!expected.contains("N/A")){
			if(expected.length()==0){
				try {
					Assert.assertTrue(isElementPresent(locator));
					ActualText = getText(locator);
					if(ActualText.equals("<!---->")) {
						ActualText = "";
					}
					Assert.assertTrue(ActualText.length()==0);
					ExecutionLog.Log("Verified that \"" + webElementNameOfLocator + "\" is blank");

				} catch (Exception e) {
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				} catch (AssertionError e) {
					ExecutionLog.Log("====Failed==== Expected value is:["+expected+"] but Actual value is ["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
			} else {
				try {
					Assert.assertTrue(isElementPresent(locator));  // Will throw Assertion Error if failed
					ActualText = getText(locator);// Will throw Exception if failed
					Assert.assertTrue(ActualText.contains(expected)); // Will throw Assertion Error if failed
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					ExecutionLog.Log ("Verified that Expected value :["+expected+"] is matched with Actual value :["+ActualText+"]");
				}
				catch (AssertionError e) { // To Catch Assertion Error
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					ExecutionLog.Log("====Failed==== Expected value is:["+expected+"] but Actual value is["+ActualText+"]. Please check the screenshot with name: " + webElementNameOfLocator +"for more details" );
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}
				catch (Exception e) { // To Catch Exception
					ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
					ExecutionLog.Log("====Failed====\"" + webElementNameOfLocator + "\" is not Present");
					getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
					e.printStackTrace();
				}

			}
		}
	}

	public void verifyElementNotPresent(String locator, String webElementNameOfLocator) throws Exception {
		try {
			Assert.assertFalse(isElementPresent(locator));
			ExecutionLog.Log ("\"" + webElementNameOfLocator + "\" is disable or not Present");
		} catch (AssertionError e) {
			ExecutionLog.Log ("Verify The data of " + webElementNameOfLocator);
			ExecutionLog.Log("====Failed==== \""+webElementNameOfLocator+"\"  should not be shown");
			getScreenShotOnCheckpointFailure(webElementNameOfLocator.replace("*", ""));
			e.printStackTrace();
		}
	}

	public void switchOutOfFrame() {
		driver.switchTo().defaultContent();
	}

	public String getText(String Locator){
		String text = "==========Failed==========No Text Available on Web Page";
		if(isElementPresent(Locator)) {
			text = driver.findElement(ByLocator(Locator)).getText();
		}
		return text;
	}

	public String getAttribute(String Locator, String Attribute){
		String AttributeValue = "No element is present on Web Page (DriverHelper.getAttribute())";
		if(isElementPresent(Locator)) {
			AttributeValue = driver.findElement(ByLocator(Locator)).getAttribute(Attribute);
		}
		return AttributeValue;
	}

	public String getDateStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy/HH");
		return sdf.format(date);
	}

	public String getAllOptions(String Locator, String WebElementNameOfLocator) throws Exception{
		StringBuffer allText = new StringBuffer();
		try {
			Select select = new Select(driver.findElement(ByLocator(Locator)));
			List<WebElement> allOptions = select.getOptions();

			for( WebElement elem : allOptions) {
				allText.append(elem.getText());
				allText.append("\n");

			}
		} catch (Exception e) {
			ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'");
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
		}
		ExecutionLog.Log(allText+"");

		return allText + "";
	}

	public void selectDropdownValue(String DropDownLocator, String DropDownLabelName, String DropDownValue) throws Exception{
			try {
				Select select = new Select(driver.findElement(ByLocator(DropDownLocator)));
				select.selectByVisibleText(DropDownValue);
				ExecutionLog.Log("Selected \"" + DropDownValue + "\" in \"" +DropDownLabelName + "\" drop down");
			} catch (NoSuchElementException e) {
				ExecutionLog.Log("====Failed==== \"" + DropDownValue + "\" is not present in '" + DropDownLabelName + "Drop Down'");
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			} 
		}
	

	public void selectDropdownValue(String DropDownLocator, String DropDownLabelName, int indexNumber) throws Exception{
		
			try {
				Select select = new Select(driver.findElement(ByLocator(DropDownLocator)));
				select.selectByIndex(indexNumber);
				ExecutionLog.Log("Selected index #\"" + indexNumber + "\" in \"" +DropDownLabelName + "\" drop down");
			} catch (NoSuchElementException e) {
				ExecutionLog.Log("====Failed==== #\"" + indexNumber + "\" is not present in '" + DropDownLabelName + "Drop Down'");
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			} 
		}
	

	public String getSelectedValueInDropdown(String DropDownLocator, String DropDownLabelName, String LabelNameFromExcel) throws Exception{
		String selectedValue = "";
		if(!LabelNameFromExcel.contains("N/A")){
			try {
				Select select = new Select(driver.findElement(ByLocator(DropDownLocator)));
				selectedValue = select.getFirstSelectedOption().getText();
			} catch (NoSuchElementException e) {
				ExecutionLog.Log("====Failed==== \" could not find " + DropDownLabelName + "Drop Down'");
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			} 
		}

		return selectedValue;
	}

	public void selectDropdownValueByIndex(String DropDownLocator, String DropDownLabelName, int indexNumber, String LabelNameFromExcel) throws Exception{
		if(!LabelNameFromExcel.contains("N/A")){
			try {
				Select select = new Select(driver.findElement(ByLocator(DropDownLocator)));
				select.selectByIndex(indexNumber);
				ExecutionLog.Log("Selected \"" + indexNumber + "\" number's value in \"" +DropDownLabelName + "\" drop down");
			} catch (NoSuchElementException e) {
				ExecutionLog.Log("====Failed==== \"" + indexNumber + "\" number's value is not present in '" + DropDownLabelName + "Drop Down'");
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			} 
		}
	}

	public void verifyFirstSelectedDropdownValue(String DropDownLocator, String DropDownLabelName, String ExpectedValue) throws Exception{
		String actualSelectedValue = "no element on the web Page";
		
			try {
				actualSelectedValue = new Select(driver.findElement(ByLocator(DropDownLocator))).getFirstSelectedOption().getText().trim();
				ExecutionLog.Log ("Verifying the drop down value ofdata of ");
				Assert.assertEquals(actualSelectedValue, ExpectedValue.trim());
				ExecutionLog.Log ("Verified that Expected value :" + DropDownLabelName);
			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]. Please check the screenshot with name: " + ExpectedValue +"for more details" );
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			}
			catch (Exception e) {
				ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]. Please check the screenshot with name: " + ExpectedValue +"for more details" );
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			}
		}
	

	public void verifyFirstSelectedDropdownValue(String DropDownLocator, String DropDownLabelName, String ExpectedValue, String LabelNameFromExcel, String AttibuteValue) throws Exception{
		String actualSelectedValue = "no element on the web Page";
		if(!LabelNameFromExcel.contains("N/A")){
			try {
				actualSelectedValue = new Select(driver.findElement(ByLocator(DropDownLocator))).getFirstSelectedOption().getAttribute(AttibuteValue);
				Assert.assertEquals(actualSelectedValue, ExpectedValue);
				ExecutionLog.Log ("Verified that Expected value :["+ExpectedValue+"] is matched with Actual value :["+actualSelectedValue+"]");
			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]. Please check the screenshot with name: " + ExpectedValue +"for more details" );
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			}
			catch (Exception e) {
				ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"] but Actual value is["+actualSelectedValue+"]. Please check the screenshot with name: " + ExpectedValue +"for more details" );
				getScreenShotOnCheckpointFailure(DropDownLabelName.replace("*", ""));
				e.printStackTrace();
			}
		}
	}

	public String getAllSeletedOptions(String Locator, String NameOfLocator){
		Select select = new Select(driver.findElement(ByLocator(Locator)));
		List<WebElement> allOptionsSelected = select.getAllSelectedOptions();
		StringBuffer allText = new StringBuffer();
		for( WebElement elem : allOptionsSelected) {
			allText.append(elem.getText());
			allText.append("\n");
		}
		ExecutionLog.Log("All Drop Down values of " + NameOfLocator + " are:\n");
		ExecutionLog.Log(allText+"");
		return allText + "";
	}

	public void verifySeletedOptions(String Locator, String ExpectedValue, String NameOfLocator) throws Exception{

		try {
			Select select = new Select(driver.findElement(ByLocator(Locator)));
			List<WebElement> allOptionsSelected = select.getAllSelectedOptions();
			StringBuffer allText = new StringBuffer();
			for( WebElement elem : allOptionsSelected) {
				allText.append(elem.getText());
				allText.append("\n");
			}
			String allSelectedText = allText + "";
			Assert.assertTrue(allSelectedText.contains(ExpectedValue));
			ExecutionLog.Log("Verified that"+ ExpectedValue + " is selected in drop down "+ NameOfLocator);
		} catch (AssertionError e) {
			ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"]"+ " is not selected in drop down "+NameOfLocator+"]. Please check the screenshot with name: \"" + NameOfLocator +"\" for more details" );
			getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));
			e.printStackTrace();
		}  catch (Exception e1) {
			ExecutionLog.Log("====Failed==== Expected value is:["+ExpectedValue+"]"+ " is not selected in drop down "+NameOfLocator+"]. Please check the screenshot with name: \"" + NameOfLocator +"\" for more details. " );
			getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));
			e1.printStackTrace();
		}


	}

	public String getAll(String Locator, String NameOfLocator){
		Select select = new Select(driver.findElement(ByLocator(Locator)));
		List<WebElement> allOptionsSelected = select.getOptions();
		StringBuffer allText = new StringBuffer();
		for( WebElement elem : allOptionsSelected) {
			allText.append(elem.getText());
			allText.append("\n");
		}
		ExecutionLog.Log("All Drop Down values of " + NameOfLocator + " are:\n");
		ExecutionLog.Log(allText+"");
		return allText + "";
	}
    //Need to Fixed 
	public void verifyDropDownValues(String Locator, String NameOfLocator, String SheetName, int RowNumstart, int RowNumEnd,String Attribute) throws Exception{

		ActualDropdownValues.clear();
		ExpectedDropdownValues.clear();
		
		
			ExecutionLog.Log("");
			ExecutionLog.Log("****Verify the Values of "+ NameOfLocator);
			try {
				Select select = new Select(driver.findElement(ByLocator(Locator)));
				List<WebElement> allOptionsSelected = select.getOptions();
				for( WebElement elem : allOptionsSelected) {
					ActualDropdownValues.add(elem.getAttribute(Attribute));
				}
				int data =0;
				for(int i = RowNumstart; i<=RowNumEnd; i++) {
					if(Current_xls.getCellData(SheetName, "TestData", i).contains("N/A")){
						break;
					}
					ExpectedDropdownValues.add(Current_xls.getCellData(SheetName, "TestData", i));
					data++;
				}
				ExecutionLog.Log("Drop Down values of " + NameOfLocator +" are: ");
				ExecutionLog.Log("Actual Drop Down Values are: \n" + ActualDropdownValues);
				ExecutionLog.Log("Expected Drop Down Values are: \n" + ExpectedDropdownValues);
				try {
					Assert.assertTrue(ActualDropdownValues.size()==ExpectedDropdownValues.size(), "=========Failed=======Actual Dropdown values of "+ NameOfLocator + " drop down are:[" + ActualDropdownValues.size()+ "]" + " BUT Expected Dropdown values are:[" + ExpectedDropdownValues.size()+ "]");

				} catch (AssertionError e) {
					//getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));
					//e.printStackTrace();;
				}
				ExecutionLog.Log("Total Number of Dropdown Valus in " + NameOfLocator + ":" +ActualDropdownValues.size());
				for ( int j = 0; j<ActualDropdownValues.size(); j++) {
					try {
						Assert.assertTrue(ExpectedDropdownValues.contains(ActualDropdownValues.get(j)));
						ExecutionLog.Log("Verified that [" + ActualDropdownValues.get(j) +"] is present in the dropdown " +  NameOfLocator);

					} catch (AssertionError e) {
						ExecutionLog.Log("=========Failed=======Actual Dropdown values of "+ NameOfLocator + "Does not match Expected ["+ExpectedDropdownValues.get(j)+"]" +"But Actual is [" + ActualDropdownValues.get(j) +"]");
						getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));
						e.printStackTrace();;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		

	}

	public void verifyDropDownValues(String Locator, String NameOfLocator, String Expected) throws Exception{
		ActualDropdownValues.clear();
		// true if expected value is present in the actual text
		boolean flag = false;
		if(!(Expected.contains("N/A"))) {
			try {
				Select select = new Select(driver.findElement(ByLocator(Locator)));
				List<WebElement> allOptionsSelected = select.getOptions();
				for( WebElement elem : allOptionsSelected) {
					ActualDropdownValues.add(elem.getText());
				}
				for(String DropdownValues : ActualDropdownValues) {
					if(DropdownValues.trim().equals(Expected)) {
						ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is present in the " + NameOfLocator + " drop down");
						flag = true;
						break;
					}
				}
				// throws exception if expected value is not present in the actual text
				if(!flag) {
					Assert.assertTrue(false);				}
				//Assert.assertTrue(ActualDropdownValues.contains(Expected));
				//ExecutionLog.Log ("Verified that Expected value :["+Expected+"] is present in the " + NameOfLocator + " drop down");

			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] is not present in the " + NameOfLocator + " drop down. please see the screenshot: " + Expected +"for more details" );
				getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));	
				e.printStackTrace();
			}

			catch (Exception e) {
				ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] is not present in the " + NameOfLocator + " drop down. please see the screenshot: " + Expected +"for more details" );
				getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));	
				e.printStackTrace();		
			}
		}
	}

	public void verifyAllAvailableValues(String Locator, String NameOfLocator, String SheetName, int RowNumstart, String runStatus_ExcelData) throws Exception{

		if(!(runStatus_ExcelData.contains("N/A"))){
			List<WebElement> Versiontypedropdown = driver.findElements(ByLocator(Locator)); 
			for (WebElement element: Versiontypedropdown) {
				String expectedValue = Current_xls.getCellData(SheetName, ClientData, RowNumstart);
				if(!(expectedValue.contains("N/A"))){
					String actualValue = element.getAttribute("innerHTML");
					try {
						Assert.assertTrue(actualValue.contains(expectedValue));
						ExecutionLog.Log("Verified that Expected value :[" + expectedValue + "] is matched with Actual value :[" + actualValue + "]");
					} catch (AssertionError e) {
						ExecutionLog.Log("=====Failed===== Expected value :[" + expectedValue + "] is matched with Actual value :[" + actualValue + "]");
						getScreenShotOnCheckpointFailure(NameOfLocator.replace("*", ""));
						e.printStackTrace();
					}

				}  if(expectedValue.contains("N/A")){
					break;

				}
				RowNumstart = RowNumstart + 1;
			}

		}
	}

	public void WaitForModalPanel() {
		try {
			driver.switchTo().window(driver.getWindowHandle());
			String element_xpath = "//*[@id='WebDialogWindow_RL_Progress']";
			if(isElementPresent(element_xpath)) {
				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element_xpath)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void WaitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until((ExpectedConditions.visibilityOfElementLocated(locator)));

	}

	public void WaitForElementPresent(String locator, Object...runStatusFromExcel) throws Exception{
		try {
			if(!runStatusFromExcel[0].toString().contains("N/A")) {
				try {
					WebDriverWait wait = new WebDriverWait(driver,90);
					wait.until((ExpectedConditions.visibilityOfElementLocated(ByLocator(locator))));
				} catch (Exception e) {
					ExecutionLog.Log("===Failed=== Could not find the locator: " + locator);
					getScreenShotOnCheckpointFailure("WaitForElement" + ScreenshotFailureNumber);
					e.printStackTrace();	
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}


	} 

	public void WaitForElementToClickable(By locator){
		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until((ExpectedConditions.elementToBeClickable(locator)));
	}

	public void WaitForElementToClickable(String locator, Object...runStatusFromExcel) throws Exception{
		try {
			if(!runStatusFromExcel[0].toString().contains("N/A")) {
				try {
					sleepTime(4);
					WebDriverWait wait = new WebDriverWait(driver,90);
					wait.until((ExpectedConditions.elementToBeClickable(ByLocator(locator))));
				} catch (Exception e) {
					ExecutionLog.Log("Could Not find the element with Locator:" + locator);
					getScreenShotOnCheckpointFailure("WaitForElementIssue" + ScreenshotFailureNumber);	
					e.printStackTrace();	
				}	
			}
		} catch (IndexOutOfBoundsException e) {
			try {
				WebDriverWait wait = new WebDriverWait(driver,90);
				wait.until((ExpectedConditions.elementToBeClickable(ByLocator(locator))));
			} catch (Exception e2) {
				ExecutionLog.Log("Could Not find the element with Locator:" + locator);
				getScreenShotOnCheckpointFailure("WaitForElementIssue" + ScreenshotFailureNumber);	
				e.printStackTrace();	
			}	
		} catch(Exception e) {
			ExecutionLog.Log("Could Not find the element with Locator:" + locator);
			getScreenShotOnCheckpointFailure("WaitForElementIssue" + ScreenshotFailureNumber);	
			e.printStackTrace();
		}

	}

	 public void waitForPageLoaded() {
		 ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);
	    }
	
	// This method need to be replaced
	public void AlertMessage (WebElement Ele, String AlertName) throws IOException {
		WebElement alert = Ele;
		if (alert.isDisplayed()){
			ExecutionLog.Log("Alert message is Pass");
			String Alertmsg = Ele.getText();
			ExecutionLog.Log( Alertmsg);
		}
		else
		{
			ExecutionLog.Log("Alert message is Fail");
			getScreenShotOnCheckpointFailure(AlertName.replace("*", ""));
		}

	}

	// This method need to be replaced
	
	public void acceptAlert(Object...runStatusFromExcel) throws IOException {
		try {
			if(!runStatusFromExcel[0].toString().contains("N/A")) {
				try {
					Alert alert = driver.switchTo().alert();
					alert.accept();
					ExecutionLog.Log("Accepted Alert");
				} catch (Exception e) {
					ExecutionLog.Log("=======Passing this Message instead of Exception to avoid PAUSE of execution=====");
					ExecutionLog.Log("Alert was not Present");
				}

			}
		} catch (Exception e) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				ExecutionLog.Log("Accepted Alert");
			} catch (Exception e2) {
			}
		}

	}

	public void scrollElementIntoView(WebElement element, Object... checkStatusFromExcel) throws Exception {
		ScreenshotFailureNumber++;
		// This try block handles Index out of Bound exception
		try {
			if(!checkStatusFromExcel[0].toString().contains("N/A")) {
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
				} catch (Exception e) {
					ExecutionLog.Log("Could not Scroll Element in View Range: " + checkStatusFromExcel[0]);
					getScreenShotOnCheckpointFailure("ScrollIssue" + ScreenshotFailureNumber);	
					e.printStackTrace();
				}
			}
		} catch (IndexOutOfBoundsException e) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			} catch (Exception e1) {
				getScreenShotOnCheckpointFailure("ScrollIssue_" + ScreenshotFailureNumber);	
				e1.printStackTrace();
			} 
		} catch (Exception e2) {
			getScreenShotOnCheckpointFailure("ScrollIssue_" + ScreenshotFailureNumber);	
			e2.printStackTrace();	
		}

	}

	public void scrollElementIntoView(String Locator, Object... checkStatusFromExcel_HorizontalScrollLocator) throws Exception {
		ScreenshotFailureNumber++;
		// This try block handles Index out of Bound exception
		try {
			if(!checkStatusFromExcel_HorizontalScrollLocator[0].toString().contains("N/A")) {

				if(Browser.equalsIgnoreCase("firefox")) {
					WebElement Image = driver.findElement(By.xpath(Locator));			        
					//Used points class to get x and y coordinates of element.
					Point point = Image.getLocation();
					int xcord = point.getX();
					Actions builder =new Actions(driver);
					builder.dragAndDropBy(driver.findElement(By.xpath(checkStatusFromExcel_HorizontalScrollLocator[1].toString())),xcord,0).build().perform();
				} 
				else{
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(ByLocator(Locator)));
					} catch (Exception e) {
						ExecutionLog.Log("Could not Scroll Element in View Range: " + checkStatusFromExcel_HorizontalScrollLocator[0]);
						getScreenShotOnCheckpointFailure("ScrollIssue_" + ScreenshotFailureNumber);	
						e.printStackTrace();
					}
				}
			}
		} catch (IndexOutOfBoundsException e) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(ByLocator(Locator)));
			} catch (Exception e1) {
				ExecutionLog.Log("Could not Scroll Element in View Range: ");
				getScreenShotOnCheckpointFailure("ScrollIssue_" + ScreenshotFailureNumber);	
				e1.printStackTrace();
			}
		} catch (Exception e2) {
			ExecutionLog.Log("Could not Scroll Element in View Range: ");
			getScreenShotOnCheckpointFailure("ScrollIssue_" + ScreenshotFailureNumber);	
			e2.printStackTrace();
		}

	}

	public void Enter(){

		try {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();


		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void sleepTime(int TimeInSeconds) throws Exception{
		Thread.sleep(TimeInSeconds*1000);
	}

	public String addDays(String date_StringFormat, int month, int days,  int year) throws Exception {
		DateFormat dateFormat ;
		if(ClientData.contains("VMN") ||ClientData.contains("AMCN") ) {
			// Change the String into Date Data Type in the given Format
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		} else {
			System.out.println("For Other");
			// Change the String into Date Data Type in the given Format
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}

		Date Date_DateFormat = dateFormat.parse(date_StringFormat); 
		// Parse Method converts a "String" into a "Date" Data Type in the given Format

		Calendar cal = Calendar.getInstance();
		cal.setTime(Date_DateFormat);
		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, month);
		cal.add(Calendar.DAY_OF_MONTH, days);
		// Change the "Date" Data Type into the "String" Data Type in the given Format
		return dateFormat.format(cal.getTime());

	}

	public void WaitForModalPanel(String loc)
	{
		driver.switchTo().window(driver.getWindowHandle()); 
		try {
			String element_xpath = loc;
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element_xpath)));
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void keyboard() throws Exception{
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		keyboard.pressKey(Keys.TAB);
		keyboard.releaseKey(Keys.TAB);
		sleepTime(3);

	}

	public String ChangeHrstoMin (String str) throws InterruptedException {
		String[] h1=str.split(":");
		int hour=Integer.parseInt(h1[0]);
		int minute=Integer.parseInt(h1[1]);
		int second=Integer.parseInt(h1[2]);
		int temp;
		temp = (60 * hour) + minute ;
		return String.format("%02d:%02d",temp,second);
	}

	public void sendKeysOnDisplayedElement(String Locator, String TestData, String WebElementNameOfLocator, String LabelNameFromExcel) throws Exception {

		if(!LabelNameFromExcel.contains("N/A")){
			try {
				Assert.assertTrue(isElementPresent(Locator));

				WebElement elem;
				try {
					elem = driver.findElement(ByLocator(Locator));
					elem.clear();
				} catch (Exception e) {

				}
				elem = getDisplayedElement(Locator, WebElementNameOfLocator, LabelNameFromExcel);
				elem.sendKeys(TestData);
				ExecutionLog.Log("Entered \"" + TestData + "\" in field '" + WebElementNameOfLocator + "'");

			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;
			} catch (Exception e) {
				ExecutionLog.Log("====Failed==== \"" + WebElementNameOfLocator + "\" field is not present'" + WebElementNameOfLocator + "'");
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();;

			}

		}
	}

	public WebElement getDisplayedElement(String Locator, String WebElementNameOfLocator, Object... checkStatusFromExcel) throws Exception {
		List<WebElement> allElements = driver.findElements(ByLocator(Locator));
		WebElement dispElem = allElements.get(0);
		try {
			if(!(checkStatusFromExcel[0].toString().contains("N/A"))) {
				for(WebElement elem : allElements){
					if(elem.isDisplayed()){
						dispElem  = elem;
						return dispElem;
					}
				}

			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			getScreenShotOnCheckpointFailure(WebElementNameOfLocator);
			e1.printStackTrace();

		}

		return dispElem;
	}

	public void contextClick(String Locator, Object... obj) throws Exception{
		try {
			WaitForElementPresent(Locator);
			sleepTime(2);
			Actions Action = new Actions(driver);
			Action.moveToElement(driver.findElement(ByLocator(Locator)));
			Action.contextClick(driver.findElement(ByLocator(Locator))).build().perform();
		} catch (Exception e) {
			ExecutionLog.Log("=====Failed===== Could not perform Right click");
			getScreenShotOnCheckpointFailure("rightClickFailure");
			e.printStackTrace();
		}

	}

	public static long numberofDays(String fromDate,String toDate)
	{
		// Creates two calendars instances

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		// Set the date for both of the calendar instance
		StringBuffer sBuffer = new StringBuffer(fromDate);
		String yearFrom = sBuffer.substring(6,10);
		String monFrom = sBuffer.substring(0,2);
		String ddFrom = sBuffer.substring(3,5);
		int intYearFrom = Integer.parseInt(yearFrom);
		int intMonFrom = Integer.parseInt(monFrom);
		int intDdFrom = Integer.parseInt(ddFrom);
		cal1.set(intYearFrom, intDdFrom, intMonFrom);

		StringBuffer sBuffer1 = new StringBuffer(toDate);
		String yearTo = sBuffer1.substring(6,10);
		String monTo = sBuffer1.substring(0,2);
		String ddTo = sBuffer1.substring(3,5);
		int intYearTo = Integer.parseInt(yearTo);
		int intMonTo = Integer.parseInt(monTo);
		int intDdTo = Integer.parseInt(ddTo);
		cal2.set(intYearTo, intDdTo, intMonTo);

		// Get the represented date in milliseconds
		long milis1 = cal1.getTimeInMillis();
		long milis2 = cal2.getTimeInMillis();

		// Calculate difference in milliseconds
		long diff = milis2 - milis1;
/*
		// Calculate difference in seconds
		long diffSeconds = diff / 1000;

		// Calculate difference in minutes
		long diffMinutes = diff / (60 * 1000);

		// Calculate difference in hours
		long diffHours = diff / (60 * 60 * 1000);
*/
		// Calculate difference in days
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffDays+1;

	}

	public void ScrollbarHorizontalRight(WebElement element) {
		Actions builder =new Actions(driver);
		builder.dragAndDropBy(element,10000,0).build().perform();
	}

	public void ScrollbarHorizontalLeft(WebElement element) {
		Actions builder =new Actions(driver);
		builder.dragAndDropBy(element,-10000,0).build().perform();
	}

	public static void DBConnection() throws Exception {

		ExecutionLog.Log(Class.class.desiredAssertionStatus()+"");

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@rlv3db39:1521:rlv3db39","rlviewer","rlv2");

		if(con!= null){
			CallableStatement pstmt = con.prepareCall("{call prc_ri_exec_raa_etl(?)}");
			pstmt.setInt(1, 0);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		}else{
			ExecutionLog.Log("Could not Get Connection");
		}
	}
	
	public static void ReportDBConnection() throws Exception {

		ExecutionLog.Log(Class.class.desiredAssertionStatus()+"");

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@rlv3db54:1521:rlv3db54","rlanltcs","rlv2");

		if(con!= null){
			CallableStatement pstmt = con.prepareCall("{call rlanltcs.prc_ra_refresh_data(?)}");
			pstmt.setInt(1, 0);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		}else{
			ExecutionLog.Log("Could not Get Connection");
		}
	}


	public String Diffruntime (String str, String str2) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("mmm:ss");
		Date d1 = format.parse(str);
		Date d2 = format.parse(str2);
		long diff = Math.abs(d1.getTime() - d2.getTime());
		final long min = TimeUnit.MILLISECONDS.toMinutes(diff);
		final long sec = TimeUnit.MILLISECONDS.toSeconds(diff -TimeUnit.MINUTES.toMillis(min) );
		return String.format("%03d:%02d", min, sec);

	}

	public String Differencevalue (String str1, String str2) throws ParseException {
		int Firstvalue1 = Integer.parseInt(str1);
		int Firstvalue2 = Integer.parseInt(str2);
		int diff = Math.abs(Firstvalue1 - Firstvalue2 );
		return Integer.toString(diff);

	}

	public String findTimeDiff (String str, String str2) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SS");
		Date d1 = format.parse(str);
		Date d2 = format.parse(str2);
		long diff = Math.abs(d2.getTime() - d1.getTime());

		final long hr = TimeUnit.MILLISECONDS.toHours(diff);
		final long min = TimeUnit.MILLISECONDS.toMinutes(diff - TimeUnit.HOURS.toMillis(hr));
		final long sec = TimeUnit.MILLISECONDS.toSeconds(diff - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min));
		final long ms = TimeUnit.MILLISECONDS.toMillis(diff - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min) - TimeUnit.SECONDS.toMillis(sec));
		return String.format("%02d:%02d:%02d:%02d", hr, min, sec, ms);

	}

	public void testCaseStatus() {
		if (TC_Status.contains("Failed")) {
			Assert.assertTrue(false, "Some Validations of the test case is failed");
		} else if (TC_Status.contains("Skipped")) {
		    throw new SkipException("This Test Case is Skipped");
		}
	
	}

	@AfterMethod(alwaysRun=true)
	protected void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
			acceptAlert();
			getScreenShotOnCheckpointFailure(result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			// enable the below code once script status method is implementd in all java files
			//if(!(Tab_AutomationStatus.toString().contains("N/A") || Tab_AutomationStatus.toString().contains("Not"))) {
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Case Skipped" + result.getThrowable());

			//} 

		} else {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case Passed");
		}

		ExtentManager.getReporter().endTest(ExtentTestManager.getTest());        
		ExtentManager.getReporter().flush();
		try {
			if(driver!=null) {
				ExecutionLog.Log("***********" + driver);
				driver.quit();	
				ExecutionLog.Log("Closed the Browser");
			}
		} catch (Exception e) {

		}
		report.flush();
	}
	public void verifyCheckBoxStatus(String locator, boolean Expected, String WebElementNameOfLocator) throws Exception {
		boolean checkBoxStatus = false;
		
			try {
				checkBoxStatus = driver.findElement(ByLocator(locator)).isSelected();
				ExecutionLog.Log("Verifying the Check box status of " + WebElementNameOfLocator);
				Assert.assertTrue(checkBoxStatus==Expected);
				ExecutionLog.Log("Verified that Expected value is:["+Expected+"] but Actual value is["+checkBoxStatus+"]");

			} catch (AssertionError e) {
				ExecutionLog.Log("====Failed==== Expected value is:["+Expected+"] but Actual value is["+checkBoxStatus+"]. Please check the screenshot with name: " + WebElementNameOfLocator +"for more details" );
				getScreenShotOnCheckpointFailure(WebElementNameOfLocator.replace("*", ""));
				e.printStackTrace();
			}

		
	}
	
	public void screenshot(String testCaseName){
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMyyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("MM-dd-yyyy h-mm-ss a");
		String formattedDate1 = sdf1.format(date);
		String formattedDate2 = sdf2.format(date);
		String formattedDate3 = sdf3.format(date);
		String fileSeperator = System.getProperty("file.separator");

		String folderName1= formattedDate1;
		String folderName2= formattedDate2;
		String imagePath1 = System.getProperty("user.dir")+"\\Screenshots\\"+ folderName1+fileSeperator;
		String imagePath2 = System.getProperty("user.dir")+"\\Screenshots\\"+ folderName1+fileSeperator+"\\"+folderName2+fileSeperator;


		String imageName=testCaseName+"_"+formattedDate3+".jpg";

		File file1 = new File(imagePath1);
		if (!file1.exists()) {
			ExecutionLog.Log("File created " + file1);
			file1.mkdir();

			File file2 = new File(imagePath2);
			if (!file2.exists()) {
				ExecutionLog.Log("File created " + file2);
				file2.mkdir();
			}
		}


		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(imagePath2 + imageName));
			System.out.println("ScreenShot of TestMethod Failure: " + imagePath2+imageName);
			Reporter.log("<html><body><a href=\""+ imagePath2+imageName +"\"><img src=\"file:///" + imagePath2+imageName + "\" alt=\"\""+ "height='120' width='120'/></a> "+"<br></br></html></body>");
			ExecutionLog.Log("Test Case :" + testCaseName + "'s Screenshot of Failure Page: \n" + imagePath2 + imageName);
		} catch (IOException e) {
			ExecutionLog.Log("Could not take the Screenshot of Test Case '" + testCaseName + "'s at failure point due to:" + imagePath2 + imageName);
			e.printStackTrace();
		}
		try {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				ExecutionLog.Log("==================Fail============ The Test Method left an Alert at the End of execution of the Test Case");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void TABKewordFiveTimes(int noOfTimesForTAB) throws Exception{
		for(int i = 1; i<=noOfTimesForTAB; i++) {
			keyboard();	
		}

	}
	
	public void refreshPage() throws Exception{
		Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		keyboard.pressKey(Keys.F5);
		keyboard.releaseKey(Keys.F5);
		sleepTime(3);

	}
	
	public void VerifyURL(String Capture_URL) throws Exception {

		try {
			String URL_RUN = driver.getCurrentUrl();
			Assert.assertEquals(URL_RUN, Capture_URL );
			} catch (AssertionError e) {
				

			}
		
		}

	public void ResponseCodeCheck(String URL_Verify) throws Exception{
		ExecutionLog executionLog = new ExecutionLog();	
		String dateTime = executionLog.getDate();
		String fileName = executionLog.getFileName();
          try { 
        	  FileWriter fstream = new FileWriter(System.getProperty("user.dir")+"\\ExecutionLog\\"+fileName+".txt",true);
  			BufferedWriter out = new BufferedWriter(fstream);
  			
        	URL url = new URL(URL_Verify);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
           
            int  code = connection.getResponseCode();
            String ResponseCode = Integer.toString(code);
            if(ResponseCode.contains("404")){
            	
				ExtentTestManager.getTest().log(LogStatus.FAIL,DriverHelper.color("red", ResponseCode));
				Reporter.log("<html><body><b>||"+DriverHelper.color("red", ResponseCode)+"||<br></br></b></html></body>");
				out.write(DriverHelper.color("red", ResponseCode));
				DriverHelper.TC_Status = "Failed";
				}
          }catch(Exception e){
        	  
          }
			
       }
	
	public void URL_PresentWithResponseCodeCheck(String Text,String Enter_URL) throws Exception {
		
		try {
			verifyElementPresent("//*[@class='footTop clearfix']//*[contains(text(),'"+Text+"')]", Text);
			clickOn("//*[@class='footTop clearfix']//*[contains(text(),'"+Text+"')]", Text);
			WaitForElementPresent("//div[@class='callusWrap']");
			sleepTime(3);
			VerifyURL(Enter_URL);
			ResponseCodeCheck(Enter_URL);
			driver.navigate().back();
			WaitForElementPresent("instantQuoteMotor");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static String CurerentMonthplusOneMonth() {
		YearMonth thisMonth    = YearMonth.now();
		YearMonth OneMonthAdd = thisMonth.plusMonths(1);
		
		DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM");
		
		String  CurerentMonthplusOneMonth = OneMonthAdd.format(monthYearFormatter);
		return CurerentMonthplusOneMonth;
	}
	public static String CurerentMonth() {
		YearMonth thisMonth    = YearMonth.now();
		
		DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM");
		
		String  CurerentMonth = thisMonth.format(monthYearFormatter);
		return CurerentMonth.toUpperCase();
	}
}
