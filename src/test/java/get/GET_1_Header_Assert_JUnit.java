package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GET_1_Header_Assert_JUnit {

    @Test
    public void test1(){

          /*
        https://petstore.swagger.io/v2/pet/2 adresine git
        StatusCode 200
        Content-Type application/json
        statusLine HTTP/1.1 200 OK
        Connection keep-alive
        Time 800'den küçük
         */


        //1 - End point oluştur
        String endPoint = "https://petstore.swagger.io/v2/pet/2";

        // 2 - GET  request oluştururuz
        given().get(endPoint); // user --> API --> DB

        // 3- Response olutururuz
        Response response = given().get(endPoint); // DB --> API --> user

        // 4 Response yazdır, icindeki bilgiyii gör

        response.prettyPrint();

        // 5 status code 200 oldugunun doğrula

        int expectedStatusCode = 200;
        int actualStatusCode = response.statusCode();
        assertEquals(expectedStatusCode,actualStatusCode);

        //6 Content -Type 'ın application/json oldugunu doğrula
        String expectedContentType = "application/json";
        String  actualContentType = response.contentType();
        assertEquals(expectedContentType,actualContentType);

        //7 Status line 'ın 'HTTP/1.1 200 OK'  olduğunu doğrula
        String expectedStatusLine="HTTP/1.1 200 OK";
        String actualStatusLine = response.statusLine();
        assertEquals(expectedStatusLine,actualStatusLine);

        //8 Contection'ın keep alive olduğunu doğrula
        String expectedConnection="keep-alive";
        String actualConnection=response.header("Connection");
        assertEquals(expectedConnection,actualConnection);

        //9 Time'ın 800 den kücük olduğunu doğrula
        int expectedTime=800;
        int actualTime= (int) response.getTime();
        assertTrue(expectedTime> actualTime);





    }




}
