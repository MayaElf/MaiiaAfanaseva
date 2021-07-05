package ru.training.at.hw5.ex2.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.util.Locale;
import org.testng.Assert;
import ru.training.at.hw5.ex1.steps.AbstractStep;


public class GivenSteps extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        indexPage.open("");
    }

    @And("I login as user {string}")
    public void authorization(String name) {
        indexPage.login("Roman", "Jdi1234");
        Assert.assertEquals(indexPage.getRoman(), name.toUpperCase(Locale.ROOT));
    }
}
