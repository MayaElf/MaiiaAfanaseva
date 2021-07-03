package ru.training.at.hw5.ex1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw5.ex1.page.IndexPage;


public class Exercise1Tests extends AbstractBaseSeleniumTest {

    @DataProvider
    public Object[][] dataProviders() {

        return new Object[][]{
                {"Home Page", "Roman", "Jdi1234", "ROMAN IOVLEV"}};
    }

    @Test(dataProvider = "dataProviders")
    public void pageTesting(String title, String username, String password, String name) throws InterruptedException {

        IndexPage indexPage = new IndexPage(driver);
        //1. "Open test site by URL"
        indexPage.open("");

        // 2. Perform login
        actionStep.authorization(username, password);

        // 3. Assert username is loggined
        assertionStep.getLogginedUsername(name);

        // 4. Open through the header menu Service -> Different Elements Page
        actionStep.changePage();

        // 5. Select checkboxes Water and Wind
        actionStep.selectedCheckboxWaterWind();

        // 6. Select radio Selen
        actionStep.selectRadioSelen();

        // 7. Select in dropdown Yellow
        actionStep.selectYellowDropdown();


        // 8. Assert checkbox, radio, dropdown name and its status are corresponding to selected
        assertionStep.getWaterWindSelenYellowSelected();


    }
}
