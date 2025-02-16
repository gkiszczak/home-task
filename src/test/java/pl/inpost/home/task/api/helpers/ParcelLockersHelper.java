package pl.inpost.home.task.api.helpers;


import io.restassured.response.Response;
import pl.inpost.home.task.api.model.Point;
import pl.inpost.home.task.api.model.PointsResponse;
import static io.restassured.RestAssured.given;
import pl.inpost.home.task.config.Config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ParcelLockersHelper extends BaseHelper {

    private static final String POINTS_ENDPOINT = "/points";
    
    public List<Point> getParcelLockersForCity(String city) {
        List<Point> allPoints = new ArrayList<>();
        int page = 1;
        int allPages = 0;

        do {
            Response response = given()
                    .auth()
                    .oauth2(Config.getApiKey())
                    .queryParam("city", city)
                    .queryParam("page", page)
                    .when()
                    .get(getEndpoint(POINTS_ENDPOINT))
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
                    
                    response.prettyPrint();

            PointsResponse pointsResponse = response.as(PointsResponse.class);
            allPages = pointsResponse.getTotalPages();
            allPoints.addAll(pointsResponse.getItems());
            page++;

        } while (page <= allPages);

        return allPoints;
    }
}

