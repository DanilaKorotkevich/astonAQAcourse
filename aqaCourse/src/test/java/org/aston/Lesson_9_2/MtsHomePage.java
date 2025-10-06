package org.aston.Lesson_9_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MtsHomePage extends BasePage {

    @FindBy(css = ".cookie.show")
    private WebElement cookieBanner;

    @FindBy(id = "cookie-agree")
    private WebElement cookieAcceptButton;

    @FindBy(className = "pay__wrapper")
    private WebElement payBlock;

    @FindBy(className = "pay__partners")
    private WebElement partnersBlock;

    @FindBy(id = "connection-phone")
    private WebElement phoneField;

    @FindBy(id = "connection-sum")
    private WebElement amountField;

    @FindBy(className = "email")
    private WebElement email;

    @FindBy(id = "score-instalment")
    private WebElement instalmentScope;

    @FindBy(id = "score-arrears")
    private WebElement arrearsScope;

    @FindBy(xpath = "//button[contains(.,'Продолжить')]")
    private WebElement continueButton;

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.mts.by");
        handleCookieBanner();
    }

    public void fillPaymentForm(String phoneNumber, String amount) {
        type(phoneField, phoneNumber);
        type(amountField, amount);
    }

    public void clickContinue() {
        click(continueButton);
    }

    public PaymentFrame switchToPaymentFrame() {
        return new PaymentFrame(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPayBlockTitle() {
        return payBlock.findElement(By.tagName("h2")).getText();
    }

    public String getPhoneText() {
        return phoneField.getAttribute("placeholder");
    }

    public String getAmountText() {
        return amountField.getAttribute("placeholder");
    }

    public String getEmailText() {
        return email.getAttribute("placeholder");
    }

    public String getInstalmentScopeText() {
        return instalmentScope.getAttribute("placeholder");
    }

    public String getArrearsScopeText() {
        return arrearsScope.getAttribute("placeholder");
    }

    public List<WebElement> getPartnerLogos() {
        return partnersBlock.findElement(By.tagName("ul")).findElements(By.tagName("li"));
    }

    public void clickServiceLink() {
        handleCookieBanner();

        WebElement block = payBlock;
        WebElement link = block.findElement(By.tagName("a"));

        String href = link.getAttribute("href");
        System.out.println("Ссылка ведет на: " + href);

        String startUrl = driver.getCurrentUrl();
        System.out.println("Текущий URL: " + startUrl);

        clickWithRetry(link, "сервисная ссылка");

        waitForPageLoad();

        String newUrl = driver.getCurrentUrl();
        System.out.println("Новый URL: " + newUrl);

        if (newUrl.equals(startUrl)) {
            System.out.println("URL не изменился. Проверяем другие признаки загрузки...");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector(".help-content, .article-content, .faq, .support")));
                System.out.println("Новый контент загружен успешно");
            } catch (Exception e) {
                System.out.println("Новый контент не обнаружен: " + e.getMessage());
            }
        }
    }

    private void clickWithRetry(WebElement element, String elementName) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                scrollToElement(element);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                return;

            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                attempts++;
                System.out.println("Попытка " + attempts + ": Элемент " + elementName + " перекрыт");
                handleCookieBanner();
                try { Thread.sleep(1000); } catch (InterruptedException ie) {}

            } catch (Exception e) {
                attempts++;
                System.out.println("Попытка " + attempts + ": Ошибка при клике на " + elementName + ": " + e.getMessage());

                if (attempts == 2) {
                    try {
                        ((org.openqa.selenium.JavascriptExecutor) driver)
                                .executeScript("arguments[0].click();", element);
                        return;
                    } catch (Exception jsException) {
                        System.out.println("JavaScript клик также не сработал: " + jsException.getMessage());
                    }
                }
            }
        }
        throw new RuntimeException("Не удалось кликнуть на элемент: " + elementName);
    }

    private void scrollToElement(WebElement element) {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);
    }

    private void waitForPageLoad() {
        try {
            wait.until(driver -> {
                String readyState = ((org.openqa.selenium.JavascriptExecutor) driver)
                        .executeScript("return document.readyState").toString();
                return readyState.equals("complete");
            });
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Ошибка при ожидании загрузки страницы: " + e.getMessage());
        }
    }

    public void handleCookieBanner() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".cookie.show")));

            if (cookieBanner.isDisplayed()) {
                System.out.println("Обнаружен куки-баннер, закрываем...");

                if (cookieAcceptButton != null && cookieAcceptButton.isDisplayed()) {
                    cookieAcceptButton.click();
                }
                else {
                    List<WebElement> closeButtons = driver.findElements(
                            By.cssSelector(".cookie__close, .cookie-accept, .btn-accept, [aria-label*='close']"));
                    for (WebElement btn : closeButtons) {
                        if (btn.isDisplayed()) {
                            btn.click();
                            break;
                        }
                    }
                }
                wait.until(ExpectedConditions.invisibilityOf(cookieBanner));
                System.out.println("Куки-баннер закрыт");
            }
        } catch (Exception e) {
            System.out.println("Куки-баннер не найден или уже закрыт: " + e.getMessage());
        }
    }

}
