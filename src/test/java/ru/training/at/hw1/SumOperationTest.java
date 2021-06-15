package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SumOperationTest {

    private double actual;
    private double expected;

    @Test (dataProvider = "data-provider")
    public void sumTest(double val1, double val2, double result) {
        actual = new Calculator().sum(val1, val2);
        expected = result;
        Assert.assertEquals(expected, actual);
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpmethod() {
        return new Object[][] {{6, 2, 8}};
    }

}
