package Lesson_8_tests.GetRequests;

import Lesson_8_tests.BaseClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class GetRequestTest extends BaseClient {

    @Test
    public void testGetRequestStatusCode() {
        given()
                .spec(requestSpec)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetRequestWithHeaders() {
        given()
                .spec(getSpecWithHeader("Custom-Header", "custom-value"))
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("headers.custom-header", equalTo("custom-value"))
                .body("headers.user-agent", equalTo("AutoTests/1.0"));
    }

    @Test
    public void testGetRequestBody() {
        given()
                .spec(requestSpec)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testResponseHeaderConnection() {
        given()
                .spec(requestSpec)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .body("headers", hasKey("connection"));
    }

    //Негативные тесты
    @Test
    public void testGetNegativeEndpoint() {
        given()
                .spec(requestSpec)
                .when()
                .get("/negativeTest")
                .then()
                .statusCode(404);
    }

    @Test
    public void testGetInvalidURL() {
        given()
                .spec(requestSpec)
                .when()
                .get("/get?invalid=param&another=param")
                .then()
                .statusCode(200)
                .body("args.invalid", equalTo("param"))
                .body("args.another", equalTo("param"));
    }
}
