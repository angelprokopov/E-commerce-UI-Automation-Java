package com.ecommerce.driver;

import com.ecommerce.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
public final class DriverFactory {
    private DriverFactory() {}

    public static WebDriver createDriver() {
        String browser = ConfigReader.get("browser","chrome").toLowerCase();
        boolean headless = ConfigReader.getBoolean("headless",false);

        return switch(browser) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                if(headless) {
                    options.addArguments("--headless=new");
                }
                options.addArguments("--window-size=1440,1000");
                yield new ChromeDriver(options);
            }
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) {
                    options.addArguments("-headless");
                }
                yield new FirefoxDriver(options);
            }
            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser + ". Use chrome or firefox.");
            };
        }
    }