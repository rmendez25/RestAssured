package utils;

import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestUtils {
    public static Response get(String url) {

        return given()
                .expect().defaultParser(Parser.JSON)
                .when()
                .get(url)
                .then()
                .extract().response();
    }

    public static Response get(String url, Map<String, String> params) {

        return given()
                .pathParams(params)
                .when()
                .get(url)
                .then()
                .extract().response();
    }

    public static Response post(String url, Object payload) {

        return given()
                .body(payload)
                .when()
                .post(url)
                .then()
                .extract().response();
    }

    public static Response update(String url, Map<String, String> params, Object payload) {

        return given()
                .pathParams(params)
                .when()
                .body(payload)
                .patch(url)
                .then()
                .extract().response();
    }

    public static Response delete(String url, Map<String, String> params) {

        return given()
                .pathParams(params)
                .when()
                .delete(url)
                .then()
                .extract().response();
    }

}
