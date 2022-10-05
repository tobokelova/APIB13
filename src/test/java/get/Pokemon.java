package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.PetPojo;
import pojo.PokemonPojo;

import java.util.List;
import java.util.Map;

public class Pokemon {
    /* Construct request :
    1.define url
    2.add header
    3.define http method
    * send request
    * validate response status code
     */
@Test// needs to come from org.junit
public void getPokemonTest() {

        Response response = RestAssured.given().header("Accept","application/json")
                .when().get("https://pokeapi.co/api/v2/pokemon")
                .then().statusCode(200).log().all().extract().response();

        Map<String, Object> deserializesResponse = response.as(new TypeRef<Map<String, Object>>() {
        });

        System.out.println(deserializesResponse);

        Assert.assertEquals(null ,deserializesResponse.get("previous"));
        Assert.assertNull(deserializesResponse.get("previous"));

        deserializesResponse.get("results");




//        deserializesResponse.get("count");
        Object object = deserializesResponse.get("results");//get() returns object
        List<Map<String,String>> list =(List<Map<String,String>>) object;//casting object to List
        for(int i =0;i <list.size();i++) {
            Map<String, String> map = list.get(i);//getting 1 by 1 map
            String name = map.get("name");//returns String
            System.out.println(name);
        }
    }

    @Test
    public void PokemonPojoTest(){
        Response response = RestAssured.given().accept("application/json")
                .when().get("https://pokeapi.co/api/v2/pokemon")
                .then().statusCode(200).extract().response();
        // deserialization
        Response response =RestAssured.given().accept("application/json")
            .when().get("https://pokeapi.co/api/v2/pokemon")
            .then().statusCode(200).extract().response();
   PokemonPojo parsedResponse= response.as(PokemonPojo.class);
   Assert.assertEquals(1154,parsedResponse.getCount());
Assert.assertEquals("https://pokeapi.co/api/v2/pokemon?offset=20&limit=20",parsedResponse.getNext());
Assert.assertEquals(20,parsedResponse.getResults().size());
        Assert.assertEquals(null,  parsedResponse.getPrevious());
        parsedResponse.getResults();
        parsedResponse.getPrevious();




    Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
    });
    deserializedResponse.get("count");
    System.out.println(deserializedResponse.get("next"));
    Assert.assertEquals("null",deserializedResponse.get("previous"));

Object object = deserializedResponse.get("results");
List<Map<String,String> resultLists =

//    Map<String, Object> deserializedResponse1 = response.as(new TypeRef<Map<String, Object>>() {
//    });
//    Assert.assertEquals("https://pokeapi.co/api/v2/pokemon?offset=20&limit=20", deserializedResponse.get("next"));
   }
}
