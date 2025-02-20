package pl.inpost.home.task.ui.page;

import pl.inpost.home.task.ui.page.annotations.PageUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@PageUrl("/find-parcel")
public class ParcelStatusPage extends GenericPage{

    public ParcelStatusPage(WebDriver driver) {
        super(driver);
    }

    public String getStatus(){
        WebElement parcelStatus = driver.findElement(By.xpath("/(//div[contains(@class,'message-box')])[1]"));
        webElementHelper.waitUntilDisplayed(parcelStatus);
        return parcelStatus.getText();
    }

    public void fillParcelNumber(String parcelNumber){
        WebElement parcelNumberInput = driver.findElement(By.cssSelector("[name=number]"));
        webElementHelper.waitUntilDisplayed(parcelNumberInput);
        parcelNumberInput.sendKeys(parcelNumber);
    }

    public void searchParcel(){
        WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        webElementHelper.waitUntilDisplayed(searchButton);
        searchButton.click();
    }
}
