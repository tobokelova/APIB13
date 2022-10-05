package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOfThrones {
    @Test
    public void gameOfThronesTest() {
        RestAssured.baseURI = "https://api.got.show/";// we split here instead of using get
        RestAssured.basePath = "api/show/characters";

        Response response1 = RestAssured.given().accept("application/json")
                .when().get()
                .then().statusCode(200).extract().response();
//sss
        List<Map<String,Object>> parsedResponse = response1.as(new TypeRef<List<Map<String,Object>>>(){

    });
        Map<String,List<String>> characterByHouseMap =new HashMap<>();// i will store all char in this Map
        for(int i = 0;i<parsedResponse.size();i++){
            Map<String,Object> characterMap=parsedResponse.get(i);
            if(characterByHouseMap.containsKey(characterMap.get("house"))){
            }if(characterMap.get("house")!=null){
                List<String>listOfNames=new ArrayList<>();
                String name = characterMap.get("name").toString();
                listOfNames.add(name);
                characterByHouseMap.put(characterMap.get("house").toString(),listOfNames);
            }
        }
        System.out.println(characterByHouseMap);
    }
}
        }


        Map<String,Object> characterMap =
    }

}

