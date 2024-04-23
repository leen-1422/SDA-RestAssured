package requests.Assignments;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class HW10 extends PetStoreBaseUrl {
    //Using the https://petstore.swagger.io/ document,
    // write an automation test that finds the number of "pets" with the status "available"
    // https://petstore.swagger.io/v2/pet/findByStatus?status=available
    // and asserts that there are more than 100.

    @Test
    public void petWithAvailableStatus(){
        //Set the Url
        spec.pathParams("first", "v2", "second","pet", "third", "findByStatus").queryParams("status", "available");

        Response response = given(spec).get("{first}/{second}/{third}");

        response.prettyPrint();

        // assert
        response.then().body("", hasSize(greaterThan(100)));

    }
}
