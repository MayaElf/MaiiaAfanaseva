package ru.training.at.hw5.ex2.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WhenSteps extends AbstractStep {

    @When("I click on {string} button in Header")
    public void getLogginedUsername(String name) {
        indexPage.clickOnService();
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnUserDetails(String userDetails) {
        indexPage.changePage();
    }

}
