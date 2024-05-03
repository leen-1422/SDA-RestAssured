package requests.Assignments;

import base_urls.UsersBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HW15_delete extends UsersBaseUrl {
    @Test
    void updateBookingTest() {
        spec.pathParams("first", "users", "second", "me");

        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());
        assertTrue(response.asString().isEmpty());


    }
}
