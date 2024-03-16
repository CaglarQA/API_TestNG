package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

public class GoRest_BaseUrl {

    //aşağıda bir 'RequestSpecification' interface oluşturuldu
    //Cünkü Response response = given().get() ;burada given RequestSpecification objesi alabilir string değil. Ama get String alabilir
   protected RequestSpecification spec;


    @Before
    public void setup() {

        System.out.println(" @Before annotation is used here.");
       spec = new RequestSpecBuilder()
               .setContentType(ContentType.JSON)
               .setBaseUri("https://gorest.co.in/public/v2").build();

    }
}
