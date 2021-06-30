package ru.training.at.hw6.ex1.component.driver;

import java.net.MalformedURLException;
import java.net.URL;
import javax.management.openmbean.InvalidOpenTypeException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



public class WebDriverFactory {
    private static final String CHROME = "CHROME";
    private static final String FIREFOX = "FIREFOX";
    private static final String OPERA = "OPERA";

    private static final String REMOTE_DRIVER_TYPE = "remote";
    private static final String LOCAL_DRIVER_TYPE = "local";

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

    public static WebDriver createWebDriver(String driverType, String browserName) {
        if (LOCAL_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            return createWebDriver(browserName);
        } else if (REMOTE_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            return createRemoteDriver(browserName);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported driver type %s.\n"
                    + "Supports only remote or local driver types.", driverType));
        }
    }

    private static WebDriver createRemoteDriver(String browserName) {
        Capabilities capabilities = null;
        if (CHROME.equalsIgnoreCase(browserName)) {
            capabilities = createChromeCapabilities();
        }  else if (FIREFOX.equalsIgnoreCase(browserName)) {
            capabilities = createFirefoxCapabilities();
        }  else {
            throw new IllegalArgumentException(String.format("Unsupported browser %s", browserName));
        }
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new InvalidOpenTypeException("Incorrect Selenium Grid URL");
        }
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static Capabilities createChromeCapabilities() {
        return new ChromeOptions();
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
