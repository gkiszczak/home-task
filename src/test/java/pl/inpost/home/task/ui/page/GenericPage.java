package pl.inpost.home.task.ui.page;

import pl.inpost.home.task.ui.utils.WebElementHelper;
import org.openqa.selenium.WebDriver;

public class GenericPage {
    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    
    public GenericPage(WebDriver driver) {
        this.driver = driver;
        this.webElementHelper = new WebElementHelper(driver);
    }
}
