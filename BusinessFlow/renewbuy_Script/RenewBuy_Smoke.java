package renewbuy_Script;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonFunctions.Renewbuy;
import utility.DriverHelper;

@Listeners(utility.ListenerClass.class)
public class RenewBuy_Smoke extends DriverHelper {
	
	
	@Test(groups="Smoke",priority =1,enabled = true,description = "Four Wheeler")
	public void TC_01_Four_Wheeeler() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
		RB.HomePageHeaderVerify();
		RB.End_To_End_Flow(loc_BuyButton,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
	}
	
	@Test(groups="Smoke",priority =2,enabled = true,description = "Two_Wheeler")
	public void TC_02_Two_Wheeler() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
		RB.HomePageHeaderVerify();
		RB.End_To_End_Flow(loc_BuyButton,VehicleName_TwoWheeler,FullVehicleName_TwoWheeler,"N/A","N/A","N/A","N/A");
		testCaseStatus();
	}

	@Test(groups="Smoke",priority =3,enabled = true,description = "Company_Owned")
	public void TC_03_Company_Owned() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
		RB.HomePageHeaderVerify();
		RB.End_To_End_Flow(loc_BuyButton,VehicleName,FullVehicleName,"Yes","N/A","N/A","N/A");
		
		testCaseStatus();
	}
	
	@Test(groups="Smoke",priority =4,enabled = true,description = "Insurance claimed this year")
	public void TC_04_Insurance_Claimed_This_Year() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
		RB.HomePageHeaderVerify();
		RB.End_To_End_Flow(loc_BuyButton,VehicleName,FullVehicleName,"N/A","Yes","N/A","N/A");
		
		testCaseStatus();
	}
	
	@Test(groups="Smoke",priority =5,enabled = true,description = "Prev Policy End Date")
	public void TC_05_Prev_Policy_End_Date() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
		RB.HomePageHeaderVerify();
		
		RB.End_To_End_Flow(loc_BuyButton,VehicleName_TwoWheeler,FullVehicleName_TwoWheeler,"N/A","N/A","Yes","N/A");
	         
		testCaseStatus();
	}
	
	@Test(groups="Smoke",priority =6,enabled = true,description = "Previous Insurer")
	public void TC_06_Previous_Insurer() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
		RB.HomePageHeaderVerify();
		
		RB.End_To_End_Flow(loc_BuyButton,VehicleName,FullVehicleName,"N/A","N/A","N/A","Yes");
	         
		testCaseStatus();
	}
	
}
