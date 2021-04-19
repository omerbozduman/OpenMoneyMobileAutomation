package com.openmoney.step_definitions;


import com.openmoney.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks  {
    @Before
    public void setUp() throws IOException {
        Driver.setupDriver();
        System.out.println("Driver.getDriver() = " + Driver.getDriver());
        Driver.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       // startRecording();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
//        stopRecording(scenario.getName() + "_" + scenario.getLine());
//        getScreenShot(scenario);
        Driver.closeDriver();

    }
}
