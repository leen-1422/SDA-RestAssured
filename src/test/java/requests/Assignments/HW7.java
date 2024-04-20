package requests.Assignments;

import base_urls.AssignmentBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.AssignmentPlaceHolderData;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

public class HW7 extends AssignmentBaseUrl {
    @Test
    public void postRequestTest() {

        //Set the Url
        spec.pathParams("first", "api", "second", "unknown");

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}/");
        response.prettyPrint();

        //Do assertion
        JsonPath jsonPath = response.jsonPath();

//        1)Status code is 200
        response.then().statusCode(200);

//        2)Print all pantone_values
        Object pantonevaluesList = jsonPath.getList("data.findAll{it.pantone_value}.pantone_value");
        System.out.println("pantonevaluesList = " + pantonevaluesList);
//

//        3)Print all ids greater than 3 on the console
//        Assert that there are 3 ids greater than 3

        List<Integer> idList = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("nameList = " + idList);
        assertEquals(idList.size(), 3);


//         4)Print all names whose ids are less than 3 on the console
//        Assert that the number of names whose ids are less than 3 is 2

        List<String> nameList = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("nameList = " + nameList);
        assertEquals(nameList.size(), 2);


    }
}
