package ru.training.at.hw5.ex3.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.training.at.hw5.ex1.component.AbstractBasePage;


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
    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[.='User Table ']")
    private WebElement userTable;
    @FindBy(id = "ivan")
    private WebElement vipForIvanSelected;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(.,'Vip')]")
    private WebElement vipForIvanInLog;



    private WebDriver webDriver;


    private final String roman = "ROMAN IOVLEV";

    private final String homePage = "Home Page";

    public String getTitles() {
        return webDriver.getTitle();
    }

    public void login(String name, String password) {
        openButton.click();
        user.sendKeys(name);
        this.password.sendKeys(password);
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

    public void clickOnService() {
        dropdownToggle.click();
    }


    public void changePage() {
        userTable.click();
    }

    public void clickVipForIvanCheck() {
        vipForIvanSelected.click();
    }

    public String getVipIvanLog() {
        return vipForIvanInLog.getText();
    }

}


