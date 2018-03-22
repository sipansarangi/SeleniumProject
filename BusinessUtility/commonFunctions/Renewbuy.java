package commonFunctions;


import java.util.Random;

import org.openqa.selenium.WebDriver;
import Reporting.ExecutionLog;
import utility.DriverHelper;

/**
 * @author Sipan Shankar Sarang
 *
 */

public class Renewbuy extends DriverHelper {

	public Renewbuy(WebDriver driver) {
		this.driver = driver;
	}

	public void HomePageHeaderVerify() throws Exception {
		/*verifyElementPresent(loc_Link_MotorInsurance, "Motor Insurance");
		verifyElementPresent(loc_Link_HealthInsurance, "Health Insurance");
		verifyElementPresent(loc_Link_PersonalAccident, "Personal Accident");
		verifyElementPresent(loc_Link_BecomeAgent, "Become Agent");
		verifyElementPresent(loc_Link_OneClickRenewal, "One-Click Renewal"); 
		verifyElementPresent(loc_Link_Blog, "Blog");
		verifyElementPresent(loc_Link_Login, "Login");*/
	}

	public void EnetrDataInHomePage() throws Exception{
		WaitForElementPresent(loc_VehicleInput);
		sendKeys(loc_VehicleInput, VehicleName, "Enter MARUTI 800 AC");
		clickOn(loc_Contains_Text.replace("@var", FullVehicleName), "Select Vehicle "+FullVehicleName+"");
		selectDropdownValue(loc_PurchaseYear, "Year", PurchaseYear.replace(".0", ""));
		WaitForElementPresent("instantQuoteMotor");
		clickOn(loc_InstantQuote, "Instant Quote");
		WaitForElementPresent(loc_BuyButton);

	}
	
	public void End_To_End_Flow(String Buy_Button_Locater,Object... TestData) throws Exception{
		Random rand = new Random();
		String RegisteredNo = String.format("%04d", rand.nextInt(10000));
		/**
		 * @author Sipan Shankar Sarangi
		 *
		 */

		/*Buy Button[0] , Vehicle[1] , Vehicle FullName[2] , Company Own[3] , InsClamed This Year[4] , Prev Policy End Date[5]
		 * This method used for Different Insurers , RenewBuy Smoke
		 * */
		WaitForElementPresent(loc_VehicleInput);
		sendKeys(loc_VehicleInput, TestData[0].toString(), "Enter "+TestData[0].toString()+""); //VehicleName
		clickOn(loc_Contains_Text.replace("@var", TestData[1].toString()), "Select Vehicle "+TestData[1].toString()+""); //FullVehicleName
		selectDropdownValue(loc_PurchaseYear, "Year", PurchaseYear.replace(".0", ""));
		WaitForElementPresent("instantQuoteMotor");
        clickOn(loc_InstantQuote, "Instant Quote");
        WaitForElementPresent(loc_BuyButton);
		
		//Verify Header in Quote Page
		ExecutionLog.Log("Vehicle Model");
		WaitForElementPresent(Buy_Button_Locater);
		WaitForElementToClickable(Buy_Button_Locater);
		verifyTextMatches(loc_VehicleModel_QuotePage, "Vehicle Model Field", VehicleModel_Header);
		verifyElementPresent(loc_VehicleModel_QuotePageEditButton, "Vehicle Model Edit Button");
		sleepTime(2);
    	verifyTextMatches(loc_VehicleModel_QuotePageInput, "Vehicle Model Quote Page", TestData[1].toString().replace(" cc", "cc"));
    	
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
    	//Buy 
    	WaitForElementToClickable(Buy_Button_Locater);
    	sleepTime(5);
    	
    	if(TestData[5].toString().contains("Yes")) {
    		clickOn(Loc_previous_insurerEditButton, "previous insurer Edit Button");
    		clickOn(Loc_previous_insurer, "previous insurer");
    		sleepTime(2);
    		clickOn(Loc_previous_insurer_Bajaj, "bajaj");
    		sleepTime(3);
    	}
    	
    	
    	if(TestData[4].toString().contains("Yes")) {
    		clickOn(Loc_PrevPolicyEndDate_EditButton, "Edit Button");
    		sleepTime(1);
    		clickUsingJSExecutor(Loc_PrevPolicyEndDate, "Prev Policy End Date");
    		WaitForElementPresent(Loc_PrevPolicyEndDate_Year);
    		selectDropdownValue(Loc_PrevPolicyEndDate_Year, "Year Select ", "2008");
    		clickOn(Loc_PrevPolicyEndDate_Date, "Select 8 ");
    		
    	}
    	//Insurance claimed this year
    	if(TestData[3].toString().contains("Yes")) {
        	WaitForElementToClickable(loc_InsuranceClaimedThisYear_Checkbox);
        	clickOn(loc_InsuranceClaimedThisYear_Checkbox, "Insurance Claimed This Year Checkbox");
        	WaitForElementToClickable(loc_BuyButton);
        	sleepTime(3);
        	verifyElementNotDisplayed(loc_NCB_Checkbox, "Existing No Claim Bonus (NCB)");
        	clickOn(loc_PremiumDetails, "Premium Details");
        	WaitForElementToClickable(loc_NoClaimDiscount);
        	verifyTextMatches(loc_NoClaimDiscount, "No Claim Discount", "0%");
    	}
    	    	
    	//Company owned 
    	if(TestData[2].toString().contains("Yes")) {
    		ExecutionLog.Log("Company owned");
    		clickOn(loc_Company_owned_Checkbox, "Company owned Checkbox");
    		sleepTime(2);
    		WaitForElementToClickable(loc_BuyButton);
    		sleepTime(2);
    	}
    	WaitForElementToClickable(Buy_Button_Locater);
    	sleepTime(2);
    	clickOn(Buy_Button_Locater, "Buy Button");
    	
    	if(isElementDisplayed(loc_SubmitButton,"Buy Button")) {
    		
    		clickOn(loc_SubmitButton, "Confirm");
    		sleepTime(5);
    	}
    	
    	//Field
    	verifyTextMatches(loc_PersonalDetails_Header, "Personal Details Header", PersonalDetails_Header);
    	verifyTextMatches(loc_VehicleDetails_Header, "Vehicle Details Header", VehicleDetails_Header);
    	verifyTextMatches(loc_ReviewAndPay_Header, "Review And Pay", ReviewAndPay_Header);    	
    	
    	WaitForElementPresent(loc_TitleDropdown);
    	clickOn(loc_TitleDropdown,"Title drop down");
    	sleepTime(2);
    	clickUsingJSExecutor(loc_TitleDropdown_Select_Mr,"Select Mr.From Title");
    	sleepTime(2);  
    	//Insurer Name Capture
    	
    	sendKeys(loc_FirstName, FirstName, "Enter Name");
    	if(!TestData[2].toString().contains("Yes")) {
    	sendKeys(loc_LastName, LastName, "Enter Last Name");
    	}
    	sendKeys(loc_Email, EmailID, "Enter Email ID");
    	sendKeys(loc_MobileNumber, MobileNumber, "Enter Mobile Num");
    	 if(isElementDisplayed(loc_DOB_Day,"")){
    	 //Date of Birth
    	 clickOn(loc_DOB_Day,"Day Drop down");
         sleepTime(2);
         clickUsingJSExecutor(loc_DOB_DayInput.replace("@var", DOB_Day),"Enter Day");
         sleepTime(2);
         //Month
         clickOn(loc_DOB_Month,"Day Drop down");
         sleepTime(2);
         clickUsingJSExecutor(loc_DOB_MonthInput.replace("@var", DOB_Month),"Enter Month");
         sleepTime(2); 
         //Year
         clickOn(loc_DOB_Year,"Year Drop down");
         sleepTime(2);
         sendKeys(loc_DOB_YearInput, DOB_Year.replace(".0", ""), "Enter Year");
         sleepTime(2);
         Enter();
         }
         //Address
         sendKeys(Loc_AddressInput, Address, "Enter Address");
         //Pin Code
         sendKeys(loc_PinCodeInput, PinCode, "Enter Pin Code");
         sleepTime(2);
         clickUsingJSExecutor(Loc_NextButton, "Enter Next");
         // 3rd Page 
         WaitForElementPresent(Loc_RegistrationNo_Input);
         
         verifyTextMatches(Loc_RegistrationNo, "Registration No", RegistrationNo);
         verifyTextMatches(Loc_ChassisNo, "Chassis No", ChassisNo);
         verifyTextMatches(Loc_EngineNo, "Engine No", EngineNo);
         verifyTextMatches(Loc_ExistingPolicyNo, "Existing Policy No", ExistingPolicyNo);
         verifyTextMatches(Loc_ExistingInsurer, "Existing Insurer", ExistingInsurer);
         verifyTextMatches(Loc_PreviousPolicyExpiryDate, "Previous Policy Expiry Date", PreviousPolicyExpiryDate);
         //Input Field
         //Registration No
         ExecutionLog.Log("Registration No");
         sendKeys(Loc_RegistrationNo_Input, RegisteredNo_InputData+RegisteredNo, "Registration No_Input");
         //Chassis No.
         ExecutionLog.Log("Chassis No.");
         sendKeys(Loc_ChassisNo_Input, ChassisNo_InputData, "Chassis No Input");
         //Engine No.
         ExecutionLog.Log("Engine No.");
         sendKeys(Loc_EngineNo_Input, EngineNo_InputData, "Engine No Input");
         //Existing Policy No.
         ExecutionLog.Log("Existing Policy No.");
         sendKeys(Loc_ExistingPolicyNo_Input, ExistingPolicyNo_InputData, "Existing Policy No Input");
         //Existing Insurer
         ExecutionLog.Log("Existing Insurer");
         clickOn(Loc_ExistingInsurerDropdown,"Existing Insurer Drop down");
         sendKeys(Loc_ExistingInsurer_Input, ExistingInsurerData, "Existing Insurer");
         Enter();
         //Previous Policy Expiry Date
         ExecutionLog.Log("Previous Policy Expiry Date");
         //Day
         ExecutionLog.Log("Day");
         clickOn(loc_PreviousPolicyEndDay,"Previous Policy EndDay");
         sendKeys(loc_PreviousPolicyEnd_Input, PreviousPolicyEndDay, "Enter 12");
         Enter();
         //Month
         ExecutionLog.Log("Month");
         clickOn(loc_PreviousPolicyEndMonth,"Previous Policy End Month");
         sleepTime(2);
         sendKeys(loc_PreviousPolicyEnd_Input, PreviousPolicyEndMonth, "Enter Month");
         Enter();
         //Year
         ExecutionLog.Log("Year");
         clickOn(loc_PreviousPolicyEndYear,"Previous Policy End Year");
         sleepTime(2);
         sendKeys(loc_PreviousPolicyEndYear_Input, PreviousPolicyEndYear, "Enter Year");
         Enter(); 
         clickUsingJSExecutor(Loc_NextButton, "Enter Next");
        
         //Next
         WaitForElementPresent(loc_TermsAndConditionsCheckBox);
         if(isElementPresent(loc_NomineeName)){
         sendKeys(loc_NomineeName, "Test Name", "Nominee Name");
         //Nominee Relation
         clickOn(loc_NomineeNameRelation,"Nominee Relation");
         sleepTime(2);
         clickOn(loc_NomineeNameRelation_Select.replace("@var", NomineeNameRelation), "Select Mother");
       
         //Nominee Age
         clickOn(loc_Nominee_Age,"Nominee Age");
         sleepTime(2);
         sendKeys(loc_NomineeAge_Input, Nominee_Age.replace(".0", ""), "Enter Nominee Age");
//         clickOn(loc_Text.replace("@var", Nominee_Age.replace(".0", "")),"Nominee Age");
         Enter();
         }
         //TC
         clickOn(loc_TermsAndConditionsCheckBox, "TC");
         sleepTime(2);
         clickUsingJSExecutor(Loc_NextButton, "Enter Next");
         WaitForElementPresent("//*[@class='btnSubmit yesButton']");
         clickOn(loc_SubmitButton, "Confirm");
      
        
         WaitForElementPresent(Loc_NewIndiaAssurancePaymentPage);
         sleepTime(5);

}
	
}
