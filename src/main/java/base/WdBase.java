package base;

import org.openqa.selenium.WebElement;

public interface WdBase {
	
	/**
	 * 
	 * @param locator - Locator type
	 * @param locatorValue - Corresponding locator value
	 * @return - WebElement 
	 */
	public WebElement locateElement(String locator,String locatorValue);
	/**
	 * 
	 * @param ele - WebElement where text has to be entered
	 * @param text - Actual text to be entered in WebElement
	 */
	public void enterText(WebElement ele, String text);
	/**
	 * 
	 * @param ele-WebElemet to be clicked
	 */
	public void click(WebElement ele);
	/**
	 * 
	 * @param ele - WebElement to identify Dropdown
	 * @param visibleText - Visible text to select from the dropdown
	 */
	public void selectByVisibleText(WebElement ele,String visibleText);
	
	/**
	 * 
	 * @param ele -WebElement to identify Dropdown
	 * @param value- Select from dropdown based on value
	 */
	public void selectByValue(WebElement ele,String value);
	/**
	 * 
	 * @param index - Select from dropdown based on index value
	 */
	public void selectByIndex(int index);
	/**
	 * 
	 * @param index - Switch to Window based on index
	 */
	public void switchToWindow(int index);
	/**
	 * Accept an alert
	 */
	public void alertAccept();
	/**
	 * Dismiss an alert
	 */
	public void alertDismiss();
	/**
	 * Get text from alert
	 */
	public void alertGetText();
	/**
	 * 
	 * @param ele
	 * @param value
	 */
	public void getAttribute(WebElement ele,String value);
	public void alertSendText(String alertText);
	public void switchToFrame();
	public void verifyTitle(String expectedTitle);
	public void getText(WebElement ele);
	public void verifyText(WebElement ele,String expectedText);
	public void invokeApp(String browser);
	/**
	 * @author Dell
	 * closes all the open window in the application
	 */
	public void quitApp();
}