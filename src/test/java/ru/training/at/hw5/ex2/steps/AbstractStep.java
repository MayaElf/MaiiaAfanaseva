package ru.training.at.hw5.ex2.steps;

import ru.training.at.hw5.ex1.component.driver.WebDriverSingleton;
import ru.training.at.hw5.ex1.hooks.CucumberHooks;
import ru.training.at.hw5.ex2.page.IndexPage;


public abstract class AbstractStep {

    public IndexPage indexPage;

    protected AbstractStep() {
        indexPage = new IndexPage(WebDriverSingleton.getDriver());
    }
}

