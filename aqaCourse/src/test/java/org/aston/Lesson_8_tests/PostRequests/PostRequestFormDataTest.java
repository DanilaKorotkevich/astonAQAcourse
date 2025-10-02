package org.aston.Lesson_8_tests.PostRequests;

import org.aston.Lesson_8_tests.BaseClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestFormDataTest extends BaseClient {

    @Test
    public void testPostFormDataValidBody() {
        given()
                .spec(getFormUrlEncodedSpec())
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.content-type", containsString("application/x-www-form-urlencoded"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPostFormDataStructure() {
        given()
                .spec(getFormUrlEncodedSpec())
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("$", hasKey("args"))
                .body("$", hasKey("data"))
                .body("$", hasKey("files"))
                .body("$", hasKey("form"))
                .body("$", hasKey("headers"))
                .body("$", hasKey("json"))
                .body("$", hasKey("url"))
                .body("form", hasKey("foo1"))
                .body("form", hasKey("foo2"))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    //Негативные тесты
    @Test
    public void testPostFormDataEmptyValues() {
        given()
                .spec(getFormUrlEncodedSpec())
                .formParam("emptyParam", "value")
                .formParam("normalParam", "value")
                .when()
                .post("/post")
                .then()
                .statusCode(500)
                .body("form.emptyParam", equalTo(null))
                .body("form.normalParam", equalTo(null));
    }

    @Test
    public void testPostFormDataDuplicateKeys() {
        given()
                .spec(getFormUrlEncodedSpec())
                .formParam("key", "value1")
                .formParam("key", "value2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.key", anyOf(equalTo("value1"), equalTo("value2")));
    }

    @Test
    public void testPostFormDataInvalidContentType() {
        given()
                .spec(getJsonSpec())
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", notNullValue());
    }
}
