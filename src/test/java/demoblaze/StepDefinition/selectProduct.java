package demoblaze.StepDefinition;

import demoblaze.Page.homePage;
import demoblaze.Page.productPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class selectProduct {
    homePage homeP;
    productPage productP;

    public selectProduct() {
        this.homeP = new homePage();
        this.productP = new productPage();
    }

    @When("click {string} on homepage")
    public void clickProductOnHomepage(String product) {
        homeP.clickProduct(product);
    }

    @Then("{string} detailspage is displayed")
    public void productDetailsPageIsDisplayed(String product) {
        productP.productDetPageDisplayed(product);
    }

    @When("click {string} for sorting the product")
    public void clickCategoriesForSortingTheProduct(String cat) {
        homeP.selectCategories(cat);
    }

    @And("product is sort by categories")
    public void productIsSortByCategories() {
        homeP.validateSortByCategories();
    }
}
