package org.aston.Lesson_8_tests.PostRequests;

import org.aston.Lesson_8_tests.BaseClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostRequestTest extends BaseClient {

    @Test
    public void testPostRequestBody() {
        String requestBody = "{\"test\": \"value\"}";

        given()
                .spec(getJsonSpec())
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.test", equalTo("value"))
                .body("headers.content-type", containsString("application/json"))
                .body("url", equalTo("https://postman-echo.com/post"));

    }

    //Негативные тесты
    @Test
    public void testPostEmptyBody() {
        given()
                .spec(requestSpec)
                .body("<{}>")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("<{}>"));
    }

    @Test
    public void testPostInvalidJSON() {
        String invalidJson = "{\"test\": \"value\"";

        given()
                .spec(requestSpec)
                .body(invalidJson)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(invalidJson))
                .body("json", nullValue());
    }

    @Test
    public void testPostWithoutContentType() {
        given()
                .spec(requestSpec)
                .body("{\"test\": \"value\"}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("{\"test\": \"value\"}"));
    }
}
