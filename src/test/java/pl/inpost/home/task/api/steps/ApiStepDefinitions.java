package pl.inpost.home.task.api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pl.inpost.home.task.api.InpostApi;
import pl.inpost.home.task.api.model.Point;

import java.util.List;

public class ApiStepDefinitions {

    private List<Point> points;

    @Given("I fetch all points in {string}")
    public void iFetchAllPointsIn(String city) {
        points = InpostApi.fetchAllPoints(city);
    }

    @Then("the response contains at least 1 point")
    public void theResponseContainsAtLeastOnePoint() {
        Assertions.assertThat(points).isNotEmpty();
    }

    @Then("the response is saved to file {string}")
    public void theResponseIsSavedToFile(String city) {
        InpostApi.savePointsToFile(city, points);
    }


}
