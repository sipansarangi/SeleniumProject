package RB;

import org.testng.annotations.Test;

import utility.DriverHelper;

public class TC_01_HomePage extends DriverHelper {
	
	@Test(groups="Regression",priority =1,enabled = true,description = "Home Page Field Verification")
	public void HomePage() throws Exception {
		
		//URL Verify
		// Manual Test Step: RB_001
		//Validation Msg
		//Without entering any data
		WaitForElementPresent(loc_InstantQuote);
		clickOn(loc_InstantQuote, "Instant Quote");
		WaitForElementPresent(Loc_AlertOk_Button);
		verifyTextMatches(Loc_AlertBox1, "Alert Msg", AlertMsg1);
		clickOn(Loc_AlertOk_Button, "OK Button");
		WaitForElementPresent(loc_InstantQuote);
		//Without Year
		sendKeys(loc_VehicleInput, VehicleName, "Vehicle Name"); //VehicleName
		WaitForElementPresent(loc_VehicleInput);
		clickOn(loc_Contains_Text.replace("@var",FullVehicleName ), FullVehicleName); //FullVehicleName

		clickOn(loc_InstantQuote, "Instant Quote");
		WaitForElementPresent(Loc_AlertBox1);
		sleepTime(3);
		verifyTextMatches(Loc_AlertBox1, "Alert Msg", AlertMsg2);
		clickOn(Loc_AlertOk_Button, "OK Button");

		// Manual Test Step: RB_009
		//Validate UI of "Purchase Year" drop-down box.
		verifyFirstSelectedDropdownValue(loc_PurchaseYear, "Purchase Year", "Purchase Year");
		verifyDropDownValues(loc_PurchaseYear, "Verify Purchase Year dropdown value", "RB", 53,68,"value");

		selectDropdownValue(loc_PurchaseYear, "Year", PurchaseYear.replace(".0", ""));

		//Instant Quote
		WaitForElementPresent(loc_InstantQuote);
		clickOn(loc_InstantQuote, "Instant Quote");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_VehicleModel_QuotePageEditButton);
		
	}

}
