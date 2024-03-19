package get;

import baseUrls.RestCountries_BaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class GET_8_PathParams_2 extends RestCountries_BaseUrl {

      /*
            Given
                https://restcountries.com/v3.1/lang/turkish
            When
                User sends a GET Request to the url
            Then
                HTTP Status Code should be 200
            And
                Content Type should be "application/json"
           And
                official name should be "Republic of Turkey",
           And
                capital should be "Ankara"
           And
                region should be "Asia"
           And
                continents should be "Europe", "Asia"
         */

    @Test
    public void test(){

        //1 Set the url
        spec.pathParams("first","lang","second","turkish");

        //2 Send request and get the response
        Response response = given(spec).get("{first}/{second}");
       // response.prettyPrint();

        //Do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("name.official",hasItem("Republic of Turkey"),
                      "capital.get(1)",hasItem("Ankara"),
                        "region",hasItem("Asia"),
                        "continents.get(1)",hasItems("Europe","Asia"));


    }


}
