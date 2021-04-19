package com.openmoney.step_definitions;

import com.openmoney.pages.android.SignInPageAndroid;
import com.openmoney.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPageStepDefs {

    SignInPageAndroid signInPageAndroid = new SignInPageAndroid();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Then("I click the Sign in button")
    public void iClickTheSignInButton() {

        signInPageAndroid.signInButton.click();
    }

    @And("I verify {string} is displayed")
    public void iVerifyIsDisplayed(String expectedText) {
        signInPageAndroid.verifyPageTitleText(expectedText);
    }

    @Then("I fill sign in form with valid credentials")
    public void iFillSignInFormWithValidCredentials() {
        signInPageAndroid.signInToOpenMoney();
    }

    @And("I click the continue button for to sign in")
    public void iClickTheContinueButtonForToSignIn() {
        signInPageAndroid.continueSignInButton.click();
    }



}
