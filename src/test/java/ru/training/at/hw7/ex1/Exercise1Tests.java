package ru.training.at.hw7.ex1;

import static ru.training.at.hw7.ex1.SiteJdi.homePage;
import static ru.training.at.hw7.ex1.page.HomePage.loginButton;
import static ru.training.at.hw7.ex1.page.HomePage.metalColors;
import static ru.training.at.hw7.ex1.page.HomePage.name;
import static ru.training.at.hw7.ex1.page.HomePage.password;
import static ru.training.at.hw7.ex1.page.HomePage.userIcon;

import org.testng.annotations.Test;

/*@Listeners({AllureListener.class})*/
public class Exercise1Tests implements TestsInit {
    @Test
    public void loginTest() {
        homePage.open();
        userIcon.click();
        name.sendKeys("Roman");
        password.sendKeys("Jdi1234");
        loginButton.click();
        metalColors.click();
    }

}
