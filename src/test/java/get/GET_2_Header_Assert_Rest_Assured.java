package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GET_2_Header_Assert_Rest_Assured {
    @Test
    public void test2() {

      /*
 https://restful-booker.herokuapp.com/booking/34
 HTTP Status Code'unun 200
 Content Type'ın "application/json; charset=utf-8"
 Status Line'ın "HTTP/1.1 200 OK"
 Server'ın' "Cowboy"
 Connection'ın "keep-alive"
 oldugunu dogrular
*/
        //1 -Set the URL;
        String url ="https://restful-booker.herokuapp.com/booking/34";

        //2 Send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();

        //3 Do assertion
        /**
         * GET_1 -> junit'deki assertion ile doğrulama yaptık
         * Burada ise RestAssured içinde doğrulama yapacagız
         * Chain yaparak (junit kullanmadan) assertion
         */

        response.then() //restassured "then" kullanrak chain yaparak assert ederiz
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .header("Server","Cowboy")
                .header("Connection","keep-alive");

    }
}
