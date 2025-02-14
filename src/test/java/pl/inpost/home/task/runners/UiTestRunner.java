package pl.inpost.home.task.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/ui_tests.feature",
        glue = "pl.inpost.home.task.ui.steps",
        plugin = {"pretty", "json:target/cucumber.json"}
)
public class UiTestRunner {
}

