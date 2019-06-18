package RestAssurred;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;

import java.io.File;

public class RequestSpecBuilders {


    public  RequestSpecBuilder commonAuthorizationSpecBuilder(){
        RequestSpecBuilder reqSpec = new RequestSpecBuilder()
                .addQueryParam("app_id","VmznfFZdwjN4j0Gzke0F")
                .addQueryParam("app_code","v_9Mc0wkCcK_zrQEOQGuhA");
        return reqSpec;
    }

    public RequestSpecBuilder uploadLocationSpecBuilder(String layerId, String layerContentFilePath){
        RequestSpecBuilder reqSpec = commonAuthorizationSpecBuilder()
                .setContentType("multipart/form-data")
                .addQueryParam("layer_id",layerId)
                .addMultiPart("zipfile", new File(layerContentFilePath));
        return reqSpec;
    }

    public RequestSpecBuilder deleteLocationSpecBuilder(String layerId){
        RequestSpecBuilder reqSpec = commonAuthorizationSpecBuilder()
                .addQueryParam("layer_id",layerId);
        return reqSpec;
    }


    public RequestSpecBuilder modifyLocationSpecBuilder(String layerId, String layerContentFilePath, String action){
        RequestSpecBuilder reqSpec = commonAuthorizationSpecBuilder()
                .addQueryParam("layer_id",layerId)
                .addQueryParam("action", action)
                .setContentType("multipart/form-data")
                .addMultiPart("zipfile", new File(layerContentFilePath));


        return reqSpec;
    }

}
