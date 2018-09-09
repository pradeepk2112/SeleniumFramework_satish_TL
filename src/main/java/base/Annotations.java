package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import dataProvider.ExcelDataProvider;


public class Annotations extends WdMethods {

	public String excelName,testCaseName,testDescription,category,authors;
	public static Properties prop;
	public String browser;
	public Platform platform;
	public String version;
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException{
		System.out.println("Before Suite");
		prop=new Properties();
		prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
		startResult();

	}
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test");
	}
	@BeforeGroups
	public void beforeGroup(){
		System.out.println("Before Group");

	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException{
		startTestCase(testCaseName, testDescription, category, authors);
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName(browser);
		dc.setPlatform(platform);
		dc.setVersion(version);
		if(prop.getProperty("RUN").equalsIgnoreCase("remote1")){
			//new URL--->URL here is java.net
			driver=new RemoteWebDriver(new URL(prop.getProperty("HUB")), dc);
		}
		else{

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
			driver=new ChromeDriver();
		}

		eventDriver=new EventFiringWebDriver(driver);
//		ListenerImplemention handler=new ListenerImplemention();
		WdMethods handler=new WdMethods();
		eventDriver.register(handler);
		eventDriver.get(prop.getProperty("URL"));
		eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*invokeApp("chrome",prop.getProperty("URL"));*/
		type(locateElement("id","username"),"DemoSalesManager");
		type(locateElement("id","password"),"crmsfa");
		click(locateElement("xpath", "//input[@value='Login']"));

	}


	@AfterMethod
	public void afterMethod(){
		endResult();
		//quitApp();
	}
	@AfterClass
	public void afterClass(){
		System.out.println("Before Class");

	}
	@AfterGroups
	public void afterGroup(){
		System.out.println("Before Group");

	}
	@AfterTest
	public void afterTest(){
		System.out.println("Before Test");
	}
	@AfterSuite
	public void afterSuite(){
		System.out.println("After Suite");
		endResult();
	}

	@DataProvider(name="getExcelData")
	public Object[][] data() throws InvalidFormatException, IOException{

		return ExcelDataProvider.getDataFromExcelSheet("./data/"+excelName+".xlsx");

		/*String data[][]=new String[2][2];
		data[0][0]="DemoSalesManager";
		data[1][0]="crmsfa";
		data[1][0]="DemoSalesManager";
		data[1][1]="crmsfa";*/
	}

}
