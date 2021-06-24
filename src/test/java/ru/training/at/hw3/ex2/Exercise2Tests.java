package ru.training.at.hw3.ex2;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.ex2.page.IndexPage;

public class Exercise2Tests extends AbstractBaseSeleniumTest {

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
        // 5. Open through the header menu Service -> Different Elements Page
        indexPage.changePage();
        // 6. Select checkboxes Water and Wind
        indexPage.clickWaterWindCheck();
        //7. Select radio Selen
        indexPage.clickSelenRadioButton();
        //8. Select in dropdown Yellow
        indexPage.yellowElementSelect();
        //9. Assert checkbox, radio, dropdown name and its status are corresponding to selected
        Assert.assertTrue(indexPage.getWaterLog());
        Assert.assertTrue(indexPage.isWaterSelected());

        Assert.assertTrue(indexPage.getWindLog());
        Assert.assertTrue(indexPage.isWindSelected());

        Assert.assertTrue(indexPage.getSelenLog());
        Assert.assertTrue(indexPage.isSelenSelected());

        Assert.assertTrue(indexPage.isYellowSelected());


    }
}
