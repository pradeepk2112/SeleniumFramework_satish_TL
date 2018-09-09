package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Annotations;

public class TC004 extends Annotations{

	WebElement ele;
	String leadId;
	WebDriver driver;

	@Test
	public void mergeLead(){

		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
		driver=new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		driver.findElement(By.xpath("//div[@class='crmsfa']")).click();

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Merge Leads")).click();
		driver.findElement(By.xpath("(//table[@name='ComboBox_partyIdFrom']/following::a)")).click();*/


		type(locateElement("id","username"),"DemoSalesManager");

		type(locateElement("id","password"),"crmsfa");

		click(locateElement("xpath", "//input[@value='Login']"));

		click(locateElement("xpath", "//div[@class='crmsfa']"));

	}
}
