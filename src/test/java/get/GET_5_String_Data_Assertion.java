package get;

import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GET_5_String_Data_Assertion {
    @Test
    public void test() {
           /*
    https://jsonplaceholder.typicode.com/todos/gfhrr756
    User send GET Request to the URL
    Response format should be “application/json”
    HTTP Status Code should be 404
    todos should be empty
     */

        //1 Set the URL
        String url = "https://jsonplaceholder.typicode.com/todos/gfhrr756";

        //2 Send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();

        //Do assertions

        response.then()
                .statusCode(404)
                .contentType("application/json");
        /**
         * Body boş olduğıu için body ile assertion yapamadık
         * response'u String e cevirip assetTrue ile string'in boş olduğunu doğruladık
         */
        String actualText = response.asString();
        String  expectedText = "{}";

        assertEquals(expectedText,actualText);


    }

    @Test
    public void test2() {

              /*
    https://restful-booker.herokuapp.com/booking/123437
    User send GET Request to the URL
    Response format should be “text/plain”
    HTTP Status Code should be 404
    HTTP Status Line should be "HTTP/1.1 404 Not Found"
    todos should be "Not Found"
     */

        //1 Set the url
        String url ="https://restful-booker.herokuapp.com/booking/123437";


        //2 Send request and get response
        Response response = given().get(url);
        response.prettyPrint();

        //Do assertion
        response.then()
                .statusCode(404)
                .contentType("text/plain")
                .statusLine("HTTP/1.1 404 Not Found");

        String actualText = response.asString();
        String expectedText = "Not Found";
        assertEquals(expectedText,actualText);

    }
}
