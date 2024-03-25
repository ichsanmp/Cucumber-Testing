package demoblaze.StepDefinition;

import demoblaze.Page.cartPage;
import demoblaze.Page.homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class selectNavbar {

    homePage homeP;
    cartPage cartP;

    public selectNavbar() {
        this.homeP = new homePage();
        this.cartP = new cartPage();
    }

    @Given("homepage is displayed")
    public void homepageIsDisplayed() throws InterruptedException {
        homeP.getHomePage();
    }

    @When("click {string} on navbar")
    public void clickMenuOnNavbar(String menu) {
        homeP.clickNavbar(menu);
    }

    @Then("{string} page is displayed")
    public void pageIsDisplayed(String menu) {
        if (menu.equals("Home")) {
            homeP.validateHomePage();
        } else if (menu.equals("Cart")) {
            cartP.validateCartPage();
        }
    }

    @Then("content is displayed")
    public void contentIsDisplayed() {
        homeP.validateContentDisplayed();
    }
}
