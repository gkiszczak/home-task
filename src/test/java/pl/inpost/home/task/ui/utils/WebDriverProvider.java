package pl.inpost.home.task.ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverProvider {

    public WebDriver prepareWebDriver() {
    
      System.out.println("=== Starting Remote WebDriver");

        System.out.println("=== WebDriver started ===");
        try {
            String seleniumUrl = System.getProperty("SELENIUM_REMOTE_URL", "http://selenium:4444/wd/hub");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            return new RemoteWebDriver(new URL(seleniumUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Selenium URL", e);
        }
    }
}
