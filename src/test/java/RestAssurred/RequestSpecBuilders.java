package RestAssurred;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Cookie;

public class RequestSpecBuilders {


    public RequestSpecBuilder test(){
        Cookie csrf= new Cookie.Builder("csrftoken","foo").build();
        RequestSpecBuilder reqSpec = new RequestSpecBuilder()
                .addHeader("Content-type","application/json")
                .addCookie(csrf);
        return reqSpec;
    }
}
