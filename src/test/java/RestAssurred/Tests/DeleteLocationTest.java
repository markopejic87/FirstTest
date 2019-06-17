package RestAssurred.Tests;

import RestAssurred.BaseApi;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeleteLocationTest extends BaseApi {

    //Upload custom location with correct data
    @Test
    public void upload_custom_location_correct(){
        RequestSpecification reqSpec = requestSpecBuilders.
                uploadLocationSpecBuilder().
                addQueryParam("layer_id","MYLAYER1").build();

        given().spec(reqSpec).multiPart("zipfile", new File("my_layer_content.zip")).log().all().
                when().post("/upload.json").
                then().statusCode(201).log().all();


    }
}
