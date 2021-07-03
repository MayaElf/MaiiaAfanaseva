package ru.training.at.hw5.ex2;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw5.ex2.page.IndexPage;


@Feature("Данный класс тестирует 9 шагов из Exercise2")
@Story("Тестируется открытие, логин, переход на другую страницу, нажатие кнопок")
public class Exercise2Tests extends AbstractBaseSeleniumTest {

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

        // 2. Assert Browser title
        assertionStep.getTitle(title);

        // 3. Perform login
        actionStep.authorization(username, password);

        // 4. Assert username is loggined
        assertionStep.getLogginedUsername(name);

        // 5. Open through the header menu Service -> Different Elements Page
        actionStep.changePage();

        // 6. Select checkboxes Water and Wind
        actionStep.selectedCheckboxWaterWind();

        //7. Select radio Selen
        actionStep.selectRadioSelen();

        //8. Select in dropdown Yellow
        actionStep.selectYellowDropdown();


        //9. Assert checkbox, radio, dropdown name and its status are corresponding to selected
        assertionStep.getWaterWindSelenYellowSelected();


    }

}
