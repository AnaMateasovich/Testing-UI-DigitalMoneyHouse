package tests;

import base.BaseTest;
import constants.TestData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CardsPage;
import pages.PayServicePage;

import java.time.Duration;

public class PayServiceTest extends BaseTest {

    @Test
    void PayServiceWithCashSuccess() throws InterruptedException {
        loginAsValidUser();

        PayServicePage payServicePage = new PayServicePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("dashboard-link")));
        dashboardLink.click();
        payServicePage.goToPayServices();
        payServicePage.selectService(1);
        payServicePage.enterCodeService(TestData.SERVICE_TO_PAY_COD);
         payServicePage.payWithCash();
         payServicePage.paymentSuccess();
    }
}
