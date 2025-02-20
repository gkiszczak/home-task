package pl.inpost.home.task.ui.page;

import pl.inpost.home.task.ui.page.annotations.PageUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
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
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.RETURN).perform();
        //WebElement searchButton = driver.findElement(By.xpath("//form[@class='tracking-form']/descendant::button"));
        //webElementHelper.waitUntilDisplayed(searchButton);
        //searchButton.click();
    }
}
