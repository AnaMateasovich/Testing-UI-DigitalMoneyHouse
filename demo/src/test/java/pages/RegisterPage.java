package pages;

import constants.UIConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    private By firstnameInput = By.id("firstname");
    private By lastnameInput = By.id("lastname");
    private By dniInput = By.id("dni");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By confirmPassInput = By.id("confirmPass");
    private By phoneInput = By.id("phone");
    private By createAccButton = By.id("createAccButton");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        driver.get(UIConstants.BASE_URL + UIConstants.REGISTER_URL);
    }

    public void register (String firstname, String lastname, String dni, String email, String password, String confirmPass, String phone) {
        driver.findElement(firstnameInput).sendKeys(firstname);
        driver.findElement(lastnameInput).sendKeys(lastname);
        driver.findElement(dniInput).sendKeys(dni);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPassInput).sendKeys(confirmPass);
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(createAccButton).click();

    }
}
