package tests;

import base.BaseTest;
import constants.TestData;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginUITest extends BaseTest {

    @Test
    void loginExitoso() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TestData.VALID_EMAIL_LOGIN, TestData.VALID_PASS_LOGIN);
    }
}
