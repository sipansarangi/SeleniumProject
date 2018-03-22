package utility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import Reporting.ExecutionLog;

public class ListenerClass extends DriverHelper implements ITestListener  {

	// Called before every Test Method
	@Override
	public void onTestStart(ITestResult tr) {
		testCaseName = tr.getName();
		
		report.loadConfig(new File(System.getProperty("user.dir") + "/lib/extentreports/extent-config.xml"));
		//logger.startTest(tr.getInstance().toString().split("@")[0].toString()+ "." + tr.getName());
		ExecutionLog.Log("*********************Started Executing '" + tr.getName() + "' Test Case*********************");
		
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		
		ExecutionLog.Log("Test '" + tr.getName() + "' PASSED");
		
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		String testCaseName = tr.getName();
		ExecutionLog.Log("Test '" + testCaseName + "' FAILED");
		ExecutionLog.Log(tr.getStatus()+""); 
		//System.out.println(driver);screenshot(testCaseName);

		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		ExecutionLog.Log("*****Test '" + tr.getName() + "'*****: SKIPPED");
		/*try {
			driver.quit();
			ExecutionLog.Log("Closed the Browser");
		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}

	@Override
	public void onFinish(ITestContext arg0) {
		
	}

	// Called before the start of <Test> Tag in TestNG.xml file
	@Override
	public void onStart(ITestContext arg0) {
		ExecutionLog.Log("Client: " + ClientName);
		ExecutionLog.Log("*********************Started Executing the Test Area(Modules/TAB): '" + arg0.getName() + "'*********************");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@AfterSuite
	public void getDetails() {
		
	}


}
