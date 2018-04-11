package renewbuy_Script;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reporting.ExecutionLog;
import utility.DriverHelper;

@Listeners(utility.ListenerClass.class)
public class RB_portal extends DriverHelper {
	Random rand = new Random();
	String RegisteredNo = String.format("%04d", rand.nextInt(10000));

	@Test(groups = {"Regression"}, priority =1,enabled = true,description = "Renewbuy Portal Field Verification") 
	public void TC_01_Field_Verification() throws Exception {

		//URL Verify
		// Manual Test Step: RB_001
		VerifyURL(URL);
		//Logo Verification 
		verifyElementDisplayed("//img[@src='https://static.renewbuy.com/pstatic/portal/images/renewbuy_logo.0b532ddf5ff2.png']", "Logo");
		
		//Home Page Header
		verifyTextMatches(("link=Motor Insurance"), "Motor Insurance", "Motor Insurance");
		verifyTextMatches(("link=Health Insurance"), "Health Insurance", "Health Insurance");
		verifyTextMatches(("link=Personal Accident"), "Personal Accident", "Personal Accident");
		verifyTextMatches(("link=Become Agent"), "Become Agent", "Become Agent");
		verifyTextMatches(("link=One-Click Renewal"), "One-Click Renewal", "One-Click Renewal");
		verifyTextMatches(("link=Blog"), "Blog", "Blog");
		verifyTextMatches(("link=Login"), "Login", "Login");
		
		moveMouse("link=Motor Insurance", "Motor Insurance");
		sleepTime(1);
		verifyTextMatches(("link=Car Insurance"), "Car Insurance", "Car Insurance");
		verifyTextMatches(("link=Two Wheeler Insurance"), "Two Wheeler Insurance", "Two Wheeler Insurance");
		verifyTextMatches(("link=Motor Insurance Reminder"), "Motor Insurance Reminder", "Motor Insurance Reminder");
		
		moveMouse("link=Car Insurance", "Car Insurance");
		sleepTime(1);
		verifyTextMatches(("link=Renew Car Insurance"), "Renew Car Insurance", "Renew Car Insurance");
		verifyTextMatches(("link=Compare Car Insurance"), "Compare Car Insurance", "Compare Car Insurance");
		verifyTextMatches(("link=New Car Insurance"), "New Car Insurance", "New Car Insurance");
		verifyTextMatches(("link=Car Insurance Calculator"), "Car Insurance Calculator", "Car Insurance Calculator");
		verifyTextMatches(("link=Car Insurance Claim"), "Car Insurance Claim", "Car Insurance Claim");
		verifyTextMatches(("link=Car Insurance Companies"), "Car Insurance Companies", "Car Insurance Companies");
		moveMouse("link=Car Insurance Companies", "Car Insurance Companies");
		sleepTime(1);
		verifyTextMatches(("link=HDFC Ergo"), "HDFC Ergo", "HDFC Ergo");
		verifyTextMatches(("link=New India"), "New India", "New India");
		verifyTextMatches(("link=Bajaj Allianz"), "Bajaj Allianz", "Bajaj Allianz");
		verifyTextMatches(("link=Bharti AXA"), "Bharti AXA", "Bharti AXA");
		verifyTextMatches(("link=Reliance"), "Reliance", "Reliance");
		verifyTextMatches(("link=Tata AIG"), "Tata AIG", "Tata AIG");
		sleepTime(3);
		//Two Wheeler Insurance
		moveMouse("//*[@id='bs-example-navbar-collapse-1']//*[text()='Two Wheeler Insurance']", "Two Wheeler Insurance");
		sleepTime(1);
		verifyTextMatches(("link=Renew Two Wheeler Insurance"), "Renew Two Wheeler Insurance", "Renew Two Wheeler Insurance");
		verifyTextMatches(("link=Compare Two Wheeler Insurance"), "Compare Two Wheeler Insurance", "Compare Two Wheeler Insurance");
		verifyTextMatches(("link=New Two Wheeler Insurance"), "New Two Wheeler Insurance", "New Two Wheeler Insurance");
		verifyTextMatches(("link=Multi Year Two Wheeler Insurance"), "Multi Year Two Wheeler Insurance", "Multi Year Two Wheeler Insurance");
		verifyTextMatches(("link=Two Wheeler Insurance Calculator"), "Two Wheeler Insurance Calculator", "Two Wheeler Insurance Calculator");
		verifyTextMatches(("link=Two Wheeler Insurance Companies"), "Two Wheeler Insurance Companies", "Two Wheeler Insurance Companies");
		verifyTextMatches(("link=Two Wheeler Insurance FAQs"), "Two Wheeler Insurance FAQs", "Two Wheeler Insurance FAQs");
		
		//Health Insurance
		moveMouse("//*[@id='bs-example-navbar-collapse-1']//*[text()='Health Insurance']", "Compare Health Insurance");
		sleepTime(1);
		verifyTextMatches(("link=Compare Health Insurance"), "Compare Health Insurance", "Compare Health Insurance");
		verifyTextMatches(("link=Individual Health Insurance"), "Individual Health Insurance", "Individual Health Insurance");
		verifyTextMatches(("link=Family Health Insurance"), "Family Health Insurance", "Family Health Insurance");
		verifyTextMatches(("link=Mediclaim Policy"), "Mediclaim Policy", "Mediclaim Policy");
		moveMouse("link=Mediclaim Policy", "Mediclaim Policy");
		sleepTime(1);
		verifyTextMatches(("link=Cashless Mediclaim Policy"), "Cashless Mediclaim Policy", "Cashless Mediclaim Policy");
		verifyTextMatches(("link=Top Up"), "Top Up", "Top Up");
		verifyTextMatches(("link=Health Insurance Companies"), "Health Insurance Companies", "Health Insurance Companies");
		moveMouse("link=Health Insurance Companies", "Health Insurance Companies");
		sleepTime(1);
		verifyTextMatches(("link=Star Health Insurance"), "Star Health Insurance", "Star Health Insurance");
		verifyTextMatches(("link=Religare"), "Religare", "Religare");
		verifyTextMatches(("link=HDFC Ergo"), "HDFC Ergo", "HDFC Ergo");
		//Login
		moveMouse("link=Login", "Login");
		sleepTime(1);
		verifyTextMatches(("link=Customer Login"), "Customer Login", "Customer Login");
//		verifyTextMatches(("partialLink=Partner Login "), "Partner Login", "Partner Login ");
		
		
		//Login Page 
		moveMouse("link=Login", "Login");
		sleepTime(1);
		clickOn("link=Customer Login", "Customer Login");
		WaitForElementPresent("loginSubmit"); 
		sleepTime(3);
		verifyElementDisplayed("//*[@id='loginPopup']//*[text()='Already a member?']", "Already a member?");
		verifyElementDisplayed("//*[@id='loginPopup']//*[text()='New user']", "New user");
		verifyElementDisplayed("//*[@id='loginPopup']/div/div/div[3]/div[1]/div/div/span/span", "Email Icone");
		verifyElementDisplayed("//*[@id='loginPopup']/div/div/div[3]/div[2]/div/div/span/span", "Password Icone");
		verifyElementDisplayed("//*[@class='loginBox']//*[@class='close_model']", "Close Button");
		verifyTextMatches("//*[@id='loginSubmit']", "Login Button", "Login", "value");
		verifyTextMatches("//*[@id='alreadyUser']", "Forgot Password Field", "Forgot Password");
		
		verifyTextMatches("//*[@id='loginPopup']/div/div/div[3]/div[1]/div/span[1]", "Email text", "Email ID");
		verifyTextMatches("//*[@id='loginPopup']/div/div/div[3]/div[2]/div/span[1]", "Password text", "Password");
		
		verifyTextMatches("//*[@id='loginEmail']", "Email Id Input Filed", "user@domain.com","placeholder");
		verifyTextMatches("//*[@id='loginPassword']", "password input Field", "********","placeholder");
		
		//Login Validation
		clickOn("//*[@id='loginSubmit']", "Login Button");
		sleepTime(2);
		verifyTextMatches("//*[@id='loginEmailError']", "Without entering Email ID and Password", "Please enter a valid Email ID");
		sendKeys("//*[@id='loginEmail']", "sipan.bgr@gmail.com", "Email ID Input");
		clickOn("//*[@id='loginSubmit']", "Login Button");
		sleepTime(1);
		verifyTextMatches("//*[@id='loginPasswordError']", "Without entering password", "Please enter a valid password");
		sleepTime(1);
		Clear("//*[@id='loginEmail']", "Email ID Input Field Clear");
		sendKeys("//*[@id='loginPassword']", "renewbuy@123", "Password Input Field");
		clickOn("//*[@id='loginSubmit']", "Login Button");
		sleepTime(1);
		verifyTextMatches("//*[@id='loginEmailError']", "Without entering Email ID", "Please enter a valid Email ID");
		
		//Close Button 
		clickOn("//*[@class='loginBox']//*[@class='close_model']", "Close Button ");
		sleepTime(5);
		//Login Page 
		moveMouse("link=Login", "Login");
		sleepTime(1);
		clickOn("link=Customer Login", "Customer Login");
		WaitForElementPresent("loginSubmit"); 
		sleepTime(3);
		
		sendKeys("//*[@id='loginEmail']", "hemlata.yadav1@renewbuy.com", "Email ID");
		sendKeys("//*[@id='loginPassword']", "hemu@123", "Password");
		sleepTime(2);
		clickOn("//*[@id='loginSubmit']", "Login Button");
		sleepTime(3);
		verifyTextMatches("//*[@id='loginError']", "Incorrect password", "Incorrect Email/Password");
		
		
		sendKeys("//*[@id='loginEmail']", "hemlata.yadav@renewbuy.com", "Email ID");
		sendKeys("//*[@id='loginPassword']", "hemu@123", "Password");
		clickOn("//*[@id='loginSubmit']", "Login Button");
		WaitForElementPresent("//*[@id='topicon']//span[@class='personicon']");
		sleepTime(5);
		verifyTextMatches("//*[@id='topicon']//span[@class='personicon']", "After Login", "R");
		
		//Logout
		clickOn("//*[@class='personicon']", "Logout Icone");
		sleepTime(1);
		verifyTextMatches("//*[@id='topicon']/div/ul/li[1]/a", "My Profile", "My Profile");
		verifyTextMatches("//*[@id='topicon']/div/ul/li[2]/a", "Change Password", "Change Password");
		verifyTextMatches("//*[@id='topicon']/div/ul/li[3]/a", "Logout", "Logout");
		sleepTime(3);
		clickOn("//*[@id='topicon']/div/ul/li[3]/a", "Logout");
		WaitForElementPresent("link=Login");
		
		//Call Button
		verifyElementDisplayed("//div[@class='callusWrap']", "Call Button");
		
		//Video
		verifyElementDisplayed("//*[@src='https://www.youtube.com/embed/aASeHNBVOzc']", "Home Page Video");
		verifyElementDisplayed("//*[@class='ytp-large-play-button ytp-button']", "Youtube Button");
		//Blog
		URL_PresentWithResponseCodeCheck("Blog", "https://www.renewbuy.com/blog/");
		//Press
		URL_PresentWithResponseCodeCheck("Press", "https://www.renewbuy.com/press/");
		//Offers
		URL_PresentWithResponseCodeCheck("Offers", "https://www.renewbuy.com/Noneoffers/");
		//Careers
		URL_PresentWithResponseCodeCheck("Careers", "https://www.renewbuy.com/p/careers/");
		//About Us
		URL_PresentWithResponseCodeCheck("About Us", "https://www.renewbuy.com/p/about-us/");
		//Contact Us
		URL_PresentWithResponseCodeCheck("Contact Us", "https://www.renewbuy.com/p/contact-us/");
		//Grievance Redressal
		URL_PresentWithResponseCodeCheck("Grievance Redressal", "https://www.renewbuy.com/p/grievance-redressal/");
		
		//Motor Insurance
		verifyElementPresent("//*[@class='navList']//*[text()='Motor Insurance']", "Motor Insurance");
		clickUsingJSExecutor("//*[@class='navList']//*[text()='Motor Insurance']", "Motor Insurance");
		WaitForElementPresent("//div[@class='callusWrap']");
		sleepTime(3);
		VerifyURL("https://www.renewbuy.com/p/motor-insurance/");
		ResponseCodeCheck("https://www.renewbuy.com/p/motor-insurance/");
		driver.navigate().back();
		WaitForElementPresent("instantQuoteMotor");
		
		//Claim Assistance
		URL_PresentWithResponseCodeCheck("Claim Assistance", "https://www.renewbuy.com/p/motor-insurance/claim-assistance/");
		//Motor Insurance Calculator
		URL_PresentWithResponseCodeCheck("Motor Insurance Calculator", "https://www.renewbuy.com/p/motor-insurance/motor-insurance-calculator/");
		//Motor Insurance Claim
		URL_PresentWithResponseCodeCheck("Motor Insurance Claim", "https://www.renewbuy.com/p/motor-insurance/motor-insurance-claim/");
		//Zero Depreciation
		URL_PresentWithResponseCodeCheck("Zero Depreciation", "https://www.renewbuy.com/p/motor-insurance/zero-depreciation/");
		//Motor Insurance FAQs
		URL_PresentWithResponseCodeCheck("Motor Insurance FAQs", "https://www.renewbuy.com/p/motor-insurance/faq/");
		
		//Car Insurance
		verifyElementPresent("//*[@class='navList']//*[text()='Car Insurance']", "Car Insurance");
		clickUsingJSExecutor("//*[@class='navList']//*[text()='Car Insurance']", "Car Insurance");
		WaitForElementPresent("//div[@class='callusWrap']");
		sleepTime(3);
		VerifyURL("https://www.renewbuy.com/p/motor-insurance/car-insurance/");
		ResponseCodeCheck("https://www.renewbuy.com/p/motor-insurance/car-insurance/");
		driver.navigate().back();
		WaitForElementPresent("instantQuoteMotor");
		
		//Compare Car Insurance
		URL_PresentWithResponseCodeCheck("Compare Car Insurance", "https://www.renewbuy.com/p/motor-insurance/car-insurance/compare-car-insurance/");
		//Renew Car Insurance
		URL_PresentWithResponseCodeCheck("Renew Car Insurance", "https://www.renewbuy.com/p/motor-insurance/car-insurance/renew-car-insurance/");
		//Car Insurance Calculator
		URL_PresentWithResponseCodeCheck("Car Insurance Calculator", "https://www.renewbuy.com/p/motor-insurance/car-insurance-calculator/");
		//New Car Insurance
		URL_PresentWithResponseCodeCheck("New Car Insurance", "https://www.renewbuy.com/p/motor-insurance/car-insurance/new-car-insurance/");
		//Car Insurance Claim
		URL_PresentWithResponseCodeCheck("Car Insurance Claim", "https://www.renewbuy.com/p/motor-insurance/car-insurance/car-insurance-claim/");
		//Third Party Insurance
		URL_PresentWithResponseCodeCheck("Third Party Insurance", "https://www.renewbuy.com/p/motor-insurance/car-insurance/third-party-insurance/");
		//Car Insurance FAQs
		URL_PresentWithResponseCodeCheck("Car Insurance FAQs", "https://www.renewbuy.com/p/motor-insurance/car-insurance/faq/");
		
		//Two wheeler insurance
		verifyElementPresent("//*[@class='navList']//*[text()='Two wheeler insurance']", "Two wheeler insurance");
		clickUsingJSExecutor("//*[@class='navList']//*[text()='Two wheeler insurance']", "Two wheeler insurance");
		WaitForElementPresent("//div[@class='callusWrap']");
		sleepTime(3);
		VerifyURL("https://www.renewbuy.com/p/motor-insurance/two-wheeler-insurance/");
		ResponseCodeCheck("https://www.renewbuy.com/p/motor-insurance/two-wheeler-insurance/");
		driver.navigate().back();
		WaitForElementPresent("instantQuoteMotor");
		
		//Compare Bike Insurance
		URL_PresentWithResponseCodeCheck("Compare Bike Insurance", "https://www.renewbuy.com/p/motor-insurance/two-wheeler-insurance/compare-two-wheeler-insurance/");
		//Renew Two Wheeler Insurance
		URL_PresentWithResponseCodeCheck("Renew Two Wheeler Insurance", "https://www.renewbuy.com/p/motor-insurance/two-wheeler-insurance/renew-two-wheeler-insurance/");
		//
		//Validation Msg
		//Without entering any data
		moveMouse(loc_VehicleInput, "");
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
		verifyTextMatches(loc_PurchaseDate_QuotePageInput, "Vehicle Model Quote Page", PurchaseDate.replace("Month",CurerentMonth()));

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
		WaitForElementToClickable(loc_VehicleModel_QuotePageInput);
		sleepTime(3);
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
		clickOn("//*[@id='previous_insurer_edit']/div[1]/div/button", "");
		sleepTime(2);
		verifyDropDownValues(loc_PreviousInsurer_Dropdown, "Previous Insurer Dropdown Value", "Dropdown_Value", 2,25,"innerHTML");
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
		sleepTime(3);
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
		WaitForElementPresent(loc_Company_owned_Checkbox);
		sleepTime(3);
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
        sendKeys(loc_PreviousPolicyEnd_Input, CurerentMonth(), "Enter Month");
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
//        clickOn(loc_Text.replace("@var", Nominee_Age.replace(".0", "")),"Nominee Age");
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
		if(ClientName.contains("DEV")) {
		verifyTextMatches(Loc_ZeroDepreciationField, "Zero Depreciation added in Premium ", "Zero Depreciation");
		}else {
			verifyTextMatches(Loc_ZeroDepreciationField_PRO, "Zero Depreciation added in Premium ", "Zero Depreciation");
		}
		//Key Replacement
		clickOn(Loc_KeyReplacementCheckBox, "Key Replacement CheckBox");
		verifyElementPresent(Loc_Quote_Loading, "Quote Loading");
		WaitForElementPresent(loc_BuyButton);
		sleepTime(3);
		if(ClientName.contains("DEV")) {
		verifyTextMatches(Loc_KeyReplacementFieldPremiumDetails, "Key Replacement added in Premium ", "Key Replacement");
		}else {
			WaitForElementPresent(Loc_KeyReplacementFieldPremiumDetails_PRO);
			sleepTime(10);
			verifyTextMatches(Loc_KeyReplacementFieldPremiumDetails_PRO, "Key Replacement added in Premium ", "Key Replacement");
		}
		testCaseStatus();
		
		
	}	
	
	@Test(groups = {"Regression"}, priority =1,enabled = true,description = "Renewbuy Portal Passanger Cover,24x7 Road Side Assistance") 
	public void TC_04_PassangerCover_RoadSideAssistance() throws Exception {
		WaitForElementPresent(loc_VehicleInput);
		sleepTime(3);
		sendKeys(loc_VehicleInput, VehicleName, "Vehicle Name"); //VehicleName
		sleepTime(2);
		clickOn(loc_Contains_Text.replace("@var",FullVehicleName ), FullVehicleName); //FullVehicleName
		selectDropdownValue(loc_PurchaseYear, "Year", PurchaseYear.replace(".0", ""));
		sleepTime(1);
		clickOn(loc_InstantQuote, "Instant Quote");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_VehicleModel_QuotePageEditButton);	
		
		//Automatic (For best quotes)
		verifyCheckBoxStatus("//input[@name='idv_type']", true, "Automatic (For best quotes) checkbox Check");
		
		//Set your IDV
		verifyCheckBoxStatus("//*[@data-target='idv_manual']//input[@name='idv_type']", false, "Set your IDV checkbox Uncheck");
		
		//Company - owned vehicle?
		verifyCheckBoxStatus("//input[@name='company_owned']", false, "Company - owned vehicle? checkbox Uncheck");
		
        //Insurance claimed this year
		verifyCheckBoxStatus("//input[@name='no_cliam']", false, "Insurance claimed this year checkbox Uncheck");
		
		//Zero Depreciation
		verifyCheckBoxStatus("//input[@name='zero_dep']", false, "Zero Depreciation Checkbox Uncheck");
		
		//Passenger Cover
		verifyCheckBoxStatus("//input[@name='passangerCover']", false, "Passenger Cover Checkbox Uncheck");
		
		//24x7 Road Side Assistance
		verifyCheckBoxStatus("//input[@name='rsaCover']", false, "24x7 Road Side Assistance Checkbox Uncheck");
		
		//Return to Invoice Cover
		verifyCheckBoxStatus("//input[@name='rtiCover']", false, "Return to Invoice Cover Checkbox Uncheck");
		
		//Externally fitted CNG kit?
		verifyCheckBoxStatus("//input[@name='cng']", false, "Externally fitted CNG kit? Checkbox Uncheck");
		
		//I don't Have Policy
		verifyCheckBoxStatus("//input[@name='passangerCover']", false, "I don't Have Policy Checkbox Uncheck");
		
		WaitForElementToClickable(loc_PremiumDetails);
		
		clickOn(Loc_PassengerCover_CheckBox, "PassengerCover CheckBox");
		
		verifyCheckBoxStatus("//input[@name='passangerCover']", true, "Checkbox Uncheck");
		
		WaitForElementToClickable(loc_PremiumDetails);
		
		
		clickOn(loc_PremiumDetails, "Premium Details"); 
		sleepTime(4);
		verifyElementDisplayed(loc_PremiumDetails_Passanger_Cover, "Passanger Cover");
		
       //24x7 Road Side Assistance
		
		clickOn(Loc_RoadSideAssistance_CheckBox, "RoadSideAssistance CheckBox");
		verifyCheckBoxStatus("//input[@name='rsaCover']", true, "24x7 Road Side Assistance Checkbox Uncheck");
		WaitForElementToClickable(loc_PremiumDetails);
		sleepTime(4);
		clickOn(loc_PremiumDetails, "Premium Details");
		WaitForElementPresent(loc_PremiumDetails_RoadSideAssistance, "");
		sleepTime(2);
		verifyElementDisplayed(loc_PremiumDetails_RoadSideAssistance, "Road Side Assistance");
		
		 //24x7 Road Side Assistance - Uncheck
		
		clickOn(Loc_RoadSideAssistance_CheckBox, "RoadSideAssistance CheckBox");
		verifyCheckBoxStatus("//input[@name='rsaCover']", false, "24x7 Road Side Assistance Checkbox Uncheck");
		
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_PremiumDetails);
		sleepTime(10);
		/*clickOn(loc_PremiumDetails, "Premium Details"); 
		sleepTime(2);
		verifyElementNotDisplayed(loc_PremiumDetails_RoadSideAssistance, "Road Side Assistance"); 
		
		clickOn(loc_PremiumDetails3, "2nd Premium Details ");
		sleepTime(4);
		verifyElementNotPresent(loc_PremiumDetails_RoadSideAssistance1, "Road Side Assistance");*/
		
		clickOn(loc_BuyButton, "Buy Button");
    	
    	if(isElementDisplayed(loc_SubmitButton,"Buy Button")) {
    		
    		clickOn(loc_SubmitButton, "Confirm");
    		sleepTime(5);
    	}
    	
    	WaitForElementPresent(loc_TitleDropdown);
		clickOn(loc_TitleDropdown,"Title drop down");
		sleepTime(2);

		verifyElementPresent(Loc_TitleDropdown_Value.replace("@var", "Title"), "Title");
		verifyElementPresent(Loc_TitleDropdown_Value.replace("@var", "Mr."), "M/s");
		verifyElementPresent(Loc_TitleDropdown_Value.replace("@var", "Mrs."), "M/s");
		verifyElementPresent(Loc_TitleDropdown_Value.replace("@var", "Ms."), "M/s");
		clickUsingJSExecutor(loc_TitleDropdown_Select_Mr,"Select Mr.From Title");
		    	
    	//Field
    	verifyTextMatches(loc_PersonalDetails_Header, "Personal Details Header", PersonalDetails_Header);
    	verifyTextMatches(loc_VehicleDetails_Header, "Vehicle Details Header", VehicleDetails_Header);
    	verifyTextMatches(loc_ReviewAndPay_Header, "Review And Pay", ReviewAndPay_Header);    	
    	
    	verifyTextMatches("//*[@id='frmPersonalDetails']/div[1]/div[1]/label", "Title Field", "Title");
    	verifyTextMatches("//*[@id='frmPersonalDetails']/div[1]/div[2]/label", "First Name", "First Name");
    	verifyTextMatches("//*[@id='frmPersonalDetails']/div[1]/div[3]/div/label", "Last Name", "Last Name");
    	verifyTextMatches("//*[@id='frmPersonalDetails']/div[2]/div[1]/label", "Email", "Email");
    	
    	verifyTextMatches("//*[@id='frmPersonalDetails']/div[2]/div[2]/div/label", "Mobile", "Mobile");
    	verifyTextMatches("//*[@id='frmPersonalDetails']/div[3]/div[1]/label", "Date of Birth", "Date of Birth");
    	verifyTextMatches("//*[@id='frmPersonalDetails']/div[3]/div[2]/label", "GSTIN", "GSTIN");
    	verifyTextMatches("//*[@id='frmPersonalDetails']/div[4]/div[1]/label", "Registration Address", "Registration Address");
    	verifyTextMatches("//*[@id='frmPersonalDetails']/div[4]/div[2]/div/label", "Communication Address", "Communication Address");
    	verifyTextMatches("//*[@id='frmPersonalDetails']/div[4]/div[2]/div/div[1]/label", "Same as provided", "Same as provided");
    	verifyCheckBoxStatus("//*[@id='adrsBtn']", true, "Same as provided check box");
    	
    	//Placeholder
    	verifyTextMatches("//*[@id='Fname']", "First Name", "John","placeholder");
    	verifyTextMatches("//*[@id='Lname']", "Last Name", "Doe","placeholder");
    	verifyTextMatches("//*[@id='Email']", "Email", "johndoe@gmail.com","placeholder");
    	verifyTextMatches("//*[@id='mobileNumber']", "Mobile Number", "10 digit mobile number","placeholder");
    	verifyTextMatches("//*[@id='gstin_number']", "GST", "GST Number","placeholder");
    	verifyTextMatches("//*[@id='registrationPincode']", "Pin Code", "Pin Code","placeholder");
    	
    	
    	sendKeys(loc_FirstName, FirstName, "Enter Name");
    	sendKeys(loc_LastName, LastName, "Enter Last Name");
    	
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
         Enter();
         //Pin Code
         sendKeys(loc_PinCodeInput, PinCode, "Enter Pin Code");
         Enter();
         sleepTime(3);
         clickUsingJSExecutor(Loc_NextButton, "Enter Next");
         // 3rd Page 
         WaitForElementPresent(Loc_RegistrationNo_Input);
         sleepTime(4);
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
         sendKeys(loc_PreviousPolicyEnd_Input, CurerentMonth(), "Enter Month");
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
         verifyCheckBoxStatus("//input[@id='tc']", false, "Terms & Conditions Checkbox");
         clickOn(loc_TermsAndConditionsCheckBox, "TC");
         sleepTime(1);
         verifyCheckBoxStatus("//input[@id='tc']", true, "Terms & Conditions Checkbox");
         sleepTime(2);
         clickUsingJSExecutor(Loc_NextButton, "Enter Next");
         WaitForElementPresent("//*[@class='btnSubmit yesButton']");
         clickOn(loc_SubmitButton, "Confirm");
      
        
         WaitForElementPresent(Loc_NewIndiaAssurancePaymentPage);
         sleepTime(5);

         
         
         
         
         
         
         
         
		
		
		testCaseStatus();
	}

	@Test(groups = {"Regression"}, priority =1,enabled = true,description = "Renewbuy Portal Existing No Claim Bonus (NCB)") 
	public void TC_05_NCB() throws Exception {
		
		sendKeys(loc_VehicleInput, VehicleName, "Vehicle Name"); //VehicleName
		clickOn(loc_Contains_Text.replace("@var",FullVehicleName ), FullVehicleName); //FullVehicleName
		selectDropdownValue(loc_PurchaseYear, "Year", "2014");
		clickOn(loc_InstantQuote, "Instant Quote");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_PremiumDetails);	
		//0- NCB 
		clickOn(loc_NCB_0, "NCB 0%");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_PremiumDetails);	
		
		WaitForElementPresent(loc_PremiumDetails);
		clickOn(loc_PremiumDetails, "Premium Details"); 
		sleepTime(2);
		verifyTextMatches(Loc_NoClaimDiscount_Value, "NCB value", "20%");
		
		//20 - NCB
		clickOn(loc_NCB_20, "NCB 20%");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_PremiumDetails);
		clickOn(loc_PremiumDetails, "Premium Details"); 
		sleepTime(2);
		verifyTextMatches(Loc_NoClaimDiscount_Value, "NCB value", "25%");
		
		//25% - NCB
		clickOn(loc_NCB_25, "NCB 25%");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_PremiumDetails);
		clickOn(loc_PremiumDetails, "Premium Details"); 
		sleepTime(2);
		verifyTextMatches(Loc_NoClaimDiscount_Value, "NCB value", "35%");
		
		//35% - NCB
		clickOn(loc_NCB_35, "NCB 35%");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_PremiumDetails);
		clickOn(loc_PremiumDetails, "Premium Details"); 
		sleepTime(2);
		verifyTextMatches(Loc_NoClaimDiscount_Value, "NCB value", "45%");
		
		
		//50% - NCB
		clickOn(loc_NCB_45, "NCB 45%");
		WaitForElementToClickable(loc_BuyButton);
		WaitForElementToClickable(loc_PremiumDetails);
		clickOn(loc_PremiumDetails, "Premium Details"); 
		WaitForElementPresent(Loc_NoClaimDiscount_Value);
		sleepTime(2);
		verifyTextMatches(Loc_NoClaimDiscount_Value, "NCB value", "50%");
		testCaseStatus();
	}
	
	//Need to add CNG
}