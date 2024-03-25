package dummyAPI_io.helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static dummyAPI_io.helper.utility.generateRandomEmail;
import static dummyAPI_io.helper.utility.generateTitle;

public class models {

    private static RequestSpecification request;
    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "65fa77883b38dc74c091e04e");
    }

    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response createNewUser(String endpoint) {
        Map<String, Object> reqLocation = new HashMap<>();
        reqLocation.put("street", "Host");
        reqLocation.put("city", "lemand");
        reqLocation.put("state", "hashmurg");
        reqLocation.put("country", "UK");
        reqLocation.put("timezone", "+2:00");

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("firstName", "tester1");
        reqBody.put("lastName", "testdata");
        reqBody.put("title", generateTitle());
        reqBody.put("email", generateRandomEmail());
        reqBody.put("gender", "male");
        reqBody.put("location", reqLocation);

        JSONObject payload = new JSONObject(reqBody);

        setupHeaders();
        String final_endpoint = endpoint + "/create";
        return request.body(payload.toString()).when().post(final_endpoint);
    }

    public static Response deleteUsers(String endpoint, String global_id) {
        setupHeaders();
        String final_endpoint = endpoint + "/{id}";
        return request.pathParam("id", global_id).when().delete(final_endpoint);
    }

    public static Response updateUsers(String endpoint, String global_id) {
        String fName = "tester2";

        JSONObject payload = new JSONObject();
        payload.put("firstName", fName);

        setupHeaders();
        String final_endpoint = endpoint + "/{id}";
        return request.pathParam("id", global_id).body(payload.toString()).when().put(final_endpoint);
    }
}
