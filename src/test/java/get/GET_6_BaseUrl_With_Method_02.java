package get;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static baseUrls.GoRest_BaseUrl_02.setupURL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;


public class GET_6_BaseUrl_With_Method_02  {
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
     *
     * Bu birinci videonun devamı
     * Burada base url bir annatotion ile değil bir method ile tanımlandı
     * Methodumuz RequestSpecification methodu ve statik'dir
     * Bundan dolayı methodumuzu cagırdık -> setupUrl( import edildi)
     * ve bu methodumuzu RequestSpec objesinin icine attık.
     */


    @Test
    public void test() {
        //1- Set the URL
        RequestSpecification spec= setupURL();

        spec.pathParam("first","users");

        //2- Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //3- Do assertion

        response.then()
                .contentType("application/json")
                .statusCode(200)
                .body("name",hasItem("Dr. Mani Naik"),
                        "id",hasItems( 6784573, 6784572, 6784574),
                        "gender",hasItems("female","male") );

    }
}
