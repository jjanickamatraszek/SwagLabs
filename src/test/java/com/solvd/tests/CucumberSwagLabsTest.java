package com.solvd.tests;

import com.zebrunner.carina.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.solvd.steps",
        snippets= CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"
        }
)
public class CucumberSwagLabsTest extends CucumberBaseTest {
}
