package Test;

import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GeneralTests {

    @BeforeMethod
    public void setUp() {
    }

    @Test(enabled = false)
    public void checkStatusCode() {
        given().
                get("https://reqres.in/api/user/2")
                .then()
                .statusCode(200);
    }

    //verify Single content using hamcrest library
    @Test(enabled = false)
    public void checkParameterValue() {
        given().
                get("https://reqres.in/api/user/2")
                .then()
                .body("data.name", equalTo("fuchsia rose"));
    }

    //verify multiple contents using hamcrest library
    @Test(enabled = false)
    public void checkMultipleParameters() {
        given().get("https://reqres.in/api/user")
                .then()
                .body("data.name", hasItems("cerulean", "fuchsia rose", "true red"));
    }

    //verify 404 response
    @Test(enabled = false)
    public void response404NotFound() {
        given().get("https://reqres.in/api/users/23")
                .then()
                .statusCode(404);
    }

    //how to set parameters and headers
    @Test(enabled = false)
    public void headersAndParameters() {
        given().param("text", "india")
                .and()
                .header("contentType", "application/json")
                .get("http://services.groupkt.com/country/search")
                .then()
                .body("RestResponse.result.name", hasItems("India"));
    }

    //test multiple content
    @Test(enabled = false)
    public void testMultipleContent() {
        given().get("http://reqres.in/api/users/12")
                .then()
                .body("data.id", equalTo(12))
                .body("data.first_name", equalTo("Rachel"))
                .body("data.last_name", equalTo("Howell"))
                .statusCode(200);
    }

    //compare complete text in one go
    @Test(enabled = false)
    public void compareWholeText() {
        given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas"))
                .log()
                .all();
    }

    //Test using xpath in response xml
    @Test(enabled = false)
    public void testUsingXpath() {
        given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .body("CUSTOMER/LASTNAME/", containsString("Fuller"))
                .log()
                .all();
    }

    //Test with root
    @Test(enabled = false)
    public void testWithRoots() {

        given()
                .param("text", "indian")
                .get("http://services.groupkt.com/country/search")
                .then()
                .root("RestResponse.result")
                .body("alpha3_code", hasItems("IOT"));

    }

    //extract details from json using path
    @Test(enabled = false)
    public void extractDetailsFromJsonUsingPath() {
        String lastName =
                given().get("http://reqres.in/api/users/2")
                        .then()
                        .extract()
                        .path("data.last_name").toString();
        System.out.println("LastName is :" + lastName);
    }

    //extract details using response
    @Test(enabled = false, description = "extract details using repsonse")
    public void extractUsingResponse() {
        Response resp = given().get("http://reqres.in/api/users/2")
                .then()
                .extract()
                .response();

        System.out.println("Id is: " + resp.path("data.id"));
        System.out.println("Response is: " + resp.statusCode());
    }


    @AfterMethod
    public void tearDown() {
    }
}