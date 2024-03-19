package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestCountries_BaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setup(){
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://restcountries.com/v3.1")
                .build();
    }

}
