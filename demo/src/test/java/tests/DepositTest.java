package tests;

import base.BaseTest;
import constants.UIConstants;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;

import java.time.Duration;

public class DepositTest extends BaseTest {

    @Test
    void depositMoneyFlow() {
        loginAsValidUser();

        DashboardPage dashboardPage = new DashboardPage(driver);WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("dashboard-link")));
        dashboardLink.click();
        dashboardPage.depositMoney("10");
    }
}
