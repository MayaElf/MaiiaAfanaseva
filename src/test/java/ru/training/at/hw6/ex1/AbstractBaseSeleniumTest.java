package ru.training.at.hw6.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ru.training.at.hw6.ex1.component.driver.WebDriverSingleton;
import ru.training.at.hw6.ex1.steps.ActionStep;
import ru.training.at.hw6.ex1.steps.AssertionStep;

public class AbstractBaseSeleniumTest {
    protected WebDriver driver;

    ActionStep actionStep;
    AssertionStep assertionStep;

    @BeforeTest
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        driver = WebDriverSingleton.getDriver();

        //driver.manage().window().maximize();

        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        testContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
