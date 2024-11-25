package com.two_n_tech.stepDefinitions;

import com.two_n_tech.utilities.ConfigurationReader;
import com.two_n_tech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Navbar_stepDefs extends Base_stepDefs{
    @Given("The user navigates to url")
    public void the_user_navigates_to_url() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user navigates to {string} url")
    public void the_user_navigates_to_url(String url) {
        Driver.get().get(ConfigurationReader.get(url+"url"));
    }
    @Then("The user clicks on navbar {string} menu and navigate to the related page")
    public void the_user_clicks_on_navbar_menu_and_navigate_to_the_related_page(String menuType) {
        homePage.navigateToMenu(menuType);
    }

}
