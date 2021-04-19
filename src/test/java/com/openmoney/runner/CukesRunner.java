package com.openmoney.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "json:target/jsonReport/cucumber.json",
                "de.monochromata.cucumber.report.PrettyReports:target/htmlReport"
        },
        glue = {"com/openmoney/step_definitions"},
        features = "src/test/resources/features",
        dryRun = false,
        tags = "@keyboards"
)

public class CukesRunner {
}
