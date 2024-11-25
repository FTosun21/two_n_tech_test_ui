package com.two_n_tech.runers;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports.html"
        },
        features = "src/test/resources/features",
        glue = "com/two_n_tech/stepDefinitions",
        dryRun = false,
        tags = " @wip"

)
public class CukesRunner {

}
