package ru.training.at.hw7.ex1;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw7.ex1.page.HomePage;
import ru.training.at.hw7.ex1.page.MetalsAndColorsForm;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {
    @Url("/index.html")
    public static HomePage homePage;
    @Url("/metals-colors.html")
    public static MetalsAndColorsForm metalsAndColorsForm;
}
