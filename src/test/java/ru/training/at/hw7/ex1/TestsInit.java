package ru.training.at.hw7.ex1;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;

import com.epam.jdi.light.elements.init.InitActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


@Listeners(ITestNGListener.class)
public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setup() {
        //WebDriverManager.chromedriver().setup();
        initSite(SiteJdi.class);

    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        killAllSeleniumDrivers();
    }
}
