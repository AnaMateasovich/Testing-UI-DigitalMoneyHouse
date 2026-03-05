package pages;

import constants.TestData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CardsPage {

    private WebDriver driver;
private WebDriverWait wait;

    private By goToCardsLink = By.linkText("Tarjetas");
    private By createCardLink = By.cssSelector("[data-test-id='create-card-link']");
    private By numberIdCard = By.id("number_id");
    private By firstLastnameCard = By.id("first_last_name");
    private By expDateCard = By.id("expiration_date");
    private By securityCodCard = By.id("cod");
    private By last4CardSuccess = By.cssSelector("[data-test-id='last4-card']");
    private By createCardBtn = By.xpath("/html/body/div[2]/div/div[2]/main/section/form/div[5]/button");
    ;




    public CardsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToCards() {
        wait.until(ExpectedConditions.elementToBeClickable(goToCardsLink)).click();
    }

    public void createCard(String numberId, String firstLastName, String expDate, String secCod) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(createCardLink)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(numberIdCard));
        driver.findElement(numberIdCard).sendKeys(numberId);
        driver.findElement(firstLastnameCard).sendKeys(firstLastName);
        driver.findElement(expDateCard).sendKeys(expDate);
        driver.findElement(securityCodCard).sendKeys(secCod);
        Thread.sleep(1000);

        driver.findElement(createCardBtn).click();
    }

    public void findCardInUserCards(String fullCardNumber) {

        String lastFour = fullCardNumber.substring(fullCardNumber.length() - 4);

        wait.until(ExpectedConditions.visibilityOfElementLocated(last4CardSuccess));

        List<WebElement> cards = driver.findElements(last4CardSuccess);

        boolean found = cards.stream()
                .anyMatch(card -> card.getText().contains(lastFour));

        if (!found) {
            throw new AssertionError("No se encontró tarjeta con últimos 4: " + lastFour);
        }
    }

    public void deleteCard(String cardId) {

        String last4 = cardId.substring(cardId.length() - 4);


        wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("[data-test-id='last4-card']")
    ));

        By deleteButton = By.cssSelector("[data-test-id='delete-card-" + last4 + "']");
        System.out.println(deleteButton);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        button.click();

        System.out.println("hizo click");


        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteButton));
        }

    public boolean isCardPresent(String cardId) {

        List<WebElement> cards = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.cssSelector("[data-test-id='last4-card']")
                )

        );

        String last4 = cardId.substring(cardId.length() - 4);

        for (WebElement card : cards) {
            if (card.getText().contains(last4)) {
                return true;
            }
        }

        return false;
    }
}


