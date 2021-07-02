package ru.training.at.hw3.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ru.training.at.hw3.ex1.component.driver.WebDriverSingleton;

public class AbstractBaseSeleniumTest {
    public WebDriver driver;

    @BeforeTest
    public void setUpSuite() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        driver = new WebDriverSingleton().getDriver();

        testContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        new WebDriverSingleton().closeDriver();
    }
}
