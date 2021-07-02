package ru.training.at.hw3.ex1.component.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {
    private static final String CHROME = "CHROME";
    private static final String FIREFOX = "FIREFOX";
    private static final String OPERA = "OPERA";

    private WebDriverFactory() {}

    public static WebDriver createWebDriver(String browser) {
        WebDriver webDriver;
        switch (browser.toUpperCase()) {
            case FIREFOX:
                webDriver = createFirefox();
                break;
            case CHROME:
                webDriver = createChrome();
                break;
            case OPERA:
                webDriver = createOpera();
                break;
            default:
                webDriver = createChrome();
                break;
        }
        webDriver.manage().window().maximize();
        return webDriver;
    }

    private static WebDriver createChrome() {
        return new ChromeDriver();
    }

    private static WebDriver createFirefox() {
        return new FirefoxDriver();
    }

    private static WebDriver createOpera() {
        return new OperaDriver();
    }
}
