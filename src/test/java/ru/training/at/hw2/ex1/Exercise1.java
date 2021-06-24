package ru.training.at.hw2.ex1;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise1 extends AbstractBaseSeleniumTest {

    @Test(description = "Тестирование")
    public void openPage() {
        IndexPage indexPage = new IndexPage(driver);
        // 1.
        indexPage.open();
        // 2.
        Assert.assertEquals(indexPage.getTitle(), "Home Page");
        // 3.
        indexPage.login();
        // 4.
        Assert.assertEquals(indexPage.getAuthorityName(), "ROMAN IOVLEV");
        // 5.
        List<WebElement> headersList = indexPage.getTopElements();

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(headersList.get(i).getText(), indexPage.getExpectedHeadersList().get(i));
        }
        // 6.
        List<WebElement> frameList = indexPage.getFrameList();
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(frameList.get(i).isDisplayed());
        }
        // 7.
        //List<WebElement> txtElementList = indexPage.getTxtElementList();
        //Assert.assertEquals(txtElementList.size(), 4);
        //for (int i = 0; i < 4; i++) {
        //Assert.assertEquals(txtElementList.get(i).getText(), indexPage.getTxtElementList().get(i));
        //}
        // 8.
        Assert.assertEquals(indexPage.getFrameButton(), indexPage.getFrameButtonLink());
        // 9.
        //indexPage.switchToFrameElement();
        //Assert.assertEquals(indexPage.getFrameButtonText(), indexPage.getFrameButtonTxt());
        // 10.
        //indexPage.switchToDefault();
        // 11.
        //List<WebElement> leftElementsList = indexPage.getLeftElements();
        //for (int i = 0; i < 5; i++) {
        //Assert.assertEquals(leftElementsList.get(i).getText(), indexPage.getExpectedLeftElements().get(i));
        //}
        // 12.
        //indexPage.closeThePage();
    }
}
