package com.konecranes.config;

public class Config {

    public static String getBaseUrl() {
        String env = System.getProperty("env","prod");

        switch(env) {
            case "dev":
                return "https://dev.konecranes.com";
        case "staging":
                return "https://staging.konecranes.com";
            default:
                return "https://konecranes.com";
        }
    }
}
