package ru.training.at.hw5.ex1.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GivenSteps extends AbstractStep {

    @Given("Open test site by URL")
    public void openIndexPage() {
        indexPage.open("");
    }

    @Given("I login as Roman Iovlev")
    public void authorization(String name, String password) {
        indexPage.login(name, password);
    }

    @Given("Assertion of user loggined")
    public void getLogginedUsername(String name) {
        Assert.assertEquals(indexPage.getAuthorityName(), name);

    }

    @Given("I open through the header menu Service -> Different Elements Page")


