package ru.training.at.hw5.ex2.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class ActionStep extends AbstractStep {
    public ActionStep(WebDriver driver) {
        super(driver);

    }


    @Step("Perform login")
    public void authorization(String name, String password) {
        indexPage.login(name, password);
    }

    @Step("Switch to Service -> Different Elements Page")
    public void changePage() {
        indexPage.changePage();
    }

    @Step("Select checkboxes Water and Wind")
    public void selectedCheckboxWaterWind() {
        indexPage.clickWaterWindCheck();
    }


    @Step("Select radio Selen")
    public void selectRadioSelen() {
        indexPage.clickSelenRadioButton();
    }

    @Step("Select in dropdown Yellow")
        public void selectYellowDropdown() {
        indexPage.yellowElementSelect();
    }



}












