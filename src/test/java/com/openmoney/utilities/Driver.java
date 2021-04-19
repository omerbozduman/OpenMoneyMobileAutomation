package com.openmoney.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Driver {

    private static AppiumDriver driver;
    private static DesiredCapabilities desiredCapabilities;

    private Driver(){

    }

    public static void setupDriver(){
        String platform= System.getProperty("platform");
        if(platform==null){
            platform=ConfigurationReader.get("platform");
            System.out.println("platform = " + platform);
        }
        platform=platform.toLowerCase();
        switch (platform){
            case "android" :
                desiredCapabilities=new DesiredCapabilities();
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"8.0");
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
                desiredCapabilities.setCapability("adbExecTimeout","20000");
                desiredCapabilities.setCapability("appPackage", ConfigurationReader.get("appPackage"));
                desiredCapabilities.setCapability("appActivity", ConfigurationReader.get("appActivity"));
                //    desiredCapabilities.setCapability(MobileCapabilityType.APP,"/data/app/live.openmoney-c_YJMqXSqqUDAJ9EbpULEg==/base.apk");

                try {
                    driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "android_sauce_labs" :
                desiredCapabilities=new DesiredCapabilities();
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"8.0");
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Samsung Galaxy S6");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
                desiredCapabilities.setCapability("adbExecTimeout","20000");
                desiredCapabilities.setCapability("testobject_api_key"," unknow.....");
                //    desiredCapabilities.setCapability(MobileCapabilityType.APP,"/data/app/live.openmoney-c_YJMqXSqqUDAJ9EbpULEg==/base.apk");

                try {
                    driver = new AppiumDriver<>(new URL("https:saucelabs testobject url"), desiredCapabilities);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;

            case "ios" :
                desiredCapabilities=new DesiredCapabilities();
                desiredCapabilities.setCapability("platform", "iOS");
                desiredCapabilities.setCapability("platformVersion","12.0");
                desiredCapabilities.setCapability("deviceName","iPhone 8");
                desiredCapabilities.setCapability("automationName", "XCUITest");
                desiredCapabilities.setCapability("adbExecTimeout","20000");
                desiredCapabilities.setCapability("udid","32BFC7B2-EDE8-4B73-92D3-3E873C133060");
            //    desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.SAFARI);
            //    desiredCapabilities.setCapability("app", "unkonwn........");
                try {
                    driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "ios_sauce_labs" :
                desiredCapabilities=new DesiredCapabilities();
                desiredCapabilities.setCapability("platform", "iOS");
                desiredCapabilities.setCapability("platformVersion","12.0");
                desiredCapabilities.setCapability("deviceName","iPhone 8");
                desiredCapabilities.setCapability("automationName", "XCUITest");
                desiredCapabilities.setCapability("adbExecTimeout","20000");
                desiredCapabilities.setCapability("adbExecTimeout","20000");
                desiredCapabilities.setCapability("testobject_api_key"," unknow.....");
                //    desiredCapabilities.setCapability(MobileCapabilityType.APP,"/data/app/live.openmoney-c_YJMqXSqqUDAJ9EbpULEg==/base.apk");

                try {
                    driver = new AppiumDriver<>(new URL("https:saucelabs testobject url"), desiredCapabilities);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }

    public static AppiumDriver getDriver(){
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null) {
            driver.quit();
            driver = null;
        }

    }


}
