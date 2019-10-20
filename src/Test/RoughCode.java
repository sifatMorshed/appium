package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Resources.ExtentReporterNG;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.tools.ant.util.*;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

//@Test(priority =3, invocationCount =3)
//public void demo1() {
//	System.out.println("Test");
//
//	}
//
//@Test (dependsOnMethods = "demo4", alwaysRun=true)
//public void demo2() {
//System.out.println("End");
//
//}
//
//@Test (priority =4)
//public void demo5() {
//System.out.println("optional");
//
//}

public class RoughCode extends BaseTestNG {
	
	AndroidDriver<AndroidElement> driver;
	
	
//	public AndroidDriver<AndroidElement> driver;
//	 public ExtentHtmlReporter htmlReporter;
//	 public ExtentReports extent;
//	 public ExtentTest test;
//
//	 @BeforeTest
//	 public void setExtent() {
//	  // specify location of the report
//	  //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
//	  
//	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
//
//	  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
//	  htmlReporter.config().setReportName("Functional Testing"); // Name of the report
//	  htmlReporter.config().setTheme(Theme.DARK);
//	  
//	  extent = new ExtentReports();
//	  extent.attachReporter(htmlReporter);
//	  
//	  // Passing General information
//	  extent.setSystemInfo("Host name", "localhost");
//	  extent.setSystemInfo("Environemnt", "Testing");
//	  extent.setSystemInfo("user", "Sifat Morshed");
//	 }

//	 public static String getScreenshot(AndroidDriver driver, String screenshotName) throws IOException {
//	  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//	  TakesScreenshot ts = (TakesScreenshot) driver;
//	  File source = ts.getScreenshotAs(OutputType.FILE);
//	  
//	  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
//	  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
//	  File finalDestination = new File(destination);
//	  FileUtil.copyFile(source, finalDestination);
//	  return destination;
//	 }
	
	//////////////////// "mygp://flexiplan" //////////////////////////
	
	public void scrollToText(String Text) {
		
		 ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator
		("new UiScrollable(new UiSelector().scrollable(true).intstance(0)).scrollIntoView(new UiSelector().text(\""+Text+"\").instance(0))");
		
	}
	
	
	    @Test(priority =1)
	    //@Parameters ("MyGPDeeplink")	   
		public void DATA350mb33Tk () throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
	    	//test = extent.createTest("AppForegroundFlexiplan");
	    	
		AndroidDriver<AndroidElement> driver = Capabilities();
				
		WebDriverWait wait = new WebDriverWait(driver, 180);
		
		AndroidElement offers =driver.findElementByAccessibilityId("Offers");
		
//		AndroidElement AB = driver.findElementById("com.portonics.mygp:id/balanceImage");
//		AB.click();
//		AndroidElement RB = driver.findElementById("com.portonics.mygp:id/UserCreditRemaining");
//		RB.getText();
//		System.out.println(RB.getText());
		
		offers.click();
		
		this.newscroll2();
		
		String selector = "108";
		Dimension size = driver.manage().window().getSize();
		
		  int starty = (int) (size.height * 0.80);
		    //Ending y location set to 20% of the height (near top)
		    int endy = (int) (size.height * 0.20);
		    //x position set to mid-screen horizontally
		    int startx = size.width / 2;
//		    System.out.println(size);
//		    System.out.println(starty);
//		    System.out.println(endy);
//		    System.out.println(startx);
		    
	//	   TouchAction Ts = new TouchAction(driver);
//		   Ts.press(point(startx, starty)).moveTo(point(startx, endy)).release().perform();
		    
		    
		    
		    String input = "6GB";
		    
		  //  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"_555 MB_\"));").click();
		    
//		    ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator
//			("new UiScrollable(new UiSelector().scrollable(true).intstance(0)).scrollIntoView(new UiSelector().text(\""+input+"\").instance(0))").click();
//		   
		  
		    
		    
		   // AndroidElement first= 
		    		
		   
		    	//	driver.findElementByXPath("(//android.widget.RelativeLayout[1]").click();
		    
//		    AndroidElement second = driver.findElementByXPath("(//android.widget.RelativeLayout)[2]");
//		    
//		    Thread.sleep(2000);
//		    
//		    second.click();
//		    
//		    Ts.press(element(first)).moveTo(element(second)).release().perform();
		    
		    		
		    		

		  //  System.out.println(driver.findElementByXPath("(//android.widget.RelativeLayout)[1]").getText());
//		    List<AndroidElement> els6 = driver.findElementsByXPath("//*");
//		    System.out.println(els6);
		    
		 
		 
//		    AndroidElement x1 = (AndroidElement) driver
//		    	    .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
//+ ".resourceId(\"com.portonics.mygp:id/container\")).scrollIntoView("
//+ "new UiSelector().index(\"2\"));");
//		    	x1.click();
		    

		   
		
		//AndroidElement App = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout");
		
		 
//		  Ts.press(point(350, 1000)).moveTo(point(350, 100)).release().perform();
		   
		   Thread.sleep(2000);
		  
//		  List<AndroidElement> allCheckBoxes=driver.findElementsByXPath("//*[@class='android.widget.LinearLayout']");
//
		   //////////////working loop////////////////
		   
//		   List<AndroidElement> textViews = driver.findElementsByXPath("//*[@class='com.portonics.mygp:id/txtTitle']");
//		    for (AndroidElement textView : textViews) {
//		        System.out.println(textView.getText());
//		    }
		    
		   
//		    List<AndroidElement> profile = driver.findElements(MobileBy.xpath(("//*[@resource-id=']")));
//		    System.out.println(profile.get(8).getText());
		    
		    
		   
	       // System.out.println(profile.size());
//	        if (!profile.isEmpty()) {
//	            System.out.println(profile.get(8).getText()); // print text in 9th element
//	        }
		    
	
		  
		
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text("+selector+"));"));
		
		
	
		
//		driver.openNotifications();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='DeepLink Test']"))).click();	
		  
		  try {driver.findElementById("com.portonics.mygp:id/UserPhoneNumber").sendKeys(MSISDN);
              driver.findElementByXPath("//android.widget.TextView[@text='Continue']").click(); 
              
              Thread.sleep(10000);} catch (NoSuchElementException e1){}

		System.out.println("1st Test case is successful");
		

		
	    }

	    
	    public void scroll() {
	    	
	    	Dimension dimensions = driver.manage().window().getSize();
    		Double screenHeightStart = dimensions.getHeight() * 0.5;
    		int scrollStart = screenHeightStart.intValue();
    		Double screenHeightEnd = dimensions.getHeight() * 0.2;
    		int scrollEnd = screenHeightEnd.intValue();
	    	
	    	TouchAction Tk=new TouchAction((PerformsTouchActions) driver);
			Tk.press(PointOption.point(0, scrollStart))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(0, scrollEnd))
			.release().perform();
			
//	        Dimension dimensions = driver.manage().window().getSize();
//	        int Startpoint = (int) (dimensions.getHeight() * 0.5);
//	        int scrollEnd = (int) (dimensions.getHeight() * 0.5);
//	        ((AndroidDriver<AndroidElement>) driver).swipe(200, Startpoint,200,scrollEnd,2000); 
			
//	        
//		  System.out.println(SMSAfterPurchase.indexOf("88.99Tk"));
//		  System.out.println(SMSAfterPurchase.indexOf(", valid"));
			
			
 // System.out.println("Data Vloume: "+SMSAfterPurchase.substring(1,4));
//  System.out.println("Pack Price: "+SMSAfterPurchase.substring(SMSAfterPurchase.indexOf("88.99Tk"),4));

		//	//	int i =ArrayUtils.indexOf(InternetPacksx, "26 MB WhatsApp Pack");
//			  for (int x = 0; x < InternetPacksx.length; x ++) {
//			      String subArray[] = InternetPacksx[x]; 
//			      for (int y = 0; y < subArray.length; y ++) {
//			          String item = subArray[y];
//			          String A = InternetPacksx[x][y];
//			          String[] strArray = new String[] {InternetPacksx[x][y]};
			          
//			          Map<String,String> map = new HashMap<String,String>();
//			          map.put(InternetPacksx[x][y]);
			
			
//			  if(!driver.findElementsById("com.android.systemui:id/manage_text").isEmpty()) {
//			  driver.navigate().back(); 
//		    	}
//		   else {
//			  
//		    	}
			
			
			
	    }
	    
	    public void newscroll2 () throws InterruptedException {

	    	 while(driver.findElementsByXPath("//android.widget.TextView[@text='555 MB']").isEmpty()){
		            scroll();
		        }
    		}
	    
	    
	    public class Scrolling {
	    	
	    	public void scrollDown() {
	    	
	    		Dimension dimensions = driver.manage().window().getSize();
	    		Double screenHeightStart = dimensions.getHeight() * 0.5;
	    		int scrollStart = screenHeightStart.intValue();
	    		Double screenHeightEnd = dimensions.getHeight() * 0.2;
	    		int scrollEnd = screenHeightEnd.intValue();
	    		
//	    		TouchAction Ts = new TouchAction(driver);
//			      Ts.press(point(App.getCenter().getX(), (int) ((App.getSize().getHeight())*.8))).moveTo(point(App.getCenter().getX(), (int) ((App.getSize().getHeight())*.2))).release().perform();
	    			
	    		
	    		TouchAction Ts=new TouchAction((PerformsTouchActions) driver);
	    			Ts.press(PointOption.point(0, scrollStart))
	    			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	    			.moveTo(PointOption.point(0, scrollEnd))
	    			.release().perform();
	    	}
	     	    	
	    	public List<WebElement> getItemWebView(){
	    		return (List<WebElement>) driver.findElementByXPath("//android.widget.TextView[@text='555 MB']");
	    	}
	    	
	    	public void scrollTillWebView() throws InterruptedException {
	    		//getItemViews().click();
	    		
	    		while(getItemWebView().size() == 0) {
	    			scrollDown();
	    		}
	    		
	    		if(getItemWebView().size() > 0) {
	    			getItemWebView().get(0).click();
	    		}
	    		Thread.sleep(4000);	
	    		
	    	}
	    }
	}

//	    
//		 @AfterTest
//		 public void endReport() {
//		  extent.flush();
//		 }
//		
//		 @AfterMethod
//		 public void tearDown(ITestResult result) throws IOException {
//		  if (result.getStatus() == ITestResult.FAILURE) {
//		   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
//		   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
////		   String screenshotPath = Login.getScreenshot(driver, result.getName());
////		   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
//		   
//		  } else if (result.getStatus() == ITestResult.SKIP) {
//		   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
//		  }
//		  else if (result.getStatus() == ITestResult.SUCCESS) {
//		   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
//		  }
		  //driver.quit();
//		 }
		 
//}
