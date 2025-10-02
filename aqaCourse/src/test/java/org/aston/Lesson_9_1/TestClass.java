package org.aston.Lesson_9_1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TestClass {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by");
    }

    @Test
    void testTitleText() {
        wait.until(titleIs("МТС – мобильный оператор в Беларуси"));
    }

    @Test
    void testBlockName() {
        WebElement block = driver.findElement(By.className("pay__wrapper"));

        WebElement title = block.findElement(By.tagName("h2"));

        String actualTitle = title.getText();
        String expectedText = "Онлайн пополнение\n" +
                "без комиссии";
        assertEquals(expectedText, actualTitle);
    }

    @Test
    void testLogoExist() {
        WebElement block = driver.findElement(By.className("pay__partners"));
        WebElement logosList = block.findElement(By.tagName("ul"));

        List<WebElement> logosItems = logosList.findElements(By.tagName("li"));
        assertEquals(5, logosItems.size());

        for (int i = 0; i < logosItems.size(); i++) {
            WebElement li = logosItems.get(i);

            WebElement img = li.findElement(By.tagName("img"));
            assertNotNull(img);

            String src = img.getAttribute("src");
            assertTrue(src != null && !src.isEmpty());
        }
    }

    @Test
    void testServiceLink() {
        WebElement block = driver.findElement(By.className("pay__wrapper"));
        WebElement link = block.findElement(By.tagName("a"));

        String startUrl = driver.getCurrentUrl();

        String text = link.getText();
        String href = link.getAttribute("href");

        assertTrue(href != null && !href.isEmpty());

        link.click();

        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(startUrl)));

        String newUrl = driver.getCurrentUrl();
        assertTrue(!newUrl.equals(startUrl));
        assertTrue(newUrl.contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    void testContinueButton() {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
        phoneField.clear();
        //phoneField.click();
        phoneField.sendKeys("297777777");

        WebElement totalRubField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("total_rub")));
        totalRubField.clear();
        //totalRubField.click();
        totalRubField.sendKeys("50");

        //WebElement button = driver.findElement(By.className("button button__default "));
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(), 'Продолжить')]")));
        button.submit();

        assertTrue(isCardFormDisplayed());
    }

    private boolean isCardFormDisplayed() {
        try {
            WebElement payField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gpay-button-online-api-id")));

            return payField.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
