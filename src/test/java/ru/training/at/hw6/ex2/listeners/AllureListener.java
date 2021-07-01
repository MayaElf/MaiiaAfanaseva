package ru.training.at.hw6.ex2.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {


    @SuppressWarnings("checkstyle:ParameterName")
    @Override
    public void onTestStart(ITestResult arg0) {

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {

    }


    @Override
    public void onTestSkipped(ITestResult arg0) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

    @Override
    public void onStart(ITestContext arg) {

    }

    @Override
    public void onFinish(ITestContext arg) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        attachScreenShot(driver);
    }


    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

