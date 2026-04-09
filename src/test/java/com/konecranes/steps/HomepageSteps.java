package com.konecranes.steps;

import com.konecranes.core.DriverFactory;
import com.konecranes.core.PageManager;
import com.konecranes.pages.HomePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomepageSteps {

    private Page page;
    private HomePage homePage;
    private PageManager pageManager;

    @Given("user opens the homepage")
    public void user_is_on_homepage() {
        page = DriverFactory.getPage();
        pageManager = new PageManager(page);
        homePage = pageManager.getHomePage();

        page.navigate("https://wwww.konecranes.com/");
        page.waitForLoadState();
    }

    @Then("homepage should be displayed")
        public void homepage_should_be_displayed() {
        homePage.verifyHomePage();
    }
}
