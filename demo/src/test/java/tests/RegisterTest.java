package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    @Test
    void successRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Prueba3", "Test", "15357899", "prueba.test4@mail.com", "1234Ab.", "1234Ab.", "3464558899");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("register-success-title")
        ));
    }
}
