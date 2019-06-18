package RestAssurred;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;

import java.io.File;

public class RequestSpecBuilders {

    //request builder that contains authorization information
    public  RequestSpecBuilder commonAuthorizationSpecBuilder(){
        RequestSpecBuilder reqSpec = new RequestSpecBuilder()
                .addQueryParam("app_id","VmznfFZdwjN4j0Gzke0F")
                .addQueryParam("app_code","v_9Mc0wkCcK_zrQEOQGuhA");
        return reqSpec;
    }

    /**
     *  request builder that is used for uploading locations
     * @param layerId - id of the layer we are uploading
     * @param layerContentFilePath - absoulute file path of the file
     * @return
     */
    public RequestSpecBuilder uploadLocationSpecBuilder(String layerId, String layerContentFilePath){
        RequestSpecBuilder reqSpec = commonAuthorizationSpecBuilder()
                .setContentType("multipart/form-data")
                .addQueryParam("layer_id",layerId)
                .addMultiPart("zipfile", new File(layerContentFilePath));
        return reqSpec;
    }

    /**
     *
     * @param layerIds - Comma separated list of layers to delete
     * @return
     */
    public RequestSpecBuilder deleteLocationSpecBuilder(String layerIds){
        RequestSpecBuilder reqSpec = commonAuthorizationSpecBuilder()
                .addQueryParam("layer_ids",layerIds);
        return reqSpec;
    }


    /**
     *
     * @param layerId - id of the layer we are uploading
     * @param layerContentFilePath - absoulute file path of the file
     * @param action - action we are using. Valid values: append update delete
     * @return
     */
    public RequestSpecBuilder modifyLocationSpecBuilder(String layerId, String layerContentFilePath, String action){
        RequestSpecBuilder reqSpec = commonAuthorizationSpecBuilder()
                .addQueryParam("layer_id",layerId)
                .addQueryParam("action", action)
                .setContentType("multipart/form-data")
                .addMultiPart("zipfile", new File(layerContentFilePath));


        return reqSpec;
    }

}
