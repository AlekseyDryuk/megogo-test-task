package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

class BaseTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://ip-api.com/json";
        RestAssured.filters(new ResponseLoggingFilter());
        RestAssured.filters(new AllureRestAssured());
    }
}
