package ru.training.at.hw4.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ru.training.at.hw4.ex1.component.driver.WebDriverSingleton;
import ru.training.at.hw4.ex1.steps.ActionStep;
import ru.training.at.hw4.ex1.steps.AssertionStep;

public class AbstractBaseSeleniumTest {
    public WebDriver driver;
    ActionStep actionStep;
    AssertionStep assertionStep;

    @BeforeTest
    public void setUpSuite() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        driver = new WebDriverSingleton().getDriver();

        testContext.setAttribute("driver", driver);
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @AfterClass
    public void tearDown() {
        new WebDriverSingleton().closeDriver();
    }
}
