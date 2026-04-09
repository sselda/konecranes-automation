package com.konecranes.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public void verifyHomePage() {
        Locator logo = page.locator("header")
                .getByRole(AriaRole.LINK,
                        new Locator.GetByRoleOptions().setName("Konecranes"));

        assertVisible(logo.first(), "Homepage is not visible!");
    }

}