package requests.Assignments;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.Users.UsersPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class HW13_ReadUser extends PetStoreBaseUrl {
    @Test
    public void getRequestNestedPojo() {
        //Set the url
        spec.pathParams("first", "v2", "second","user", "third", "leen");
        //Set expected Data
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
        //Set the request and get the response
        Response response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();
        //Do Assertion
        UsersPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), UsersPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getUsername(), actualData.getUsername());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
    }
}
