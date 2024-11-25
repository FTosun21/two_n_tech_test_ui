package com.two_n_tech.stepDefinitions;


import com.two_n_tech.utilities.BrowserUtils;
import com.two_n_tech.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {
    @Before
    public void setUp() {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDownScenarios(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());

        }
        BrowserUtils.waitFor(2);
        Driver.closeDriver();
    }
}
