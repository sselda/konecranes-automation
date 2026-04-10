package com.konecranes.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CookieBannerComponent extends BaseComponent{

    private final Locator acceptButton;

    public CookieBannerComponent(Page page) {
        super(page);

        this.acceptButton = page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Accept all cookies")
        );
    }

    public void acceptCookiesIfPresent() {
        try{
            if(acceptButton.isVisible()) {
                acceptButton.click();
            }
        } catch (Exception e) {
            //banner not present -> ignore
        }
    }
}
