package RestAssurred;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;

public class RequestSpecBuilders {


    public RequestSpecBuilder uploadLocationSpecBuilder(){
        RequestSpecBuilder reqSpec = new RequestSpecBuilder()
                .setContentType("multipart/form-data")
                .addQueryParam("app_id","VmznfFZdwjN4j0Gzke0F")
                .addQueryParam("app_code","v_9Mc0wkCcK_zrQEOQGuhA");
        return reqSpec;
    }
}
