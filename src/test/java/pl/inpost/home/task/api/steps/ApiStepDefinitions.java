package pl.inpost.home.task.api.steps;

import pl.inpost.home.task.api.utils.ResponseFileWriter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pl.inpost.home.task.api.helpers.ParcelLockersHelper;
import pl.inpost.home.task.api.model.Point;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class ApiStepDefinitions {

    private ResponseFileWriter responseFileWriter = new ResponseFileWriter();
    private ParcelLockersHelper parcelLockersHelper = new ParcelLockersHelper();

    private List<Point> points;
    private Map<String, List<Point>> cityPointsMap = new HashMap<>();

    @Given("I fetch all points in {string}")
    public void iFetchAllPointsIn(String cities) {
        String[] cityArray = cities.split(",");
        for (String city : cities) {
            List<Point> cityPoints = parcelLockersHelper.getParcelLockersForCity(city);
            cityPointsMap.put(city, cityPoints);
        }
    }

    @Then("the response contains at least 1 point")
    public void theResponseContainsAtLeastOnePoint() {
        for (Map.Entry<String, List<Point>> entry : cityPointsMap.entrySet()) { 
        String city = entry.getKey();
        List<Point> points = entry.getValue();
        Assertions.assertThat(points).isNotEmpty();
        }
    }

    @Then("the response is saved to file with city in the name")
    public void theResponseIsSavedToFile() { 
          for (Map.Entry<String, List<Point>> entry : cityPointsMap.entrySet()) {
            String city = entry.getKey();
            List<Point> points = entry.getValue();
            responseFileWriter.savePointsToFile(city, points);
        }
    }
}
