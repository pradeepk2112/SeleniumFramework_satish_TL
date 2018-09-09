package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{

	public LoginPage(){
		PageFactory.initElements(eventDriver, this);

	}

	@FindBy(how=How.ID,using="username")
	WebElement userName;
	
	public LoginPage enterUserName(String uName){		
		type(userName, uName);
		return this;
	}

	@FindBy(how=How.ID,using="password")
	WebElement password;
	
	public LoginPage enterPassword(String pwd){
		type(password, pwd);
		return this;
	}

	@FindBy(how=How.XPATH,using="//input[@value='Login']")
	WebElement login;
	public HomePage clickLoginBtn(){
		click(login);
		return new HomePage();
	}

	
	
}
