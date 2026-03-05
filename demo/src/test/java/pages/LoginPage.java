package pages;

import constants.UIConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("loginButton");
    private By continueButton = By.id("continueButton");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(UIConstants.BASE_URL + UIConstants.LOGIN_URL);
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(continueButton).click();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
