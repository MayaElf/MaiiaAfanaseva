package ru.training.at.hw7.ex1;

import static ru.training.at.hw7.ex1.SiteJdi.homePage;
import static ru.training.at.hw7.ex1.SiteJdi.metalsAndColorsForm;
import static ru.training.at.hw7.ex1.page.HomePage.metalColors;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw7.ex1.entities.MetalsColors;



public class Exercise1Tests implements TestsInit {

    @DataProvider(name = "json-data")
    public static Object[][] getJson() {
        Gson gson = new Gson();
        String fileName = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";
        try {
            JsonObject jsonObject = new JsonParser().parseReader(new FileReader(fileName)).getAsJsonObject();
            List<MetalsColors> data = jsonObject.keySet().stream()
                    .map(key -> gson.fromJson(jsonObject.get(key), MetalsColors.class))
                    .collect(Collectors.toList());
            return data.stream().map(value -> new MetalsColors[]{value}).toArray(Object[][]::new);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Test(dataProvider = "json-data")
    public void loginTest(MetalsColors metalsColors) {
        homePage.open();
        homePage.login();
        metalColors.click();
        metalsAndColorsForm.isOpened();
        metalsAndColorsForm.fillForm(metalsColors);
        metalsAndColorsForm.submit();
        Assert.assertEquals(metalsAndColorsForm.getResult(), getExpectedResultList(metalsColors));
    }

    public List<String> getExpectedResultList(MetalsColors metalsColors) {
        List<String> list = new ArrayList<>();
        int temp = metalsColors.summary[0] + metalsColors.summary[1];
        list.add("Summary: " + temp);
        list.add("Elements: " + Arrays.toString(metalsColors.elements).replace("[", "").replace("]", ""));
        list.add("Color: " + metalsColors.color);
        list.add("Metal: " + metalsColors.metals);
        list.add("Vegetables: " + Arrays.toString(metalsColors.vegetables).replace("[", "").replace("]", ""));
        return list;
    }

}
