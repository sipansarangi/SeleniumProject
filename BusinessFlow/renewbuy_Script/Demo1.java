package renewbuy_Script;

import java.awt.Scrollbar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonFunctions.Renewbuy;
import utility.DriverHelper;
@Listeners(utility.ListenerClass.class)
public class Demo1 extends DriverHelper {
	Renewbuy RB = new Renewbuy(driver);
	@Test(groups="Smoke",priority =1,enabled = true,description = "Four Wheeler")
	public void TC_01_Four_Wheeeler() throws Exception {
	System.out.println("Enter URL");
	
	
	test88();
	
		}
	
	
	public void test88() throws Exception {
		int counter= 1;
		while (counter <= 10) {
			   System.out.println(counter);
			   
			   JavascriptExecutor jse = (JavascriptExecutor)driver;
			   jse.executeScript("window.scrollBy(0,250)", "");
			   clickUsingJSExecutor("//*[@id='fastExecNextp_803']", "");
			   
			   WaitForElementPresent("//*[@id='fastExecNextp_803']");
			   sleepTime(2);
			   counter++;    
	}
		
}
}