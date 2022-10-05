package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.PetPojo;

import java.util.List;
import java.util.Map;

public class Hatiko {
    @Test// needs to come from org.junit
    public void getHatikoTest() {
        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get("https://petstore.swagger.io/v2/pet/10567")
                .then().statusCode(200).log().all().extract().response();//print all data

// deserialization
        Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });
        Assert.assertEquals("hatiko",deserializedResponse.get("name"));
        Assert.assertEquals(10567,deserializedResponse.get("id"));
        Assert.assertEquals("sdet doggie",deserializedResponse.get("status"));

        Object object2 =deserializedResponse.get("category");

       Map<String,Object > category =(Map<String,Object>) object2;
        System.out.println(category);
        List<String> photoUrlList =(List<String>) deserializedResponse.get("photoUrls");
        System.out.println("photoUrls" + photoUrlList);

    }
    @Test
    public void petPojoTest(){
        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get("https://petstore.swagger.io/v2/pet/10567")
                .then().statusCode(200).log().all().extract().response();//print all data
        //deserialization
        PetPojo deserializedResponse = response.as(PetPojo.class);
        Assert.assertEquals("hatiko",deserializedResponse.getName());
        Assert.assertEquals(10567,deserializedResponse.getId());

    }

}
