package demoblaze.StepDefinition;

import demoblaze.Page.cartPage;
import demoblaze.Page.productPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class countTotalPrice {

    cartPage cartP;

    public countTotalPrice() {
        this.cartP = new cartPage();
    }

    @Then("total payment on cartpage is equal with cart detail displayed")
    public void totalPaymentOnCartpageIsEqualWithCartDetailDisplayed() {
        cartP.countCartDetail();
    }
}
