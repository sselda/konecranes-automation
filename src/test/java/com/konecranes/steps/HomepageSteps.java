package com.konecranes.steps;

import com.konecranes.core.DriverFactory;
import com.konecranes.core.PageManager;
import com.konecranes.pages.HomePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomepageSteps {

    private Page page;
    private HomePage homePage;
    private PageManager pageManager;

    @Given("user opens the homepage")
    public void user_is_on_homepage() {
        page = DriverFactory.getPage();
        pageManager = new PageManager(page);
        homePage = pageManager.getHomePage();

        page.navigate("https://www.konecranes.com/");
        page.waitForLoadState();
    }

    @Then("homepage should be displayed")
        public void homepage_should_be_displayed() {
        homePage.verifyHomePage();
    }

    @When("user click the search button")
        public void user_click_search_button() {
        homePage.navbarComponent.clickSearchButton();
    }

    @When("user searches for {string}")
        public void userSearches(String text) {
            homePage.navbarComponent.openSearch(text);
        }

    @Then("search results should be displayed")
        public void verifyResults() {
        assertTrue(page.url().contains("crane"));
    }

}

