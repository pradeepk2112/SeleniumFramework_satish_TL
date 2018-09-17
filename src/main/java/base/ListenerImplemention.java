package base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import reporting.ExtentReporter;

public abstract  class ListenerImplemention extends ExtentReporter implements WebDriverEventListener {
	String errorText=null;

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		//System.out.println("WebElement" +arg0+ " was changed to " +arg2[0]);
		reportStep("WebElement" +arg0+ "was changed to"+arg2[0] , "PASS");

	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("WebElement" +arg0+ " was clicked");

	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {

		System.out.println("Browser" +arg1+ "launched with URL" +arg0);
		reportStep(arg1 +"browser was launched with URL " +arg0, "PASS");

	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		System.out.println("Before Changing Value");
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Before Click");

	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver arg1) {
		switch(throwable.getClass().getSimpleName()){

		case "NoSuchElementException":
			System.out.println("No Sch Elemtn Exep");
			reportStep("Element with " +throwable.getMessage() +"could not be found", "FAIL");
			//reportStep("Element cound not be found", "FAIL");
			/*errorText=(throwable.getMessage());
			String s2[]=new String[100];
			s2=errorText.split({);
			
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Splited Text"+s2.length);*/
			break;
		case "NoSuchWindowException":
			System.out.println("");
			break;
		
		}
		/*if(throwable instanceof NoSuchElementException){
			errorText=(throwable.getMessage());
			System.out.println(errorText);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11Element could not be found with Locator: " +errorText.substring(55,56) +" Value:"+errorText.substring(70,79));
		}
		else if(throwable instanceof NoSuchWindowException){
			System.out.println("Window could not be found" +throwable.getMessage());
		}
		else if(throwable instanceof InvalidSelectorException){
			System.out.println("Xpath is wrong" +throwable.getMessage());
		}
		else if(throwable instanceof InvalidElementStateException){
			System.out.println("");
		}
		else if(throwable instanceof NoSuchElementException){
			System.out.println("");
		}
		else if(throwable instanceof StaleElementReferenceException){
			System.out.println();
		}
*/
		throw new RuntimeException();//to stop the test case execution
	}

	@Override
	public abstract long takeSnap();

	@Override
	public abstract EventFiringWebDriver  getEventDriver();

	

}
