package post;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import utils.PayLoad;

import java.io.File;

public class Slack {
    @Test

    public void sendMessageTest() {
        RestAssured.baseURI = "https://slack.com/";
        RestAssured.basePath = "api.chat.postMessage";

        RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(PayLoad.getPetPayLoad("Aigerim: message from Java"))
                .header("Authorization", "Bearer xoxb-3471786148807-4185093481968-iOJahd3cCSTT7cPsAZuOVXiD")
                .when().post()
                .then().statusCode(200).extract().response();
    }

    @Test
    public void test() {

        File file = new File("src/test/resources/slackMessage/json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, slackMesssagePojo);
    }
}
