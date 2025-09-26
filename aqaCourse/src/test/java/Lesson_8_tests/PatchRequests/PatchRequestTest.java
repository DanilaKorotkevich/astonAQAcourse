package Lesson_8_tests.PatchRequests;

import Lesson_8_tests.BaseClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchRequestTest extends BaseClient {

    @Test
    public void testPatchRequestStatus() {
        given()
                .spec(getTextPlainSpec())
                .when()
                .patch("/patch")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPatchRequestBody() {
        given()
                .spec(getTextPlainSpec())
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    //Негативные тесты
    @Test
    public void testPatchWithDiffContentTypes() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .spec(getTextPlainSpec())
                .body("message=" + requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("form.message", equalTo(requestBody));
    }

    @Test
    public void testPatchEmptyBody() {
        given()
                .spec(getTextPlainSpec())
                .body("")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(""));
    }

    @Test
    public void testPatchWithoutContentType() {
        given()
                .spec(getTextPlainSpec())
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
