package pl.inpost.home.task.api;



import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import pl.inpost.home.task.api.model.Point;
import pl.inpost.home.task.api.model.PointsResponse;
import pl.inpost.home.task.config.ApiConfig;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class InpostApi {
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static List<Point> fetchAllPoints(String city) {
        List<Point> allPoints = new ArrayList<>();
        int page = 1;
        int allPages = 0;

        do {
            Response response = given()
                    .auth()
                    .oauth2(ApiConfig.getApiKey())
                    .queryParam("city", city)
                    .queryParam("page", page)
                    .when()
                    .get(ApiConfig.getBaseUrl() + ApiConfig.POINTS_ENDPOINT)
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();

            PointsResponse pointsResponse = response.as(PointsResponse.class);
            allPages = pointsResponse.getTotalPages();
            allPoints.addAll(pointsResponse.getItems());
            page++;

        } while (page <= allPages);

        return allPoints;
    }

    public static void savePointsToFile(String city, List<Point> points) {
        try {
String filePath = "target/response/" +"package-" + city + ".json";
            File file = new File(filePath);
             objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, points);
            System.out.println("Points saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving points to file: " + e.getMessage());
        }
    }
}

