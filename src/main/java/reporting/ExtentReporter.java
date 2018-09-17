package reporting;

import java.io.File;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class ExtentReporter {

	public static ExtentReports extent;
	public static ExtentTest test;

	public abstract long takeSnap();
	public abstract EventFiringWebDriver getEventDriver();
	public void startResult(){

		extent= new ExtentReports("./reports/ExtentReport.html",true);
		extent.loadConfig(new File("./src/main/resources/extent-config.xml"));
	}

	public void endResult(){
		extent.flush();
	}

	public void startTestCase(String testCaseName,String testDescription,String category,String authors){

		test=extent.startTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);

	}

	public void endTestCase(){
		extent.endTest(test);
	}

	public void reportStep(String desc,String status,boolean bSnap){

		if(bSnap || !status.equalsIgnoreCase("INFO")){
			long snapNumber = 100000l;

			try {
				snapNumber= takeSnap();
			} catch (Exception e) {
				e.printStackTrace();
			}
			desc = desc+test.
					addScreenCapture("./../reports/images/"+snapNumber+".jpg");
		}
		if(status.equalsIgnoreCase("PASS")){
			test.log(LogStatus.PASS, desc);
		}
		else if(status.equalsIgnoreCase("FAIL")){
			test.log(LogStatus.FAIL, desc);
			System.out.println(desc);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!Inside Report Step Fail!!!!!!!!!!!!!!!!!!!!!1");
			throw new RuntimeException("FAILED");
		}
		else if(status.equalsIgnoreCase("WARN")){
			test.log(LogStatus.WARNING, desc);
		}
		else if(status.equalsIgnoreCase("INFO")){
			test.log(LogStatus.INFO, desc);
		}
	}


	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	/*public void reportStep(String desc, String status, boolean bSnap) {

		if(bSnap || !status.equalsIgnoreCase("INFO")){
			long snapNumber = 1000l;

			try {
				snapNumber= takeSnap();
			} catch (Exception e) {
				e.printStackTrace();
			}
			desc = desc+test.
					addScreenCapture("./../reports/Screenshots/"+snapNumber+".jpg");
		}

		// Write if it is successful or failure or information
		if(status.equalsIgnoreCase("PASS")){
			test.log(LogStatus.PASS, desc);
		}else if(status.equalsIgnoreCase("FAIL")){
			test.log(LogStatus.FAIL, desc);
			throw new RuntimeException("FAILED");
		}else if(status.equalsIgnoreCase("WARN")){
			test.log(LogStatus.FAIL, desc);
		}else if(status.equalsIgnoreCase("INFO")){
			test.log(LogStatus.INFO, desc);
		}

	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	public abstract long takeSnap();


	public ExtentReports startResult(){
		extent = new ExtentReports("./reports/report.html", false);
		extent.loadConfig(new File("./src/main/resources/extent-config.xml"));
		return extent;
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription){
		test = extent.startTest(testCaseName, testDescription);
		return test;
	}

	public void endResult(){		
		extent.flush();
	}

	public void endTestcase(){
		extent.endTest(test);
	}

	 */	

}
