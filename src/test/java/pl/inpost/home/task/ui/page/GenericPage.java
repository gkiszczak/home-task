package pl.inpost.home.task.ui.page;

import pl.inpost.home.task.config.Config;
import pl.inpost.home.task.ui.utils.WebElementHelper;
import org.openqa.selenium.WebDriver;

public class GenericPage {
    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    
    public GenericPage(WebDriver driver) {
        this.driver = driver;
        this.webElementHelper = new WebElementHelper(driver);
    }
        public void navigateToPage() {
        if (this.getClass().isAnnotationPresent(PageUrl.class)) {
            String url = Config.getBaseUIUrl() + this.getClass().getAnnotation(PageUrl.class).value();
            driver.get(url);
        } else {
            throw new IllegalStateException("PageUrl annotation is missing on " + this.getClass().getSimpleName());
        }
    
}
