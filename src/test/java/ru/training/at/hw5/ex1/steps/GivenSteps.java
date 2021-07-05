package ru.training.at.hw5.ex1.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.util.Locale;
import org.testng.Assert;


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

    @And("I click on {string} button in Header")
    public void getLogginedUsername(String name) {
        indexPage.clickOnService();

    }

    @And("I click on {string} button in Service dropdown")
    public void changePage(String diffElements) {
        indexPage.changePage();
    }

}


