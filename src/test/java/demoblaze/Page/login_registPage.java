package demoblaze.Page;

import org.openqa.selenium.By;

import static demoblaze.Helper.utility.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class login_registPage {

    String username, pass;

    By signup_inputUsername = By.xpath("//input[@id='sign-username']");
    By signup_inputPassword = By.xpath("//input[@id='sign-password']");
    By login_inputUsername = By.xpath("//input[@id='loginusername']");
    By login_inputPassword = By.xpath("//input[@id='loginpassword']");
    By validateLoginNavbar = By.xpath("//li[@class='nav-item']//a[@class='nav-link']/parent::li//a[@id='nameofuser']");

    By loginButton(String button) {
        return By.xpath("//button[text()='"+button+"']");
    }
    public void signup_InputUsername() {
        username = generateRandomUsername();

        driver.findElement(signup_inputUsername).sendKeys(username);
    }

    public void signup_inputPassword() {
        pass = generateRandomPassword();

        driver.findElement(signup_inputPassword).sendKeys(pass);
    }

    public void login_inputUsername() {
        driver.findElement(login_inputUsername).sendKeys(username);
    }
    public void login_inputUnregistUsername(String username) {
        driver.findElement(login_inputUsername).sendKeys(username);
    }

    public void login_inputPassword() {
        driver.findElement(login_inputPassword).sendKeys(pass);
    }

    public void login_inputUnregistPassword(String password) {
        driver.findElement(login_inputPassword).sendKeys(password);
    }

    public void clickButton(String button) throws InterruptedException {
        driver.findElement(loginButton(button)).click();
        Thread.sleep(5000);
    }
    public void validateUsernameDisplayed() {
        String usernameDisplay = driver.findElement(validateLoginNavbar).getText();
        assertEquals("Welcome " + username, usernameDisplay);
    }
}
