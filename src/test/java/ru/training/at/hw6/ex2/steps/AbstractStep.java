package ru.training.at.hw6.ex2.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw6.ex1.page.IndexPage;


public abstract class AbstractStep {

    IndexPage indexPage;

    protected AbstractStep(WebDriver driver) {
        indexPage = new IndexPage(driver);
    }

    @Step("Открыть домашнюю страницу")
    public void openIndexPage() {
        indexPage.open();
    }
}

