package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = "stepDefinitions",
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true,
    dryRun = false
)
public class TestRunner {
    
}