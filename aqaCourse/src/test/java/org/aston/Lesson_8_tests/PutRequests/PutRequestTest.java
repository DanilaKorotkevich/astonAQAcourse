package org.aston.Lesson_8_tests.PutRequests;

import org.aston.Lesson_8_tests.BaseClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class PutRequestTest extends BaseClient {

    @Test
    public void testPutRequestStatus() {
        given()
                .spec(getTextPlainSpec())
                .when()
                .put("/put")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPutRequestBody() {

        given()
                .spec(getTextPlainSpec())
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void testPutResponseStructure() {
        given()
                .spec(getTextPlainSpec())
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("$", hasKey("args"))
                .body("$", hasKey("data"))
                .body("$", hasKey("files"))
                .body("$", hasKey("form"))
                .body("$", hasKey("headers"))
                .body("$", hasKey("json"))
                .body("$", hasKey("url"))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/put"))
                .body("headers.host", equalTo("postman-echo.com"));
    }

    //Негативные тесты
    @Test
    public void testPutWithEmptyBody() {
        given()
                .spec(getTextPlainSpec())
                .body("")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(""));
    }

    @Test
    public void testPutToInvalidEndpoint() {
        given()
                .spec(getTextPlainSpec())
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/nonexist")
                .then()
                .statusCode(404);
    }

    @Test
    public void testPutWithoutContentType() {
        given()
                .spec(getTextPlainSpec())
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
