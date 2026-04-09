package com.konecranes.core;

import com.konecranes.pages.HomePage;
import com.microsoft.playwright.Page;

public class PageManager {
    private Page page;
    private HomePage homePage;

    public PageManager(Page page) {
        this.page=page;
    }

    public HomePage getHomePage() {
        if(homePage == null) {
            homePage = new HomePage(page);
        }
        return homePage;
    }
}
