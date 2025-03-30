package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class utils {

    RequestSpecification req;

    public RequestSpecification requestSpecification() {
     req = new RequestSpecBuilder()
        .setBaseUri("https://rahulshettyacademy.com")
        .addQueryParam("key", "qaclick123")
        .setContentType(ContentType.JSON)
        .build();
    return req;
}
}
