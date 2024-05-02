package requests.Assignments;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class HW13_DeleteUser extends PetStoreBaseUrl {
    @Test
    void testDeleteUser () {
        //Set the url
        spec.pathParams("first", "user", "second","user", "third", "leen");

        //Send DELETE request to delete the user
        Response response = given(spec).delete("{first}/{second}/{third}");

        //Do Assertion
        assertEquals(200, response.statusCode());
        assertTrue(response.asString().isEmpty());
    }
}
