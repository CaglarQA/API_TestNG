package get;

import baseUrls.GoRest_BaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;


public class GET_6_BaseUrl_With_Annatoion extends GoRest_BaseUrl {
   /*
https://gorest.co.in/public/v2/users
User send GET Request to the URL
    Response format should be “application/json”
    HTTP Status Code should be 200
    name contains "Dr. Mani Naika"
    id should be 6784573, 6784572, 6784576
    gender should be male and female

   */

    /**
     * Aşagıda test junit testidir. bu yüzden  base url 'i aldığımız test de junit olmalıdır
     */

    @Test
    public void test() {
        //1- Set the URL
        spec.pathParam("first","users");

        //2- Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //3- Do assertion


        response.then()
                .contentType("application/json")
                .statusCode(200)
                .body("name",hasItem("Dr. Mani Naik"),
                        "id",hasItems( 6784573, 6784572, 6784576),
                        "gender",hasItems("female","male") );

    }
}
