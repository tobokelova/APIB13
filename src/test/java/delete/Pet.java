package delete;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import pojo//.PetDeletePojo;
//import utils.PayLoad;

import java.util.Map;

import static io.restassured.RestAssured.given;

//public class Pet {
//    @Before
//    public void setup(){
//        RestAssured.baseURI="https://petstore.swagger.io";// static variable //we can call it without
//        RestAssured.basePath ="v2/pet";
//    }
//    @Test
//    public void deletePetTest(){
//        //post request
//        Response response = given().accept(ContentType.JSON)
//                .contentType(ContentType.JSON)
//                .body(PayLoad.getPetPayLoad())
//                .when().post()
//                .then().statusCode(200)
//                .extract().response();
//
//        //TODO add post response validation -validate name,status ,id use Pojo and typeref class
//      //get pet request
//        response= given().accept(ContentType.JSON)
//                .when().get("105627")
//                .then().statusCode(200).extract().response();
//        //TODO ADD GET RESPONSE Validation -validate name,status,id
//
//
//        // delete pet request
//        response = given().accept(ContentType.JSON)
//                .when().delete("105627")
//                .then().statusCode(200).extract().response();
//
//        PetDeletePojo parsedDeleteResponse =response.as(PetDeletePojo.class);
//        Assert.assertEquals(200,parsedDeleteResponse.getCode);
//
//
//        response = given().accept(ContentType.JSON)
//                .when().get("105627")
//                .then().statusCode(404).extract().response();
//
//        Map<String,Object> deserializedGetResponse =response.as(new TypeRef<Map<String, Object>>() {
//        });
//        String expectedMessage ="Pet not found";
//        String actualMessage =deserializedGetResponse.get("message").toString();//valueOf or explicit casting
//        Assert.assertEquals(expectedMessage,actualMessage);
//
//    }
//}
