package renewbuy_Script;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reporting.ExecutionLog;
import utility.DriverHelper;

@Listeners(utility.ListenerClass.class)
public class RB_portal extends DriverHelper {


	@Test(groups = {"Regression"}, priority =1,enabled = true,description = "Renewbuy Portal Field Verification") 
	public void TC_01_Field_Verification() throws Exception {

		//URL Verify
		// Manual Test Step: RB_001
		VerifyURL();
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

		ExecutionLog.Log("Manual Steps-4 major fields at top of the page as: "
				+ "\"Vehicle Model\", \"Registered City\", \"Purchase Date\" and \"Previous insurer\".");

		//Vehicle Model 
		ExecutionLog.Log("Vehicle Model");
		verifyTextMatches(loc_VehicleModel_QuotePage, "Vehicle Model Field", VehicleModel_Header);
		verifyElementPresent(loc_VehicleModel_QuotePageEditButton, "Vehicle Model Edit Button");

		//Registered Rto 
		ExecutionLog.Log("Registered Rto");
		verifyTextMatches(loc_RegisteredCity_QuotePage, "Registered Rto Field", RegisteredRto_Header);
		verifyElementPresent(loc_RegisteredCity_QuotePageEditButton, "Registered Rto Edit Button");
		verifyTextMatches(loc_RegisteredCity_QuotePageInput, "Vehicle Model Quote Page", City);

		//Purchase Date
		ExecutionLog.Log("Purchase Date");
		verifyTextMatches(loc_PurchaseDate_QuotePage, "Purchase Date Field", PurchaseDate_Header);
		verifyElementPresent(loc_PurchaseDate_QuotePageEditButton, "Purchase Date Edit Button");
		verifyTextMatches(loc_PurchaseDate_QuotePageInput, "Vehicle Model Quote Page", PurchaseDate.replace(".0", ""));

		//Previous Insurer
		ExecutionLog.Log("Previous Insurer");
		verifyTextMatches(loc_PreviousInsurer_QuotePage, "Previous Insurer Field", PreviousInsurer_Header);
		verifyElementPresent(loc_PreviousInsurer_QuotePageEditButton, "Previous Insurer Edit Button");
		verifyTextMatches(loc_PreviousInsurer_QuotePageInput, "Previous Insurer Quote Page", PreviousInsurer);

		ExecutionLog.Log("Advanced Search at left side of page including: \"IDV selection\", "
				+ "\"NCB\" and \"Additional covers\". Out of which only IDV: \"Automatic\" should be checked by default.");

		//Advanced_search
		verifyTextMatches(Loc_Advanced_search_Field, "Advanced search Field", Adv_Search_Field);

		//IDV selection
		verifyTextMatches(loc_InsuredDeclaredValue_IDV_Field, "Insured Declared Value (IDV)", InsuredDeclaredValueIDV_Field);
		verifyTextMatches(loc_Automatic_For_best_Quotes_Field, "Automatic (For best quotes)", Automatic_For_best_Quotes_Field);
		verifyTextMatches(loc_Set_Your_IDV_Field, "Set your IDV ", Set_Your_IDV_Field);
		verifyTextMatches(loc_CompanyOwnedVehicle_Field, "Company Owned Vehicle", CompanyOwnedVehicle_Field);
		verifyTextMatches(loc_Insuranceclaimed_This_Year_Field, "Company Owned Vehicle", Insuranceclaimed_This_Year_Field);

		//Additional Cover
		verifyTextMatches(loc_AdditionalCover_Field, "Additional Cover Field", AdditionalCover_Field); 
        //Zero Depreciation
		verifyTextMatches(loc_ZeroDepreciation_Field, "Zero Depreciation Field", ZeroDepreciation_Field); 
		//Passenger Cover
		verifyTextMatches(loc_PassengerCover_Field, "Passenger Cover Field", PassengerCover_Field); 
		//Road Side Assistance 
		verifyTextMatches(loc_RoadSideAssistance_Field, "Road Side Assistance Field", RoadSideAssistance_Field); 
		//Return To Invoice Cover
		verifyTextMatches(loc_ReturnToInvoiceCover_Field, "Return To Invoice Cover Field", ReturnToInvoiceCover_Field); 
		//Externally fitted CNG kit? 
		verifyTextMatches(loc_ExternallyfittedCNGkit_Field, "Externally fitted CNG kit? Field", ExternallyfittedCNGkit_Field); 
		//Prev Policy Details
		verifyTextMatches(loc_PrevPolicyDetails_Field, "c Field", PrevPolicyDetails_Field); 
		//I don't Have Policy
		verifyTextMatches(loc_IdontHavePolicy_Field, "I don't Have Policy Field", IdontHavePolicy_Field); 
		//Prev Policy End Date
		verifyTextMatches(loc_PrevPolicyEndDate_Field, "Prev Policy End Date Field", PrevPolicyEndDate_Field); 
		//Manufacturing Year
		verifyTextMatches(loc_ManufacturingYear_Field, "Manufacturing Year Field", ManufacturingYear_Field); 
		
		clickOn(loc_PurchaseDate_QuotePageEditButton, "Purchase Date Edit Button");
		verifyElementPresent(Loc_Day_Dropdown, "Day");
		verifyElementPresent(Loc_Month_Dropdown, "Month");
		verifyElementPresent(Loc_Year_Dropdown, "Year");

		clickOn(Loc_Purchase_DateCancelButton, "Cancel Button");

		sleepTime(3);

		verifyElementNotDisplayed(Loc_Day_Dropdown, "Day");
		verifyElementNotDisplayed(Loc_Month_Dropdown, "Month");
		verifyElementNotDisplayed(Loc_Year_Dropdown, "Year");
		
		//VehicleModel
        verifyElementPresent(loc_VehicleModel_QuotePageEditButton, "Vehicle Model Edit Button");
		clickOn(loc_VehicleModel_QuotePageEditButton, "VehicleModel Edit Button");
		verifyElementPresent(loc_VehicleModel_QuotePageCancelButton, "Cancel Button");
        sendKeys(loc_VehicleModel_QuotePageInput1, VehicleName2, "Vehicle Name"); //VehicleName
        
        //Cancel Button
        clickOn(loc_VehicleModel_QuotePageCancelButton, "Cancel Button");
        sleepTime(2);
		verifyTextMatches(loc_VehicleModel_QuotePageInput, "Verify Vehicle Name ", FullVehicleName.replace(" cc", "cc"));
        //Edit
		clickOn(loc_VehicleModel_QuotePageEditButton, "VehicleModel Edit Button");
		sendKeys(loc_VehicleModel_QuotePageInput1, VehicleName2, "Vehicle Name"); //VehicleName
		clickOn(loc_Contains_Text.replace("@var",FullVehicleName2 ), FullVehicleName2); //FullVehicleName
		WaitForElementToClickable(loc_VehicleModel_QuotePageEditButton);
		sleepTime(2);
		verifyTextMatches(loc_VehicleModel_QuotePageInput, "Verify Vehicle Name ", FullVehicleName2.replace(" cc", "cc"));
		
	    //Registered Rt
		verifyTextMatches(loc_Registered_RTO_Data, "Registered RTO Data", "Delhi");
		//Edit Button
		verifyElementPresent(loc_Registered_RTO_EditButton, "Registered RTO Edit Button");
		clickUsingJSExecutor(loc_Registered_RTO_EditButton, "Registered RTO Edit Button");
		sleepTime(1);
		verifyElementPresent(loc_Registered_RTO_CancelButton, "Registered RTO Cancel Button");
		sendKeys(Loc_Registered_RTO_Input, "Gurugram", "City name change");
		
		if(ClientName.contains("DEV")) {
		WaitForElementPresent(loc_Contains_Text.replace("@var", "HR26-Gurugram/Gurgaon"));
		}else {
			WaitForElementPresent(loc_Contains_Text.replace("@var", "HR26-Gurugram"));
		}
		sleepTime(2);
		if(ClientName.contains("DEV")) {
		clickOn(loc_Contains_Text.replace("@var", "HR26-Gurugram/Gurgaon"), "Select HR26-Gurugram/Gurgaon");
		}else {
			clickOn(loc_Contains_Text.replace("@var", "HR26-Gurugram"), "Select HR26-Gurugram");
		}
		WaitForElementToClickable(loc_BuyButton);
        sleepTime(2);
        if(ClientName.contains("DEV")) {
		verifyTextMatches(loc_Registered_RTO_Data, "Registered RTO Data", "Gurugram/Gurgaon");
        }else {
        	verifyTextMatches(loc_Registered_RTO_Data, "Registered RTO Data", "Gurugram");
        }
		
		//Search by RTO code
		clickUsingJSExecutor(loc_Registered_RTO_EditButton, "Registered RTO Edit Button");
		sendKeys(Loc_Registered_RTO_Input, "DL01", "City name change");
		WaitForElementPresent(loc_Contains_Text.replace("@var", "DL01-Delhi North Hill Road"));
		clickOn(loc_Contains_Text.replace("@var", "DL01-Delhi North Hill Road"), "Select DL01-Delhi North Hill Road");
		WaitForElementToClickable(loc_BuyButton);
        sleepTime(2);
		verifyTextMatches(loc_Registered_RTO_Data, "Registered RTO Data", "Delhi");
		
		//Previous Insurer
		clickOn(loc_PreviousInsurer_QuotePageEditButton, "Previous Insurer Edit Button");
		verifyDropDownValues(loc_PreviousInsurer_Dropdown, "Previous Insurer Dropdown Value", "RB", 73,91,"innerHTML");
		//Esc Key
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
		sleepTime(3);

		testCaseStatus();
		
	}
	
	@Test(groups = {"Regression"}, priority =1,enabled = true,description = "Renewbuy Portal Company - Owned Vehicle") 
	public void TC_02_Company_Owned_Vehicle() throws Exception {

		//Company - owned vehicle
		sendKeys(loc_VehicleInput, VehicleName, "Vehicle Name"); //VehicleName
		clickOn(loc_Contains_Text.replace("@var",FullVehicleName ), FullVehicleName); //FullVehicleName
		selectDropdownValue(loc_PurchaseYear, "Year", PurchaseYear.replace(".0", ""));
		clickOn(loc_InstantQuote, "Instant Quote");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_VehicleModel_QuotePageEditButton);
		
		//Capture Current URL
		String url = driver.getCurrentUrl();
		System.out.println(url);
		//Company - owned vehicle? 
		ExecutionLog.Log("Company owned");
		clickOn(loc_Company_owned_Checkbox, "Company owned Checkbox");
		sleepTime(2);
		verifyElementPresent(Loc_Quote_Loading, "Quote Loading");
		WaitForElementToClickable(loc_BuyButton);
		sleepTime(2);
		if(isElementDisplayed(loc_SubmitButton,"Buy Button")) {

			clickOn(loc_SubmitButton, "Confirm");
			sleepTime(5);
		}
		clickOn(loc_BuyButton, "Buy Button");
		WaitForElementPresent(loc_TitleDropdown);
		clickOn(loc_TitleDropdown,"Title drop down");
		sleepTime(2);

		verifyElementPresent(Loc_TitleDropdown_Value.replace("@var", "Title"), "Title");
		verifyElementPresent(Loc_TitleDropdown_Value.replace("@var", "M/s"), "M/s");
		clickUsingJSExecutor(loc_TitleDropdown_Select_Mr,"Select Mr.From Title");
		
		sendKeys(loc_FirstName, FirstName, "Enter Name");
		sendKeys(loc_Email, EmailID, "Enter Email ID");
		sendKeys(loc_MobileNumber, MobileNumber, "Enter Mobile Num");

		//Address
		sendKeys(Loc_AddressInput, Address, "Enter Address");
		//Pin Code
		sendKeys(loc_PinCodeInput, PinCode, "Enter Pin Code");
		sleepTime(2);
		clickUsingJSExecutor(Loc_NextButton, "Enter Next");

		driver.navigate().to(url);
		verifyElementPresent(Loc_Quote_Loading, "Quote Loading");
		WaitForElementToClickable(loc_BuyButton);
		
		testCaseStatus();
	}
	
	@Test(groups = {"Regression"}, priority =1,enabled = true,description = "Renewbuy Portal Zero Depreciation") 
	public void TC_03_Zero_Depreciation() throws Exception {
		sendKeys(loc_VehicleInput, VehicleName, "Vehicle Name"); //VehicleName
		clickOn(loc_Contains_Text.replace("@var",FullVehicleName ), FullVehicleName); //FullVehicleName
		selectDropdownValue(loc_PurchaseYear, "Year", PurchaseYear.replace(".0", ""));
		clickOn(loc_InstantQuote, "Instant Quote");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_VehicleModel_QuotePageEditButton);
		//Zero Depreciation
		verifyElementNotDisplayed(Loc_EngineProtectorField, "Engine Protector Field");
		verifyElementNotDisplayed(Loc_ConsumablesField, "Consumables Field");
		verifyElementNotDisplayed(Loc_KeyReplacementField, "Key Replacement Field");
		clickOn(loc_ZeroDepreciation_CheckBox, "Zero Depreciation_CheckBox");
		verifyElementPresent(Loc_Quote_Loading, "Quote Loading");
		sleepTime(3);
		verifyElementDisplayed(Loc_EngineProtectorField, "Engine Protector Field");
		verifyElementDisplayed(Loc_ConsumablesField, "Consumables Field");
		verifyElementDisplayed(Loc_KeyReplacementField, "Key Replacement Field");
		//Engine Protector Field
		verifyTextMatches(Loc_EngineProtectorField, "Engine Protector Field", EngineProtectorField); 
		//Consumables Field
		verifyTextMatches(Loc_ConsumablesField, "Consumables Field", ConsumablesField); 
		//Key Replacement
		verifyTextMatches(Loc_KeyReplacementField, "Key Replacement Field", KeyReplacementField);
		sleepTime(3);
		WaitForElementPresent(loc_PremiumDetails1);
		clickUsingJSExecutor(loc_PremiumDetails1, "Premium Details");
		sleepTime(4);
		verifyTextMatches(Loc_ZeroDepreciationField, "Zero Depreciation added in Premium ", "Zero Depreciation");
		//Key Replacement
		clickOn(Loc_KeyReplacementCheckBox, "Key Replacement CheckBox");
		verifyElementPresent(Loc_Quote_Loading, "Quote Loading");
		WaitForElementPresent(loc_BuyButton);
		sleepTime(3);
		clickOn(loc_PremiumDetails2, "");
		sleepTime(3);
		verifyTextMatches(Loc_KeyReplacementFieldPremiumDetails, "Key Replacement added in Premium ", "Key Replacement");
		
		testCaseStatus();
	}	
	
	@Test(groups = {"Regression"}, priority =1,enabled = true,description = "Renewbuy Portal Passanger Cover") 
	public void TC_04_PassangerCover_RoadSideAssistance() throws Exception {
		
		sendKeys(loc_VehicleInput, VehicleName, "Vehicle Name"); //VehicleName
		clickOn(loc_Contains_Text.replace("@var",FullVehicleName ), FullVehicleName); //FullVehicleName
		selectDropdownValue(loc_PurchaseYear, "Year", PurchaseYear.replace(".0", ""));
		clickOn(loc_InstantQuote, "Instant Quote");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_VehicleModel_QuotePageEditButton);	
		
		clickOn(Loc_PassengerCover_CheckBox, "PassengerCover CheckBox");
		WaitForElementToClickable(loc_PremiumDetails);
		
		clickOn(loc_PremiumDetails, "Premium Details"); 
		WaitForElementPresent(loc_PremiumDetails_Passanger_Cover, "");
		sleepTime(2);
		verifyElementDisplayed(loc_PremiumDetails_Passanger_Cover, "Passanger Cover");
		
       //24x7 Road Side Assistance
		
		clickOn(Loc_RoadSideAssistance_CheckBox, "RoadSideAssistance CheckBox");
		WaitForElementToClickable(loc_PremiumDetails);
		
		clickOn(loc_PremiumDetails, "Premium Details"); 
		WaitForElementPresent(loc_PremiumDetails_RoadSideAssistance, "");
		sleepTime(2);
		verifyElementDisplayed(loc_PremiumDetails_RoadSideAssistance, "Road Side Assistance");
		
		testCaseStatus();
	}

	@Test(groups = {"Regression"}, priority =1,enabled = true,description = "Renewbuy Portal Passanger Cover") 
	public void TC_05_PassangerCover_RoadSideAssistance() throws Exception {
		
		
		
	}
}


