package Reporting;

import com.relevantcodes.extentreports.ExtentReports;

import utility.DriverHelper;

public class ExtentManager {

	final static String filePath = System.getProperty("user.dir") + "\\test-output\\AdvanceReport\\Renewbuy.html";
    
    public synchronized static ExtentReports getReporter() {
        if (DriverHelper.report == null) {
        	DriverHelper.report = new ExtentReports(filePath, true);
        }
        
        return DriverHelper.report;
    }
}
