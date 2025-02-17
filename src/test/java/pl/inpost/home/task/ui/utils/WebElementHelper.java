package pl.inpost.home.task.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementHelper {

	private WebDriver driver;

	public WebElementHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void waitUntilDisplayed(WebElement element) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(d -> element.isDisplayed());
	}
}