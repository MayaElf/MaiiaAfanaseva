package ru.training.at.hw5.ex1.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WhenSteps extends AbstractStep {

    @When("I select {string} and {string} checkboxes")
    public void selectedCheckboxWaterWind(String wind, String water) {
        indexPage.clickWaterWindCheck();
    }

    @And("I select {string} in radio buttons")
    public void selectRadioSelen(String selen) {
        indexPage.clickSelenRadioButton();
    }

    @And("I select {string} in dropdown")
    public void selectYellowDropdown(String yellow) {
        indexPage.yellowElementSelect();
    }

}
