package com.two_n_tech.stepDefinitions;


import com.two_n_tech.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;






public class SearchBox_stepDefs extends Base_stepDefs{
    @When("The user clicks on the search button")
    public void the_user_clicks_on_the_search_button() {
        searcBoxPage.searchIcon.click();
    }
    @When("The user enters {string} into the search box")
    public void the_user_enters_into_the_search_box(String newsInfo) {
       searcBoxPage.searchInfo(newsInfo);
    }
    @Then("The user verifies that result for entry title contains {string}")
    public void the_user_verifies_that_result_for_entry_title_contains(String result) {
       searcBoxPage.verifyEntryTitleIsDisplayed(result);
    }
    @Then("The user clicks on {int} th news article")
    public void the_user_clicks_on_th_news_article(Integer selectedLink) {
        searcBoxPage.clickLinks(selectedLink);
    }
    @Then("The user should be navigated to the detail page of that article")
    public void the_user_should_be_navigated_to_the_detail_page_of_that_article() {
        searcBoxPage.verifyEntryTitleIsDisplayed(searcBoxPage.articleDetailEntryTitle);
    }


}
