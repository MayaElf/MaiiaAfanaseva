package ru.training.at.hw5.ex3;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/ru/training/at/hw5/feature/Exercise3.feature"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {

}
