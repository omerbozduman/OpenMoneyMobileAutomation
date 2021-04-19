package com.openmoney.pages.ios;

import com.openmoney.pages.base.BasePage;
import com.openmoney.utilities.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class KeyboardsPageIOS extends BasePage {


    public void clickSettings(String appName){
        Driver.getDriver().findElementByName(appName).click();
    }

    public void clickGeneralButton(String button){
        Driver.getDriver().findElementByXPath("(//*[@name='"+button+"'])[1]").click();
    }

    public void clickKeyboardButton(){
        Driver.getDriver().findElementByXPath("(//*[@name='Keyboard'])[1]").click();
    }


    public boolean verifyTitle(String expectedTitle) {
        String locator = "(//*[@name='"+expectedTitle+"'])[1]";

        MobileElement titleElement = (MobileElement) Driver.getDriver().findElementByXPath(locator);

        if (titleElement.isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }
}
