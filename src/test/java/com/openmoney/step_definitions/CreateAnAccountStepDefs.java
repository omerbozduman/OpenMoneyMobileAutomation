package com.openmoney.step_definitions;

import com.openmoney.pages.android.CreateAnAccountPageAndroid;
import com.openmoney.utilities.ConfigurationReader;
import com.openmoney.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class CreateAnAccountStepDefs {

    CreateAnAccountPageAndroid createAnAccountPageAndroid = new CreateAnAccountPageAndroid();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
    private String platform = ConfigurationReader.get("platform").toLowerCase();

    @Given("I open the open money app")
    public void i_open_the_open_money_app() throws MalformedURLException, InterruptedException {

        if(platform.equals("android")) {
            createAnAccountPageAndroid.swipeScreen();
            System.out.println("platform is = " + platform);
        }else if(platform.equals("ios")) {

        }
    }

    @Then("I click the create an account button")
    public void i_click_the_create_an_account_button() throws InterruptedException {
        Thread.sleep(2000);
        createAnAccountPageAndroid.createAnAccountButton.click();
    }
    @Then("I fill the sign up form with valid credentials")
    public void i_fill_the_sign_up_form_with_valid_credentials() {
       createAnAccountPageAndroid.fillTheFormWithValidCredentials();
    }
    @Then("I click the terms and conditions confirm button")
    public void i_click_the_terms_and_conditions_confirm_button() {
        createAnAccountPageAndroid.termsConditionConfirmButton.click();
    }
    @Then("I create a secret code")
    public void i_create_a_secret_code() throws InterruptedException {
        Thread.sleep(2000);
        createAnAccountPageAndroid.selectSecretCode();
    }
    @Then("I confirm secret code")
    public void i_confirm_secret_code() throws InterruptedException {
        Thread.sleep(2000);
       createAnAccountPageAndroid.selectSecretCode();
    }
    @Then("I select the stay in the loop options")
    public void i_select_the_stay_in_the_loop_options() {
        createAnAccountPageAndroid.getUpdatesCheckBox.click();
        createAnAccountPageAndroid.receiveTheLatestCheckBox.click();
        createAnAccountPageAndroid.journeyTipsCheckBox.click();

    }
    @Then("I click the continue button")
    public void i_click_the_continue_button() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Continue']")));
        createAnAccountPageAndroid.continueButton.click();
    }
    @Then("I enter my first name")
    public void i_enter_my_first_name() {
        createAnAccountPageAndroid.yourFirstNameBox.sendKeys("Open");

    }
    @Then("I enter my last name")
    public void i_enter_my_last_name() {
        createAnAccountPageAndroid.yourLastNameBox.sendKeys("Money");

    }
    @Then("I enter my birth date")
    public void i_enter_my_birth_date() {

    }
    @Then("I click continue button")
    public void i_click_continue_button() {
        createAnAccountPageAndroid.continueButton.click();

    }


    @And("I fill the sign up form with {string} {string} {string}")
    public void iFillTheSignUpFormWith(String emailAddress, String password, String termsConditions) {
        createAnAccountPageAndroid.fillTheFormWithInValidCredentials(emailAddress,password,termsConditions);
    }

    @Then("I verify the {string}")
    public void iVerifyThe(String expectedErrorMessage) {
        String actualErrorMessage= createAnAccountPageAndroid.getErrorMessage(expectedErrorMessage);
        Assert.assertEquals("verify error message",expectedErrorMessage,actualErrorMessage);
    }
}
