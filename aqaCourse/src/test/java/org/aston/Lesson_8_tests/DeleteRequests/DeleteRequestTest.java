package org.aston.Lesson_8_tests.DeleteRequests;

import org.aston.Lesson_8_tests.BaseClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRequestTest extends BaseClient {

    @Test
    public void testDeleteRequest() {
        given()
                .spec(requestSpec)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/delete"))
                .body("headers.host", equalTo("postman-echo.com"));
    }

    @Test
    public void testDeleteRequestWithQueryParameters() {
        given()
                .spec(requestSpec)
                .when()
                .delete("/delete?itemId=123&userId=456")
                .then()
                .statusCode(200)
                .body("args.itemId", equalTo("123"))
                .body("args.userId", equalTo("456"))
                .body("url", equalTo("https://postman-echo.com/delete?itemId=123&userId=456"));
    }

    //Негативные тесты
    @Test
    public void testDeleteInvalidResource() {
        given()
                .spec(requestSpec)
                .when()
                .delete("/nonexistent")
                .then()
                .statusCode(404);
    }

    @Test
    public void testDeleteSpecialChar() {
        given()
                .spec(requestSpec)
                .when()
                .delete("/delete?param=value%20with%20spaces&another=special@chars")
                .then()
                .statusCode(200)
                .body("args.param", equalTo("value%20with%20spaces"))
                .body("args.another", equalTo("special@chars"));
    }
}
