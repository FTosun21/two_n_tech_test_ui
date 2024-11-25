package com.two_n_tech.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Two_n_tech_hr_stepDefs extends Base_stepDefs{
    @When("The user fill form with valid details")
    public void the_user_fill_form_with_valid_details() {
        hrPage.fillForm();
    }
    @Then("The user verifies that form submit massage is {string}")
    public void the_user_verifies_that_form_submit_massage_is(String expectedMessage) {
        hrPage.verifySubmitMessage(expectedMessage);
    }
}
