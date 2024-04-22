package requests.Assignments;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HW11 {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/

    @Test
    public void numberOfWomen() {

        Response response = RestAssured.get("https://automationexercise.com/api/productsList");

        response.jsonPath().prettyPrint();

        JsonPath jsonPath = response.jsonPath();


        int numberOfWomen = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
        System.out.println("numberOfWomen = " + numberOfWomen);

        assertEquals(numberOfWomen, 12);
    }
}
