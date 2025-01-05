package org.demoqa;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.demoqa.stepdefinitions",
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json", "html:target/cucumber-report/cucumber.html"}
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
