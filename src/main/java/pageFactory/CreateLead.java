package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateLead extends AbstractPage {
	public CreateLead(){
		PageFactory.initElements(eventDriver, this);		
	}
	

	@FindBy(how=How.ID,using="createLeadForm_companyName")
	WebElement companyName;
	
	public CreateLead enterCompanyName(String cmpName){
		type(companyName, cmpName);
		return this;		
	}
	
	@FindBy(how=How.ID,using="createLeadForm_firstName")
	WebElement firstName;
	public CreateLead enterFirstName(String fName){
		type(firstName,fName);
		return this;
	}
	
	@FindBy(how=How.ID,using="createLeadForm_lastName")
	WebElement lastName;
	
	public CreateLead enterLastName(String lName){
		type(lastName,lName);
		return this;
	}
	
	
	@FindBy(how=How.ID,using="createLeadForm_dataSourceId")
	WebElement source;
	public CreateLead selectSource(String src){
		selectByVisibleText(source, src);
		return this;
	}
	
	@FindBy(how=How.ID,using="createLeadForm_marketingCampaignId")
	WebElement marketingCampaign;
	
	public CreateLead selectMarktCampaign(String mktCmpaign){
		selectByVisibleText(marketingCampaign, mktCmpaign);
		return this;
	}
	@FindBy(how=How.ID,using="createLeadForm_primaryPhoneNumber")
	WebElement phoneNumber;
	
	public CreateLead enterPhoneNo(String phNo){
		type(phoneNumber, phNo);
		return this;
	}
	@FindBy(how=How.ID,using="createLeadForm_primaryEmail")
	WebElement email;
	
	public CreateLead enterEmail(String eMail){
		type(email, eMail);	
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//input[@class='smallSubmit']")
	WebElement submit;
	
	public ViewLead clickCreateLeadBtn(){
		click(submit);
		return new ViewLead();
	}
	
	
}
