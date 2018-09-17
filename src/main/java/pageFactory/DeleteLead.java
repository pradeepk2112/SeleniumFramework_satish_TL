package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteLead extends AbstractPage {
	public DeleteLead(){
		PageFactory.initElements(eventDriver, this);		
	}
	

	@FindBy(how=How.LINK_TEXT,using="Leads")
	WebElement leads;
	
	public DeleteLead clickLeads(){
		click(leads);
		return this;		
	}
	
	@FindBy(how=How.LINK_TEXT,using="Find Leads")
	WebElement findLeads;
	public DeleteLead clickFindLeads(){
		click(findLeads);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Phone')]")
	WebElement phone;
	
	public DeleteLead clickPhone(){
		click(phone);
		return this;
	}
	
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Find Leads')]")
	WebElement findLeads1;
	public DeleteLead selectSource(){
		click(findLeads1);
		return this;
	}
	
	String s=getText(locateElement("xpath","//*[@class='x-grid3-row-table']//a"));
	
	@FindBy(how=How.XPATH,using="//*[@class='x-grid3-row-table']//a")
	WebElement clickLeadTable;
	
	public DeleteLead selectMarktCampaign(){
		click(clickLeadTable);
		return this;
	}
	@FindBy(how=How.LINK_TEXT,using="Delete")
	WebElement clickDelete;
	
	public DeleteLead enterPhoneNo(){
		click(clickDelete);
		return this;
	}
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Name and ID')]")
	WebElement clickSearchBox;
	
	public DeleteLead enterEmail(){
		click(clickSearchBox);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='id']")
	WebElement searchLead;
	public DeleteLead enterLead(String lead){
		type(searchLead, s);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Find Leads')]")
	WebElement FindLeadBtn;
	
	public DeleteLead clickFindLeadBtn(){
		click(FindLeadBtn);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Find Leads')]")
	WebElement verifyDeletedLead;
	
	public DeleteLead verifyDeletedLead(){
		verifyText(verifyDeletedLead, "No records to display");
		return this;
	}
	
	
	
	
	
}
