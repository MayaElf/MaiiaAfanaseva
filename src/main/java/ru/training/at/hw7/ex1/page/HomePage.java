package ru.training.at.hw7.ex1.page;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    @UI("#user-icon")
    public static UIElement userIcon;

    @UI("#user-name")
    private static UIElement userName;

    @UI("//input[@id='name']")
    public static TextField name;

    @UI("input#password")
    public static TextField password;

    @UI("#login-button")
    public static Button loginButton;

    @UI("//ul/li/a[.='Metals & Colors']")
    public static Button metalColors;

    public void login() {
        if (userName.isHidden()) {
            userIcon.click();
            name.sendKeys("Roman");
            password.sendKeys("Jdi1234");
            loginButton.click();
        }
    }
}
