package requests.Assignments;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.*;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class HW12 extends PetStoreBaseUrl {
    //Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
    //(All actions must be done on same pet)
    //            (Use Pojo)

    // Post --> https://petstore.swagger.io/v2/pet
    @Test
    public void postRequestNestedPojo() {
        //Set the url
        spec.pathParams("first", "v2", "second","pet");

        //Set the expected data
        PetCategory petCategory = new PetCategory(1,"dog");
        String[] photoUrlsArray = { "string1", "string2", "string3" };
        PetTags[] petTagsArray = { new PetTags(1, "tag1") };
        PetStore expectedData = new PetStore(1, petCategory, "doggie", photoUrlsArray, petTagsArray, "available");

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetStore actualData = response.as(PetStore.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getId(), expectedData.getCategory().getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls(), expectedData.getPhotoUrls());
//        assertEquals(actualData.getTags()., expectedData.getTags());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }

    @Test
    public void getRequestPojoTest() {
        //Set the url
        spec.pathParams("first", "v2", "second","pet");

        //Set the expected data
        PetCategory petCategory = new PetCategory(1,"dog");
        String[] photoUrlsArray = { "string1", "string2", "string3" };
        PetTags[] petTagsArray = { new PetTags(1, "tag1") };
        PetStore expectedData = new PetStore(1, petCategory, "doggie", photoUrlsArray, petTagsArray, "available");
        System.out.println("expectedData = " + expectedData);

        // Send the request and get the response
        Response response = given(spec).get("{first}/{second}");//Parameters can be declared directly here
        response.prettyPrint();

        //Do assertion
        PetStore actualData = response.as(PetStore.class);
        System.out.println("actualData = " + actualData);


        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getId(), expectedData.getCategory().getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls(), expectedData.getPhotoUrls());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }
    // PUT --> https://petstore.swagger.io/v2/pet
    @Test
    public void putRequestPojoTest() {
        //Set the url
        spec.pathParams("first", "v2", "second","pet");

        //Set the expected data
        PetCategory petCategory = new PetCategory(1,"dog");
        String[] photoUrlsArray = { "string1", "string2", "string3" };
        PetTags[] petTagsArray = { new PetTags(1, "tag1") };
        PetStore expectedData = new PetStore(1, petCategory, "doggie", photoUrlsArray, petTagsArray, "available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetStore actualData = response.as(PetStore.class);
        System.out.println("actualData = " + actualData);


        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getId(), expectedData.getCategory().getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls(), expectedData.getPhotoUrls());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }


}
