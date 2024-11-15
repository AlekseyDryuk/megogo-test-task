package tests;

import assertions.ClusterAssertion;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.ClusterResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.ClusterStep;

@Feature("Cluster Tests")
class ClusterTest extends BaseTest {

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {
            "0.ua.pool.ntp.org",
            "1.ua.pool.ntp.org",
            "2.ua.pool.ntp.org",
            "3.ua.pool.ntp.org",
            "4.ua.pool.ntp.org"
    })
    @Story("Verify clusters located in Ukraine")
    @DisplayName("Verify cluster located in Ukraine")
    @Description("Verify that clusters are located in Ukraine by querying the pool.ntp.org server for each cluster.")
    void verifyClustersLocatedInUkraine(String cluster) {
        ClusterStep clusterStep = new ClusterStep();

        ClusterResponse clusterResponse = clusterStep.getClusterInfo(cluster);
        ClusterAssertion.verifyClusterCountry(clusterResponse, "Ukraine");
    }
}
