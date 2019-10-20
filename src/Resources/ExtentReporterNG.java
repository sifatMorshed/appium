package Resources;

import java.io.File;
import java.io.IOException;
import java.lang.Exception;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.aspectj.util.FileUtil;
import org.apache.commons.io.FileUtils;

//public class ExtentReporterNG {
//	
//	public ExtentHtmlReporter htmlReporter;
//	public ExtentReports extent;
//	public ExtentTest test;
//
//
//@BeforeTest
//public void setExtent(String AppForegroundFlexiplan) {
// // specify location of the report
// //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
// 
// htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
//
// htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
// htmlReporter.config().setReportName("Functional Testing"); // Name of the report
// htmlReporter.config().setTheme(Theme.DARK);
// 
// extent = new ExtentReports();
// extent.attachReporter(htmlReporter);
// 
// // Passing General information
// extent.setSystemInfo("Host name", "localhost");
// extent.setSystemInfo("Environemnt", "Testing");
// extent.setSystemInfo("user", "Sifat Morshed");
//}
//
//@AfterTest
//public void endReport() {
// extent.flush();
//}
//
//@AfterMethod
//public void tearDown(ITestResult result) throws IOException {
// if (result.getStatus() == ITestResult.FAILURE) {
//  test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
//  test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
////  String screenshotPath = Login.getScreenshot(driver, result.getName());
////  test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
//  
// } else if (result.getStatus() == ITestResult.SKIP) {
//  test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
// }
// else if (result.getStatus() == ITestResult.SUCCESS) {
//  test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
// }
// //driver.quit();
//}

public class ExtentReporterNG implements IReporter {
	
	//public static AndroidDriver<AndroidElement> driver;////////////    !!!!!!!!!!!!
    private ExtentReports extent; ///private static
    private static ExtentKlovReporter klov;
    ExtentHtmlReporter htmlReporter;
 
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)  {
    	
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
       // ExtentKlovReporter klov = new ExtentKlovReporter("project", "build"); ///
        
      htmlReporter.config().setDocumentTitle("UAT Report"); // Title of report
      htmlReporter.config().setReportName("Deep Link Testing"); // Name of the report
      htmlReporter.config().setTheme(Theme.DARK);
        
       extent = new ExtentReports();
//       klov = new ExtentKlovReporter();      ///C:\App Testing\klov jar\klov-server-master\0.2.5>java -jar klov-0.2.5.jar
//       klov.initMongoDbConnection("localhost", 27017);
//       klov.initKlovServerConnection("http://localhost:5689");
//       klov.setProjectName("UAT Report");
//       klov.setReportName("Deep link Testing");
       extent.attachReporter(htmlReporter);
//       extent.attachReporter(klov); ///
        
      extent.setSystemInfo("Application", "MyGP");
      extent.setSystemInfo("Host name", "Localhost");
      extent.setSystemInfo("Environemnt", "Testing");
      extent.setSystemInfo("user", "Sifat Morshed");
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext(); 
					
						buildTestNodes(context.getPassedTests(), Status.PASS);
						buildTestNodes(context.getFailedTests(), Status.FAIL);		
						buildTestNodes(context.getSkippedTests(), Status.SKIP);	
				}
            }
 
        extent.flush();
    }
 
   
    
    public void buildTestNodes( IResultMap tests, Status status)  { //ITestResult result1
        ExtentTest test;
        
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName());
 
test.getModel().setStartTime(getTime(result.getStartMillis()));
test.getModel().setEndTime(getTime(result.getEndMillis()));
 
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
 
                String message = "Test " + status.toString().toLowerCase() + "ed";
                
                
               // try {
					//String screenshotPath = getScreenShot.capture("Screen");
					//test.fail("details").addScreenCaptureFromPath(screenshotPath);
				//	test.log(status, (Markup) test.addScreenCaptureFromPath(screenshotPath));
					
					//test.addScreenCaptureFromPath(screenshotPath);
			//	} catch (IOException e1) {}
 
                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();
 
                test.log(status, message);
               // test.fail("details").addScreenCaptureFromPath("screenshot.png");
                
                
                
//              test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
//              test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
               
              
			
//			
		
		
              
                extent.flush();
          //      extent.endTest(test);
            }
        }
    }
 

    
 
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();        
    }
}



