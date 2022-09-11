package utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestUtils {

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

    public static Response get(String url) {
        defaultRequestSpec();

        return given()
                .expect().defaultParser(Parser.JSON)
                .when()
                .get(url)
                .then()
                .extract().response();
    }

    public static Response get(String url, Map<String, String> params) {
        defaultRequestSpec();

        return given()
                .pathParams(params)
                .when()
                .get(url)
                .then()
                .extract().response();
    }

    public static Response post(String url, Object payload) {
        defaultRequestSpec();

        return given()
                .body(payload)
                .when()
                .post(url)
                .then()
                .extract().response();
    }

    public static Response update(String url, Map<String, String> params, Object payload) {
        defaultRequestSpec();

        return given()
                .pathParams(params)
                .when()
                .body(payload)
                .patch(url)
                .then()
                .extract().response();
    }

    public static Response delete(String url, Map<String, String> params) {
        defaultRequestSpec();

        return given()
                .pathParams(params)
                .when()
                .delete(url)
                .then()
                .extract().response();
    }

}
