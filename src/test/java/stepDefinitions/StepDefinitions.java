package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import utils.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinitions extends Utils {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Add Place Payload")
    public void add_place_payload() throws Exception {

        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//        res = given().spec(requestSpecification())
//                .body(data.addPlacePayload());

    }

    @When("User Calls {string} with Post http request")
    public void user_calls_with_post_http_request(String resource) {
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());
        response = res.when().post(resourceAPI.getResource())
                .then().spec(resspec).extract().response();

    }

    @Then("The API call is successful with Status Code {int}")
    public void the_api_call_is_successful_with_status_code(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());

    }

    @And("{string} is in response body is {string}")
    public void isInResponseBodyIs(String key, String value) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
//        assertEquals(js.get(key).toString(), value );
    }

    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws Exception {
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        res = given().spec(requestSpecification())
                .body(data.addPlacePayload(name, language, address));
        System.out.println(res.toString());

    }


}