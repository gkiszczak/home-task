package pl.inpost.home.task.ui.page;

import pl.inpost.home.task.ui.page.annotations.PageUrl;
import pl.inpost.home.task.config.Config;
import pl.inpost.home.task.ui.utils.WebElementHelper;
import org.openqa.selenium.WebDriver;

public class GenericPage {
    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    
    public GenericPage(WebDriver driver) {
    System.out.println("init page object");
    System.out.println(driver);
        this.driver = driver;
        this.webElementHelper = new WebElementHelper(driver);
    }
        public void goTo() {
        if (this.getClass().isAnnotationPresent(PageUrl.class)) {
            String url = Config.getBaseUIUrl() + this.getClass().getAnnotation(PageUrl.class).value();
            driver.get(url);
        } else {
            throw new IllegalStateException("PageUrl annotation is missing on " + this.getClass().getSimpleName());
        }
    }
}
