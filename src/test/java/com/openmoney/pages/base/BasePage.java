package com.openmoney.pages.base;

import com.openmoney.utilities.ConfigurationReader;
import com.openmoney.utilities.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

//    public static AppiumDriver<MobileElement> driver;

    public BasePage() {
            PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
        }











//
//
//    public void launchApp() throws MalformedURLException {
//
//        URL appiumServerURL = new URL(ConfigurationReader.get("appiumServerURL"));
//        System.out.println("appiumServerURL = " + appiumServerURL);
//
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        if (ConfigurationReader.get("platformName").equalsIgnoreCase("Android")) {
////            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationReader.get("deviceName"));
////            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigurationReader.get("platformName"));
////            desiredCapabilities.setCapability(MobileCapabilityType.VERSION,ConfigurationReader.get("version"));
////            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"automationName");
////            driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
//
//            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//            desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"8.0");
//            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");
//            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
//            desiredCapabilities.setCapability("appPackage", ConfigurationReader.get("appPackage"));
//            desiredCapabilities.setCapability("appActivity", ConfigurationReader.get("appActivity"));
//        //    desiredCapabilities.setCapability(MobileCapabilityType.APP,"/data/app/live.openmoney-c_YJMqXSqqUDAJ9EbpULEg==/base.apk");
//        //    driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
//            driver = new AndroidDriver<MobileElement>(appiumServerURL, desiredCapabilities);
//
//
////            driver.findElement(MobileBy.AccessibilityId("Apps list")).click();
////            driver.findElementByXPath("(//*[@text='OpenMoney'])[1]").click();
//        } else if (ConfigurationReader.get("platformName").equalsIgnoreCase("IOS")) {
//            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro Max");
//            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
//            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//            driver = new IOSDriver<MobileElement>(appiumServerURL, desiredCapabilities);
//        }
//        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//
//    }
//
//    public void androidBackButton() {
//        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
//    }
//
//    public ApplicationState getAppState() {
//        return driver.queryAppState("io.plaidapp");
//    }

}
