package pl.inpost.home.task.ui.page;

import pl.inpost.home.task.ui.page.annotations.PageUrl;
import pl.inpost.home.task.config.Config;
import pl.inpost.home.task.ui.utils.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GenericPage {
    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    
    public GenericPage(WebDriver driver) {
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
    
    public void handleCookiePopup(){
        WebElement cookiePopupAccept = driver.findElement(By.id("onetrust-accept-btn-handler"));
        webElementHelper.waitUntilDisplayed(cookiePopupAccept);
        cookiePopupAccept.click();
    }
}
