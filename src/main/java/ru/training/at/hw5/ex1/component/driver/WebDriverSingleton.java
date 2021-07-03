package ru.training.at.hw5.ex1.component.driver;

import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    public WebDriverSingleton() { }

    public static WebDriver getDriver() {
        String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        if (Objects.isNull(driver)) {
            driver = WebDriverFactory.createWebDriver(browserName);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}

