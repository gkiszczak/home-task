package pl.inpost.home.task.api.steps;

import pl.inpost.home.task.api.utils.ResponseFileWriter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pl.inpost.home.task.api.helpers.ParcelLockersHelper;
import pl.inpost.home.task.api.model.Point;

import java.util.List;

public class ApiStepDefinitions {

    private ResponseFileWriter responseFileWriter = new ResponseFileWriter();
    private ParcelLockersHelper parcelLockersHelper = new ParcelLockersHelper();

    private List<Point> points;

    @Given("I fetch all points in {string}")
    public void iFetchAllPointsIn(String city) {
        points = parcelLockersHelper.getParcelLockersForCity(city);
    }

    @Then("the response contains at least 1 point")
    public void theResponseContainsAtLeastOnePoint() {
        Assertions.assertThat(points).isNotEmpty();
    }

    @Then("the response is saved to file {string}")
    public void theResponseIsSavedToFile(String city) { 
    responseFileWriter.savePointsToFile(city, points);
    }
}
