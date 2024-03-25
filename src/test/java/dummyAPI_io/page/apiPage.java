package dummyAPI_io.page;

import dummyAPI_io.helper.endpoint;
import dummyAPI_io.helper.utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static dummyAPI_io.helper.models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class apiPage {

    String setURL, global_id;
    Response res;

    public void prepareUrlFor (String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setURL = endpoint.CREATE_NEW_USERS;
                break;
            case "UPDATE_USERS":
                setURL = endpoint.UPDATE_USERS;
                break;
            case "DELETE_USERS":
                setURL = endpoint.DELETE_USERS;
                break;
            default:
                System.out.println("Input right URL");
        }
    }

    public void hitApiGetListUsers() {
        res = getListUsers(setURL);
    }

    public void validationStatusCodeIsEquals(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("data.id");
        List<Object> title = res.jsonPath().getList("data.title");
        List<Object> fName= res.jsonPath().getList("data.firstName");
        List<Object> lName = res.jsonPath().getList("data.lastName");
        List<Object> picture = res.jsonPath().getList("data.picture");

        assertThat(id.get(0)).isNotNull();
        assertThat(title.get(0)).isIn("mr", "ms", "mrs", "miss", "dr","");
        assertThat(fName.get(0)).isNotNull();
        assertThat(lName.get(0)).isNotNull();
        assertThat(picture.get(0)).isNotNull();
    }

    public void validationResponseJsonWithJSONSchema(String filename) {
        File JSONFile = utility.getJsonSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }


    public void hitApiCreateNewUser() {
        res = createNewUser(setURL);
    }

    public void validationResponseBodyCreateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String title = jsonPathEvaluator.get("title");
        String fName = jsonPathEvaluator.get("firstName");
        String lName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");

        assertThat(id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(fName).isNotNull();
        assertThat(lName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isNotNull();

        global_id = id;
    }

    public void hitApiDeleteUser() {
        res = deleteUsers(setURL, global_id);
    }

    public void hitApiUpdateUser() {
        res = updateUsers(setURL, global_id);
    }
}
