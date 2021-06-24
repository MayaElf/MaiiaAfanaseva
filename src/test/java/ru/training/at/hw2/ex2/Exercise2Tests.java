package ru.training.at.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise2Tests {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager
                .chromedriver()
                .setup();
    }

    private final String url = "https://jdi-testing.github.io/jdi-light/index.html ";

    private WebDriver webDriver;
    private final int ten = 10;

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

        //5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.className("dropdown-toggle")).click();
        webDriver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[.='Different elements']")).click();

        //6. Select checkboxes Water and Wind
        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().activeElement();
        webDriver.findElement(By.xpath("//label[@class='label-checkbox' and contains(., 'Water')]/input")).click();
        webDriver.findElement(By.xpath("//label[@class='label-checkbox' and contains(., 'Wind')]/input")).click();

        //7. Select radio Selen
        webDriver.findElement(By.xpath("//label[@class='label-radio' and contains(., 'Selen')]/input")).click();

        //8.Select in dropdown Yellow
        webDriver.findElement(By.xpath("//div[@class='colors']/select")).click();
        webDriver.findElement(By.xpath("//div[@class='colors']/select/option[contains(., 'Yellow')]")).click();

        //9. Assert checkbox, radio, dropdown name and its status are corresponding to selected
        WebElement waterLog = webDriver.findElement(By.xpath("//ul[@class='panel-body-list logs']"
                + "/li[contains(., 'Water')]"));
        Assert.assertTrue(waterLog.getText().contains("Water"));
        Assert.assertTrue(webDriver.findElement(By.xpath("//label[@class='label-checkbox' "
                + "and contains(., 'Water')]/input")).isSelected());

        WebElement windLog = webDriver.findElement(By.xpath("//ul[@class='panel-body-list logs']"
                + "/li[contains(., 'Wind')]"));
        Assert.assertTrue(windLog.getText().contains("Wind"));
        Assert.assertTrue(webDriver.findElement(By.xpath("//label[@class='label-checkbox' "
                + "and contains(., 'Wind')]/input")).isSelected());

        WebElement selenLog = webDriver.findElement(By.xpath("//ul[@class='panel-body-list logs']"
                + "/li[contains(., 'Selen')]"));
        Assert.assertTrue(selenLog.getText().contains("Selen"));
        Assert.assertTrue(webDriver.findElement(By.xpath("//label[@class='label-radio' "
                + "and contains(., 'Selen')]/input")).isSelected());

        WebElement yellowLog = webDriver.findElement(By.xpath("//ul[@class='panel-body-list logs']"
                + "/li[contains(., 'Yellow')]"));
        Select yellow = new Select(webDriver.findElement(By.xpath("//div[@class='colors']/select")));
        Assert.assertTrue(yellowLog.getText().contains(yellow.getFirstSelectedOption().getText()));

        //10. Close Browser

        webDriver.close();
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
