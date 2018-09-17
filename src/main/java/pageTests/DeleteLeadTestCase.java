package pageTests;

import org.openqa.selenium.Platform;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Annotations;
import pageFactory.HomePage;
import pageFactory.LoginPage;

public class DeleteLeadTestCase extends Annotations {
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class");
		excelName="DeleteLead";
		browser="chrome";
		platform=Platform.WIN10;
		version="59.0";
		testCaseName="DeleteLead ";
		testDescription="Deletes a lead";
		authors="Sathish";
		category="Functional";
		
		
	}
	
	
	
	@Test(dataProvider="getExcelData")
	public void deleteLead(){
		
		/*new LoginPage()
		.enterUserName()
		.enterPassword()
		.clickLoginBtn()
		*/
		/*new HomePage()
		.clickCRMSFA()
		.clickCreateLeadLnk()
		.enterCompanyName()
		.enterFirstName()
		.enterLastName()
		.selectSource()
		.selectMarktCampaign()
		.enterPhoneNo()
		.enterEmail()
		.clickCreateLeadBtn()
		.getCreatedLeadValue();*/
	}

}
