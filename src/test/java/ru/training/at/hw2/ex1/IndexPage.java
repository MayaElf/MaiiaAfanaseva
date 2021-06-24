package ru.training.at.hw2.ex1;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class IndexPage extends AbstractBasePage {
    public IndexPage(WebDriver driver) {
        super(driver);
        expectedHeadersList.add("HOME");
        expectedHeadersList.add("CONTACT FORM");
        expectedHeadersList.add("SERVICE");
        expectedHeadersList.add("METALS & COLORS");

        expectedTxtIcon.add("To include good practices\nand ideas from successful\nEPAM project");
        expectedTxtIcon.add("To be flexible and\ncustomizable");
        expectedTxtIcon.add("To be multiplatform");
        expectedTxtIcon.add("Already have good base\n(about 20"
                + " internal and\nsome external projects),\nwish to get more…");
        expectedLeftElements.add("Home");
        expectedLeftElements.add("Contact form");
        expectedLeftElements.add("Service");
        expectedLeftElements.add("Metals & Colors");
        expectedLeftElements.add("Elements packs");

    }

    public void open() {
        open("");
    }

    public void closeThePage() {
        webDriver.close();
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    private static final List<String> expectedHeadersList = new ArrayList<String>();
    private static final List<String> expectedTxtIcon = new ArrayList<String>();
    private static final List<String> expectedLeftElements = new ArrayList<>();

    @FindBy(id = "user-icon")
    private WebElement openButton;
    @FindBy(id = "name")
    private WebElement user;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
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
    @FindBy(id = "frame")
    private WebElement frameButton;
    @FindBy(id = "frame-button")
    private WebElement frameButtonTxt;
    @FindBy(xpath = "\"//ul[@class='sidebar-menu left']/li/a/span\"")
    private List<WebElement> leftElements;

    private final String frameButtonText = "Frame Button";

    private final String frameButtonLink = "https://j"
            + "di-testing.github.io/jdi-light/frame-button.html";

    private WebDriver webDriver;

    public String getFrameButtonText() {
        return frameButtonText;
    }

    public List<String> getExpectedLeftElements() {
        return expectedLeftElements;
    }

    public List<WebElement> getLeftElements() {
        return leftElements;
    }

    public void switchToFrameElement() {
        webDriver.switchTo().frame(frameButton);
    }

    public void switchToDefault() {
        webDriver.switchTo().defaultContent();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getFrameButtonLink() {
        return frameButtonLink;
    }

    public String getFrameButton() {
        return frameButton.getAttribute("src");
    }

    public String getFrameButtonTxt() {
        return frameButtonTxt.getAttribute("value");
    }

    public void login() {
        openButton.click();
        user.sendKeys("Roman");
        password.sendKeys("Jdi1234");
        loginButton.click();
    }

    public String getAuthorityName() {
        return authorityName.getText();
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

    public List<String> getExpectedHeadersList() {
        return expectedHeadersList;
    }

    public List<WebElement> getTxtElementList() {
        return txtElementList;
    }

    public List<String> getExpectedTxtIcon() {
        return expectedTxtIcon;
    }
}
