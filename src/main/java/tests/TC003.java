package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Annotations;

public class TC003 extends Annotations{
	
	public static WebElement elem;
	
	@Test
	public void deleteLead() throws IOException  {
		
		
		type(locateElement("id","username"),"DemoSalesManager");
		type(locateElement("id","password"), "crmsfa");
		click(locateElement("className","decorativeSubmit"));
		click(locateElement("linkText", "CRM/SFA"));
		click(locateElement("linkText","Leads"));
		click(locateElement("linkText","Find Leads"));
		click(locateElement("xpath","//span[contains(text(),'Phone')]"));
		click(locateElement("xpath","//button[contains(text(),'Find Leads')]"));
		String s=getText(locateElement("xpath","//*[@class='x-grid3-row-table']//a"));
		click(locateElement("xpath","//*[@class='x-grid3-row-table']//a"));
		click(locateElement("linkText","Delete"));
		click(locateElement("linkText","Find Leads"));
		click(locateElement("xpath","//span[contains(text(),'Name and ID')]"));
		type(locateElement("xpath", "//input[@name='id']"),s);
		click(locateElement("xpath","//button[contains(text(),'Find Leads')]"));
		verifyText(locateElement("xpath", "//div[contains(text(),'No records to display')]"), "No records to display");
		
		
}
}
