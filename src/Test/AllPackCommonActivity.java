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
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.opencsv.CSVWriter;

import Resources.ExtentReporterNG;
import android.animation.ObjectAnimator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
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

public class AllPackCommonActivity extends BaseTestNG {

		public void takeReportedScreenshot(AndroidDriver<AndroidElement> driver, String methodName) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{

		    Thread.sleep(3000);
		      
		    File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		    FileUtil.copyFile(scrfile, new File(System.getProperty("user.dir")+"/TestsScreenshots/"+ methodName + ".png"));
		      
			Thread.sleep(1000);
		}
		
		public void takeGeneralScreenshot(AndroidDriver<AndroidElement> driver, String[] Location, int n) throws MalformedURLException, InterruptedException, Exception, NoSuchElementException{

		    Thread.sleep(3000);
		      
		    File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		    FileUtil.copyFile(scrfile, new File(Location[n]));
		      
			Thread.sleep(1000);
		}
		
	    public void Login(AndroidDriver<AndroidElement> driver, String[] MSISDN, int n) throws InterruptedException, NoSuchElementException {
		    	
	    	   //driver.findElementByXPath("//android.widget.TextView[@text='Login']").click();
	    	   
	    	   driver.findElementById("com.portonics.mygp:id/btnGpID").click();
		    	
	    	   Thread.sleep(3000);
	    	   
	    	   driver.findElements(By.className("android.widget.Button")).get(1).click();

	       try { 
	    		   
	    	   if(driver.findElementByXPath("//android.widget.TextView[@text='Continue']").isDisplayed()) {
    		   
    		   driver.findElementById("com.portonics.mygp:id/UserPhoneNumber").sendKeys(MSISDN[n]);
               driver.findElementByXPath("//android.widget.TextView[@text='Continue']").click(); 
               
               Thread.sleep(10000);
	    	} 
    	   else {
    		   
    	   }}catch (NoSuchElementException e1){}
       } 
	       
	     public void TokenLoginFail(AndroidDriver<AndroidElement> driver, String[] MSISDN, int n) throws InterruptedException, NoSuchElementException {
	    	   
//		    	  try { 
//		    	  driver.findElementByXPath("//android.widget.TextView[@text='Login']").click(); }catch (NoSuchElementException e1){} 
		    	  
	    		   try { if (!driver.findElementsByXPath("//android.widget.TextView[@text='Login']").isEmpty()) {
	    			   
	    			   driver.findElementByXPath("//android.widget.TextView[@text='Login']").click();
	    			   driver.findElementById("com.portonics.mygp:id/UserPhoneNumber").sendKeys(MSISDN[n]);
		               driver.findElementByXPath("//android.widget.TextView[@text='Continue']").click(); 
		               
		               Thread.sleep(10000);
	    		   } 
	    
	    	   else  {
	 
		    	} }catch (NoSuchElementException e1){} 
	       } 
	       
	     public void checkOTPBoxAndLogin(AndroidDriver<AndroidElement> driver, String[] MSISDN, int n) throws InterruptedException, NoSuchElementException {
	    		   
	    		  try { if (!driver.findElementsById("com.portonics.mygp:id/UserPhoneNumber").isEmpty()) {
	    			   
	    			   driver.findElementById("com.portonics.mygp:id/UserPhoneNumber").sendKeys(MSISDN[n]);
		               driver.findElementByXPath("//android.widget.TextView[@text='Continue']").click(); 
		               
		               Thread.sleep(10000);
	    		   }
	    
	    	   else  {
	 
		    	} } catch (NoSuchElementException e1){}
	       }
	       
	    public void LogOutActivity(AndroidDriver<AndroidElement> driver) throws InterruptedException {	
	    	driver.findElementByXPath("//android.widget.TextView[@text='More']").click();
	    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).setSwipeDeadZonePercentage(0.3).scrollIntoView(new UiSelector().text(\"Sign Out\"));").click();
//	    	driver.findElementByAccessibilityId("More").click();
//			driver.findElementByXPath("//android.widget.TextView[@text='Log out']").click();
			Thread.sleep(2000);
	    }
	    
	    public void GuestModeActivity(AndroidDriver<AndroidElement> driver) throws InterruptedException {	
	    	driver.findElementById("com.portonics.mygp:id/btnGuest").click();
			Thread.sleep(2000);
	    }
	    
	    
		public int RowIndex (String[][] array, String target) {
		    for (int i = 0; i < array.length; i++) {
		    	 String subArray[] = array[i]; 
			      for (int j = 0; j < subArray.length; j ++) {
		        if (array[i][j] == target) {
		        	return i;
		        }
		    }  
		    }
		    return -1;
		}
	    
		
	    public void scrollDownForData (AndroidDriver<AndroidElement> driver, String[][] InternetPacks, int i, int j) throws MalformedURLException, InterruptedException  {

	   driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).setSwipeDeadZonePercentage(0.35).scrollIntoView(new UiSelector().text(\""+InternetPacks[i][0]+"\"));").click();
	    }

	    
		public void scrollDownForVoice (AndroidDriver<AndroidElement> driver, String[][] VoicePacks, int i, int j) throws MalformedURLException, InterruptedException  {

			   driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).setSwipeDeadZonePercentage(0.3).scrollIntoView(new UiSelector().text(\""+VoicePacks[i][0]+"\"));").click();
			    }
				
		
	    public String ReadSMS(AndroidDriver<AndroidElement> driver, String platformVersion) throws InterruptedException {
	    	
	    	  WebDriverWait wait = new WebDriverWait(driver, 30);
			  Thread.sleep(3000);
			  driver.openNotifications();
			  
	          if(platformVersion.equals("6")) {
			  
	    	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/title")));
	    	  String SMSAfterPurchase= driver.findElementById("android:id/big_text").getText();
	    	  
	    	  driver.findElementById("android:id/big_text").click();

//			  Thread.sleep(3000);
//	          driver.navigate().back();
//	          
	    	  return SMSAfterPurchase;
	    	  
	          }
	         
			  else {
//				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='GP Internet']")));
//				  String SMSAfterPurchase= driver.findElementById("android:id/message_text").getText();
				  
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/title")));
		    	  String SMSAfterPurchase= driver.findElementById("android:id/big_text").getText();
				  
				 // driver.findElementById("android:id/message_text").click();
		    	  driver.findElementById("android:id/big_text").click();
		    	  

//				  Thread.sleep(3000);
//		          driver.navigate().back();
		          
				  return SMSAfterPurchase;
			  }
	  }
	    
}
		
