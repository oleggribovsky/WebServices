package kjoy;

import static org.junit.Assert.assertTrue;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;


public class RestAssuredTest {



    @Test
    public void checkStatusCode()
    {
        System.out.println("Current DateTime: " + LocalDateTime.now());
        Response response = RestAssured.when()
                .get("https://jsonplaceholder.typicode.com/users")
                .andReturn();
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkHeader(){
        System.out.println("Current DateTime: " + LocalDateTime.now());

        Response response = RestAssured.when()
                .get("https://jsonplaceholder.typicode.com/users")
                .andReturn();
        String contentTypeHeader = response.getHeader("content-type") ;
        System.out.println(contentTypeHeader);
        Assert.assertEquals(contentTypeHeader, "application/json; charset=utf-8");

    }

    @Test
    public void checkResponse(){
        System.out.println("Current DateTime: " + LocalDateTime.now());

        Response response = RestAssured.when()
                .get("https://jsonplaceholder.typicode.com/users")
                .andReturn();

        ResponseBody body = response.getBody();
        User[] responseUsers = body.as(User[].class);
        System.out.println(responseUsers.length);
        Assert.assertEquals(responseUsers.length, 10);

    }
}

