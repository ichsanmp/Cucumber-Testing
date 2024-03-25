package demoblaze.StepDefinition;

import demoblaze.Page.orderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class createOrder {
    orderPage orderP;
    public createOrder() {
        this.orderP = new orderPage();
    }

    @When("click place order button")
    public void clickPlaceOrderButton() {
        orderP.clickCreateOrder();
    }

    @And("fill {string} text box with {string}")
    public void fillTextBoxWith(String criteria, String inputText) {
        orderP.fillOrderForm(criteria, inputText);
    }

    @Then("notify is displayed with text {string}")
    public void notifyIsDisplayedWithText(String notifyText) {
        orderP.validateSuccessOrder(notifyText);
    }

    @Then("click OK button")
    public void clickOKButton() {
        orderP.closeOrderNotification();
    }

    @Then("notify will display with text {string}")
    public void notifyWillDisplayWithText(String message) {
        orderP.validateCreateOrder(message);
    }
}
