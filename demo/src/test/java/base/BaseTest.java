package base;

import constants.TestData;
import constants.UIConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(UIConstants.DEFAULT_TIMEOUT));
        driver.get(UIConstants.BASE_URL);
    }

    protected void loginAsValidUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TestData.VALID_EMAIL_LOGIN, TestData.VALID_PASS_LOGIN);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
