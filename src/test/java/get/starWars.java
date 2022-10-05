package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class starWars {
    @Test
    public void getStarWarTest(){
        Response r1=RestAssured.given().header("Accept","application/json")
                .when().get("https://swapi.dev/api/people")
                .then().statusCode(200).log().all().extract().response();

                          //parsedResponse -->i can use it
        Map<String,Object> deseriliazedR1=r1.as(new TypeRef<Map<String, Object>>() {
        });
        deseriliazedR1.get("results");//returns object
        Object object = deseriliazedR1.get("results");
        List<Map<String,Object>> list  =(List<Map<String,Object>>) object;// now i have regular list
        for(int i =0;i< list.size();i++){
            Map<String,Object> map= list.get(i);
            System.out.println(map.get("name"));
        }
        Object object2 =deseriliazedR1.get("gender");
        List<Map<String,Object>> list2  =(List<Map<String,Object>>) object;
        for(int i =0;i<list2.size();i++){
            if(list2.contains("female")){

            }
        }






    }
}
