package requests.Assignments;

import base_urls.UsersBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactList.UserResponsePojo;
import pojos.ContactList.UsersPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class HW15_Create extends UsersBaseUrl {

    @Test
    void createBookingTest() {
        //Set the url
        spec.pathParams("first", "users");

        //Set the expected data
        String strJson = """
                {
                    "firstName": "Test",
                    "lastName": "User",
                    "email": "t688ghvk878@fake.com",
                    "password": "myPassword"
                }
               """;


        UsersPojo expectedData = convertJsonToJava(strJson, UsersPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
       response.prettyPrint();

//        //Do assertion
        UsersPojo actualData = convertJsonToJava(response.asString(), UsersPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(actualData.getFirstName(), expectedData.getFirstName());




    }
}
