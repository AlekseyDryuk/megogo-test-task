package steps;

import io.restassured.RestAssured;
import models.ClusterResponse;

public class ClusterStep {

    public ClusterResponse getClusterInfo(String cluster) {

        return RestAssured.given()
                .pathParam("query", cluster)
                .get("/{query}")
                .then().statusCode(200)
                .extract().as(ClusterResponse.class);
    }
}
