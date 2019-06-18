package RestAssurred;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class ResponseSpecBuilders {
    public static ResponseSpecBuilder commonResponseSpecBuoilders() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON);
    }
}
