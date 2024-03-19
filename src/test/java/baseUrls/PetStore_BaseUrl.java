package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PetStore_BaseUrl {

    public static RequestSpecification setUp(){
        RequestSpecification specifi = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2").build();
        return specifi;
    }
}
