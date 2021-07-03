package ru.training.at.hw4.ex1.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.training.at.hw4.ex1.component.driver.WebDriverSingleton;

public abstract class AbstractComponent {
    public static WebDriver driver;
    public WebDriverWait wait;

    public AbstractComponent(WebDriver driver) {
        this.driver = new WebDriverSingleton().getDriver();
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}

