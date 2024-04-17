package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class C02_AssertHeader {
    @Test
    public void assertHeader(){

//        https://restful-booker.herokuapp.com/booking
//        User sends a GET Request to the url
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        //response.prettyPrint();


//        HTTP Status Code should be 200
        // Aseertions
        response.then().statusCode(200);

//        Content Type should be JSON
        response.then().contentType("application/json");

//        Status Line should be HTTP/1.1 200 OK
        response.then().statusLine("HTTP/1.1 200 OK");

        // connection should be keep-alive
        response.then().header("Connection", "keep-alive");


    }


}
