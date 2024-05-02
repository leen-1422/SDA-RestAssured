package Pet_Store;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import pojos.pet_pojos.PetPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class R01_CreatePet extends PetStoreBaseUrl {
/*
     Given
       1) https://petstore.swagger.io/v2/pet
       2)  {
              "id": 98765432,
              "category": {
                "id": 0,
                "name": "Cat"
              },
              "name": "Cotton",
              "photoUrls": [
                "string"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "Kitty"
                }
              ],
              "status": "available"
            }
    When
        I send POST Request to the Url

    Then
        Status code is 200
    And
        response body is like {
                          "id": 98765432,
                          "category": {
                            "id": 0,
                            "name": "Cat"
                          },
                          "name": "Cotton",
                          "photoUrls": [
                            "string"
                          ],
                          "tags": [
                            {
                              "id": 0,
                              "name": "Kitty"
                            }
                          ],
                          "status": "available"
                        }
*/

    @Test
    void postTest(){
        //Set the url
        spec.pathParams("first","v2" , "second","pet");

        //Set the expected data
        String strJson = """
                        {
                          "id": 768679890,
                          "category": {
                            "id": 0,
                            "name": "Cat"
                          },
                          "name": "Cotton",
                          "photoUrls": [
                            "NewPhoto.com", "secondPhoto.com"
                          ],
                          "tags": [
                            {
                              "id": 0,
                              "name": "Kitty"
                            }
                          ],
                          "status": "available"
                        }""";

        PetPojo expectedData = convertJsonToJava(strJson, PetPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetPojo actualData = convertJsonToJava(response.asString(), PetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls().getFirst(), expectedData.getPhotoUrls().getFirst());
        assertEquals(actualData.getPhotoUrls().get(1), expectedData.getPhotoUrls().get(1));
        assertEquals(actualData.getTags().getFirst().getName(), expectedData.getTags().getFirst().getName());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }

}













