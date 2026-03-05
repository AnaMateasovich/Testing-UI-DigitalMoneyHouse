package tests;

import base.BaseTest;
import constants.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CardsPage;
import pages.DashboardPage;

import java.time.Duration;

public class CardsTest extends BaseTest {

    @Test
    void createCardSuccess() throws InterruptedException {
        loginAsValidUser();

        CardsPage cardsPage = new CardsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("dashboard-link")));
        dashboardLink.click();
        cardsPage.navigateToCards();
        cardsPage.createCard(TestData.VALID_CARD_ID, TestData.VALID_NAME_CARD, TestData.VALID_EXP_DATE_CARD, TestData.VALID_SEC_COD_CARD);
        cardsPage.findCardInUserCards(TestData.VALID_CARD_ID);
    }

    @Test
    void deleteSuccess() {
        loginAsValidUser();

        CardsPage cardsPage = new CardsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("dashboard-link")));
        dashboardLink.click();
        cardsPage.navigateToCards();
        cardsPage.deleteCard(TestData.VALID_CARD_ID);
        Assertions.assertFalse(cardsPage.isCardPresent(TestData.VALID_CARD_ID));
    }
}
