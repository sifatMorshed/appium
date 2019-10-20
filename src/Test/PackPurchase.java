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
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;
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

public class PackPurchase extends BaseTestNG {
	
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
	
	//////////////////// "Data Pack purchase" //////////////////////////
	
    String[][] InternetPacks = { 
		                        {"Emergency 30 MB", "30MB", "0 MB", "0%", "0 Tk", "3 Days", "Null"},
		                        {"350MB + 35 MB Bonus", "350MB", "35 MB", "10%", "33Tk", "3 Days", "28"},
		                        {"1GB +103 MB Bonus", "1GB", "103 MB", "10%", "88.99Tk", "7 Days", "76"},
		                        {"6GB + 615 MB Bonus", "6GB", "615 MB", "10%", "148Tk", "7 Days", "127"},
		                        {"3 GB + 308 MB Bonus", "3 GB", "308 MB", "10%", "108Tk", "7 Days", "93"},
		                        {"1.5GB + 154 MB Bonus", "1.5GB", "154 MB", "10%", "239Tk", "30 Days", "205"},
		                        {"2GB + 205 MB Bonus", "2GB", "205 MB", "10%", "54Tk", "72 Hours", "46"},
		                        {"1GB +103 MB Bonus", "1GB", "103 MB", "10%", "189Tk", "30 Days", "162"},
		                        {"3GB + 308 MB Bonus", "3GB", "308 MB", "10%", "289Tk", "30 Days", "248"},
		                        {"5GB + 512 MB Bonus", "5GB", "512 MB", "10%", "399Tk", "30 Days", "342"},
		                        {"10GB +1 GB Bonus", "10GB", "1 GB", "10%", "189Tk", "7 Days", "170"},
		                        {"3GB(2GB +1GB 4G)", "3GB", "0 MB", "0%", "63Tk", "72 Hours", "54"},
		                        {"500 SMS", "500 any net SMS", "0 MB","0%", "19Tk", "30 Days", "16"},
		                        {"555 MB", "555 MB", "0 MB","0%", "149Tk", "28 Days", "128"},
		                        {"85 MB", "85 MB", "0 MB","0%", "38Tk", "7 Days", "33"},
		                        {"5GB Bioscope Pack", "5 GB", "0 MB","0%", "49Tk", "30 Days", "42"},
		                        {"2GB (1GB+1GB Bioscope)", "2 GB", "0 MB","0%", "101Tk", "7 Days", "Null"},
		                        {"200 SMS", "200 any net SMS", "0 MB","0%", "11.07Tk", "30 Days", "10"},
		                        {"1GB Bioscope Pack", "1 GB", "0 MB","0%", "17.0Tk", "7 Days", "Null"},
		                        {"5 MB", "5MB", "0 MB","0%", "2.62Tk", "3 Days", "Null"},
		                        {"115 MB", "115MB", "0 MB","0%", "58Tk", "30 Days", "50"},
		                        {"30 MB Bioscope Prime Pass", "30 MB", "0 MB","0%", "9Tk", "3 Days", "Null"},
		                        {"26 MB Facebook Pack", "26MB", "0 MB", "0%", "1.57Tk", "3 Days", "Null"},
		                        {"26 MB WhatsApp Pack", "26MB", "0 MB", "0%", "1.57Tk", "3 Days", "Null"},
		                        {"15 GB - Become a Silver STAR", "15 GB", "0 MB","0%", "649Tk", "30 Days", "557"},
		                        {"46MB Video Pack", "46MB", "0 MB", "0%", "6.28Tk", "3 Days", "Null"},
		                        {"86 MB Facebook Pack", "86MB", "0 MB", "0%", "6.28Tk", "7 Days", "Null"},
		                        {"340 MB Facebook Pack", "340MB", "0 MB", "0%", "19Tk", "28 Days", "Null"},
		                        {"30 GB - Become a Silver STAR", "30 GB", "0 MB","0%", "998Tk", "30 Days", "857"},
		                   	   };
    
    String[][] VoicePacks =   { 
						        {"500 Minutes", "500 min", "0 min", "0%", "288 Tk", "30 Days", "226"},
						        {"10 Minutes", "10 min", "0 min", "0%", "6Tk", "6 hours", "0"},
						        {"330 Minutes", "330 min", "0 min", "0%", "199Tk", "30 Days", "156"},
						        {"23 Minutes", "23 min", "0 min", "0%", "14Tk", "16 Hours", "0"},
						        {"160 Minutes", "160 min", "0 min", "0%", "99Tk", "7 Days", "78"},
						        {"90 Minutes + 50 SMS", "90 min", "50 any net SMS", "0%", "53Tk", "7 Days", "42"},
						        {"125 Minutes", "125 min", "0 MB", "0%", "78Tk", "7 Days", "61"},
						        {"200 Minutes", "200 min", "0 MB", "0%", "117Tk", "10 Days", "92"},
						        {"40 Minutes", "40 min", "0 MB", "0%", "24Tk", "24 Hours", "0"},
						        {"400 Minutes", "400 min", "0 MB", "0%", "233Tk", "15 Days", "183"},
						        {"70 Minutes", "70 min", "0 MB", "0%", "44Tk", "4 Days", "35"},
						        {"45 Minutes - Prepaid Only", "45 min", "0 MB", "0%", "33Tk", "7 Days", "26"},
						        {"250 Minutes", "250 min", "0 min", "0%", "150Tk", "7 Days", "0"},
						        {"50 Minutes", "50 min", "0 min","0%", "30Tk", "1 Day", "0"},
						        {"300 Minutes", "300 min", "0 min","0%", "175Tk", "7 Days", "0"},
						   	   };
    
	      public void DataPackPurchaseCommonActivity(AndroidDriver<AndroidElement> driver, String methodName, String platformVersion, String ActualSMS, int i) throws NoSuchElementException, MalformedURLException, InterruptedException, Exception {
		 
		  AllPackCommonActivity Activity= new AllPackCommonActivity();
		  
		  Integer GPPointsBP = Integer.valueOf((driver.findElementById("com.portonics.mygp:id/txtGpPoint").getText()).replaceAll("\\D+",""));
		
		  driver.findElementById("com.portonics.mygp:id/UserInternetBalanceDetails").click();
		  Thread.sleep(2000);
		  Integer InternetVolumeBP = Integer.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
		  
		  if (platformVersion.equals("6")) {
        	  driver.findElementByAccessibilityId("Navigate up").click();
          }
          else {
        	  driver.navigate().back();
          }
		  
		  driver.findElementByAccessibilityId("Offers").click();
		  Activity.scrollDownForData(driver, InternetPacks, i,0);
		  driver.findElementById("com.portonics.mygp:id/tvText").click();
		  driver.findElementByXPath("//android.widget.TextView[@text='Go to Home']").click();
		  Activity.takeReportedScreenshot(driver, methodName);
		  
		  //Thread.sleep(150000);
		  Activity.LogOutActivity(driver);
		  Activity.Login(driver,MSISDN, 1);
		  
		  Integer GPPointsAP = Integer.valueOf((driver.findElementById("com.portonics.mygp:id/txtGpPoint").getText()).replaceAll("\\D+",""));
		  int GPPoints = GPPointsAP-GPPointsBP;
		  
		  driver.findElementById("com.portonics.mygp:id/UserInternetBalanceDetails").click();
		  Thread.sleep(2000);
		  Integer InternetVolumeAP = Integer.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
		  int InternetVolume_With_Bonus_MB= InternetVolumeAP-InternetVolumeBP;

		  String SMS= new AllPackCommonActivity().ReadSMS(driver, platformVersion);
		
          //String SMS= "1GB Internet started successfully with 10% bonus. Total fee 88.99Tk, valid 7 days (Activation + 6 days). To Check Internet balance & validity click mygp.li/check or dial *121*1*4#. To Cancel, dial *121*3041#.";
		
		 // Assert.assertEquals(SMS, driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc=\"Message from GP Internet\"])[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText());
		   // Assert.assertEquals(ActualSMS, SMS);
		    
		    Pattern Data_Volume = Pattern.compile(InternetPacks[i][1]);
	        Pattern Price = Pattern.compile(InternetPacks[i][4]);
	        Pattern Validity = Pattern.compile(InternetPacks[i][5]);
	        Pattern GP_Points = Pattern.compile(InternetPacks[i][6]);
	        Pattern Bonus_Percent = Pattern.compile(InternetPacks[i][3]);
	        Pattern DynamicLink = Pattern.compile("mygp.li/check");
	        
	        Matcher Data_VolumeMatcher = Data_Volume.matcher(SMS);
	        Matcher PriceMatcher = Price.matcher(SMS);
	        Matcher ValidityMatcher = Validity.matcher(SMS);
	        Matcher GP_PointsMatcher = GP_Points.matcher(String.valueOf(GPPoints));
	        Matcher Bonus_PercentMatcher = Bonus_Percent.matcher(SMS);
	        Matcher DynamicLinkMatcher = DynamicLink.matcher(SMS);
	        
	        System.out.println("Pack Name: " + InternetPacks[i][0]);
	        
	        while (Data_VolumeMatcher.find()) 
	        {
	            System.out.println("Data Volume: "+Data_VolumeMatcher.group());
	        }
	        
	        while (PriceMatcher.find()) 
	        {
	            System.out.println("Price: "+PriceMatcher.group());
	        }
	        
	        while (ValidityMatcher.find()) 
	        {
	            System.out.println("Validity: "+ValidityMatcher.group());
	        }
	        
	        while (Bonus_PercentMatcher.find()) 
	        {
	            System.out.println("Bonus_%: "+Bonus_PercentMatcher.group());
	        }
	        
	        while (GP_PointsMatcher.find()) 
	        {
	            System.out.println("GP_Points: "+GP_PointsMatcher.group());
	        }
	        
	        while (DynamicLinkMatcher.find()) 
	        {
	            System.out.println("MyGP Dynamic Link: "+DynamicLinkMatcher.group());
	        }
	        
	        System.out.println("InternetVolume With Bonus MB: " + InternetVolume_With_Bonus_MB); 
	     
	        System.out.println("SMS Text: " + SMS); 

		  //  System.out.println(driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc=\"Message from GP Internet\"])[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText());
		  
	}
	      
	      public void VoicePackPurchaseCommonActivity(AndroidDriver<AndroidElement> driver, String methodName, String platformVersion, String ActualSMS, int i) throws NoSuchElementException, MalformedURLException, InterruptedException, Exception {
	 		 
			  AllPackCommonActivity Activity= new AllPackCommonActivity();
			  
			  Integer GPPointsBP = Integer.valueOf((driver.findElementById("com.portonics.mygp:id/txtGpPoint").getText()).replaceAll("\\D+",""));
			
			  driver.findElementById("com.portonics.mygp:id/UserVoiceBalanceDetails").click();
			  Thread.sleep(2000);
			  Integer MinutesVolumeBP = Integer.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
			  
			  if (platformVersion.equals("6")) {
	        	  driver.findElementByAccessibilityId("Navigate up").click();
	          }
	          else {
	        	  driver.navigate().back();
	          }
			  
			  driver.findElementByAccessibilityId("Offers").click();
			  driver.findElementByAccessibilityId("Minutes").click();
			  Activity.scrollDownForVoice(driver, VoicePacks, i,0);
			  driver.findElementById("com.portonics.mygp:id/tvText").click();
			  driver.findElementByXPath("//android.widget.TextView[@text='Go to Home']").click();
			  Activity.takeReportedScreenshot(driver, methodName);
			  
			  //Thread.sleep(150000);
			  Activity.LogOutActivity(driver);
			  Activity.Login(driver,MSISDN, 1);
			  
			  Integer GPPointsAP = Integer.valueOf((driver.findElementById("com.portonics.mygp:id/txtGpPoint").getText()).replaceAll("\\D+",""));
			  int GPPoints = GPPointsAP-GPPointsBP;
			  
			  driver.findElementById("com.portonics.mygp:id/UserVoiceBalanceDetails").click();
			  Thread.sleep(2000);
			  Integer MinutesVolumeAP = Integer.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
			  int MinutesVolume_With_Bonus_min= MinutesVolumeAP-MinutesVolumeBP;

			  String SMS= new AllPackCommonActivity().ReadSMS(driver, platformVersion);
			
	          //String SMS= "1GB Internet started successfully with 10% bonus. Total fee 88.99Tk, valid 7 days (Activation + 6 days). To Check Internet balance & validity click mygp.li/check or dial *121*1*4#. To Cancel, dial *121*3041#.";
			
			 // Assert.assertEquals(SMS, driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc=\"Message from GP Internet\"])[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText());
			   // Assert.assertEquals(ActualSMS, SMS);
			    
			    Pattern Minutes_Volume = Pattern.compile(VoicePacks[i][1]);
		        Pattern Price = Pattern.compile(VoicePacks[i][4], Pattern.CASE_INSENSITIVE);
		        Pattern Validity = Pattern.compile(VoicePacks[i][5]);
		        Pattern GP_Points = Pattern.compile(VoicePacks[i][6]);
		        Pattern Bonus_Percent = Pattern.compile(VoicePacks[i][3]);
		        Pattern DynamicLink = Pattern.compile("mygp.li/check");
		        
		        Matcher Minutes_VolumeMatcher = Minutes_Volume.matcher(SMS);
		        Matcher PriceMatcher = Price.matcher(SMS);
		        Matcher ValidityMatcher = Validity.matcher(SMS);
		        Matcher GP_PointsMatcher = GP_Points.matcher(String.valueOf(GPPoints));
		        Matcher Bonus_PercentMatcher = Bonus_Percent.matcher(SMS);
		        Matcher DynamicLinkMatcher = DynamicLink.matcher(SMS);
		        
		        System.out.println("Pack Name: " + VoicePacks[i][0]);
		        
		        while (Minutes_VolumeMatcher.find()) 
		        {
		            System.out.println("Voice Volume: "+Minutes_VolumeMatcher.group());
		        }
		        
		        while (PriceMatcher.find()) 
		        {
		            System.out.println("Price: "+PriceMatcher.group());
		        }
		        
		        while (ValidityMatcher.find()) 
		        {
		            System.out.println("Validity: "+ValidityMatcher.group());
		        }
		        
//		        while (Bonus_PercentMatcher.find()) 
//		        {
//		            System.out.println("Bonus_%: "+Bonus_PercentMatcher.group());
//		        }
		        
		        while (GP_PointsMatcher.find()) 
		        {
		            System.out.println("GP_Points: "+GP_PointsMatcher.group());
		        }
		        
		        while (DynamicLinkMatcher.find()) 
		        {
		            System.out.println("MyGP Dynamic Link: "+DynamicLinkMatcher.group());
		        }
		        
//		        System.out.println("MinutesVolume With Bonus MB: " + MinutesVolume_With_Bonus_min); 
		     
		        System.out.println("SMS Text: " + SMS);
		}
	
	        @Test(priority =1)
	        @Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
	      	public void DATAEmergency30MB (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
	          	//test = extent.createTest("AppForegroundFlexiplan");
	      	
	        AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
	      	AllPackCommonActivity Activity= new AllPackCommonActivity();
	      	String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
	      	
	      	int i = new AllPackCommonActivity().RowIndex(InternetPacks, "Emergency 30 MB");

	      	String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";

	      	this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
	      	
	      	System.out.println("1st Test case is successful");

	          }

			@Test(priority =2)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA350MB35MBBonus (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "350MB + 35 MB Bonus");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("2nd Test case is successful");
			
			}
			
			@Test(priority =3)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA1GB103MBBonus (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "1GB +103 MB Bonus");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("3rd Test case is successful");
			
			}
			
			@Test(priority =4)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA6GB615BBonus (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "6GB + 615 MB Bonus");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("4th Test case is successful");
			
			}
			
			@Test(priority =5)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA3GB308MBBonus (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "3 GB + 308 MB Bonus");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("5th Test case is successful");
			
			}
			
			@Test(priority =6)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA1and5GB154MBBonus (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "1.5GB + 154 MB Bonus");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("6th Test case is successful");
			
			}
			
			@Test(priority =7)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA2GB205MBBonus (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "2GB + 205 MB Bonus");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("7th Test case is successful");
			
			}
			
			@Test(priority =8)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA1GB103MBBonus189Tk (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "1GB +103 MB Bonus");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("8th Test case is successful");
			
			}
			
			@Test(priority =9)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA3GB308MBBonus289Tk (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "3GB + 308 MB Bonus");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("9th Test case is successful");
			
			}
			
			@Test(priority =10)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA5GB512MBBonus (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "5GB + 512 MB Bonus");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("10th Test case is successful");
			
			}
			
			@Test(priority =11)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA10GB1GBBonus (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "10GB +1 GB Bonus");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("11th Test case is successful");
			
			}
			
			@Test(priority =12)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA3GB (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "3GB(2GB +1GB 4G)");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("12th Test case is successful");
			
			}
			
			@Test(priority =13)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA500SMS (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "500 SMS");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("13th Test case is successful");
			
			}
			
			@Test(priority =14)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA500SMB (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "500 MB");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("14th Test case is successful");
			
			}
			
			@Test(priority =15)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA5GBBioscopePack (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "5GB Bioscope Pack");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("15th Test case is successful");
			
			}
			
			@Test(priority =16)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA2GBBioscopePack (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "2GB (1GB+1GB Bioscope)");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("16th Test case is successful");
			
			}
			
			@Test(priority =17)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA200SMS (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "200 SMS");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("17th Test case is successful");
			
			}
			
			@Test(priority =18)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA1GBBioscopePack (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "1GB Bioscope Pack");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("18th Test case is successful");
			
			}
			
			@Test(priority =19)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA5MB (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "5 MB");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("19th Test case is successful");
			
			}
			
			@Test(priority =20)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA115MB (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "115 MB");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("20th Test case is successful");
			
			}
			
			@Test(priority =21)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA30MBBioscopePrimePass (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "30 MB Bioscope Prime Pass");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("21st Test case is successful");
			
			}
			
			@Test(priority =22)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA26MBFacebookPack (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "26 MB Facebook Pack");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("22nd Test case is successful");
			
			}
			
			@Test(priority =23)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA26MBWhatsAppPack (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "26 MB WhatsApp Pack");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("23rd Test case is successful");
			
			}
			
			@Test(priority =24)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA15GBBecomeaSilverSTAR (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "15 GB - Become a Silver STAR");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("24th Test case is successful");
			
			}
			
			@Test(priority =25)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA46MBVideoPack (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "46MB Video Pack");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("25th Test case is successful");
			
			}
			
			@Test(priority =26)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA86MBFacebookPack (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "86 MB Facebook Pack");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("26th Test case is successful");
			
			}
			
			@Test(priority =27)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA340MBFacebookPack (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "340 MB Facebook Pack");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("27th Test case is successful");
			
			}
			
			@Test(priority =28)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void DATA30GBBecomeaSilverSTAR (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "30 GB - Become a Silver STAR");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("28th Test case is successful");
			
			}
			
			@Test(priority =29)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE500Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "500 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("29th Test case is successful");
			
			}
			
			@Test(priority =30)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE10Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "10 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("30th Test case is successful");
			
			}
			
			@Test(priority =31)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE330Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "330 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("31th Test case is successful");
			
			}
			
			@Test(priority =32)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE23Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "23 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("32nd Test case is successful");
			
			}
			
			@Test(priority =33)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE160Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "160 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("33rd Test case is successful");
			
			}
			
			@Test(priority =34)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE90Minutes50SMS (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "90 Minutes + 50 SMS");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("34th Test case is successful");
			
			}
			
			@Test(priority =35)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE125Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "125 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("35th Test case is successful");
			
			}
			
			@Test(priority =36)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE200Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "200 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("36th Test case is successful");
			
			}
			
			@Test(priority =37)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE40Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "40 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("37th Test case is successful");
			
			}
			
			@Test(priority =38)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE400Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "400 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("38th Test case is successful");
			
			}
			
			@Test(priority =39)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE70Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "70 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("39th Test case is successful");
			
			}
			
			@Test(priority =40)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE45MinutesPrepaidOnly (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "45 Minutes - Prepaid Only");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("40th Test case is successful");
			
			}
			
			@Test(priority =41)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE250Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "250 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("41st Test case is successful");
			
			}
			
			@Test(priority =42)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE50Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "50 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("42th Test case is successful");
			
			}
			
			@Test(priority =43)
			@Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
			public void VOICE300Minutes (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(VoicePacks, "300 Minutes");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.VoicePackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("43th Test case is successful");
			
			}


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
//		   String screenshotPath = Login.getScreenshot(driver, result.getName());
//		   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
//		   
//		  } else if (result.getStatus() == ITestResult.SKIP) {
//		   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
//		  }
//		  else if (result.getStatus() == ITestResult.SUCCESS) {
//		   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
//		  }
//		  //driver.quit();
//		 }
		 
}
