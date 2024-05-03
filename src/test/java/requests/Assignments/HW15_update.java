package requests.Assignments;

import base_urls.UsersBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactList.UserResponsePojo;
import pojos.ContactList.UsersPojo;


import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class HW15_update extends UsersBaseUrl {
    @Test
    void updateBookingTest() {

        spec.pathParams("first", "users", "second", "me");

        UsersPojo expectedData  = new UsersPojo("Mary", "Steel", "Password.123", "gkjggj@ghgkjl.com");
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        UserResponsePojo actualData = response.as(UserResponsePojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getEmail(), actualData.getEmail());

    }
}
