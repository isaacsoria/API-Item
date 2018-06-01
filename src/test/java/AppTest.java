import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void validar_status_code_200(){
        RestAssured.baseURI="http://localhost:8080";
        RequestSpecification httpRequest= RestAssured.given();
        Response response = httpRequest.get("users/111");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(String.valueOf(statusCode),"200");
    }


}
