package ru.training.at.hw5.ex3.steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ThenSteps extends AbstractStep {

    @Then("1 log row has {string} text in log section")
    public void textInLogForIvan(String checkLog) {

        Assert.assertEquals(indexPage.getVipIvanLog().substring(9), checkLog);
    }
}
