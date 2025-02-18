package pl.inpost.home.task.ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pl.inpost.home.task.ui.utils.ScreenshotUtils;
import pl.inpost.home.task.ui.utils.WebDriverProvider;

public class Hooks {
    private WebDriverProvider wdp = new WebDriverProvider ();
    public static WebDriver driver;

    @Before
    public void setUp() {
        this.driver = wdp.prepareWebDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.takeScreenshot(driver, scenario.getName().replaceAll(" ", "_")); 
        } 
        driver.quit();
        
    }

    public WebDriver getDriver() {
        return driver;
    }
}
