package renewbuy_Script;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reporting.ExecutionLog;
import utility.DriverHelper;

@Listeners(utility.ListenerClass.class)
public class CSE extends DriverHelper {

	
	@Test(groups = {"Regression"}, priority =1,enabled = true,description = "Renewbuy Home Page Test") 
	public void Test_HomePage() throws Exception {
		
		//verify_module
		ExecutionLog.Log("CSE");
		selectDropdownValue("manufacturer", "Manufacturer dropdown", "BAJAJ");
		verifyFirstSelectedDropdownValue("manufacturer", "Manufacturer dropdown", "BAJAJ");
		sleepTime(100);
	}

}

