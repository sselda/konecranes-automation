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
        context = playwright.chromium().launchPersistentContext(
                Paths.get("user-data"),
                new BrowserType.LaunchPersistentContextOptions()
                        .setChannel("chrome")
                        .setHeadless(false)

        );

        page.set(context.newPage());
    }

    public static Page getPage() {
        return page.get();
    }

    public static void tearDown() {
        if(context != null) context.close();
        if(playwright != null) playwright.close();
        //page.remove();
    }
}
