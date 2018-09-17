package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Annotations;

public class TC001 extends Annotations {

	WebElement ele;
	String leadId;
	WebDriver driver;
	

	@Test
	public void createLead() throws InterruptedException{

		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
		driver=new ChromeDriver();		
		//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		//driver=new FirefoxDriver();		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='crmsfa']")).click();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Create Lead")).click();
		//Thread.sleep(10000);
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CurrentlyGlobally");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sathish");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Natarajan");
		ele=driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select source=new Select(ele);
		source.selectByVisibleText("Conference");
		ele=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select marktCampaign=new Select(ele);
		marktCampaign.selectByVisibleText("Affiliate Sites");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("1234567890");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("testmail@gmail.com");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		//Thread.sleep(10000);
		leadId=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Created Lead" + leadId);
		 */

		
		
		type(locateElement("id","username"),"DemoSalesManager");
		
		type(locateElement("id","password"),"crmsfa");
		
		click(locateElement("xpath", "//input[@value='Login']"));
		
		click(locateElement("xpath", "//div[@class='crmsfa']"));
		
		click(locateElement("link", "Create Lead"));
		
		type(locateElement("id", "createLeadForm_companyName"),"CurrentlyGlobally");

		type(locateElement("id", "createLeadForm_firstName"),"Sathish");
		
		type(locateElement("id", "createLeadForm_lastName"),"Natarajan");
		
		selectByVisibleText(locateElement("id", "createLeadForm_dataSourceId"),"Conference");
		
		selectByVisibleText(locateElement("id", "createLeadForm_marketingCampaignId"),"Affiliate Sites");
		
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"),"1234567890");
		
		type(locateElement("id", "createLeadForm_primaryEmail"),"testmail@gmail.com");
		
		click(locateElement("xpath","//input[@class='smallSubmit']"));
		
		getText(locateElement("id", "viewLead_companyName_sp"));
		
		LoginTest1234.login();
	}


}
