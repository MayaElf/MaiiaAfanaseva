package ru.training.at.hw5.ex2.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.training.at.hw5.ex1.component.driver.WebDriverSingleton;

public class CucumberHooks {

    @Before
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.getDriver();
    }

    @After
    public void closeDriver() {
        WebDriverSingleton.closeDriver();
    }
}
