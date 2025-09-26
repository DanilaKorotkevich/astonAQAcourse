package Lesson_8_tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseClient {
    protected static RequestSpecification requestSpec;

    static {
        setupGlobalConfiguration();
    }

    private static void setupGlobalConfiguration() {
        // Глобальная конфигурация RestAssured
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        // Базовая спецификация для всех тестов
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://postman-echo.com")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("User-Agent", "AutoTests/1.0")
                .addHeader("X-Requested-With", "JUnit-Tests")
                .addHeader("X-Test-Suite", "API-Tests")
                .build();

        System.out.println("✓ Global test configuration initialized");
    }

    // Вспомогательные методы для разных Content-Type
    protected static RequestSpecification getJsonSpec() {
        return new RequestSpecBuilder()
                .addRequestSpecification(requestSpec)
                .setContentType("application/json")
                .build();
    }

    protected static RequestSpecification getFormUrlEncodedSpec() {
        return new RequestSpecBuilder()
                .addRequestSpecification(requestSpec)
                .setContentType("application/x-www-form-urlencoded")
                .build();
    }

    protected static RequestSpecification getTextPlainSpec() {
        return new RequestSpecBuilder()
                .addRequestSpecification(requestSpec)
                .setContentType("text/plain")
                .build();
    }

    // Метод для спецификации с дополнительными заголовками
    protected static RequestSpecification getSpecWithHeader(String headerName, String headerValue) {
        return new RequestSpecBuilder()
                .addRequestSpecification(requestSpec)
                .addHeader(headerName, headerValue)
                .build();
    }
}
