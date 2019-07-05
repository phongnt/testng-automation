import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RestApiTest {
    @Test
    public void putRequestTest() {
        //API URL
        RestAssured.baseURI = "http://www.mocky.io/v2/5d1f1962310000016aebea9e";

        //HTTP request
        RequestSpecification httpRequest = RestAssured.given();

        //Getting response
        Response response = httpRequest.request(Method.PUT);

        //Getting response body to verify/assert
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        System.out.println(response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200!");

        JsonPath jsonPathEvaluation = response.getBody().jsonPath();
        String mess = jsonPathEvaluation.get("mess");
        Assert.assertEquals("Hello World!", mess, "Incorrect received message!");
    }
}
