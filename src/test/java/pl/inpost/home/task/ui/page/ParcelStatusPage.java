package pl.inpost.home.task.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParcelStatusPage extends GenericPage{

    public ParcelStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getStatus(){
        WebElement parcelStatus = driver.findElement(By.xpath("/(//div[contains(@class,'message-box')])[1]"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(d -> parcelStatus.isDisplayed());
        return parcelStatus.getText();
    }

    public void fillParcelNumber(String parcelNumber){
        WebElement parcelNumberInput = driver.findElement(By.cssSelector("[name=number]"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(d -> parcelNumberInput.isDisplayed());
        parcelNumberInput.sendKeys(parcelNumber);
    }

    public void searchParcel(){
        WebElement searchButton = driver.findElement(By.xpath("//form[@class='tracking-form']/descendant::button[@type='submit']"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(d -> searchButton.isDisplayed());
        searchButton.click();
    }
}
