package testPlans;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    @BeforeTest
    public static void defaultRequestSpec() {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        filters.add(new ErrorLoggingFilter());
        filters.add(new AllureRestAssured());

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost:5000")
                .setBasePath("/api")
                .addFilters(filters)
                .setContentType(ContentType.JSON)
                .build();
    }
}
