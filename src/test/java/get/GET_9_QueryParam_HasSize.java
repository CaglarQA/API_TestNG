package get;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static baseUrls.PetStore_BaseUrl.setUp;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class GET_9_QueryParam_HasSize {
    /*
 https://petstore.swagger.io/ dokumanını kullanarak statüsü "available" olan "pet"
    sayısını bulup 100'den fazla olduğunu assert eden bir otomasyon testi yazınız.

 */

    @Test
    public void test() {
        //1 - Set the URL
        RequestSpecification spc = setUp();
        spc.pathParams("a","pet","b","findByStatus")
                .queryParam("status","available");

        //2- Send request and get the response
        Response response = given(spc).get("{a}/{b}");
      //  response.prettyPrint();

        //3- Do assertion
        assertEquals(200, response.statusCode());

        int countOfAvaliable=response.jsonPath().getList("id").size();
        System.out.println("countOfAvaliable = " + countOfAvaliable);
        assertTrue(countOfAvaliable>100);

        //Do Assertion
        response.then()
                .statusCode(200)
                .body("id",hasSize(greaterThan(100)));
    }
}
