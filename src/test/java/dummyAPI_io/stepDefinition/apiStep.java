package dummyAPI_io.stepDefinition;

import dummyAPI_io.page.apiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class apiStep {

    apiPage apiPage;
    public apiStep() {
        this.apiPage = new apiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @And("hit api get users list data")
    public void hitApiGetUsersListData() {
        apiPage.hitApiGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        apiPage.validationStatusCodeIsEquals(status_code);
    }

    @Then("validation response body get all list users data")
    public void validationResponseBodyGetAllListUsersData() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }

    @And("hit api post create new user")
    public void hitApiCreateNewUser() {
        apiPage.hitApiCreateNewUser();
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPage.validationResponseBodyCreateUser();
    }

    @And("hit api delete user")
    public void hitApiDeleteUser() {
        apiPage.hitApiDeleteUser();
    }

    @When("hit api update user")
    public void hitApiUpdateUser() {
        apiPage.hitApiUpdateUser();
    }
}
