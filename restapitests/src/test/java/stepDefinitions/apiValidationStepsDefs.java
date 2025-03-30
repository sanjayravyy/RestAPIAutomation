package stepDefinitions;

import java.io.FileNotFoundException;

import org.junit.Assert;

import Utils.utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuilders;

public class apiValidationStepsDefs extends utils {
    public apiValidationStepsDefs() throws FileNotFoundException {
        super();
    }

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuilders data = new TestDataBuilders();

    @Given("^I have a addPlace payload$")
    public void i_have_a_add_place_payload() {

        res = given().spec(requestSpecification()).body(data.addPlacePayload());
    }

    @When("^I call the \"(.*)\" with POST http request$")
    public void i_call_the_with_post_http_request(String apiName) {

        resspec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .build();

        response = res.when()
            .post("/maps/api/place/add/json")
            .then()
            .spec(resspec)
            .extract()
            .response();
    }

    @Then("^I check API got successfully executed with status code (\\d+)$")
    public void i_check_api_got_successfully_executed_with_status_code(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("^I check the \"(.*)\" should be \"(.*)\"$")
    public void i_check_the_should_be(String field, String expectedValue) {
        JsonPath js = new JsonPath(response.asString());
        Assert.assertEquals(js.getString(field), expectedValue);
    }
} 