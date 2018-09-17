package pageTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Annotations;
import pageFactory.LoginPage;

public class LoginTestCase extends Annotations {
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class");
		excelName="Login";
	}
	
	
	@Test(dataProvider="getExcelData")
	public void Login(String userName,String password){
		
		new LoginPage().enterUserName(userName)
		.enterPassword(password)
		.clickLoginBtn();
	}
	
	
	
}
