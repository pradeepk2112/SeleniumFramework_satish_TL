package base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WdMethods extends ListenerImplemention{

	WebDriver driver;
	public static EventFiringWebDriver eventDriver;//It should be public and static->>public because pages will extend it 
	//and static because it will help out in parallel execution 
	WebElement ele;
	Select mySelection;
	String primaryWindow;
	Alert a;
	//
	public WebElement locateElement(String locator,String locatorValue){
		switch(locator){
		case "id":			
			ele=eventDriver.findElement(By.id(locatorValue));
			break;
		case "name":
			ele=eventDriver.findElement(By.name(locatorValue));
			break;
		case "classname":
			ele=eventDriver.findElement(By.className(locatorValue));
			break;
		case "link":
			ele=eventDriver.findElement(By.linkText(locatorValue));
			break;
		case "partiallinktext":
			ele=eventDriver.findElement(By.partialLinkText(locatorValue));
			break;
		case "xpath":
			ele=eventDriver.findElement(By.xpath(locatorValue));
			break;
		case "tagname":
			ele=eventDriver.findElement(By.tagName(locatorValue));
			break;
		case "css":
			ele=eventDriver.findElement(By.cssSelector(locatorValue));
			break;
		case "value":
			ele=eventDriver.findElement(By.xpath("//*[@value='"+locatorValue+"']"));
			break;
		case "type":
			ele=eventDriver.findElement(By.xpath("//*[@type='"+locatorValue+"']"));
			break;

		default:
			System.out.println("Not a Valid locator!!!!");
			break;
		}
		return ele;
	}

	public void type(WebElement ele, String text){
		ele.sendKeys(text);
	}

	public void click(WebElement ele){
		ele.click();
	}
	public void selectByVisibleText(WebElement ele,String visibleText){
		mySelection=new Select(ele);
		mySelection.selectByVisibleText(visibleText);
	}
	public void selectByValue(WebElement ele,String value){
		mySelection=new Select(ele);
		mySelection.selectByValue(value);
	}
	public void selectByIndex(int index){
		mySelection=new Select(ele);
		mySelection.selectByIndex(index);
	}

	public void switchToWindow(int index){
		Set<String> allWindowHandles=eventDriver.getWindowHandles();
		List<String> allWindows=new ArrayList<String>();
		allWindows.addAll(allWindowHandles);
		eventDriver.switchTo().window(allWindows.get(index));	
	}

	public void alertAccept(){
		a=eventDriver.switchTo().alert();
		a.accept();
	}

	public void alertDismiss(){
		a=eventDriver.switchTo().alert();
		a.dismiss();
	}
	public void alertGetText(){
		a=eventDriver.switchTo().alert();
		a.getText();
	}

	public void getAttribute(WebElement ele,String value){
		ele.getAttribute(value);
	}
	public void alertSendText(String alertText){
		a=eventDriver.switchTo().alert();
		a.sendKeys(alertText);
	}

	public void switchToFrame(){
		eventDriver.switchTo().frame(ele);
	}

	public void verifyTitle(String expectedTitle){
		String actualTitle=eventDriver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not match");
	}

	public String getText(WebElement ele){
		String text=ele.getText();
		System.out.println("Lead ID" +text);
		return text;
	}

	public void verifyText(WebElement ele,String expectedText){
		String actualText=ele.getText();
		Assert.assertEquals(actualText, expectedText, "Text did not match");

	}

	public void invokeApp(String browser,String URL){

		switch(browser){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
			driver=new ChromeDriver();
			break;


		case "firefox":

			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			break;

		case "ie":
			break;
		default:
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!Invalid Browser!!!!!!!!!!!!!!!!!!!");
			break;
		}
		eventDriver=new EventFiringWebDriver(driver);
		//ListenerImplemention handler=new ListenerImplemention();
		WdMethods handler=new WdMethods();
		eventDriver.register(handler);
		eventDriver.get(URL);
		eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	public void quitApp(){
		eventDriver.quit();
	}

	@Override
	public long takeSnap() {
		long number=(long)Math.floor(Math.random()*900000000L)+98997899989L;
		File srcFile=eventDriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./reports/images/"+number+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;		
	}

	@Override
	public EventFiringWebDriver getEventDriver() {
		// TODO Auto-generated method stub
		return eventDriver;
	}

	
}
