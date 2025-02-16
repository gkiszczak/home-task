package pl.inpost.home.task.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/api_tests.feature",
        glue = "pl.inpost.home.task.api.steps",
        plugin = {"pretty", "html:target/reports/cucumber-ui.html"}
)
public class ApiTestRunner {
}

