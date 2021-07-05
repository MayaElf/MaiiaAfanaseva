package ru.training.at.hw5.ex2.page;

import java.util.ArrayList;
import java.util.List;
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
    @FindBy(xpath = "//label[@for='ivan' and contains(., 'Vip')]/input")
    private WebElement vipForIvanSelected;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li[contains(.,'Vip')]")
    private WebElement vipForIvanInLog;
    @FindBy(xpath = "//tbody//tr/td/select")
    private List<WebElement> usersDropDownList;
    @FindBy(xpath = "//tbody//tr/td/a")
    private List<WebElement> userNamesList;
    @FindBy(xpath = "//div[@class='user-descr']/span")
    private List<WebElement> userDescriptionList;
    @FindBy(xpath = "//div[@class='user-descr']/input[@type='checkbox']")
    private List<WebElement> userCheckBoxList;
    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> userRow;
    @FindBy(xpath = "//tbody/tr/td/select")
    private WebElement selectElement;


    public int quantityOfDropdowns() {
        return usersDropDownList.size();
    }

    public int userNamesQuantity() {
        return userNamesList.size();
    }

    public int userDescriptionQuantity() {
        return userDescriptionList.size();
    }

    public int userCheckBoxQuantity() {
        return userCheckBoxList.size();
    }


    private WebDriver webDriver;

    private final int one = 1;

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
        userTable.click();
    }

    public void clickOnService() {
        dropdownToggle.click();
    }

    public void clickVipForIvanCheck() {
        vipForIvanSelected.click();
    }

    public boolean getVipIvanLog() {
        return vipForIvanInLog.isDisplayed();
    }

    public List<List<String>> getUserDetails() {
        List<List<String>> user = new ArrayList<>();
        for (int i = 0; i < userRow.size(); i++) {
            List<String> temp = new ArrayList<>();
            temp.add(userRow.get(i).findElement(By.tagName("td")).getText());
            temp.add(userRow.get(i).findElement(By.tagName("a")).getText());
            temp.add(userRow.get(i).findElement(By.tagName("span")).getText().replace("\n", " "));
            user.add(temp);
        }
        return user;
    }

    public List<String> getSelectOptions() {
        Select select = new Select(selectElement);
        List<WebElement> selectElements = select.getOptions();
        List<String> list = new ArrayList<>();
        for (WebElement element : selectElements) {
            list.add(element.getText());
        }
        return list;
    }

}


