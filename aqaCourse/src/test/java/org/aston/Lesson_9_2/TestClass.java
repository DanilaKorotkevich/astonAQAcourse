package org.aston.Lesson_9_2;

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
    void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        mtsHomePage = new MtsHomePage(driver);
    }

    @Test
    void testTitleText() {
        mtsHomePage.open();
        mtsHomePage.wait.until(ExpectedConditions.titleIs("МТС – мобильный оператор в Беларуси"));
    }

    @Test
    void testBlockName() {
        mtsHomePage.open();
        String actualTitle = mtsHomePage.getPayBlockTitle();
        assertEquals("Онлайн пополнение\n" +
                "без комиссии", actualTitle);
    }

    @Test
    void testLogoExist() {
        mtsHomePage.open();
        List<WebElement> logos = mtsHomePage.getPartnerLogos();

        assertEquals(5, logos.size());

        for (WebElement logo : logos) {
            assertNotNull(logo.findElement(By.tagName("img")));
            String src = logo.findElement(By.tagName("img")).getAttribute("src");
            assertTrue(src != null && !src.isEmpty());
        }
    }

    @Test
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
    }

    @Test
    void testFieldsPlaceholder() {
        mtsHomePage.open();
        assertEquals("E-mail для отправки чека",mtsHomePage.getEmailText());
        assertEquals("Сумма",mtsHomePage.getAmountText());
        assertEquals("Номер телефона",mtsHomePage.getPhoneText());
        assertEquals("Номер счета на 44",mtsHomePage.getInstalmentScopeText());
        assertEquals("Номер счета на 2073",mtsHomePage.getArrearsScopeText());
    }

    @Test
    public void testPaymentForm() {
        mtsHomePage.handleCookieBanner();
        mtsHomePage.fillPaymentForm("297777777", "12");
        mtsHomePage.clickContinue();

        PaymentFrame paymentFrame = mtsHomePage.switchToPaymentFrame();
        paymentFrame.verifyAmount("12.00 BYN");
        paymentFrame.verifyPayButton("Оплатить 12.00 BYN");
        paymentFrame.verifyCardFields();
        paymentFrame.verifyPaymentSystemIcons();
        paymentFrame.verifyPhoneNumber("Оплата: Услуги связи Номер:375297777777");
    }
}
