package ru.training.at.hw5.ex3;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.training.at.hw5.ex1.page.IndexPage;
import ru.training.at.hw5.ex3.listeners.AllureListener;

@Listeners({AllureListener.class})
@Feature("Данный класс тестирует 11 шагов Exercise1")
@Story("Тестируется открытие, логин, переход на другую страницу, заголовки, наличие кнопок")
public class FailingTests extends AbstractBaseSeleniumTest {

    @DataProvider
    public Object[][] dataProviderss() {
        List<String> expectedHeaders = new ArrayList<>();
        expectedHeaders.add("HOMe");
        expectedHeaders.add("CONTACT FORM");
        expectedHeaders.add("SERVICE");
        expectedHeaders.add("METALS & COLORS");

        List<String> expectedIconText = new ArrayList<>();
        expectedIconText.add("To include good practices\nand"
                + " ideas from successful\nEPAM project");
        expectedIconText.add("To be "
                + "flexible and\ncustomizable");
        expectedIconText.add("To be multiplatform");
        expectedIconText.add("Already have good base\n(about 20"
                + " internal and\nsome external projects),\nwish to get more…");

        List<String> expectedLeftElements = new ArrayList<>();
        expectedLeftElements.add("Home");
        expectedLeftElements.add("Contact form");
        expectedLeftElements.add("Service");
        expectedLeftElements.add("Metals & Colors");
        expectedLeftElements.add("Elements packs");

        return new Object[][]{
                {"Home Page", "Roman", "Jdi1234", "ROMAN IOVLEV", expectedHeaders, expectedIconText, "Frame"
                        + " Button", expectedLeftElements, "https://j"
                        + "di-testing.github.io/jdi-light/frame-button.html"}};
    }

    @Test(dataProvider = "dataProviderss")
    public void openPage(String title, String username, String password, String name,
                         List<String> expectedHeaders,
                         List<String> expectedIconText, String frameButtonText,
                         List<String> expectedLeftElements, String expectedUrl) {
        IndexPage indexPage = new IndexPage(driver);
        // 1. Open test site by URL
        indexPage.open("");
        // 2. Assert Browser title
        assertionStep.getTitle(title);
        // 3. Perform login
        actionStep.authorization(username, password);
        // 4. Assert username is loggined
        assertionStep.getLogginedUsername(name);
        // 5. Assert 4 headers are displayed with proper texts
        assertionStep.getTopElements(expectedHeaders);
        // 6. Assert 4 images are displayed
        assertionStep.frameList();
        // 7. Assert there are 4 texts under icons
        assertionStep.getTextsUnderIcons(expectedIconText);

        // 8. Assert that frame with "Frame button" exist
        assertionStep.buttonExists(expectedUrl);
        // 9. Check that there is “Frame Button” in the iframe
        assertionStep.buttonInFrameCheck(frameButtonText);
        // 10. Switch to original window back
        actionStep.returnToOriginalWindow();
        // 11. Assert that there are 5 items in the Left Section are
        //displayed and they have proper text
        assertionStep.fiveItemsDisplayedProperText(expectedLeftElements);

    }
}
