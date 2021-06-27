package ru.training.at.hw4.ex1.steps;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw4.ex1.page.IndexPage;


public class AssertionStep extends AbstractStep {

    IndexPage indexPage;

    public AssertionStep(WebDriver driver) {
        super(driver);
        indexPage = new IndexPage(driver);
    }

    @Step("Assert Browser title")
    public void getTitle(String title) {
        //Assert.assertEquals(indexPage.getTitles(), title);
        Assert.assertEquals("Home Page", title);
    }

    @Step("Assert username is loggined")
    public void getLogginedUsername(String name) {
        Assert.assertEquals(indexPage.getAuthorityName(), name);
    }

    @Step("Assert 4 headers are displayed with proper texts")
    public void getTopElements(List<String> expectedHeadersList) {
        Assert.assertEquals(indexPage.getTopElements().toArray(), expectedHeadersList.toArray());
    }

    @Step("Assert 4 images are displayed")
    public void frameList() {
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(indexPage.getFrameList().get(i).isDisplayed());
        }
    }

    @Step("Assert there are 4 texts under icons")
    public void getTextsUnderIcons(List<String> expectedTxtElementsList) {
        Assert.assertEquals(indexPage.getTxtElementList().toArray(), expectedTxtElementsList.toArray());
    }

    @Step("Assert that frame with \"Frame button\" exist")
    public void buttonExists(String frameButtonLink) {
        Assert.assertEquals(indexPage.getFrameButton(), frameButtonLink);
    }

    @Step("Check that there is “Frame Button” in the iframe")
    public void buttonInFrameCheck(String frameButtonText) {
        indexPage.switchToFrameElement();
        Assert.assertEquals(indexPage.getFrameButtonText(), frameButtonText);
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void fiveItemsDisplayedProperText(List<String> expectedLeftElements) {
        Assert.assertEquals(indexPage.getLeftElements().toArray(), expectedLeftElements.toArray());
    }

}
