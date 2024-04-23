package requests.Assignments;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.CreateUserData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HW9 extends PetStoreBaseUrl {

// Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
// https://petstore.swagger.io/v2/user

    @Test
    public void createUser(){

        //Set the Url
        spec.pathParams("first", "v2", "second","user");

        Map<String, Object> expectedData = CreateUserData.expectedDataMap(
                1,
                "leen998",
                "leen",
                "alsultan",
                "leen@hhjd.com",
                "123456",
                "0987654567",
                0);

        //Send the request and get the response
        Response response = given(spec)
                .body(expectedData)
                .post("{first}/{second}");

        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .body("message", equalTo("1")
                );









    }

}
