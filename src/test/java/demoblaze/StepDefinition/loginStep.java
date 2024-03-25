package demoblaze.StepDefinition;

import demoblaze.Page.homePage;
import demoblaze.Page.login_registPage;
import demoblaze.Page.validationAlert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStep {

    homePage homeP;
    login_registPage loginp;
    validationAlert validAlert;

    public loginStep() {
        this.homeP = new homePage();
        this.loginp = new login_registPage();
        this.validAlert = new validationAlert();
    }

    @When("click {string} button")
    public void clickContentButton(String button) throws InterruptedException {
        loginp.clickButton(button);
    }

    @Then("alert will display with text {string}")
    public void alertWillDisplayWithText(String alert) {
        validAlert.validateAlertMessage(alert);
    }

    @And("input username at sign up form")
    public void inputUsernameAtSignUpForm() {
        loginp.signup_InputUsername();
    }

    @And("input password at sign up form")
    public void inputPasswordAtSignUpForm(){
        loginp.signup_inputPassword();
    }

    @And("click OK on alert to continue")
    public void clickOKOnAlertToContinue() throws InterruptedException {
        validAlert.continueAlert();
    }

    @And("input username at log in form")
    public void inputUsernameAtLogInForm() {
        loginp.login_inputUsername();
    }

    @And("input password at log in form")
    public void inputPasswordAtLogInForm() {
        loginp.login_inputPassword();
    }

    @Then("registered username will displayed on navbar")
    public void registeredUsernameWillDisplayedOnNavbar() {
        loginp.validateUsernameDisplayed();
    }

    @And("input username as {string} at sign up form")
    public void inputUsernameAsAtSignUpForm(String username) {
        loginp.login_inputUnregistUsername(username);
    }

    @And("input password as {string} at sign up form")
    public void inputPasswordAsAtSignUpForm(String password) {
        loginp.login_inputUnregistPassword(password);
    }
}
