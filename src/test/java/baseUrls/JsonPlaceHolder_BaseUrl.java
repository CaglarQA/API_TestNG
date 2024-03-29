package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;

public class JsonPlaceHolder_BaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void baseUrl(){

        spec= new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://jsonplaceholder.typicode.com").build();
    }

}
