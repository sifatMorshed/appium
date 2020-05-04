package Test;

import org.testng.annotations.AfterMethod;
import org.apache.poi.*;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.google.common.collect.ImmutableMap;
import com.opencsv.CSVWriter;

import Resources.ExtentReporterNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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
import io.appium.java_client.AppiumDriver;
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
	
	Date PurchaseTime = new Date();
	String ServiceClass = null;
	String Deeplink = "mygp://pack/internet/";
	//String DeeplinkVoice = "mygp://pack/voice/";
	
	String[] Prepaid = {
						"01308183551",
						"01308183552",
						"01716234749",
						"01315933246",
						"01318300752",
						"01716234802",
						"01740537733",
						"01740537734",
						"01740537735",
						"01740537736",
						"01740537737",
						"01740537738",
						"01740537739",
						"01740537740",
						"01740537741",
						"01740537742",
						"01314245754",
						//"01313208887"
	                   };
	
	String[] Postpaid = {
						"01713219375",
						"01713219376",
						"01713219377",
						"01713219378",
						"01713219379",
						"01713219380",
						"01713219381",
						"01713219382",
						"01713219383",
						"01713219384",
						"01313208887"
           				};
	
	String[] Xplore = {
					   "01714111404",
					  };
	
    String[][] InternetPacks = { 
		                        {"Emergency 30 MB", "353", "30MB", "0 MB", "0%", "0 Tk", "3 Days", "Null", "Null"},
		                        {"350 MB + 35 MB Bonus", "995", "350MB", "35 MB", "10%", "32.99Tk", "3 Days", "28", "mygp.li/check"},
		                        {"1 GB +103 MB Bonus", "65", "1GB", "103 MB", "10%", "88.99Tk", "7 Days", "76", "mygp.li/check"},
		                        {"6 GB + 615 MB Bonus", "404", "6GB", "615 MB", "10%", "147.99Tk", "7 Days", "127", "mygp.li/check"},
		                        {"108TK", "242", "3 GB", "308 MB", "10%", "108.00Tk", "7 Days", "93", "mygp.li/check"},
		                        {"1.5 GB + 154 MB Bonus", "112", "1.5GB", "154 MB", "10%", "247.99Tk", "30 Days", "205", "mygp.li/check"},
		                        {"2 GB + 205 MB Bonus", "992", "2GB", "205 MB", "10%", "54.00Tk", "72 Hours", "46", "mygp.li/check"},
		                        {"1 GB +103 MB Bonus", "491", "1GB", "103 MB", "10%", "189.00Tk", "30 Days", "162", "mygp.li/check"},
		                        {" + 308 MB Bonus", "497", "3GB", "308 MB", "10%", "288.99Tk", "30 Days", "248", "mygp.li/check"},
		                        {"5 GB + 512 MB Bonus", "500", "5GB", "512 MB", "10%", "398.99Tk", "30 Days", "342", "mygp.li/check"},
		                        {"10 GB +1 GB Bonus", "485", "10GB", "1 GB", "10%", "197.99Tk", "7 Days", "170", "mygp.li/check"},
		                        {"3GB(2GB +1GB 4G)", "569", "3GB", "0 MB", "0%", "62.99Tk", "72 Hours", "54", "mygp.li/check"},
		                        {"500 SMS", "662", "500 any net SMS", "0 MB","0%", "19 tk", "30 Days", "16", "Null"},
		                        {"555 MB", "8", "555 MB", "0 MB","0%", "149Tk", "28 Days", "128", "Null"},
		                        {"85 MB", "548", "85 MB", "0 MB","0%", "38Tk", "7 Days", "33", "mygp.li/check"},
		                        {"5GB Bioscope Pack", "464", "5 GB", "0 MB","0%", "49Tk", "30 Days", "42", "mygp.li/check"},
		                        {"2GB (1GB+1GB Bioscope)", "530", "2GB", "0 MB","0%", "100.99Tk", "7 Days", "Null", "Null"},
		                        {"200 SMS", "593", "200 any net SMS", "0 MB","0%", "11.07Tk", "30 Days", "10", "Null"},
		                        {"1GB Bioscope Pack", "641", "1 GB", "0 MB","0%", "17.0Tk", "7 Days", "Null", "Null"},
		                        {"5 MB", "665", "5MB", "0 MB","0%", "2.62Tk", "3 Days", "Null", "mygp.li/check"},
		                        {"115 MB", "7", "115MB", "0 MB","0%", "57.99Tk", "30 Days", "50", "mygp.li/check"},
		                        {"30 MB Bioscope Prime Pass", "533", "30 MB", "0 MB","0%", "8.99Tk", "3 Days", "Null"},
		                        {"26MB Facebook Pack", "430", "26MB", "0 MB", "0%", "1.57Tk", "3 Days", "Null", "mygp.li/check"},
		                        {"26MB WhatsApp Pack", "302", "26MB", "0 MB", "0%", "1.57Tk", "3 Days", "Null", "mygp.li/check"},
		                        {"15 GB - Become a Silver STAR", "503", "15 GB", "0 MB","0%", "649.00Tk", "30 Days", "557", "mygp.li/check"},
		                        {"46MB Video Pack", "419", "46MB", "0 MB", "0%", "6.28Tk", "3 Days", "Null", "mygp.li/check"},
		                        {"90MB Facebook Pack", "416", "86MB", "0 MB", "0%", "6.28Tk", "7 Days", "Null", "mygp.li/check"},
		                        {"340MB Facebook Pack", "407", "340MB", "0 MB", "0%", "19Tk", "28 Days", "Null", "mygp.li/check"},
		                        {"30GB - Become a Silver STAR", "494", "30 GB", "0 MB","0%", "998Tk", "30 Days", "857", "mygp.li/check"},
		                        {"3GB_67TK", "680", "3 GB", "308 MB","10%", "67Tk", "3 Days", "57", "mygp.li/check"},
		                   	   };
    
    //665 884
    //302 800
    
    String[][] VoicePacks =   { 
						        {"500 Minutes", "500 min", "0 min", "0%", "288 Tk", "30 Days", "226"},
						        {"10 Minutes", "10 min", "0 min", "0%", "6Tk", "6 hours", "Null"},
						        {"330 Minutes", "330 min", "0 min", "0%", "199Tk", "30 Days", "156"},
						        {"23 Minutes", "23 min", "0 min", "0%", "14Tk", "16 Hours", "Null"},
						        {"160 Minutes", "160 min", "0 min", "0%", "99Tk", "7 Days", "78"},
						        {"90 Minutes + 50 SMS", "90 min", "50 any net SMS", "0%", "53Tk", "7 Days", "42"},
						        {"125 Minutes", "125 min", "0 MB", "0%", "78Tk", "7 Days", "61"},
						        {"200 Minutes", "200 min", "0 MB", "0%", "117Tk", "10 Days", "92"},
						        {"40 Minutes", "40 min", "0 MB", "0%", "24Tk", "24 Hours", "Null"},
						        {"400 Minutes", "400 min", "0 MB", "0%", "233Tk", "15 Days", "183"},
						        {"70 Minutes", "70 min", "0 MB", "0%", "44Tk", "4 Days", "35"},
						        {"45 Minutes - Prepaid Only", "45 min", "0 MB", "0%", "33Tk", "7 Days", "26"},
						        {"250 Minutes", "250 min", "0 min", "0%", "150Tk", "7 Days", "Null"},
						        {"50 Minutes", "50 min", "0 min","0%", "30Tk", "1 Day", "Null"},
						        {"300 Minutes", "300 min", "0 min","0%", "175Tk", "7 Days", "Null"},
						   	   };
   
	//////////////////// "Data Pack purchase" //////////////////////////
    
	      public void DataPackPurchaseCommonActivity(AndroidDriver<AndroidElement> driver, String methodName, String platformVersion, String ActualSMS, int i) throws NoSuchElementException, MalformedURLException, InterruptedException, Exception, IOException {
		 
		  AllPackCommonActivity Activity= new AllPackCommonActivity();
      
		  //Integer GPPointsBP = Integer.valueOf((driver.findElementById("com.portonics.mygp:id/txtGpPoint").getText()).replaceAll("\\D+",""));
		
		  String PhoneNumber = driver.findElementById("com.portonics.mygp:id/UserPhoneNumber").getText();
	
		  boolean RatePlanPrepaid =  Arrays.asList(Prepaid).contains(PhoneNumber);
		  boolean RatePlanPostpaid =  Arrays.asList(Postpaid).contains(PhoneNumber);
		  boolean RatePlanXplore =  Arrays.asList(Xplore).contains(PhoneNumber);
		 
		  if(RatePlanPrepaid==true) {
			  ServiceClass = "prepaid";
			  System.out.println(ServiceClass);
		  }
		  
		  if(RatePlanPostpaid==true) {
			  ServiceClass = "postpaid";
			  System.out.println(ServiceClass);
		  }
		  
		  if(RatePlanXplore==true) {
			  ServiceClass = "Xplore";
			  System.out.println(ServiceClass);
		  }
	  
		  if (ServiceClass.equals("prepaid")) {

			  driver.findElementById("com.portonics.mygp:id/UserValidTill").click();
			  Thread.sleep(6000);
			  
			  Float AccountBalanceBP = Float.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
			  Float AccountBalanceBPF = Float.valueOf(AccountBalanceBP)/100;
			  
			  driver.findElementByXPath("//android.widget.TextView[@text='Internet']").click();
			  Integer InternetVolumeBP = Integer.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
			  
			  if (platformVersion.equals("6")) {
	        	  driver.findElementByAccessibilityId("Navigate up").click();
	          }
	          else {
	        	  driver.navigate().back();
	          }	    
			  
			  Map<String, Object> command = ImmutableMap.of("command", "am start -a android.intent.action.VIEW -d \"mygp://pack/internet/"+ InternetPacks[i][1] +"\" com.portonics.mygp");
			  driver.executeScript("mobile:shell", command);
		
			  driver.findElementByXPath("//android.widget.TextView[@text='Confirm Purchase']").click();
			  Activity.takeGeneralScreenshot(driver, Location, 0);
			  driver.findElementByXPath("//android.widget.TextView[@text='Go to Home']").click();
			  Activity.takeReportedScreenshot(driver, methodName);
			  
			  driver.findElementById("com.portonics.mygp:id/UserInternetBalanceDetails").click();
			  Thread.sleep(4000);
			  Integer InternetVolumeAP = Integer.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
			  int InternetVolume_With_Bonus_MB= InternetVolumeAP-InternetVolumeBP;
			  
			  driver.findElementByXPath("//android.widget.TextView[@text='Emergency']").click();
			  driver.findElementByXPath("//android.widget.TextView[@text='Main Account']").click();
			  Thread.sleep(6000);
			  
			  Float AccountBalanceAP = Float.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
			  Float AccountBalanceAPF = Float.valueOf(AccountBalanceAP)/100;
	  
			  Float BalanceDeducted= AccountBalanceBPF-AccountBalanceAPF;
			  Double BalanceDeductedF = Math.round(BalanceDeducted * 100.0) / 100.0;
			  
			  String csv = "Prepaid.csv";
		      CSVWriter writer = new CSVWriter(new FileWriter(csv,true));
		      
		      String [] Reportheader = "Service class,Product Nanme,MSISDN,Product ID,Date,MA Before Purchase,MA After Purchase,Charged,DA value before purchase,DA value after purchase,DA value changed,Expected volume,Activation SMS,Bonus SMS".split(",");
		      String [] Purchaserecord = {ServiceClass, InternetPacks[i][0], PhoneNumber, "", PurchaseTime.toString(), String.valueOf(AccountBalanceBPF), String.valueOf(AccountBalanceAPF), String.valueOf(BalanceDeductedF), String.valueOf(InternetVolumeBP), String.valueOf(InternetVolumeAP), String.valueOf(InternetVolume_With_Bonus_MB)};
		        
		      List<String[]> entries = new ArrayList<>();
		   
		      entries.add(Purchaserecord);
		      writer.writeAll(entries);         
		      writer.flush();
		      writer.close();
		  } 
		  
		  else {
			  
			  driver.findElementById("com.portonics.mygp:id/UserValidTill").click();
			  Thread.sleep(8000);
			  
			  Float AccountBalanceBP = Float.valueOf(driver.findElementById("com.portonics.mygp:id/tvPostPaidAvailable").getText().replaceAll("\\D+",""));
			  Float AccountBalanceBPF = Float.valueOf(AccountBalanceBP)/100;
			  
			  driver.findElementByXPath("//android.widget.TextView[@text='Internet']").click();
			  Integer InternetVolumeBP = Integer.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
			  
			  if (platformVersion.equals("6")) {
	        	  driver.findElementByAccessibilityId("Navigate up").click();
	          }
	          else {
	        	  driver.navigate().back();
	          }	    
			  
			  Map<String, Object> command = ImmutableMap.of("command", "am start -a android.intent.action.VIEW -d \"mygp://pack/internet/"+ InternetPacks[i][1] +"\" com.portonics.mygp");
			  driver.executeScript("mobile:shell", command);
		
			  Thread.sleep(2000);
			  driver.findElementByXPath("//android.widget.TextView[@text='Confirm Purchase']").click();
			  Activity.takeGeneralScreenshot(driver, Location, 0);
			  driver.findElementByXPath("//android.widget.TextView[@text='Go to Home']").click();
			  Activity.takeReportedScreenshot(driver, methodName);
			  
			  driver.findElementById("com.portonics.mygp:id/UserInternetBalanceDetails").click();
			  Thread.sleep(4000);
			  Integer InternetVolumeAP = Integer.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
			  int InternetVolume_With_Bonus_MB= InternetVolumeAP-InternetVolumeBP;
			  
			  driver.findElementByXPath("//android.widget.TextView[@text='Main Account']").click();
			  Thread.sleep(8000);
			  
			  Float AccountBalanceAP = Float.valueOf(driver.findElementById("com.portonics.mygp:id/tvPostPaidAvailable").getText().replaceAll("\\D+",""));
			  Float AccountBalanceAPF = Float.valueOf(AccountBalanceAP)/100;
	  
			  Float BalanceDeducted= AccountBalanceBPF-AccountBalanceAPF;
			  Double BalanceDeductedF = Math.round(BalanceDeducted * 100.0) / 100.0;
			  
			  String csv = "Postpaid.csv";
		      CSVWriter writer = new CSVWriter(new FileWriter(csv,true));
		      
		      String [] Reportheader = "Service class,Product Nanme,MSISDN,Product ID,Date,MA Before Purchase,MA After Purchase,Charged,DA value before purchase,DA value after purchase,DA value changed,Expected volume,Activation SMS,Bonus SMS".split(",");
		      String [] Purchaserecord = {ServiceClass, InternetPacks[i][0], PhoneNumber, "", PurchaseTime.toString(), String.valueOf(AccountBalanceBPF), String.valueOf(AccountBalanceAPF), String.valueOf(BalanceDeductedF), String.valueOf(InternetVolumeBP), String.valueOf(InternetVolumeAP), String.valueOf(InternetVolume_With_Bonus_MB)};
		        
		      List<String[]> entries = new ArrayList<>();
		   
		      entries.add(Purchaserecord);
		      writer.writeAll(entries);         
		      writer.flush();
		      writer.close();
		  }

		  
	     
//		  driver.findElementById("com.portonics.mygp:id/UserValidTill").click();
//		  
//		  Float AccountBalanceBP = Float.valueOf(driver.findElementById("com.portonics.mygp:id/tvPostPaidAvailable").getText().replaceAll("\\D+",""));
//		  Thread.sleep(4000);
//		  Float AccountBalanceBPF = Float.valueOf(AccountBalanceBP)/100;
		  
		  
		  
		  //driver.findElementById("com.portonics.mygp:id/UserValidTill").click();
		  
		  //Thread.sleep(3000);
		  
//		  Float AccountBalanceBP = Float.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
//		  Float AccountBalanceBPF = Float.valueOf(AccountBalanceBP)/100;

	
		  
		  //Activity.scrollDownForData(driver, InternetPacks, i,0);
	
		  

//		  Activity.LogOutActivity(driver);
//		  Activity.Login(driver,MSISDN, 1);
		  
//		  Integer GPPointsAP = Integer.valueOf((driver.findElementById("com.portonics.mygp:id/txtGpPoint").getText()).replaceAll("\\D+",""));
//		  int GPPoints = GPPointsAP-GPPointsBP;
		  
		  
		  
		 // 
		  
		  
//		  Float AccountBalanceAP = Float.valueOf(driver.findElementById("com.portonics.mygp:id/tvPostPaidAvailable").getText().replaceAll("\\D+",""));
//		  Thread.sleep(4000);
//		  Float AccountBalanceAPF = Float.valueOf(AccountBalanceAP)/100;
//		  
//		  System.out.println(AccountBalanceAPF);
		  
//		  Float AccountBalanceAP = Float.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
//		  Float AccountBalanceAPF = Float.valueOf(AccountBalanceAP)/100;
		  
//		  Float BalanceDeducted= AccountBalanceBPF-AccountBalanceAPF;
//		  Double BalanceDeductedF = Math.round(BalanceDeducted * 100.0) / 100.0;
		  
		  
		  //System.out.println(BalanceDeductedF);
		    
		 // String SMS= new AllPackCommonActivity().ReadSMS(driver, platformVersion);
		
       //   String SMS= "1GB Internet started successfully with 10% bonus. Total fee 88.99Tk, valid 7 days (Activation + 6 days). To Check Internet balance & validity click mygp.li/check or dial *121*1*4#. To Cancel, dial *121*3041#.";
		
		 // Assert.assertEquals(SMS, driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc=\"Message from GP Internet\"])[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText());
		   // Assert.assertEquals(ActualSMS, SMS);
		    
//		    Pattern Data_Volume = Pattern.compile(InternetPacks[i][1]);
//	        Pattern Price = Pattern.compile(InternetPacks[i][4]);
//	        Pattern Validity = Pattern.compile(InternetPacks[i][5]);
//	        //Pattern GP_Points = Pattern.compile(InternetPacks[i][6]);
//	        Pattern Bonus_Percent = Pattern.compile(InternetPacks[i][3]);
//	        Pattern DynamicLink = Pattern.compile("mygp.li/check");
	        
//	        Matcher Data_VolumeMatcher = Data_Volume.matcher(SMS);
//	        Matcher PriceMatcher = Price.matcher(SMS);
//	        Matcher ValidityMatcher = Validity.matcher(SMS);
//	        //Matcher GP_PointsMatcher = GP_Points.matcher(String.valueOf(GPPoints));
//	        Matcher Bonus_PercentMatcher = Bonus_Percent.matcher(SMS);
//	        Matcher DynamicLinkMatcher = DynamicLink.matcher(SMS);
	        
	        
            
//	        while (Data_VolumeMatcher.find()) 
//	        {
//	            System.out.println("Data Volume: "+Data_VolumeMatcher.group());          
//	        }
//	        
//	        while (PriceMatcher.find()) 
//	        {
//	            System.out.println("Price: "+PriceMatcher.group());
//	        }
//	        
//	        while (ValidityMatcher.find()) 
//	        {
//	            System.out.println("Validity: "+ValidityMatcher.group());
//	        }
//	        
//	        while (Bonus_PercentMatcher.find()) 
//	        {
//	            System.out.println("Bonus_%: "+Bonus_PercentMatcher.group());
//	        }
	        
//	        while (GP_PointsMatcher.find()) 
//	        {
//	            System.out.println("GP_Points: "+GP_PointsMatcher.group());
//	        }
	        
//	        while (DynamicLinkMatcher.find()) 
//	        {
//	            System.out.println("MyGP Dynamic Link: "+DynamicLinkMatcher.group());
//	        }
	        
	        //System.out.println("InternetVolume With Bonus MB: " + InternetVolume_With_Bonus_MB); 
	     
	        //System.out.println("SMS Text: " + SMS); 
	        
	        
	        //System.out.println(Data_VolumeMatcher);
	        
	
            
            //System.out.println("Pack Name: " + InternetPacks[i][0]);
            
//	        	csvWriter.flush();
//	        	csvWriter.close();

		  //  System.out.println(driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc=\"Message from GP Internet\"])[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText());          	      
	      }

	      
	      public void VoicePackPurchaseCommonActivity(AndroidDriver<AndroidElement> driver, String methodName, String platformVersion, String ActualSMS, int i) throws NoSuchElementException, MalformedURLException, InterruptedException, Exception {
	 		 
			  AllPackCommonActivity Activity= new AllPackCommonActivity();
			  
			  Integer GPPointsBP = Integer.valueOf((driver.findElementById("com.portonics.mygp:id/txtGpPoint").getText()).replaceAll("\\D+",""));
			
			  driver.findElementById("com.portonics.mygp:id/UserVoiceBalanceDetails").click();
			  
			  Thread.sleep(2000);
			  Integer MinutesVolumeBP = Integer.valueOf(driver.findElementById("com.portonics.mygp:id/UserBalance").getText().replaceAll("\\D+",""));
			  
			  //System.out.println(driver.findElementById("com.portonics.mygp:id/UserBalance").getText());
			  if (platformVersion.equals("6")) {
	        	  driver.findElementByAccessibilityId("Navigate up").click();
	          }
	          else {
	        	  driver.navigate().back();
	          }
			  
			 // driver.findElementById("com.portonics.mygp:id/action_offers").click();
			
			  driver.findElementByXPath("//android.widget.TextView[@text='Offers']").click();

			 // driver.findElementByAccessibilityId("Offers").click();
			  //driver.findElementByAccessibilityId("Minutes").click();
			  driver.findElementByXPath("//android.widget.TextView[@text='Minutes']").click();
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
			  System.out.println("Pack Name: ");
			  Thread.sleep(2000);
			  Integer MinutesVolumeAP = Integer.valueOf(driver.findElementById("com.portonics.mygp:id//UserBalance").getText().replaceAll("\\D+",""));
			  int MinutesVolume_With_Bonus_min= MinutesVolumeAP-MinutesVolumeBP;
			  
			  System.out.println("wewewe");

			  String SMS= new AllPackCommonActivity().ReadSMS(driver, platformVersion);
			
	          //String SMS= "1GB Internet started successfully with 10% bonus. Total fee 88.99Tk, valid 7 days (Activation + 6 days). To Check Internet balance & validity click mygp.li/check or dial *121*1*4#. To Cancel, dial *121*3041#.";
			
			 // Assert.assertEquals(SMS, driver.findElementByXPath("(//android.widget.FrameLayout[@content-desc=\"Message from GP Internet\"])[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView").getText());
			   // Assert.assertEquals(ActualSMS, SMS);
			    
			    Pattern Minutes_Volume = Pattern.compile(VoicePacks[i][1]);
		        Pattern Price = Pattern.compile(VoicePacks[i][4], Pattern.CASE_INSENSITIVE);
		        Pattern Validity = Pattern.compile(VoicePacks[i][5]);
		       // Pattern GP_Points = Pattern.compile(VoicePacks[i][6]);
		      //  Pattern Bonus_Percent = Pattern.compile(VoicePacks[i][3]);
		        Pattern DynamicLink = Pattern.compile("mygp.li/check");
		        
		        Matcher Minutes_VolumeMatcher = Minutes_Volume.matcher(SMS);
		        Matcher PriceMatcher = Price.matcher(SMS);
		        Matcher ValidityMatcher = Validity.matcher(SMS);
		       // Matcher GP_PointsMatcher = GP_Points.matcher(String.valueOf(GPPoints));
		       // Matcher Bonus_PercentMatcher = Bonus_Percent.matcher(SMS);
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
		        
//		        while (GP_PointsMatcher.find()) 
//		        {
//		            System.out.println("GP_Points: "+GP_PointsMatcher.group());
//		        }
		        
		        while (DynamicLinkMatcher.find()) 
		        {
		            System.out.println("MyGP Dynamic Link: "+DynamicLinkMatcher.group());
		        }
		        
		       System.out.println("MinutesVolume With Bonus MB: " + MinutesVolume_With_Bonus_min); 
		     
		        System.out.println("SMS Text: " + SMS);
		}
	     
	      
	        @Test(priority =1)
	        @Parameters ({"Systemport", "deviceName", "platformVersion", "UDID", "URL_"}) 	
	      	public void DATAEmergency30MB (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
	          	//test = extent.createTest("AppForegroundFlexiplan");
	      	
	        AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
	      	AllPackCommonActivity Activity= new AllPackCommonActivity();
	      	String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
	     
	      	int i = new AllPackCommonActivity().RowIndex(InternetPacks, "5 MB");
//
	      	String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
//
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "350 MB + 35 MB Bonus");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "1 GB +103 MB Bonus");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "6 GB + 615 MB Bonus");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "108TK");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "1.5 GB + 154 MB Bonus");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "2 GB + 205 MB Bonus");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "1 GB +103 MB Bonus");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "3 GB + 308 MB Bonus");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "5 GB + 512 MB Bonus");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "10 GB +1 GB Bonus");
			
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
			public void DATA500MB (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "555 MB");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "26MB Facebook Pack");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "26MB WhatsApp Pack");
			
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
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "90 MB Facebook Pack");
			
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
			public void DATA3GB67TK (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{
				//test = extent.createTest("AppForegroundFlexiplan");
			
			AndroidDriver<AndroidElement> driver = this.Capabilities(Systemport, deviceName, platformVersion, UDID, URL_);
			AllPackCommonActivity Activity= new AllPackCommonActivity();
			String methodName= new Object(){}.getClass().getEnclosingMethod().getName();
			
			int i = new AllPackCommonActivity().RowIndex(InternetPacks, "3GB_67TK");
			
			String ActualSMS = "26MB Messaging Internet started successfully. Total fee 2.61Tk, valid 3 days. To check Internet balance, click mygp.li/check or dial *121*1*4#. To cancel your Internet Pack, dial *121*3041#.";
			
			this.DataPackPurchaseCommonActivity(driver, methodName, platformVersion, ActualSMS, i);
			
			System.out.println("29th Test case is successful");
			
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
