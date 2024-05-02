package requests.Assignments;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetCategory;
import pojos.PetStore;
import pojos.PetTags;
import pojos.Users.UsersPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class HW13_CreateUser extends PetStoreBaseUrl {

    // Post --> https://petstore.swagger.io/v2/user

//    {
//        "id": 0,
//            "username": "string",
//            "firstName": "string",
//            "lastName": "string",
//            "email": "string",
//            "password": "string",
//            "phone": "string",
//            "userStatus": 0
//    }
    @Test
    public void postRequestNestedPojo() {
        //Set the url
        spec.pathParams("first", "v2", "second","user");

        //Set the expected data

        String strJson = """
                {
                  "id": 1,
                  "username": "leen",
                  "firstName": "leen",
                  "lastName": "hgejf",
                  "email": "rfekm@gmail.com",
                  "password": "123456",
                  "phone": "65784377",
                  "userStatus": 0
                }
                """;

        UsersPojo expectedData = ObjectMapperUtils.convertJsonToJava(strJson , UsersPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();
        //Do assertion
        assertEquals(response.statusCode(),200);
        assertEquals(response.path("message"), "1");
        assertEquals(response.path("type"), "unknown");
    }
}
