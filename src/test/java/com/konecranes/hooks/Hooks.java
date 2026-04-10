package com.konecranes.hooks;

import com.konecranes.components.CookieBannerComponent;
import com.konecranes.core.DriverFactory;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Video;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initBrowser();
        Page page = DriverFactory.getPage();
        CookieBannerComponent cookieBannerComponent = new CookieBannerComponent(page);
        cookieBannerComponent.acceptCookiesIfPresent();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screenshot = DriverFactory.getPage().screenshot();
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        } else {
            byte[] screenshot = DriverFactory.getPage().screenshot();
            scenario.attach(screenshot, "image/png", "Successfully Screenshot");
        }
        //VIDEO ATTACH

        if (scenario.isFailed()) {
            Video videoBytes = DriverFactory.getPage().video();
            scenario.attach(String.valueOf(videoBytes), "video/mp4", "Failure Execution Video");
        } else {
            Video videoBytes = DriverFactory.getPage().video();
            scenario.attach(String.valueOf(videoBytes), "video/mp4", "Successfully Execution Video");
        }

        DriverFactory.tearDown();

    }

}
