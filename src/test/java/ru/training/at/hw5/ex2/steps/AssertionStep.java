package ru.training.at.hw5.ex2.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw5.ex1.page.IndexPage;
import ru.training.at.hw5.ex1.steps.AbstractStep;


public class AssertionStep extends AbstractStep {

    IndexPage indexPage;

    public AssertionStep(WebDriver driver) {
        super(driver);
        indexPage = new IndexPage(driver);
    }

    @Step("Assert Browser title")
    public void getTitle(String title) {
        Assert.assertEquals("Home Page", title);
    }

    @Step("Assert username is loggined")
    public void getLogginedUsername(String name) {
        Assert.assertEquals(indexPage.getAuthorityName(), name);
    }

    @Step("Assert checkbox, radio, dropdown name and its status are corresponding to selected")
    public void getWaterWindSelenYellowSelected() {
        Assert.assertTrue(indexPage.getWaterLog());
        Assert.assertTrue(indexPage.isWaterSelected());

        Assert.assertTrue(indexPage.getWindLog());
        Assert.assertTrue(indexPage.isWindSelected());

        Assert.assertTrue(indexPage.getSelenLog());
        Assert.assertTrue(indexPage.isSelenSelected());

        Assert.assertTrue(indexPage.isYellowSelected());
    }


}

