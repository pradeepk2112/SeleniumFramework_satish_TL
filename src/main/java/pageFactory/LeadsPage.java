package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage extends AbstractPage {

	public LeadsPage(){
		PageFactory.initElements(eventDriver, this);
	}

	@FindBy(how=How.LINK_TEXT,using="Create Lead")
	WebElement createLead;
	 public CreateLead clickCreateLeadLnk(){
		 click(createLead);
		 return new CreateLead();
		 
	 }
}
