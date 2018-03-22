package excelDataBinding;

public interface TestData {

	Excel_Reader xlsInputData = new Excel_Reader(System.getProperty("user.dir") + "\\BusinessUtility\\ExcelDataBinding\\TestData.xlsx");

	String VehicleName                               = xlsInputData.getCellData("RB", "TestData", 2);
	String FullVehicleName                           = xlsInputData.getCellData("RB", "TestData", 3);
	
	String VehicleName1                              = xlsInputData.getCellData("RB", "TestData", 50);
	String FullVehicleName1                          = xlsInputData.getCellData("RB", "TestData", 51);
	
	String VehicleName2                              = xlsInputData.getCellData("RB", "TestData", 71);
	String FullVehicleName2                          = xlsInputData.getCellData("RB", "TestData", 72);
	
	String PurchaseYear                              = xlsInputData.getCellData("RB", "TestData", 4);
	String FirstName                                 = xlsInputData.getCellData("RB", "TestData", 5);
	String LastName                                  = xlsInputData.getCellData("RB", "TestData", 6);
	String MobileNumber                              = xlsInputData.getCellData("RB", "TestData", 7);
	String EmailID                                   = xlsInputData.getCellData("RB", "TestData", 8);
	String City                                      = xlsInputData.getCellData("RB", "TestData", 9);
	String PurchaseDate                              = xlsInputData.getCellData("RB", "TestData", 10);
	String PreviousInsurer                           = xlsInputData.getCellData("RB", "TestData", 11);
	String VehicleModel_Header                       = xlsInputData.getCellData("RB", "TestData", 12);
	String RegisteredRto_Header                      = xlsInputData.getCellData("RB", "TestData", 13);
	String PurchaseDate_Header                       = xlsInputData.getCellData("RB", "TestData", 14);
	String PreviousInsurer_Header                    = xlsInputData.getCellData("RB", "TestData", 15);
	String PersonalDetails_Header                    = xlsInputData.getCellData("RB", "TestData", 16);
	String VehicleDetails_Header                     = xlsInputData.getCellData("RB", "TestData", 17);
	String ReviewAndPay_Header                       = xlsInputData.getCellData("RB", "TestData", 18);
	String Premium_Header                            = xlsInputData.getCellData("RB", "TestData", 19);
	String DOB_Day                                   = xlsInputData.getCellData("RB", "TestData", 20);
	String DOB_Month                                 = xlsInputData.getCellData("RB", "TestData", 21);
	String DOB_Year                                  = xlsInputData.getCellData("RB", "TestData", 22);
	String Address                                   = xlsInputData.getCellData("RB", "TestData", 23);
	String PinCode                                   = xlsInputData.getCellData("RB", "TestData", 24);
	String RegistrationNo                            = xlsInputData.getCellData("RB", "TestData", 25);
	String ChassisNo                                 = xlsInputData.getCellData("RB", "TestData", 26);
	String EngineNo                                  = xlsInputData.getCellData("RB", "TestData", 27);
	String ExistingPolicyNo                          = xlsInputData.getCellData("RB", "TestData", 28);
	String ExistingInsurer                           = xlsInputData.getCellData("RB", "TestData", 29);
	String PreviousPolicyExpiryDate                  = xlsInputData.getCellData("RB", "TestData", 30);
	String RegisteredNo_InputData                    = xlsInputData.getCellData("RB", "TestData", 31);
	String ChassisNo_InputData                       = xlsInputData.getCellData("RB", "TestData", 32);
	String EngineNo_InputData                        = xlsInputData.getCellData("RB", "TestData", 33);
	String ExistingPolicyNo_InputData                = xlsInputData.getCellData("RB", "TestData", 34);
	String ExistingInsurerData                       = xlsInputData.getCellData("RB", "TestData", 35);
	String PreviousPolicyEndDay                      = xlsInputData.getCellData("RB", "TestData", 36);
	String PreviousPolicyEndMonth                    = xlsInputData.getCellData("RB", "TestData", 37);
	String PreviousPolicyEndYear                     = xlsInputData.getCellData("RB", "TestData", 38);
	String NomineeNameRelation                       = xlsInputData.getCellData("RB", "TestData", 39);
	String Nominee_Age                               = xlsInputData.getCellData("RB", "TestData", 40);
	String VehicleName_TwoWheeler                    = xlsInputData.getCellData("RB", "TestData", 41);
	String FullVehicleName_TwoWheeler                = xlsInputData.getCellData("RB", "TestData", 42);
	String Don_have_a_policy_TwoWheeler              = xlsInputData.getCellData("RB", "TestData", 43);
	String InsurerName                               = xlsInputData.getCellData("RB", "TestData", 44);
	String PolicyNumber                              = xlsInputData.getCellData("RB", "TestData", 45);
	String PremiumPaid                               = xlsInputData.getCellData("RB", "TestData", 46);
	String NoClaimBonus                              = xlsInputData.getCellData("RB", "TestData", 47);
	String ZeroDepreciation                          = xlsInputData.getCellData("RB", "TestData", 48);
	String NextRenewalDate                           = xlsInputData.getCellData("RB", "TestData", 49);
	String AlertMsg1                                 = xlsInputData.getCellData("RB", "TestData", 69);
	String AlertMsg2                                 = xlsInputData.getCellData("RB", "TestData", 70);
	String Adv_Search_Field                          = xlsInputData.getCellData("RB", "TestData", 92); 
	String InsuredDeclaredValueIDV_Field             = xlsInputData.getCellData("RB", "TestData", 93); 
	String Automatic_For_best_Quotes_Field           = xlsInputData.getCellData("RB", "TestData", 94); 
	String Set_Your_IDV_Field                        = xlsInputData.getCellData("RB", "TestData", 95);
	String CompanyOwnedVehicle_Field                 = xlsInputData.getCellData("RB", "TestData", 96);
	String Insuranceclaimed_This_Year_Field          = xlsInputData.getCellData("RB", "TestData", 97);
	String AdditionalCover_Field                     = xlsInputData.getCellData("RB", "TestData", 98);
	
    String ZeroDepreciation_Field                    = xlsInputData.getCellData("RB", "TestData", 99);
	String PassengerCover_Field                      = xlsInputData.getCellData("RB", "TestData", 100);
	String RoadSideAssistance_Field                  = xlsInputData.getCellData("RB", "TestData", 101);
	String ReturnToInvoiceCover_Field                = xlsInputData.getCellData("RB", "TestData", 102);
	String ExternallyfittedCNGkit_Field              = xlsInputData.getCellData("RB", "TestData", 103);
	String PrevPolicyDetails_Field                   = xlsInputData.getCellData("RB", "TestData", 104);
	String IdontHavePolicy_Field                     = xlsInputData.getCellData("RB", "TestData", 105);
	String PrevPolicyEndDate_Field                   = xlsInputData.getCellData("RB", "TestData", 106);
	String ManufacturingYear_Field                   = xlsInputData.getCellData("RB", "TestData", 107);
	
	
	
	//Health
	//Proposer Details
	String Field_Email                              = xlsInputData.getCellData("Health", "TestData", 2);
	String Field_FullAddress                        = xlsInputData.getCellData("Health", "TestData", 3);
	String Field_MobileNumber                       = xlsInputData.getCellData("Health", "TestData", 4);
	String Field_City                               = xlsInputData.getCellData("Health", "TestData", 5);
	String Field_PinCode                            = xlsInputData.getCellData("Health", "TestData", 6);
	String Field_PanNumber                          = xlsInputData.getCellData("Health", "TestData", 7);
	String Field_AadhaarNumber                      = xlsInputData.getCellData("Health", "TestData", 8);
	//Member Details
	String Field_FirstName                          = xlsInputData.getCellData("Health", "TestData", 9);
	String Field_LastName                           = xlsInputData.getCellData("Health", "TestData", 10);
	String Field_DateOfBirth                        = xlsInputData.getCellData("Health", "TestData", 11);
	String Field_Gender                             = xlsInputData.getCellData("Health", "TestData", 12);
	String Field_MaritalStatus                      = xlsInputData.getCellData("Health", "TestData", 13);
	String Field_Height                             = xlsInputData.getCellData("Health", "TestData", 14);
	String Field_Weight                             = xlsInputData.getCellData("Health", "TestData", 15);
	String DateOfBirth                              = xlsInputData.getCellData("Health", "TestData", 16);
    //
	String FieldNomineeRelation                     = xlsInputData.getCellData("Health", "TestData", 17);
	String FieldNomineeDOB                          = xlsInputData.getCellData("Health", "TestData", 18);
	String Health_DOB_Year                          = xlsInputData.getCellData("Health", "TestData", 19);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} 
