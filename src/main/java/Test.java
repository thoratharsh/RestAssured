import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Test {

    public static void main(String args[]) {
        given().
                get("https://reqres.in/api/user/2")
                .then()
                .body("data.name", is("fuchsia rose"));

        Response resp= get("https://reqres.in/api/user/2");
        String body=resp.toString();
        System.out.println("Body"+body);
    }


}
