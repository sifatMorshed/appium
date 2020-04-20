package Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class BaseTestNG  {
		
	String[] MSISDN = {"01313208887", "01714121423", "01308183551", "01711086742"}; 
	
	String L = "C:\\Users\\sifat.m.morshed\\Desktop\\Test Screenshot\\PackTesting\\";
	String ReportPath = "C:\\Users\\sifat.m.morshed\\Desktop\\PackReport";
	String[] Location = {L+"Datapack", L+"Internet", L+"Voice", L+"Flexiplan Gift"};
	
	public AndroidDriver<AndroidElement> Capabilities (String Systemport, String deviceName, String platformVersion, String UDID, String URL_) throws MalformedURLException {
		    
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("deviceName", deviceName);
		    desiredCapabilities.setCapability("platformName", "Android");
		    desiredCapabilities.setCapability("udid", UDID);
		    desiredCapabilities.setCapability("systemPort", Systemport);
		    desiredCapabilities.setCapability("appPackage", "com.portonics.mygp");
		    desiredCapabilities.setCapability("appActivity", "com.portonics.mygp.ui.MainActivity");
		    desiredCapabilities.setCapability("noReset", true);
		    desiredCapabilities.setCapability("enableAppiumBehavior", true);
		    desiredCapabilities.setCapability("platformVersion", platformVersion);
		    desiredCapabilities.setCapability("automationName", "UiAutomator2");
		    desiredCapabilities.setCapability("newCommandTimeout", "86400");
		    desiredCapabilities.setCapability("adbExecTimeout", "21000");
		
		    URL remoteUrl = new URL("http://" + URL_);
		   
		    AndroidDriver<AndroidElement>  driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
		    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		    
		    return driver; 
	}	
}
