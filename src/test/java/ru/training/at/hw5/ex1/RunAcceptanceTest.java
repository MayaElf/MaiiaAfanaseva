package ru.training.at.hw5.ex1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/ru/training/at/hw5/feature/Exercise1.feature"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {

}
