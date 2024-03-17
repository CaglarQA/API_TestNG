package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class RegressIn_BaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setup(){

     spec = new RequestSpecBuilder()
             .setContentType(ContentType.JSON)
             .setBaseUri("https://reqres.in/api").build();

    }

}
