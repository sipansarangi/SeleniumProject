package locators;

public interface CommonLocators {

	/*=================================================================================================
			                                    Motor
	=================================================================================================*/
	String loc_Link_MotorInsurance                    = "link=Motor Insurance";
	String loc_Link_HealthInsurance                   = "link=Health Insurance";
	String loc_Link_PersonalAccident                  = "link=Personal Accident";
	String loc_Link_BecomeAgent                       = "link=Become Agent";
	String loc_Link_OneClickRenewal                   = "link=Blog";
	String loc_Link_Blog                              = "link=Blog";
	String loc_Link_Login                             = "link=Login";
	
	
	String loc_Text                                   = "//*[text()='@var']";
	String loc_Contains_Text                          = "//*[contains(text(),'@var')]";
	String loc_VehicleInput                           = "//*[@id='variant']";
	String loc_PurchaseYear                           = "regYear";
	String loc_InstantQuote                           = "instantQuoteMotor";
	String loc_BuyButton                              = "//*[@class='buy_button']";
	String loc_TitleDropdown                          = "//*[@title='Title']";
	String loc_TitleDropdown_Select_Mr                = "//*[@class='dropdown-menu inner']//*[text()='Mr.'] | //*[@class='dropdown-menu inner']//*[text()='M/s']";
	String loc_FirstName                              = "Fname";
	String loc_LastName                               = "Lname";
	String loc_Email                                  = "Email";
	String loc_MobileNumber                           = "mobileNumber";
	String loc_VehicleModel_QuotePage                 = "//*[@id='mod_vehicle_container']/div[1]/div[1]";
	String loc_RegisteredCity_QuotePage               = "//*[@id='mod_vehicle_container']/div[2]/div[1]";
	String loc_PurchaseDate_QuotePage                 = "//*[@id='mod_vehicle_container']/div[3]/div[1]";
	String loc_PreviousInsurer_QuotePage              = "//*[@id='mod_vehicle_container']/div[4]/div[1]";
	String loc_VehicleModel_QuotePageInput            = "//*[@id='vehicle_model']/div[1]";
	String loc_VehicleModel_QuotePageInput1           = "//*[@id='vehicle_model_edit']//input";

	String loc_RegisteredCity_QuotePageInput          = "//*[@id='registered_city']/div[1]";
	String loc_PurchaseDate_QuotePageInput            = "//*[@id='purchase_date']/div[1]";
	String loc_PreviousInsurer_QuotePageInput         = "//*[@id='previous_insurer']/div[1]";
	String loc_VehicleModel_QuotePageEditButton       = "//*[@id='vehicle_model']/div[2]";
	String loc_VehicleModel_QuotePageCancelButton       = "//*[@id='vehicle_model_edit']/div[2]/div[1]";
	
	
	  
	String loc_RegisteredCity_QuotePageEditButton     = "//*[@id='registered_city']/div[2]";
	String loc_PurchaseDate_QuotePageEditButton       = "//*[@id='purchase_date']/div[2]";
	String loc_PreviousInsurer_QuotePageEditButton    = "//*[@id='previous_insurer']/div[2]";
	String loc_PreviousInsurer_Dropdown               = "//*[@id='previous_insurer_edit']//select";
	
	
	
	
	
	String loc_PersonalDetails_Header                 = "//*[@id='pDetails']/div/span";
	String loc_VehicleDetails_Header                  = "//*[@id='vDetails']";
	String loc_ReviewAndPay_Header                    = "//*[@class='poDetails']";
	String loc_VehicleName_Quote3                     = "//ul[@class='infoList']/li[1]";
	String loc_Premium_Quote3                         = "//ul[@class='infoList']/li[2]";
	String loc_DOB_Day                                = "//*[@title='Day']";
	String loc_DOB_Month                              = "//*[@title='Month']";
	String loc_DOB_Year                               = "//*[@data-id='dobYear']";
	String loc_DOB_YearInput                          = "//*[@id='frmPersonalDetails']/div[3]/div[1]/div/div[3]/div/div/div/input";
	String loc_DOB_DayInput                           = "//*[@class='dropdown-menu inner']//*[text()='@var']";
	String loc_DOB_MonthInput                         = "//*[@class='dropdown-menu inner']//*[text()='@var']";
	String Loc_AddressInput                           = "//*[@id='registrationAddress']";
	String loc_PinCodeInput                           = "//*[@id='registrationPincode']";
	String Loc_NextButton                             = "//*[@id='makePayment']";
	String Loc_RegistrationNo                         = "//*[@id='frmVehicleDetails']//*[text()='Registration No.']";
	String Loc_ChassisNo                              = "//*[@id='frmVehicleDetails']//*[text()='Chassis No.']";
	String Loc_EngineNo                               = "//*[@id='frmVehicleDetails']//*[text()='Engine No.']";
	String Loc_ExistingPolicyNo                       = "//*[@id='frmVehicleDetails']//*[text()='Existing Policy No.']";
	String Loc_ExistingInsurer                        = "//*[@id='frmVehicleDetails']//*[text()='Existing Insurer']";
	String Loc_PreviousPolicyExpiryDate               = "//*[@id='frmVehicleDetails']//*[text()='Previous Policy Expiry Date']";
	String Loc_RegistrationNo_Input                   = "//*[@id='registrationNumber']";
	String Loc_ChassisNo_Input                        = "//*[@id='chassisNo']";
	String Loc_EngineNo_Input                         = "//*[@id='engineNo']";
	String Loc_ExistingPolicyNo_Input                 = "//*[@id='previousPolicyNumber']";
	String Loc_ExistingInsurerDropdown                = "//*[@data-id='previousInsurer']";
	String Loc_ExistingInsurer_Input                  = "//*[@class='btn-group bootstrap-select dropup open']//input[@class='form-control']";
	String loc_PreviousPolicyEndDay                   = "//*[@data-id='previousPolicyEndDay']";
	String loc_PreviousPolicyEnd_Input                = "//*[@class='btn-group bootstrap-select dropup open']//input[@class='form-control']";
	String loc_PreviousPolicyEndMonth                 = "//*[@data-id='previousPolicyEndMonth']";
	String loc_PreviousPolicyEndYear                  = "//*[@data-id='previousPolicyEndYear']";
	String loc_PreviousPolicyEndYear_Input            = "//*[@id='frmVehicleDetails']/div[3]/div[3]/div/div/div[3]/div/div/div/input | //*[@id='frmVehicleDetails']/div[3]/div[4]/div/div/div[3]/div/div/div/input";
	String loc_TermsAndConditionsCheckBox             = "//*[@id='tc']";
	String loc_NomineeName                            = "nomineeName";
	String loc_NomineeNameRelation                    = "//*[@data-id='nomineeRelation']";
	String loc_NomineeNameRelation_Select             = "//*[@id='frmPolicyDetails']//span[text()='@var']";
	String loc_Nominee_Age                            = "//*[@data-id='nomineeAge']";
	String loc_SubmitButton                           = "//*[@class='btnSubmit yesButton']";
	String loc_NomineeAge_Input                       = "//*[@id='frmPolicyDetails']/div[1]/div[3]/div[3]/div/div/div/div/input";
	String loc_Company_owned_Checkbox                 = "//*[@id='change_filters']//*[@data-target='company_owned']//span";
	String loc_NCB_Checkbox                           = "//*[@id='ncb_radio']/label";
	String loc_InsuranceClaimedThisYear_Checkbox      = "//*[@id='non_new']//span[@class='btn_custom check_btn']";
	String loc_PremiumDetails                         = "//*[@id='quotes_container']/div[1]/div[2]/div[2]";
	String loc_PremiumDetails1                        = "//*[@id='quotes_container']/div[6]/div[2]/div[3]";
	String loc_PremiumDetails2                        = "//*[@id='quotes_container']/div[3]/div[2]/div[3]";
	String loc_NoClaimDiscount                        = "//*[@id='quotes_container']/div[1]//span[@class='right undefined']";  
	String Loc_PrevPolicyEndDate                      = "//*[@id='prev_pol_date_edit']";
	String Loc_PrevPolicyEndDate_Year                 = "//*[@class='ui-datepicker-year']";
	String Loc_PrevPolicyEndDate_EditButton           = "//*[@data-target='#prev_pol_date_edit']";
	String Loc_PrevPolicyEndDate_Date                 = "//*[@class='ui-datepicker-calendar']//*[text()='8']";
	String Loc_LoadingPage                            = "fetch_quotes";  
	
	String loc_BuyButton_HDFC_Ergo                    = "//div[@data-insurer='HDFC-Ergo']//*[@class='buy_button']"; 
	String loc_BuyButton_NewIndia                     = "//div[@data-insurer='NewIndia']//*[@class='buy_button']"; 
	String loc_BuyButton_TataAig                      = "//div[@data-insurer='TataAig']//*[@class='buy_button']"; 
	String loc_BuyButton_Reliance                     = "//div[@data-insurer='Reliance']//*[@class='buy_button']"; 
	String loc_BuyButton_BajajAllianz                 = "//div[@data-insurer='BajajAllianz']//*[@class='buy_button']"; 
	String loc_BuyButton_Bharti_Axa                   = "//div[@data-insurer='Bharti Axa']//*[@class='buy_button']"; 
	String loc_BuyButton_Iffco_Tokio                  = "//div[@data-insurer='Iffco-Tokio']//*[@class='buy_button']"; 
	String loc_BuyButton_DIGIT                        = "//div[@data-insurer='DIGIT']//*[@class='buy_button']";

	String loc_BuyButton_HDFC_Ergo_ZeroDep            = "//div[@data-insurer='HDFCZERO-ERGO']//*[@class='buy_button']"; 
	String loc_BuyButton_NewIndia_ZeroDep             = "//div[@data-insurer='NewIndia-ZeroDep']//*[@class='buy_button']"; 
	String loc_BuyButton_TataAig_ZeroDep              = "//div[@data-insurer='TataAig-ZeroDep']//*[@class='buy_button']"; 
	String loc_BuyButton_Reliance_ZeroDep             = "//div[@data-insurer='Reliance-zerodep']//*[@class='buy_button']"; 
	String loc_BuyButton_BajajAllianz_ZeroDep         = "//div[@data-insurer='BAJAJALLIANZZERO']//*[@class='buy_button']";
	String loc_BuyButton_Bharti_Axa_ZeroDep           = "//div[@data-insurer='BhartiAxaZeroDep']//*[@class='buy_button']"; 
	String loc_BuyButton_Iffco_Tokio_ZeroDep          = "//div[@data-insurer='Iffco-Tokio-ZeroDep']//*[@class='buy_button']";
	String loc_BuyButton_DIGIT_ZeroDep                = "//div[@data-insurer='DIGIT-ZERODEP']//*[@class='buy_button']";

	String Loc_NewIndiaAssurancePaymentPage           = "//*[@class='box-title'] | //*[@id='logo']";
	String loc_SubmitButton_PaymentPage               = "//*[@id='Button1']";
	String loc_CardNo_PaymentPageInput                = "//*[@id='txtCardNo']";
	String loc_CVV_PaymentPageInput                   = "//*[@id='txtPinNo']";
	
	String loc_InsurerName                            = "//*[@class='tblCommon']//th[1]";
	String loc_PolicyNumber                           = "//*[@class='tblCommon']//th[2]";
	String loc_PremiumPaid                            = "//*[@class='tblCommon']//th[4]";
	String loc_NoClaimBonus                           = "//*[@class='tblCommon']//th[5]";
	String loc_ZeroDepreciation                       = "//*[@class='tblCommon']//th[6]";
	String loc_NextRenewalDate                        = "//*[@class='tblCommon']//th[7]";
	String Loc_previous_insurerEditButton             = "//*[@id='previous_insurer']//div[@class='edit_data modal_pop']";
	String Loc_previous_insurer_Bajaj                 = "//*[@id='previous_insurer_edit']//span[contains(text(),'Bajaj')]";
	String Loc_previous_insurer                       = "//*[@id='previous_insurer_edit']//button[@class='btn dropdown-toggle btn-default']";
	String Loc_Health_Header                          = "//*[@id='heathformWrap']/div/h3";
	String Loc_AlertBox1                              = "//*[@class='content text-center']";
	String Loc_AlertOk_Button                         = "//*[@id='alertBox']//*[@class='btnSubmit']";
	String Loc_Day_Dropdown                           = "//*[@id='purchase_date_edit']//div[1]/div/button";
	String Loc_Month_Dropdown                         = "//*[@id='purchase_date_edit']//div[2]/div/button";
	String Loc_Year_Dropdown                          = "//*[@id='purchase_date_edit']//div[3]/div/button";
	String Loc_Purchase_DateCancelButton              = "//*[@id='purchase_date_edit']//*[text()='Cancel']";
	String Loc_Advanced_search_Field                  = "//*[@class='advanced_search_con']/h3";
	String loc_InsuredDeclaredValue_IDV_Field         = "//*[@id='set_idv_container']/h5";
	String loc_Automatic_For_best_Quotes_Field        = "//*[@id='set_idv_container']/div[2]/label";
	String loc_Set_Your_IDV_Field                     = "//*[@class='card btn_container tooltip_trigger']";
	String loc_CompanyOwnedVehicle_Field              = "//*[@id='change_filters']/div[2]/div[1]/label";
	String loc_Insuranceclaimed_This_Year_Field       = "//*[@id='non_new']/div[1]/label";
	String loc_AdditionalCover_Field                  = "//*[@id='change_filters']/div[3]/div/h5";
	String loc_ZeroDepreciation_Field                 = "//*[@id='change_filters']/div[3]/div/label[1]";
	String Loc_EngineProtectorField                   = "//*[@id='change_filters']/div[3]/div/label[2]";
	String Loc_ConsumablesField                       = "//*[@id='change_filters']/div[3]/div/label[3]";
	String Loc_KeyReplacementField                    = "//*[@id='change_filters']/div[3]/div/label[4]";
	String Loc_KeyReplacementCheckbox                 = "//*[@id='change_filters']/div[3]/div/label[4]";
	
	
	String loc_PassengerCover_Field                       = "//*[@id='change_filters']/div[3]/div/label[5]";
	String loc_RoadSideAssistance_Field                   = "//*[@id='change_filters']/div[3]/div/label[6]";
	String loc_ReturnToInvoiceCover_Field                 = "//*[@id='change_filters']/div[3]/div/label[7]";
	String loc_ExternallyfittedCNGkit_Field               = "//*[@id='change_filters']/div[3]/div/div/label";
	String loc_PrevPolicyDetails_Field                    = "//*[@id='prev_pol_container']/div/h5";
	String loc_IdontHavePolicy_Field                      = "//*[@id='prev_policy_detail']";
	String loc_PrevPolicyEndDate_Field                    = "//*[@id='prev_pol_container']/div/label[2]/div/div[1]";
	String loc_ManufacturingYear_Field                    = "//*[@id='show_offline']/div/h5";
	String loc_Registered_RTO_Data                        = "//*[@id='registered_city']//*[@class='field_data']";
	String loc_Registered_RTO_EditButton                  = "//*[@id='registered_city']/div[2]";
	String loc_Registered_RTO_CancelButton                = "//*[@id='registered_city_edit']/div[2]/div[1]";
	String Loc_Registered_RTO_Input                       = "//*[@id='selectcity']";
//	String Loc_TitleDropdown_Value                        = "//select[@id='salutation']";
	String Loc_TitleDropdown_Value                        = "//*[@class='dropdown-menu inner']//*[text()='@var']";
	String Loc_Quote_Loading                              = "//*[@id='fetch_quotes']"; 
	String loc_ZeroDepreciation_CheckBox                  = "//label[@data-target='zero_dep']//span[@class='btn_custom']";
	String Loc_ZeroDepreciationField                      = "//*[@id='quotes_container']/div[4]/div[2]/div[2]/div[2]/span[1]";
    String Loc_KeyReplacementCheckBox                     = "//*[@id='change_filters']/div[3]/div/label[4]/span[1]";
    String Loc_KeyReplacementFieldPremiumDetails          = "//*[@id='quotes_container']/div[3]/div[2]/div[2]/div[3]/span[1]";
    String Loc_PassengerCover_CheckBox                    = "//*[@id='change_filters']/div[3]/div/label[5]/span[1]";
    String Loc_RoadSideAssistance_CheckBox                = "//*[@id='change_filters']/div[3]/div/label[6]/span[1]";
    String loc_PremiumDetails_Passanger_Cover             = "//*[@id='quotes_container']/div[1]/div[4]/div[1]//*[contains(text(),'Unnamed Passenger Cover')]";
    String loc_PremiumDetails_RoadSideAssistance          = "//*[@id='quotes_container']/div[1]/div[4]/div[1]//*[contains(text(),'RoadSide Assistance')]";
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	============================================================================================================
	                                               Health
	============================================================================================================*/
	String Loc_Home_AgeDropdown                          = "//*[@id='selfAge']";
	String Loc_Home_City                                 = "//*[@id='city']";     
	String Loc_SumInsured                                = "//*[@id='sumInsured']";
	String Loc_InstantQuote_Button                       = "//*[@id='instantQuoteHealth']";
	//Proposer Details
	String Loc_Header_proposerDetails                    = "//*[@href='#proposerDetails']/span[1]";
	
	String loc_EmailID                                   = "//*[@id='proposerDetails']//input[@name='email']";
	String loc_Address                                   = "//*[@id='proposerDetails']//input[@name='communication_addressline1']";
	String loc_Phone_Number                              = "//*[@id='proposerDetails']//input[@name='phone_number']";
	String loc_City_Name                                 = "//*[@id='proposerDetails']//input[@name='city_name']";
	String loc_City_Pincode                              = "//*[@id='proposerDetails']//select[@name='pincode']";
	String loc_Pan_Number                                = "//*[@id='proposerDetails']//input[@name='pan_number']";
	String loc_Aadhar_Number                             = "//*[@id='proposerDetails']//input[@name='aadhar_number']";
	
	
	String loc_Field_EmailID                             = "//*[@id='proposerDetails']//label[@for='email']";
	String loc_Field_Address                             = "//*[@id='proposerDetails']//label[@for='communication_addressline1']";
	String loc_Field_Phone_Number                        = "//*[@id='proposerDetails']//label[@for='phone_number']";
	String loc_Field_City_Name                           = "//*[@id='proposerDetails']//label[@for='city_name']";
	String loc_Field_City_Pincode                        = "//*[@id='proposerDetails']//label[@for='pincode']";
	String loc_Field_Pan_Number                          = "//*[@id='proposerDetails']//label[@for='pan_number']";
	String loc_Field_Aadhar_Number                       = "//*[@id='proposerDetails']//label[@for='aadhar_number']";
	String loc_Submit_Button                             = "//*[@id='submit_first']";
	String loc_Submit_Button1                            = "//*[@id='members_accordian_form']//*[@class='btn nextPanel']";
	String loc_Submit_Button2                            = "//*[@id='nominee_accordian_form']//*[@class='btn nextPanel']";
	String loc_Submit_Button3                            = "//*[@id='medicalFromSubmit']";
	String loc_Submit_Button4                            = "//*[@id='payment_submit']";
	String loc_Submit_Button5                            = "//*[@id='proceedBtn']";
	
	
	
	
	
	
	
	
	
	//Member Details
	String Loc_Header_MemberDetails                      = "//*[@href='#membersDetails']/span[1]";
	
	String Loc_FirstName                                 = "//*[@id='members_accordian_form']//input[@name='members[0][fname]']";
	String Loc_LastName                                  = "//*[@id='members_accordian_form']//input[@name='members[0][lname]']";
	String Loc_DateOfBirth                               = "//*[@id='members_accordian_form']//input[@name='members[0][dob]']";
	String Loc_Gender                                    = "//*[@id='members_accordian_form']//select[@name='members[0][gender]']";
	String Loc_MaritalStatus                             = "//*[@id='members_accordian_form']//select[@name='members[0][marital_status]']";
	String Loc_Height                                    = "//select[@name='members[0][feet]']";
	String Loc_Height1                                   = "//select[@name='members[0][inche]']";
	String Loc_Weight                                    = "//*[@id='members_accordian_form']//input[@name='members[0][weight]']";
	
	String Loc_Field_FirstName                           = "//*[@id='members_accordian_form']//label[@for='members[0][fname]']";
	String Loc_Field_LastName                            = "//*[@id='members_accordian_form']//label[@for='members[0][lname]']";
	String Loc_Field_DateOfBirth                         = "//*[@id='members_accordian_form']//label[@for='members[0][dob]']";
	String Loc_Field_Gender                              = "//*[@id='members_accordian_form']//label[@for='members[0][gender]']";
	String Loc_Field_MaritalStatus                       = "//*[@id='members_accordian_form']//label[@for='members[0][marital_status]']";
	String Loc_Field_Height                              = "//*[@id='members_accordian_form']//label[@for='height_ft']";
	String Loc_Field_Weight                              = "//*[@id='members_accordian_form']//label[@for='members[0][weight]']";
	String Loc_DateOfBirth_Month                         = "//select[@class='ui-datepicker-month']";
	String Loc_DateOfBirth_Year                          = "//select[@class='ui-datepicker-year']";
	String Loc_DateOfBirth_Day                           = "//*[@id='ui-datepicker-div']//*[text()='@var']";
	String Loc_NomineeDetailsFirstName                   = "//*[@name='nominee_fname']";
	String Loc_NomineeDetailsLastName                    = "//*[@name='nominee_lname']";
	String Loc_Field_NomineeDetailsFirstName             = "//label[@for='nominee_fname']";
	String Loc_Field_NomineeDetailsLastName              = "//label[@for='nominee_lname']";
	String Loc_Field_NomineeRelation                     = "//label[@for='nominee_relation']";
	String Loc_NomineeRelation                           = "//select[@name='nominee_relation']";
	String Loc_Header_Nominee_Relation                   = "//*[@href='#nomineeDetails']/span[1]";
	String loc_Nominee_DOB                               = "//*[@id=\"nomineeDetails\"]//*[@name='nominee_dob']";
	String loc_Field_Nominee_DOB                         = "//label[@for='nominee_dob']";
	String loc_NomineeDOB_Month                          = "//select[@class='ui-datepicker-month']";
	String loc_NomineeDOB_Year                           = "//select[@class='ui-datepicker-year']";
	String Loc_OtpInput                                  = "//*[@id='otp_number']";
	String Loc_OTP_SubmitButton                          = "//*[@id='otp_submit']";
	String Loc_Health_Male                               = "//*[@id='heathformWrap']//*[@for='male']";
	String Loc_Health_Female                             = "//*[@id='heathformWrap']//*[@for='female']";
	
	
	
	
	
	
	
}
