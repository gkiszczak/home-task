package pl.inpost.home.task.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import pl.inpost.home.task.ui.page.ParcelStatusPage;
import pl.inpost.home.task.config.Config;


public class SearchPageStepDefinitions {
    private WebDriver driver;
    ParcelStatusPage parcelStatusPage;

    public SearchPageStepDefinitions(
 ) { Hooks hooks = TestContext.getHooks();  
      this.driver = hooks.getDriver();
        this.parcelStatusPage = new ParcelStatusPage(driver);
        
    }

    @Given("I open InPost tracking page")
    public void iOpenInpostTrackingPage() {
        System.out.println(this.driver); parcelStatusPage.goTo();
    }

    @When("I enter tracking number {string}")
    public void iEnterTrackingNumber(String number) {
        parcelStatusPage.fillParcelNumber(number);
    }

    @And("I click search")
    public void iClickSearch() {
        parcelStatusPage.searchParcel();
    }

    @Then("I should see tracking details with status {string}")
    public void iShouldSeeTrackingDetailsWithStatus(String status) {
        String actualStatus = parcelStatusPage.getStatus();
        Assertions.assertThat(actualStatus).isNotEmpty().isEqualTo(status);
    }
}
