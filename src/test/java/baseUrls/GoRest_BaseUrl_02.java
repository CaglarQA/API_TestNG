package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRest_BaseUrl_02 {

    /**
     * Burada annatoion kullanmadan (Before) method olarak base url tanımladık
     * Methodumuz RequestSpecification döndürecek
     * ayrıca methodumuz statik yaptık böylece extend etmeden de methodu cagırabiliriz
     *
     * @return
     */


    public static RequestSpecification setupURL() {

        RequestSpecification spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://gorest.co.in/public/v2").build();

        return spec;

    }
}
