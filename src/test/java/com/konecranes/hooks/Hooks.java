package com.konecranes.hooks;

import com.konecranes.core.DriverFactory;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Files;
import java.nio.file.Path;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initBrowser();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screenshot = DriverFactory.getPage().screenshot();
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        DriverFactory.tearDown();
        //VIDEO ATTACH
        Page page = DriverFactory.getPage();

        try {
            Path videoPath = page.video().path();
            byte[] videoBytes = Files.readAllBytes(videoPath);
            scenario.attach(videoBytes, "video/mp4", "Execution Video");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
