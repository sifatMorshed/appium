package Resources;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

public class ExtentReportListener extends TestListenerAdapter {
	
 public ExtentHtmlReporter htmlReporter;
 public ExtentReports extent;
 public ExtentTest logger;
 public ExtentTest parenttest;
 public ExtentTest childtest;
 
  
 public void onStart(ITestContext testContext) {
	 
  //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.10.20.60", 80));
  htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/myReport.html");//specify location of the report
  //htmlReporter.setAppendExisting(true);

  htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/test-output/extent-config.xml");
  
  ///C:\App Testing\klov jar\klov-server-master\0.2.5>java -jar klov-0.2.5.jar
ExtentKlovReporter klov = new ExtentKlovReporter("project", "build");
klov.initMongoDbConnection("localhost", 27017);
klov.initKlovServerConnection("http://localhost");
klov.setProjectName("UAT Report");
klov.setReportName("Pack Purchase Testing");
//extent.attachReporter(klov);
//extentReports.attachReporter(klovReporter);
  
  extent=new ExtentReports();
  extent.attachReporter(htmlReporter, klov);
  extent.setSystemInfo("Application", "MyGP");
  extent.setSystemInfo("Host name","localhost");
  extent.setSystemInfo("Environemnt","Testing");
  extent.setSystemInfo("user","Sifat Morshed");
  
  htmlReporter.config().setDocumentTitle("UAT Report"); // Tile of report
  htmlReporter.config().setReportName("Pack Purchase Testing"); // name of the report
  htmlReporter.config().setTheme(Theme.DARK);
 }
 
 public void onTestSuccess(ITestResult tr)
 {
  logger=extent.createTest(tr.getName()); // create new entry in th report
  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted

  String screenshotPath=System.getProperty("user.dir")+"/TestsScreenshots/"+tr.getName()+ ".png";
  
  try {
   logger.pass("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
  } catch (IOException e) {
    e.printStackTrace();
  } 
 }
 
 public void onTestFailure(ITestResult tr)
 {
  logger=extent.createTest(tr.getName()); // create new entry in th report
  logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
  
  String screenshotPath=System.getProperty("user.dir")+"/TestsScreenshots/" +tr.getName()+ ".png";
    
  try {
   logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
  } catch (IOException e) {
    e.printStackTrace();
  } 
  
  logger.log(Status.FAIL, tr.getThrowable().getMessage());
//  message = tr.getThrowable().getMessage();
//  
//  test.log(status, message);;
  
 }
 
 public void onTestSkipped(ITestResult tr)
 {
  logger=extent.createTest(tr.getName()); // create new entry in th report
  logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
 }
 
 public void onFinish(ITestContext testContext)
 {
  extent.flush();
 }
 
 }

