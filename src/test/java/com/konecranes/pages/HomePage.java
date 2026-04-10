package com.konecranes.pages;

import com.konecranes.components.NavbarComponent;
import com.konecranes.core.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage {

    public NavbarComponent navbarComponent;

    public HomePage(Page page) {
        super(page);
        this.navbarComponent = new NavbarComponent(page);
    }

    public void verifyHomePage() {
        Locator logo = page.locator("header")
                .getByRole(AriaRole.LINK,
                        new Locator.GetByRoleOptions().setName("Konecranes"));

        assertVisible(logo.first(), "Homepage is not visible!");
    }

}