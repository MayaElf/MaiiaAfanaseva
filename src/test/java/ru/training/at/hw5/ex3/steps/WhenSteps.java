package ru.training.at.hw5.ex3.steps;

import io.cucumber.java.en.When;

public class WhenSteps extends AbstractStep {

    @When("I select 'vip' checkbox for {string}")
    public void selectIvanSergey(String ivanSergey) {
        indexPage.clickVipForIvanCheck();
    }
}
