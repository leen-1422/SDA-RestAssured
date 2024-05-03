package requests.Assignments;

import base_urls.UsersBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactList.UserResponsePojo;
import pojos.ContactList.UsersPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class HW15_Read extends UsersBaseUrl {

    @Test
    void getBookingTest(){
        spec.pathParams("first", "users", "second", "me");

        //Set the expected data
        /*
        {
          "_id": "608b2db1add2691791c04c89",
          "firstName": "Test",
          "lastName": "User",
          "email": "test@fake.com",
          "__v": 1
        }
         */
        UserResponsePojo expectedData = new UserResponsePojo("firstname", "lastname", null, null, "email");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        UserResponsePojo actualData = response.as(UserResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getEmail(), actualData.getEmail());
    }
}
