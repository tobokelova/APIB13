package homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class Homework {
    @Test
    public void test2(){
        Response response =RestAssured.given().accept("application/json")
                .when().get("https://reqres.in/")
                .then().statusCode(200).extract().response();


    }
}