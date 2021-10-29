package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JustTest {
    @Test
    public void testLogin(){
        Response response = (Response) given().auth().preemptive().basic("admin", "123").when().get("http://localhost:8080/login?from=%2F").then().statusCode(200);
        response.prettyPrint();
    }
}
