package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class C03_AssertHeaderAndBody {

    @Test
    public void negative() {


//       https://restful-booker.herokuapp.com/booking/0
//       User sends a GET Request to the URL
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/0");
        response.prettyPrint();


//       HTTP Status code should be 404
//       Status Line should be HTTP/1.1 404 Not Found
        //1st way:
        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        //2nd way:
        int statusCode = response.statusCode();
        assertEquals(statusCode, 404);

        String statusLine = response.statusLine();
        assertEquals(statusLine, "HTTP/1.1 404 Not Found");


//       Response body contains "Not Found"
        String stringBody = response.asString();
        System.out.println("stringBody" + stringBody);

        Boolean isContain= stringBody.contains("Not Found");
        assertTrue(isContain);

//       Response body does not contain "Clarusway"
        assertFalse(stringBody.contains("Clarusway"));

//       Server is "Cowboy"
        String server = response.header("Server");
        assertEquals(server, "Cowboy");
    }
}
