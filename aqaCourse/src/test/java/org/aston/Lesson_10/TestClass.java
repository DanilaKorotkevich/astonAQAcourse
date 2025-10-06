package org.aston.Lesson_10;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {

    WebDriver driver;
    MtsHomePage mtsHomePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        mtsHomePage = new MtsHomePage(driver);

        Allure.step("Инициализация драйвера и открытие главной страницы MTS");
    }

    @Test
    @Step("Тест проверяет правильность заголовка сайта")
    void testTitleText() {
        mtsHomePage.open();
        mtsHomePage.wait.until(ExpectedConditions.titleIs("МТС – мобильный оператор в Беларуси"));
        Allure.step("test complete");
    }

    @Test
    @Step("Test block name")
    void testBlockName() {
        mtsHomePage.open();
        String actualTitle = mtsHomePage.getPayBlockTitle();
        assertEquals("Онлайн пополнение\n" +
                "без комиссии", actualTitle);
        Allure.step("block name assert expected text");
    }

    @Test
    @Step("Test logos exists")
    void testLogoExist() {
        mtsHomePage.open();
        List<WebElement> logos = mtsHomePage.getPartnerLogos();

        assertEquals(5, logos.size());

        for (WebElement logo : logos) {
            assertNotNull(logo.findElement(By.tagName("img")));
            String src = logo.findElement(By.tagName("img")).getAttribute("src");
            assertTrue(src != null && !src.isEmpty());
            Allure.step("logo " + logo + " is exist");
        }
    }

    @Test
    @Step("Test service link is right")
    void testServiceLink() {
        mtsHomePage.open();
        String startUrl = driver.getCurrentUrl();

        mtsHomePage.clickServiceLink();

        mtsHomePage.wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe(startUrl)));

        String newUrl = driver.getCurrentUrl();
        assertNotEquals(startUrl, newUrl);
        assertTrue(newUrl.contains(
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        Allure.step("test complete!");
    }

    @Test
    @Step("test placeholders")
    void testFieldsPlaceholder() {
        mtsHomePage.open();
        assertEquals("E-mail для отправки чека",mtsHomePage.getEmailText());
        assertEquals("Сумма",mtsHomePage.getAmountText());
        assertEquals("Номер телефона",mtsHomePage.getPhoneText());
        assertEquals("Номер счета на 44",mtsHomePage.getInstalmentScopeText());
        assertEquals("Номер счета на 2073",mtsHomePage.getArrearsScopeText());
        Allure.step("Test complete!");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            Allure.step("Драйвер закрыт");
        }
    }
}
