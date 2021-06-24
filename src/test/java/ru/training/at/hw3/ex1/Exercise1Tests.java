package ru.training.at.hw3.ex1;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.ex1.page.IndexPage;

public class Exercise1Tests extends AbstractBaseSeleniumTest {
    private final int four = 4;
    private final int five = 5;


    @Test(description = "Тестирование")
    public void openPage() {
        IndexPage indexPage = new IndexPage(driver);
        // 1. Open test site by URL
        indexPage.open();
        // 2. Assert Browser title
        Assert.assertEquals(indexPage.getTitles(), indexPage.getNameOfTitle());
        // 3. Perform login
        indexPage.login();
        // 4. Assert username is loggined
        Assert.assertEquals(indexPage.getAuthorityName(), indexPage.getRoman());
        // 5. Assert 4 headers are displayed with proper texts
        List<WebElement> headersList = indexPage.getTopElements();

        for (int i = 0; i < four; i++) {
            Assert.assertEquals(headersList.get(i).getText(), indexPage.getExpectedHeadersList().get(i));
        }
        // 6. Assert 4 images are displayed
        List<WebElement> frameList = indexPage.getFrameList();
        for (int i = 0; i < four; i++) {
            Assert.assertTrue(frameList.get(i).isDisplayed());
        }
        // 7. Assert there are 4 texts under icons
        List<WebElement> txtElementList = indexPage.getTxtElementList();
        Assert.assertEquals(txtElementList.size(), four);
        for (int i = 0; i < four; i++) {
            Assert.assertEquals(txtElementList.get(i), indexPage.getTxtElementList().get(i));
        }
        // 8. Assert that frame with "Frame button" exist
        Assert.assertEquals(indexPage.getFrameButton(), indexPage.getFrameButtonLink());
        // 9. Check that there is “Frame Button” in the iframe
        indexPage.switchToFrameElement();
        Assert.assertEquals(indexPage.getFrameButtonText(), indexPage.getFrameButtonTxt());
        // 10. Switch to original window back
        indexPage.switchToDefault();
        // 11. Assert that there are 5 items in the Left Section are
        //displayed and they have proper text

        List<WebElement> leftElementsList = indexPage.getLeftElements();
        for (int i = 0; i < five; i++) {
            Assert.assertEquals(leftElementsList.get(i).getText(), indexPage.getExpectedLeftElements().get(i));
        }

    }
}
