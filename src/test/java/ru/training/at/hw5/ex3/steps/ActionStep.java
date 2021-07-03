package ru.training.at.hw5.ex3.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class ActionStep extends AbstractStep {
    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Perform login")
    public void authorization(String name, String password) {
        indexPage.login(name, password);
    }

    @Step("Switch to original window back")
    public void returnToOriginalWindow() {
        indexPage.switchToDefault();
    }
}


