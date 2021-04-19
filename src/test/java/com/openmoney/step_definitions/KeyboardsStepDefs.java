package com.openmoney.step_definitions;

import com.openmoney.pages.ios.KeyboardsPageIOS;
import com.openmoney.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyboardsStepDefs {

    KeyboardsPageIOS keyboardsPageIOS = new KeyboardsPageIOS();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("I open the {string} app")
    public void iOpenTheApp(String appName) {
        keyboardsPageIOS.clickSettings(appName);
    }

    @Then("I click the {string} button")
    public void iClickTheButton(String button) {
        keyboardsPageIOS.clickGeneralButton(button);
    }

    @Then("I verify {string} is displayed on the bottom")
    public void iVerifyIsDisplayedOnTheBottom(String expectedTitle) {
        keyboardsPageIOS.verifyTitle(expectedTitle);
    }
}
