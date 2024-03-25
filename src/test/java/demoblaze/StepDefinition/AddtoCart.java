package demoblaze.StepDefinition;

import demoblaze.Page.cartPage;
import demoblaze.Page.productPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddtoCart {
    productPage productP;
    cartPage cartP;

    public AddtoCart() {
        this.productP = new productPage();
        this.cartP = new cartPage();
    }

    @When("click add to cart button")
    public void clickAddToCartButton() throws InterruptedException {
        productP.clickAddToCartButton();
    }
    @Then("{string} is displayed on cart page")
    public void isDisplayedOnCartPage(String product) {
        cartP.productIsDisplayed(product);
    }
}
