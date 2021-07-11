package ru.training.at.hw7.ex1.page;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import ru.training.at.hw7.ex1.entities.MetalsColors;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsForm extends WebPage {
    @UI("[name=custom_radio_odd]")
    private static RadioButtons odds;
    @UI("[name=custom_radio_even]")
    private static RadioButtons even;
    @UI("#elements-checklist input")
    private static Checklist elements;
    @JDropdown(list = "#colors li",
            expand = "#colors span.caret")
    private static Dropdown colors;
    @JDropdown(list = "#metals span.text", expand = "#metals span.caret")
    private static Dropdown metals;
    @JDropdown(list = "#vegetables li", expand = "#vegetables span.caret")
    private static Dropdown vegetables;
    @UI("#submit-button")
    private static Button submit;
    @UI("//ul[@class='panel-body-list results']/li")
    private static UIElement result;

    public static void fillForm(MetalsColors metalsColors) {
        odds.select(String.valueOf(metalsColors.summary[0]));
        even.select(String.valueOf(metalsColors.summary[1]));
        for (String s : metalsColors.elements) {
            elements.select(s);
        }
        colors.expand();
        colors.select(metalsColors.color);
        metals.expand();
        metals.select(metalsColors.metals);
        vegetables.expand();
        vegetables.select(3);
        for (String s : metalsColors.vegetables) {
            vegetables.select(s);
        }
    }

    public void submit() {
        submit.click();
    }

    public static List<String> getResult() {
        List<String> list = new ArrayList<>();
        for (WebElement element : result.getAll()) {
            list.add(element.getText());
        }
        return list;
    }

}
