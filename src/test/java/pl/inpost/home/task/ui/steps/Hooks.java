package pl.inpost.home.task.ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pl.inpost.home.task.ui.utils.ScreenshotUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        try {
            String seleniumUrl = System.getProperty("SELENIUM_REMOTE_URL", "http://selenium:4444/wd/hub");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            this.driver = new RemoteWebDriver(new URL(seleniumUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Selenium URL", e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.takeScreenshot(driver, scenario.getName().replaceAll(" ", "_"));
        }
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
