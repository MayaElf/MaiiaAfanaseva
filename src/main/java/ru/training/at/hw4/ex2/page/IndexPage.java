package ru.training.at.hw4.ex2.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.training.at.hw4.ex1.component.AbstractBasePage;




public class IndexPage extends AbstractBasePage {
    public IndexPage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
    }

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
    @FindBy(className = "dropdown-toggle")
    private WebElement dropdownToggle;
    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[.='Different elements']")
    private WebElement differentElements;
    @FindBy(xpath = "//label[@class='label-checkbox' and contains(., 'Water')]/input")
    private WebElement waterCheck;
    @FindBy(xpath = "//label[@class='label-checkbox' and contains(., 'Wind')]/input")
    private WebElement windCheck;
    @FindBy(xpath = "//label[@class='label-radio' and contains(., 'Selen')]/input")
    private WebElement selenRadioButton;
    @FindBy(xpath = "//div[@class='colors']/select")
    private WebElement listSelect;
    @FindBy(xpath = "//div[@class='colors']/select/option[contains(., 'Yellow')]")
    private WebElement yellowSelect;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(.,'Water')]")
    private WebElement waterInLog;
    @FindBy(xpath = "//label[@class='label-checkbox' and contains(., 'Water')]/input")
    private WebElement waterSelected;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(.,'Wind')]")
    private WebElement windInLog;
    @FindBy(xpath = "//label[@class='label-checkbox' and contains(., 'Wind')]/input")
    private WebElement windSelected;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(.,'Selen')]")
    private WebElement selenInLog;
    @FindBy(xpath = "//label[@class='label-radio' and contains(., 'Selen')]/input")
    private WebElement selenSelected;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(.,'Yellow')]")
    private  WebElement yellowInLog;
    @FindBy(xpath = "//div[@class='colors']/select")
    private WebElement yellowSelected;

    private WebDriver webDriver;


    private final String roman = "ROMAN IOVLEV";

    private final String homePage = "Home Page";

    public String getTitles() {
        return webDriver.getTitle();
    }

    public void login() {
        openButton.click();
        user.sendKeys("Roman");
        password.sendKeys("Jdi1234");
        loginButton.click();
    }

    public String getNameOfTitle() {
        return homePage;
    }

    public String getRoman() {
        return roman;
    }

    public String getAuthorityName() {
        return authorityName.getText();
    }

    public void changePage() {
        dropdownToggle.click();
        differentElements.click();
    }

    public void clickWaterWindCheck() {
        waterCheck.click();
        windCheck.click();
    }

    public void clickSelenRadioButton() {
        selenRadioButton.click();
    }

    public void yellowElementSelect() {
        listSelect.click();
        yellowSelect.click();

    }

    public boolean getWaterLog() {
        return waterInLog.isDisplayed();
    }

    public boolean isWaterSelected() {
        return waterSelected.isSelected();
    }

    public boolean getWindLog() {
        return windInLog.isDisplayed();
    }

    public boolean isWindSelected() {
        return windSelected.isSelected();
    }

    public boolean getSelenLog() {
        return selenInLog.isDisplayed();
    }

    public boolean isSelenSelected() {
        return selenSelected.isSelected();
    }

    public boolean getYellowLog() {
        return yellowInLog.isDisplayed();
    }

    public boolean isYellowSelected() {
        Select yellow = new Select(yellowSelected);
        return yellowInLog.getText().contains(yellow.getFirstSelectedOption().getText());
    }

}

