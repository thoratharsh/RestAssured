package Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersTests {

    // get Header of api response
    @Test(enabled = false)
    public void getHeaderFromResponse() {
        Response resp = given().get("http://reqres.in/api/users/2");
        String CFRayHeader = resp.getHeader("CF-RAY");
        System.out.println("CF Ray Header is:" + CFRayHeader);
    }

    //iterate over header list
    @Test(enabled =false)
    public void iterateHeaderList() {
        Response resp = given().get("http://reqres.in/api/users/2");
        Headers header = resp.getHeaders();
        for (Header h : header) {
            System.out.println("Header is :" + h.getName() + " value is:" + h.getValue());
        }

    }

}
