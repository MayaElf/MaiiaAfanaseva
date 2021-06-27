package ru.training.at.hw4.ex1.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.ex1.page.IndexPage;


public abstract class AbstractStep {

    public IndexPage indexPage;

    protected AbstractStep(WebDriver driver) {
        indexPage = new IndexPage(driver);
    }

    @Step("Открыть домашнюю страницу")
    public void openIndexPage() {
        indexPage.open();
    }
}
