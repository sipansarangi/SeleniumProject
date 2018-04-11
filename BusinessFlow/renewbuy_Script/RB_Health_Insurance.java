package renewbuy_Script;

import org.testng.SkipException;
import org.testng.annotations.Test;

import utility.DriverHelper;

public class RB_Health_Insurance extends DriverHelper {
	
	@Test(groups="Smoke",priority =1,enabled = true,description = "")
	public void TC_01() throws Exception {
		
	selectDropdownValue(Loc_Home_AgeDropdown, "Age dropdown", "26");	
	sendKeys(Loc_Home_City, "Delhi", "Enter city");
	clickOn(loc_Text.replace("@var", "Delhi"), "Select Delhi from dropdown");
	selectDropdownValue(Loc_SumInsured, "Sum Insured", "5 Lakhs");
	clickOn(Loc_InstantQuote_Button, "Instant Quote Button");
	WaitForElementPresent(loc_BuyButton);
	
	//Buy 
	isElementDisplayed(loc_BuyButton,"Buy Button");
	WaitForElementPresent(loc_BuyButton);
	if(isElementDisplayed(loc_BuyButton,"Buy Button")) {
	clickOn(loc_BuyButton, "Buy Button");
	
	//Proposer Details
	verifyTextMatches(Loc_Header_proposerDetails, "proposer Details", "Proposer Details");
	
	//Proposer Details Field
	clickOn(loc_EmailID, "EmailID");
	verifyTextMatches(loc_Field_EmailID, "Field EmailID", Field_Email);
	clickOn(loc_Address, "Address");
	verifyTextMatches(loc_Field_Address, "Field Address", Field_FullAddress);
	clickOn(loc_Phone_Number, "Phone Number");
	verifyTextMatches(loc_Field_Phone_Number, "Field Phone Number", Field_MobileNumber);
	
	verifyTextMatches(loc_Field_City_Name, "Field City Name", Field_City);
	
	verifyTextMatches(loc_Field_City_Pincode, "Field City Pincode", Field_PinCode);
	
	verifyTextMatches(loc_Field_Pan_Number, "Field Pan_Number", Field_PanNumber);
	clickOn(loc_Aadhar_Number, "Aadhar Number");
	verifyTextMatches(loc_Field_Aadhar_Number, "Field Aadhar Number", Field_AadhaarNumber);
  
	//Enter Data 
	sendKeys(loc_EmailID, EmailID, "Email Id");
	
	sendKeys(loc_Address, Address, "Address");
	
	sendKeys(loc_Phone_Number, MobileNumber, "Phone Number");
	
	sendKeys(loc_Aadhar_Number, "673678263843", "Aadhar Number");
	
	//Member Details
	verifyTextMatches(Loc_Header_MemberDetails, "Member Details", "Member Details");
	
	clickOn(loc_Submit_Button, "Submit Button");
	WaitForElementPresent(Loc_FirstName);
	sleepTime(2);
	
	//Member Details Field
	clickOn(Loc_FirstName, "FirstName");
	verifyTextMatches(Loc_Field_FirstName, "Field FirstName", Field_FirstName);
	
	clickOn(Loc_LastName, "LastName");
	verifyTextMatches(Loc_Field_LastName, "Field LastName", Field_LastName);
	
	verifyTextMatches(Loc_Field_DateOfBirth, "Field Date Of Birth", Field_DateOfBirth);
	
	verifyTextMatches(Loc_Field_Gender, "Field Gender", Field_Gender);
	
	verifyTextMatches(Loc_Field_MaritalStatus, "Field Marital Status", Field_MaritalStatus);
	
	verifyTextMatches(Loc_Field_Height, "Field Height", Field_Height);
	
	clickOn(Loc_Weight, "Weight");
	verifyTextMatches(Loc_Field_Weight, "Field Weight", Field_Weight);
	
	//Enter Data 
    sendKeys(Loc_FirstName, FirstName, "First Name");
    sendKeys(Loc_LastName, LastName, "Last Name");
    sendKeys(Loc_LastName, LastName, "Last Name");
	
    clickOn(Loc_DateOfBirth, "Date Of Birth");
	selectDropdownValue(Loc_DateOfBirth_Month, "Date Of Birth Month", DOB_Month);
	selectDropdownValue(Loc_DateOfBirth_Year, "Date Of Birth Year", DOB_Year.replace(".0", ""));
	clickOn(Loc_DateOfBirth_Day.replace("@var", "2"), "Date Of Birth Day");

	selectDropdownValue(Loc_Gender, "Gender select", "Male");
	selectDropdownValue(Loc_MaritalStatus, "Marital Status", "Unmarried");
	selectDropdownValue(Loc_Height, "Height", "5");
	selectDropdownValue(Loc_Height1, "Height", "10");
	sendKeys(Loc_Weight, "75", "Weight");
	clickOn(loc_Submit_Button1, "CONTINUE Button");
	//Nominee Details
	verifyTextMatches(Loc_Header_Nominee_Relation, "Nominee Details", "Nominee Details");
	
	//Nominee Details Field
	WaitForElementToClickable(Loc_NomineeDetailsFirstName);
	clickOn(Loc_NomineeDetailsFirstName, "Nominee First Name");
	verifyTextMatches(Loc_Field_NomineeDetailsFirstName, "Nominee First Name", Field_FirstName);
	
	clickOn(Loc_NomineeDetailsLastName, "Nominee Last Name");
	verifyTextMatches(Loc_Field_NomineeDetailsLastName, "Nominee Last Name", Field_LastName);
	
	verifyTextMatches(Loc_Field_NomineeRelation, "Nominee Relation", FieldNomineeRelation);
	
	verifyTextMatches(loc_Field_Nominee_DOB, "Nominee DOB", FieldNomineeDOB);
	
	sendKeys(Loc_NomineeDetailsFirstName, "TestName", "Nominee First Name Input");
	
	sendKeys(Loc_NomineeDetailsLastName, "LastName", "Nominee Last Name Input");
	
	selectDropdownValue(Loc_NomineeRelation, "Nominee Relation", NomineeNameRelation);
	
	clickOn(loc_Nominee_DOB, "Nominee DOB");
	selectDropdownValue(loc_NomineeDOB_Year, "Year", Health_DOB_Year.replace(".0", ""));
	selectDropdownValue(loc_NomineeDOB_Month, "Month", "Dec");
	
	//Select Date
	clickOn(Loc_DateOfBirth_Day.replace("@var", "2"), "Date");
	sleepTime(3);
	clickOn(loc_Submit_Button2, "CONTINUE Button");
	sleepTime(4);
	WaitForElementToClickable(loc_Submit_Button3);
	clickOn(loc_Submit_Button3, "CONTINUE Button");
	
	WaitForElementToClickable(loc_Submit_Button4);
	clickOn(loc_Submit_Button4, "CONTINUE Button");
	
	WaitForElementToClickable(loc_Submit_Button5);
	clickOn(loc_Submit_Button5, "CONTINUE Button");
	
	if(ClientName.contains("DEV")) {
	//OTP
    WaitForElementPresent(Loc_OtpInput);
    sleepTime(2);
	sendKeys(Loc_OtpInput, "123", "OTP input field");
	clickOn(Loc_OTP_SubmitButton, "OTP Submit Button");
	
	WaitForElementToClickable(loc_SubmitButton_PaymentPage);
	clickOn(loc_SubmitButton_PaymentPage, "SubmitButton_PaymentPage");
	sleepTime(3);
	WaitForElementToClickable(loc_SubmitButton_PaymentPage);

	sendKeys(loc_CardNo_PaymentPageInput, "1234567891234566", "Card Number");
	sendKeys(loc_CVV_PaymentPageInput, "123", "CVV");
	clickOn(loc_SubmitButton_PaymentPage, "SubmitButton_PaymentPage");
	WaitForElementPresent(loc_InsurerName);

	verifyTextMatches(loc_InsurerName, "Insurer Name", InsurerName);
	verifyTextMatches(loc_PolicyNumber, "PolicyNumber", PolicyNumber);
	verifyTextMatches(loc_PremiumPaid, "PremiumPaid", PremiumPaid);
	verifyTextMatches(loc_NoClaimBonus, "NoClaimBonus", NoClaimBonus);
	verifyTextMatches(loc_ZeroDepreciation, "ZeroDepreciation", ZeroDepreciation);
	verifyTextMatches(loc_NextRenewalDate, "NextRenewalDate", NextRenewalDate);
	}
	System.out.println();
	}else {
		System.out.println("loading issue");
		throw new SkipException("Skipping this exception due to loading issue");
	}
	testCaseStatus();
	}

}
