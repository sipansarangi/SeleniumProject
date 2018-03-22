package renewbuy_Script;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonFunctions.Renewbuy;
import utility.DriverHelper;

@Listeners(utility.ListenerClass.class)
public class Different_Insurers extends DriverHelper {

	
	@Test(groups = {"Smoke"}, priority =1,enabled = true,description = "HDFC_Ergo") 
	public void TC_01_HDFC_Ergo() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
		RB.End_To_End_Flow(loc_BuyButton_HDFC_Ergo,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();

		}

	@Test(groups = {"Smoke"}, priority =2,enabled = true,description = "HDFC Ergo ZeroDep") 
	public void TC_02_HDFC_Ergo_ZeroDep() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_HDFC_Ergo_ZeroDep,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}

	@Test(groups = {"Smoke"}, priority =3,enabled = true,description = "NewIndia") 
	public void TC_03_NewIndia() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
		
		RB.End_To_End_Flow(loc_BuyButton_NewIndia,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}

	@Test(groups = {"Smoke"}, priority =4,enabled = true,description = "NewIndia ZeroDep") 
	public void TC_04_NewIndia_ZeroDep() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
		
		RB.End_To_End_Flow(loc_BuyButton_NewIndia_ZeroDep,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}

	@Test(groups = {"Smoke"}, priority =5,enabled = true,description = "TataAig") 
	public void TC_05_TataAig() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_TataAig,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}

	@Test(groups = {"Smoke"}, priority =6,enabled = true,description = "TataAig ZeroDep") 
	public void TC_06_TataAig_ZeroDep() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_TataAig_ZeroDep,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}

	@Test(groups = {"Smoke"}, priority =7,enabled = true,description = "Reliance") 
	public void TC_07_Reliance() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_Reliance,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}
	
	@Test(groups = {"Smoke"}, priority =8,enabled = false,description = "Reliance ZeroDep") 
	public void TC_08_Reliance_ZeroDep() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_Reliance_ZeroDep,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}

	@Test(groups = {"Smoke"}, priority =9,enabled = true,description = "Bajaj Allianz") 
	public void TC_09_BajajAllianz() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_BajajAllianz,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}
	
	@Test(groups = {"Smoke"}, priority =10,enabled = true,description = "Bajaj Allianz ZeroDep") 
	public void TC_10_BajajAllianz_ZeroDep() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_BajajAllianz_ZeroDep,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}
	
	@Test(groups = {"Smoke"}, priority =11,enabled = false,description = "Bharti Axa") 
	public void TC_11_Bharti_Axa() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_Bharti_Axa,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}

	@Test(groups = {"Smoke"}, priority =6,enabled = false,description = "Bharti Axa ZeroDep") 
	public void TC_09_Bharti_Axa_ZeroDep() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_Bharti_Axa_ZeroDep,VehicleName,FullVehicleName,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}

	@Test(groups = {"Smoke"}, priority =6,enabled = true,description = "DIGIT") 
	public void TC_10_DIGIT() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_DIGIT,VehicleName1,FullVehicleName1,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}
	
	@Test(groups = {"Smoke"}, priority =6,enabled = true,description = "DIGIT ZeroDep") 
	public void TC_11_DIGIT_ZeroDep() throws Exception {
		Renewbuy RB = new Renewbuy(driver);
	
		RB.End_To_End_Flow(loc_BuyButton_DIGIT_ZeroDep,VehicleName1,FullVehicleName1,"N/A","N/A","N/A","N/A");
		testCaseStatus();
		
		}
	}

