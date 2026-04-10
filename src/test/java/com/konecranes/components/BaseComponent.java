package com.konecranes.components;

import com.microsoft.playwright.Page;

public class BaseComponent {

    protected Page page;

    public BaseComponent(Page page) {
        this.page = page;
    }
}
