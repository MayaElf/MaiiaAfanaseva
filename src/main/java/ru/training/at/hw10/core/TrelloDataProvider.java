package ru.training.at.hw10.core;

import org.testng.annotations.DataProvider;
import ru.training.at.hw10.constants.ParamEnum;

public class TrelloDataProvider {

    @DataProvider
    public Object[][] cardNameDataProvider() {
        return new Object[][] {
            {"HW10_CARD", ParamEnum.values()}
        };
    }

    @DataProvider
    public Object[][] cardDescDataProvider() {
        return new Object[][] {
            {"Awesome task", ParamEnum.values()}
        };
    }

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][] {
            {ParamEnum.values()}
        };
    }

    @DataProvider
    public Object[][] cardIdBoardDataProvider() {
        return new Object[][] {
            {"60f300ddb915db17bb2726b4", ParamEnum.values()}
        };
    }

    @DataProvider
    public Object[][] cardIdListDataProvider() {
        return new Object[][] {
            {"60f300ddb915db17bb2726b5", ParamEnum.values()}
        };
    }

    @DataProvider
    public Object[][] falseDataProvider() {
        return new Object[][] {
            {false, ParamEnum.values()}
        };
    }
}
