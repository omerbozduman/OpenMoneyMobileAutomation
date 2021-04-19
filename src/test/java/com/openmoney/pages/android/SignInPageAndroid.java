package com.openmoney.pages.android;

import com.openmoney.pages.base.BasePage;
import com.openmoney.utilities.ConfigurationReader;
import com.openmoney.utilities.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignInPageAndroid extends BasePage {

    @AndroidFindBy(xpath = "//*[@text='Sign in']")
    public MobileElement signInButton;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public MobileElement emailAddressBoxForSign;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    public MobileElement passwordBoxForSign;

    @AndroidFindBy(xpath = "//*[@text='Continue']")
    public MobileElement continueSignInButton;

    public boolean verifyPageTitleText(String expectedText){
        boolean flag=false;
        String locator="//*[@text='"+expectedText+"']";
        if(Driver.getDriver().findElementByXPath(locator).isDisplayed()){
            flag=true;
        }

        return flag;
    }

    public void signInToOpenMoney(){

        emailAddressBoxForSign.sendKeys(ConfigurationReader.get("emailAddress"));
        passwordBoxForSign.sendKeys(ConfigurationReader.get("password"));

    }



}
