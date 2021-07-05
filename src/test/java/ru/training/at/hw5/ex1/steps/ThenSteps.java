package ru.training.at.hw5.ex1.steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import ru.training.at.hw5.ex1.page.IndexPage;

public class ThenSteps extends AbstractStep {

    @Then("Log rows are displayed and checkbox name and its status are corresponding to selected")
    public void getWaterWindSelenYellowSelected() {
        org.testng.Assert.assertTrue(indexPage.getWaterLog());
        org.testng.Assert.assertTrue(indexPage.isWaterSelected());

        org.testng.Assert.assertTrue(indexPage.getWindLog());
        org.testng.Assert.assertTrue(indexPage.isWindSelected());
    }

    @Then("Log rows are displayed and radio button name and it status is corresponding to selected")
    public void getRightCheckboxes() {
        org.testng.Assert.assertTrue(indexPage.getSelenLog());
        org.testng.Assert.assertTrue(indexPage.isSelenSelected());
    }

    @Then("Log rows are displayed dropdown name and selected value is corresponding to selected")
    public void getYellow() {
        Assert.assertTrue(indexPage.isYellowSelected());
    }
}


