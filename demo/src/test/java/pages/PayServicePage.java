package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayServicePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By payServicesLinkText = By.linkText("Pago de servicios");
    private By selectService = By.linkText("Pago de servicios");
    private By boxCode = By.cssSelector("[data-test-id='payservice-cod-box']");
    private By inputPayWithCash = By.cssSelector("[data-test-id='ps-balance-input']");
    private By payBtn = By.id("pay-payservice-btn");
    private By successText = By.cssSelector("[data-test-id='success-payment-text']");


    public PayServicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void goToPayServices () {
        wait.until(ExpectedConditions.elementToBeClickable(payServicesLinkText)).click();
    }

    public void selectService(int serviceId) {
        By selectServiceButton = By.cssSelector("[data-test-id='select-service-" + serviceId + "']");

        wait.until(ExpectedConditions.elementToBeClickable(selectServiceButton)).click();
    }

    public void enterCodeService(String codService) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(boxCode)).sendKeys(codService);

        By continueBtn = By.id("continue-btn-payService");

        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn)).click();
    }

    public void payWithCash (){
        wait.until(ExpectedConditions.elementToBeClickable(inputPayWithCash)).click();
        wait.until(ExpectedConditions.elementToBeClickable(payBtn)).click();
    }

    public void paymentSuccess () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successText));
    }
}
