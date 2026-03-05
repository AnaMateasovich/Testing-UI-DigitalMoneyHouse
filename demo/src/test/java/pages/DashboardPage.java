package pages;

import constants.UIConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage {

    private WebDriver driver;

    private By depositMoneyButton = By.id("deposit-money-button");
    private By depositFromCreditCardButton = By.id("deposit-from-cc-btn");
    private By creditCardSelect = By.cssSelector("input[name='creditCardSelect']");
    private By continueButton = By.linkText("Continuar");
    private By enterAmountInput = By.id("enter-amount-input");
    private By finalContinueButton = By.id("final-btn-deposit");
    private By successMessage = By.xpath("//*[contains(text(),'Ya cargamos el dinero en tu cuenta')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void depositMoney(String amount) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(depositMoneyButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(depositFromCreditCardButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(creditCardSelect)).click();

        List<WebElement> cards = driver.findElements(creditCardSelect);

        if(!cards.isEmpty()) {
            cards.get(0).click();
            wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

            WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(enterAmountInput));

            amountInput.clear();
            amountInput.sendKeys(amount);

            wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

            WebElement finalContinue = wait.until(
                    ExpectedConditions.elementToBeClickable(finalContinueButton)
            );

            finalContinue.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        } else {
            throw new RuntimeException("No hay tarjetas disponibles para seleccionar");
        }
    }


}
