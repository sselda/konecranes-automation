package com.konecranes.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NavbarComponent extends BaseComponent {

    private final Locator searchButton;
    private final Locator searchInput;
    private final Locator productsMenu;

    public NavbarComponent(Page page) {
        super(page);

        this.searchButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Search Konecranes.com"));
        this.searchInput = page.getByPlaceholder(
                "Search",
                new Page.GetByPlaceholderOptions().setExact(true)
        );
        this.productsMenu = page.locator("text=Products");
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void openSearch(String text) {
        searchInput.fill(text);
        searchInput.press("Enter");
    }

    public void clickProducts() {
        productsMenu.click();
    }

}
