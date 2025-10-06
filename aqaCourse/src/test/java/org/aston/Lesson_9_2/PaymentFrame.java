package org.aston.Lesson_9_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentFrame extends BasePage {

    @FindBy(css = "iframe.bepaid-iframe")
    private WebElement paymentIframe;

    @FindBy(xpath = "//span[contains(@class, 'ng-star-inserted') and contains(text(), 'BYN')]")
    private WebElement amountSpan;

    @FindBy(css = "button.colored.disabled")
    private WebElement payButton;

//    @FindBy(xpath = "//input[@placeholder='Номер карты']")
//    private WebElement cardNumberInput;
//
//    @FindBy(xpath = "//input[@placeholder='Срок действия']")
//    private WebElement expiryDateInput;
//
//    @FindBy(xpath = "//input[@placeholder='CVV']")
//    private WebElement cvvInput;

    @FindBy(xpath = "//img[contains(@src, 'visa') or contains(@src, 'mastercard') or contains(@src, 'payment-system')]")
    private List<WebElement> paymentSystemIcons;

    public PaymentFrame(WebDriver driver) {
        super(driver);
        switchToIframe();
        PageFactory.initElements(driver, this);
    }

    private void switchToIframe() {
        waitForVisibility(paymentIframe);
        driver.switchTo().frame(paymentIframe);
    }

    public void verifyAmount(String expectedAmount) {
        waitForVisibility(amountSpan);
        assertEquals(expectedAmount, amountSpan.getText());
    }

    public void verifyPayButton(String expectedAmount) {
        waitForVisibility(payButton);
        String paySpan = payButton.findElement(By.tagName("span")).getText();
        assertEquals(expectedAmount, paySpan);
        //assertTrue(payButton.getText().contains(expectedAmount));
    }

    public void verifyCardFields() {
        String[] expectedFields = {"Номер карты", "Срок действия", "CVC", "Имя и фамилия на карте"};

        String cardNumberText = driver.findElement(By.xpath(
                "//div[1]/app-input/div/div/div[1]/label")).getText();
        String expiryDateText = driver.findElement(By.xpath(
                "//div[2]/div[1]/app-input/div/div/div[1]/label")).getText();
        String cvcText = driver.findElement(By.xpath(
                "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label")).getText();
        String nameText = driver.findElement(By.xpath(
                "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label")).getText();

        assertEquals(expectedFields[0], cardNumberText);
        assertEquals(expectedFields[1], expiryDateText);
        assertEquals(expectedFields[2], cvcText);
        assertEquals(expectedFields[3], nameText);
    }

    public void verifyPaymentSystemIcons() {
        wait.until(driver -> paymentSystemIcons.size() > 0);
        assertTrue(paymentSystemIcons.size() > 0);
    }

    public void verifyPhoneNumber(String expectedText) {
        WebElement phoneDisplay = driver.findElement(
                org.openqa.selenium.By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));
        String phoneActualText = phoneDisplay.getText();
        assertEquals(expectedText, phoneActualText);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
