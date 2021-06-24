package ru.training.at.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;


public class IndexPage1 {
    @FindBy(id = "user-icon")
    private WebElement openButton;
    @FindBy(id = "name")
    private WebElement user;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement button;
    @FindBy(id = "user-name")
    private WebElement authorityName;
    @FindBy(xpath = "//ul[@class='uui"
            + "-navigation nav navbar-nav m-l8']/li/a")
    private List<WebElement> topElements;
    @FindBy(id = "frame")
    private WebElement frameElement;
    @FindBy(id = "first_frame")
    private WebElement frameFirstElement;
    @FindBy(id = "second_frame")
    private WebElement frameSecondElement;
    @FindBy(id = "jdi-frame-site")
    private WebElement frameJdiElement;
    @FindBy(id = "benefit-txt")
    private List<WebElement> txtElementList;

    private WebDriver webDriver;

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getAuthorityName() {
        return authorityName.getText();
    }

    public void open() {
        webDriver
                .manage()
                .window()
                .maximize();
        webDriver
                .manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        webDriver
                .navigate()
                .to("https://jdi-testing.github.io/jdi-light/index.html ");
    }

    public List<WebElement> getTopElements() {
        return topElements;
    }

    public List<WebElement> getFrameList() {
        List<WebElement> elementList = new ArrayList<>();
        elementList.add(frameElement);
        elementList.add(frameFirstElement);
        elementList.add(frameSecondElement);
        elementList.add(frameJdiElement);
        return elementList;
    }

    public List<WebElement> getTxtElementList() {
        return txtElementList;
    }
}
