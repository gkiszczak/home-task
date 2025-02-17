package pl.inpost.home.task.ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverProvider {

    public WebDriver prepareWebDriver() {
        try {
            String seleniumUrl = System.getProperty("SELENIUM_REMOTE_URL", "http://selenium:4444/wd/hub");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            return new RemoteWebDriver(new URL(seleniumUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Selenium URL", e);
        }
    }
}
