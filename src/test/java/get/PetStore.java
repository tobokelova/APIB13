package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.PetPojo;

import java.util.List;
import java.util.Map;

public class PetStore {
    @Test
    public void petStoreTest() {
        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get("https://petstore.swagger.io/v2/pet/10567")
                .then().statusCode(200).log().all().extract().response();// if it working fine ,there is no need to have log on


    /*{
    "id": 10567,
    "category": {
        "id": 0,
        "name": "hatiko"
    },
    "name": "hatiko",
    "photoUrls": [
        "https://s3.amazon.com"
    ],
    "tags": [
        {
            "id": 0,
            "name": "string"
        }
    ],
    "status": "sdet doggie"
}

     */
        //deserialized
        //name,id ,status

        Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
                                                              });
                Assert.assertEquals("hatiko", deserializedResponse.get("name"));
        Assert.assertEquals("10567", deserializedResponse.get("id"));
        Assert.assertEquals("sdet doggie", deserializedResponse.get("status"));

        Object categoryObject = deserializedResponse.get("category");
        Map<String, Object> category = (Map<String, Object>) categoryObject;
        System.out.println("category" + category);
        List<String> photoList = (List<String>) deserializedResponse.get("photoUrls");//casting i cant create
        System.out.println("photoUrls" + photoList);
    }

    @Test
    public void petPojoTest() {
        Response response = RestAssured.given().accept("application/json")
                .when().get("https://petstore.swagger.io/v2/pet/10567")
                .then().statusCode(200).extract().response();
  // we are putting in Object
        PetPojo deserializedResponse = response.as(PetPojo.class);//give your jason and pjo class and willl do matching
        Assert.assertEquals("hatiko",deserializedResponse.getName());
        Assert.assertEquals(10567,deserializedResponse.getId());

    }
}