package kjoy;

import static org.junit.Assert.assertTrue;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;


public class RestAssuredTest {
    @BeforeTest
    public void initTest() {
    //RestAssured.baseURI  = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void checkStatusCode()
    {
        Response response = RestAssured.when()
                .get("https://jsonplaceholder.typicode.com/users")
                .andReturn();
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkHeader(){

        Response response = RestAssured.when()
                .get("https://jsonplaceholder.typicode.com/users")
                .andReturn();
        String contentTypeHeader = response.getHeader("content-type") ;
        System.out.println(contentTypeHeader);
        Assert.assertEquals(contentTypeHeader, "application/json; charset=utf-8");

    }

    @Test
    public void checkResponse(){

        Response response = RestAssured.when()
                .get("https://jsonplaceholder.typicode.com/users")
                .andReturn();

        ResponseBody body = response.getBody();
        Post[] responsePosts = body.as(Post[].class);
        System.out.println(responsePosts.length);
        Assert.assertEquals(responsePosts.length, 10);

    }
}
