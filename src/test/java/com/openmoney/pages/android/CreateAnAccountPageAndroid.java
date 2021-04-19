package com.openmoney.pages.android;

import com.openmoney.pages.base.BasePage;
import com.openmoney.utilities.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateAnAccountPageAndroid extends BasePage {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    @AndroidFindBy(xpath = "//*[@text='Create an account']")
    public MobileElement createAnAccountButton;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public MobileElement emailBox;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    public MobileElement passwordBox;

    @AndroidFindBy(xpath = "//*[@text='\uF3FF']")
    public MobileElement termsConditionConfirmButton;

    @AndroidFindBy(xpath = "//android.widget.Button")
    public List<MobileElement> numbers;

    @AndroidFindBy(xpath = "//*[@text='Continue']")
    public MobileElement continueButton;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"\uF3FF\"])[1]")
    public MobileElement getUpdatesCheckBox;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"\uF3FF\"])[2]")
    public MobileElement receiveTheLatestCheckBox;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"\uF3FF\"])[3]")
    public MobileElement journeyTipsCheckBox;

    @AndroidFindBy(xpath = "//*[@text='Your first name']")
    public MobileElement yourFirstNameBox;

    @AndroidFindBy(xpath = "//*[@text='Your last name']")
    public MobileElement yourLastNameBox;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='How secure is this?]")
    public MobileElement secureLinkText;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='How do I link my account?']")
    public MobileElement linkMyAccountText;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Connect your main account']")
    public MobileElement connectYourAccountTitle;


    public void fillTheFormWithValidCredentials(){

        emailBox.sendKeys("open123@yahoo.com");
        passwordBox.sendKeys("123489A65?Yj");
    }

    public void selectSecretCode(){
        Driver.getDriver().findElementByXPath("//*[@text='1']").click();
        Driver.getDriver().findElementByXPath("//*[@text='1']").click();
        Driver.getDriver().findElementByXPath("//*[@text='2']").click();
        Driver.getDriver().findElementByXPath("//*[@text='3']").click();

    }

    public boolean verifyPopularProviders(){
        boolean flag=false;
        int providerCounter=0;

        String locator= "//android.view.View[@content-desc=Santander Open Banking]";
        if(Driver.getDriver().findElementByXPath(locator).isDisplayed()){
            providerCounter++;

        }
        if(providerCounter==1){
            flag=true;
        }
        return flag;
    }

    public void swipeScreen() throws InterruptedException {

        for(int i=2; i<=4;i++){
            String locator="//*[@text='Go to slide "+i+"']";
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(locator)));
            Thread.sleep(2);
            Driver.getDriver().findElementByXPath(locator).click();
        }

        Thread.sleep(2);

        TouchAction t =new TouchAction(Driver.getDriver());
        PointOption point=new PointOption();
        new TouchAction(Driver.getDriver()).tap(PointOption.point(521,1628)).release().perform();
    }

    public void fillTheFormWithInValidCredentials(String emailAddress, String password, String termsConditions){

        if(emailAddress.isEmpty()){
            emailBox.sendKeys("1");
            emailBox.clear();
            passwordBox.sendKeys(password);
            if(termsConditions.equals("select")){
                termsConditionConfirmButton.click();
            }
        } else if(password.isEmpty()){
            emailBox.sendKeys(emailAddress);
            passwordBox.sendKeys("1");
            passwordBox.clear();
            if(termsConditions.equals("select")){
                termsConditionConfirmButton.click();
            }
        }else {

            emailBox.sendKeys(emailAddress);
            passwordBox.sendKeys(password);
            if (termsConditions.equals("select")) {
                termsConditionConfirmButton.click();
            }
        }
    }

    public String getErrorMessage(String expectedErrorMessage){
        String actualErrorMessage="";
        if(expectedErrorMessage.contains("continue button")){
            try{
                continueButton.click();
                actualErrorMessage="verify continue button is not clickable";
            }catch (Exception e){
                System.out.println("omer bozduman");
                actualErrorMessage="verify continue button is not clickable";
            }
        }else {
            continueButton.click();
            String locator = "//*[@text='"+expectedErrorMessage+"']";
            actualErrorMessage = Driver.getDriver().findElementByXPath(locator).getText();
        }
        return actualErrorMessage;
    }

//    public void swipeStories(int swipeCount){
//        Point p = wait.until(ExpectedConditions.visibilityOf(swipeList)).getLocation();
//        TouchAction t = new TouchAction(driver);
//        for (int i = 0; i < swipeCount; i++) {
//            t.press(PointOption.point(p.x + 300, p.y));
//            t.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
//            t.moveTo(PointOption.point(p.x + 100, p.y));
//            t.release();
//            t.perform();
//        }
    }




