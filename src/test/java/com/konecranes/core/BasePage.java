package com.konecranes.core;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page=page;
    }

    protected Locator find(String selector) {
        return page.locator(selector);
    }

    protected void click(String selector) {
        find(selector).click();
    }

    protected String getText(String selector) {
        return find(selector).textContent();
    }

    protected Locator waitForVisible(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        return locator;
    }

    protected void assertVisible(Locator locator, String message) {
        assertTrue(waitForVisible(locator).isVisible(), message);
    }
}
