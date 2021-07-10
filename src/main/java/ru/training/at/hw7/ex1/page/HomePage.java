package ru.training.at.hw7.ex1.page;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    @UI("#user-icon")
    public static UIElement userIcon;

    @UI("//input[@id='name']")
    public static WebElement name;

    @UI("input#password")
    public static WebElement password;

    @UI("#login-button")
    public static WebElement loginButton;

    @UI("//ul/li/a[.='Metals & Colors']")
    public static WebElement metalColors;


}
