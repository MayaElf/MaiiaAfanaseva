package ru.training.at.hw2.ex1;

import org.openqa.selenium.WebDriver;

public class AbstractBasePage extends AbstractComponent {
    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    protected AbstractBasePage(WebDriver driver) {
        super(driver);
    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }

}
