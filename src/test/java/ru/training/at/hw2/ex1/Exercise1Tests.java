package ru.training.at.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Exercise1Tests {

    private WebDriver webDriver;

    private final String url = "https://jdi-testing.github.io/jdi-light/index.html ";

    private final String listXPath = "//ul[@class='uui"
            + "-navigation nav navbar-nav m-l8']/li/a";

    private final String[] expectesHeaders = new String[]{"HOME", "CON"
            + "TACT FORM", "SERVICE", "METALS & COLORS"};

    private final String[] expectedTxtIcon = new String[]{"To "
            + "include good practices\nand "
            + "ideas from successful\nEPAM project", "To be flexible and\ncus"
            + "tomizable", "To be multiplatform", "Alre"
            + "ady have good base\n(about 20 internal and\n"
            + "some external projects),\nwish to get more…"};

    private final String frameButton = "Frame Button";

    private final String frameButtonLink = "https://j"
            + "di-testing.github.io/jdi-light/frame-button.html";

    private final String[] leftString = new String[]{"Home", "C"
            + "ontact form", "Ser"
            + "vice", "Metals & Colors", "Elements packs"};

    private final int four = 4;

    private final int five = 5;

    private final int ten = 10;

    private final String leftElementXpath = "//ul[@cl"
            + "ass='sidebar-menu left']/li/a/span";


    @BeforeClass
    public static void setupClass() {
        WebDriverManager
                .chromedriver()
                .setup();
    }


    @Test
    public void tests() {
        webDriver = new ChromeDriver();
        webDriver
                .manage()
                .window()
                .maximize();
        webDriver
                .manage()
                .timeouts()
                .implicitlyWait(ten, TimeUnit.SECONDS);
        //1. Open test site by URL
        webDriver
                .navigate()
                .to(url);
        //2. Assert Browser title
        Assert.assertEquals(webDriver
                .getTitle(), "Home Page");
        //3. Perform login
        WebElement openButton = webDriver
                .findElement(By.id("user-icon"));
        openButton.click();
        WebElement login = webDriver
                .findElement(By.id("name"));
        WebElement password = webDriver
                .findElement(By.id("password"));
        login.sendKeys("Roman");
        password.sendKeys("Jdi1234");
        webDriver
                .findElement(By
                        .id("login-button"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, ten);
        loginButton.click();
        //4. Assert username is loggined
        Assert.assertEquals(webDriver
                .findElement(By.id("user-name"))
                .getText(), "ROMAN IOVLEV");
        //5. Assert 4 headers are displayed with proper texts
        List<WebElement> elementList = webDriver
                .findElements(By
                        .xpath(listXPath));
        String[] actualHeaders = new String[elementList.size()];
        Assert.assertEquals(elementList.size(), four);
        for (int i = 0; i < elementList.size(); i++) {
            actualHeaders[i] = elementList.get(i).getText();
        }
        Assert.assertEquals(actualHeaders, expectesHeaders);

        //6. Assert 4 images are displayed
        Assert.assertTrue(webDriver
                .findElement(By.id("frame"))
                .isDisplayed());
        Assert.assertTrue(webDriver
                .findElement(By.id("first_frame"))
                .isDisplayed());
        Assert.assertTrue(webDriver
                .findElement(By.id("second_frame"))
                .isDisplayed());
        Assert.assertTrue(webDriver
                .findElement(By.id("jdi-frame-site"))
                .isDisplayed());

        //7. Assert there are 4 texts under icons
        List<WebElement> txtElementList = webDriver
                .findElements(By
                        .className("benefit-txt"));
        Assert.assertEquals(four, txtElementList.size());
        List<String> actualTxtElements = new ArrayList<>();
        for (WebElement element : txtElementList) {
            Assert.assertTrue(element.isDisplayed());
        }
        for (WebElement element : txtElementList) {
            actualTxtElements.add(element.getText());
        }
        Assert.assertEquals(actualTxtElements.toArray(), expectedTxtIcon);

        //8. Assert that frame with "Frame button" exist
        Assert.assertEquals(webDriver
                .findElement(By.id("frame"))
                .getAttribute("src"), frameButtonLink);

        //9. Check that there is “Frame Button” in the iframe
        WebElement frameElement = webDriver.findElement(By.id("frame"));
        webDriver.switchTo().frame(frameElement);
        Assert.assertEquals(webDriver
                .findElement(By.id("frame-button"))
                .getAttribute("value"), frameButton);

        //10. Switch to original window back
        webDriver
                .switchTo()
                .defaultContent();

        //11. Assert that there are 5 items in the Left Section are
        // displayed and they have proper text
        List<WebElement> leftElement = webDriver
                .findElements(By.xpath(leftElementXpath));
        Assert.assertEquals(leftElement.size(), five);
        List<String> actualLeftElements = new ArrayList<>();
        for (WebElement element : leftElement) {
            actualLeftElements.add(element.getText());
        }
        Assert.assertEquals(actualLeftElements.toArray(), leftString);
        //12. Close Browser
        webDriver.close();
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
