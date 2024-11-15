package assertions;

import models.ClusterResponse;
import org.junit.jupiter.api.Assertions;

public class ClusterAssertion {

    public static void verifyClusterCountry(ClusterResponse clusterResponse, String expectedCountry) {
        if (clusterResponse.getStatus().equals("success")) {
            Assertions.assertEquals(expectedCountry, clusterResponse.getCountry(),
                    "This cluster is from " + clusterResponse.getCountry());
        } else {
            Assertions.fail(String.format("Cluster response status is %s, with %s message",
                    clusterResponse.getStatus(), clusterResponse.getMessage()));
        }
    }
}
