package Test;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SetRequestData {

    //set query parameters. Query parameters sent in get method
    @Test(enabled = false)
    public void setQueryParameter() {
        given().queryParam("text", "India")
                .get("http://services.groupkt.com/country/search")
                .then()
                .statusCode(200);
    }

    //set form parameters. Form parameters are set for post method
    @Test(enabled = false)
    public void setFormParameters() {
        given().formParam("test", "test")
                .get("http://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }

    //set path parameters
    @Test(enabled = false)
    public void setPathParameters() {
        given().pathParam("operation", "search")
                .param("text", "india")
                .get("http://services.groupkt.com/country/{operation}")
                .then()
                .statusCode(200);
    }

    //set header for a request
    @Test(enabled = false)
    public void setHeaderForRequest() {
        given().header("test", "test")
                .when()
                .get("http://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }

    //Set content type
    @Test
    public void setContentType() {
        given().contentType(ContentType.JSON)
                .contentType("application/json; charset=utf-8")
                .when()
                .get("http://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }
}

