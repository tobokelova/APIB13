package post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.PetPojo;
//import utils.PayLoad;

//public class Pet {
//    @Test
//    public void createPetTest(){
//        //https://petstore.swagger.io/v2/pet
//        RestAssured.baseURI="https://petstore.swagger.io";
//        RestAssured.basePath="v2/pet";
//
//        Response response = RestAssured.given()
//                .accept("application/json")
//                .contentType("application/json")
//                .body("{\n" +
//                        "  \"id\": 1056789,\n" +
//                        "  \"category\": {\n" +
//                        "    \"id\": 0,\n" +
//                        "    \"name\": \"hatiko\"\n" +
//                        "  },\n" +
//                        "  \"name\": \"hatiko\",\n" +
//                        "  \"photoUrls\": [\n" +
//                        "    \"https://s3.amazon.com\"\n" +
//                        "  ],\n" +
//                        "  \"tags\": [\n" +
//                        "    {\n" +
//                        "      \"id\": 0,\n" +
//                        "      \"name\": \"string\"\n" +
//                        "    }\n" +
//                        "  ],\n" +
//                        "  \"status\": \"available\"\n" +
//                        "}")
//                .when().post()
//                .then().statusCode(200).extract().response();
//
//        PetPojo deserializedResponse = response.as(PetPojo.class);
//        Assert.assertEquals("hatiko",deserializedResponse.getName());
//        // does concatination
//        response =RestAssured.given().accept("application/json")
//                .when().get("105627")
//                .then().statusCode(2000).extract().response();
////validate get response field
//    }
//}
