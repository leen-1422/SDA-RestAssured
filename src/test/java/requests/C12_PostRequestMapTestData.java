package requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C12_PostRequestMapTestData extends JsonPlaceHolderBaseUrl {
/*
     Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
          }
    When
        I send POST Request to the Url

    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
*/

    @Test
    public void postRequestTest() {

        //Set the Url
        spec.pathParams("first", "todos");

        //Set the expected data(Payload) --> Preparing expected data as String is not recommended. Because we can not extract specific field from String body for assertion.

            Map<String, Object> expectedData = JsonPlaceHolderTestData.expectedDataMap(55, "Tidy your room", false);

        //Send the request and get the response
        Response response = given(spec)
                //.contentType(ContentType.JSON)//For serialization we need to declare content type. This process is repetitive action, to avoid repeation we will put this in spec object.
                .body(expectedData)
                .post("{first}");

        response.prettyPrint();

        //Do assertion
        //Do assertion
        response
                .then()
                .statusCode(201)
                .body("userId", equalTo(expectedData.get("userId")), //By map payload, we can get specific data from body. This is more dynamic.
                        "title", equalTo(expectedData.get("title")),
                        "completed", equalTo(expectedData.get("completed")));
    }

}