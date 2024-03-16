package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GET_3_Body_Assert_Hamcrest_Matcher {
// BU TESTTE TEK DATANIN BODYSİ ÜZERİNDE HAMCREST MATCHER İLE DOĞRULAMA YAPTIK
       /*
       https://jsonplaceholder.typicode.com/posts/1
  I send a GET request to the Url
    HTTP Status Code should be 200
    Response format (contentType) should be "application/json"
    "id" should be 1
    "title" should be "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body" should be "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
*/

    @Test
    public void test() {

        //1 Set URL
        String url ="https://jsonplaceholder.typicode.com/posts/1";

        //2 Send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();

        //3 Do assertions
        //1. way :

        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("userId",equalTo(1))//hamcrest kullanarak assertion yapıyoruz
                .body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("body",equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));

        /**
         * Yukarıda body leirn birinde assert doğru olmadığında bir sonraki asserte  gecmez. Buna 'HardAssertion" denir
         * Body parcalara bölüp assertion yapıldığında , ilk hatalı boyd'de kalıp aşağıyı kontrol etmiyor
         */

        //2.Way :
        /**
         * Burada tek body methodu kullanıyoruz, tek body içinde 3 tane assertion kullandık. Burada assertion'ların birinde ahata bulsa bile devam ediyor, diğer assertionları da kontrol ediyor
         */

        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("userId",equalTo(1)//hamcrest kullanarak assertion yapıyoruz
                ,"title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
                ,"body",equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));

    }
}
