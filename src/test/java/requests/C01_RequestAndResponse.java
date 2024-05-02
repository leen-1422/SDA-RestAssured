package requests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;



public class C01_RequestAndResponse {
    public static void main(String[] args){

        // https://restful-booker.herokuapp.com/booking
        // User sends a GET Request to the url
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        // print the response body
        //response.prettyPrint();

        // HTTP Status Code should be 200
        int statusCode = response.statusCode();
        System.out.println("statusCode" + statusCode);

        // Content Type should be JSON
        String contentType = response.contentType();
        System.out.println("contentType"+contentType);
        // Status Line should be HTTP/1.1 200 OK
        String statusLine = response.statusLine();
        System.out.println("statusLine"+statusLine);

        // print connection and date headers on console
        String connection = response.header("Connection");
        String date = response.header("Date");
        System.out.println("\nConnection = "+ connection);
        System.out.println("\ndate = "+ date);


        // print all headers on console
        Headers headers= response.headers();
        System.out.println("\nheaders"+headers);
    }
}
