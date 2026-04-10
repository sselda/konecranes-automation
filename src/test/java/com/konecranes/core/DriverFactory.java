package com.konecranes.core;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class DriverFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static void initBrowser() {
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
        );

        BrowserContext context = browser.newContext();
        page.set(context.newPage());
    }

    public static Page getPage() {
        return page.get();
    }

    public static void tearDown() {
        if(context != null) context.close();
        if(playwright != null) playwright.close();
        page.remove();
    }
}
