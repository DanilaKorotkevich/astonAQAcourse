package org.aston.Lesson_10;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

@Feature("Онлайн пополнение")
@Story("Пополнение услуг связи через форму на главной странице")
public class TestPaymentFrame extends TestClass {

    @Test
    @Description("Тест проверяет корректность отображения данных в платежной форме после заполнения основных полей")
    @Severity(SeverityLevel.CRITICAL)
    public void testPaymentForm(){
        try {
            MtsHomePage homePage = new MtsHomePage(driver);
            homePage.handleCookieBanner();
            homePage.fillPaymentForm("297777777", "12");
            homePage.clickContinue();

            PaymentFrame paymentFrame = homePage.switchToPaymentFrame();

            paymentFrame.verifyAmount("12.00 BYN");
            paymentFrame.verifyPayButton("Оплатить 12.00 BYN");
            paymentFrame.verifyCardFields();
            paymentFrame.verifyPaymentSystemIcons();
            paymentFrame.verifyPhoneNumber("Оплата: Услуги связи Номер:375297777777");

            paymentFrame.switchToDefaultContent();

            Allure.step("Все проверки пройдены успешно");
        } catch (Exception e) {
            throw e;
        }
    }
}
