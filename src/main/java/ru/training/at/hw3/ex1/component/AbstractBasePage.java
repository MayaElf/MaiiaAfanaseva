package ru.training.at.hw3.ex1.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class AbstractBasePage extends AbstractComponent {
    private String path = "src/test/resources/java.properties";
    private File file = new File(path);

    public AbstractBasePage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        try {
            FileInputStream fs = new FileInputStream(file);
            Properties pro = new Properties();
            pro.load(fs);
            driver.navigate().to(pro.getProperty("url") + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
