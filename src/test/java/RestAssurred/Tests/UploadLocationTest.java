package RestAssurred.Tests;

import RestAssurred.BaseApi;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * todo: class comment
 *
 * @author mpejic
 */
public class UploadLocationTest extends BaseApi
{
    //Upload custom location with correct data
    @Test
    public void upload_custom_location_correct(){
        RequestSpecification reqSpec = requestSpecBuilders.
                uploadLocationSpecBuilder().
                addQueryParam("layer_id","MYLAYER1").build();

        given().spec(reqSpec).multiPart("zipfile", new File("my_layer_content.zip")).log().all().
                when().post("/upload.json").
                then().statusCode(201).log().all();
//                and().
//                body("",equalTo(""));
    }


    //incorrect location file
    @Test
    public void upload_location_incorrect(){
        RequestSpecification reqSpec = requestSpecBuilders.
                uploadLocationSpecBuilder().
                addQueryParam("layer_id","MYLAYER").build();

        given().spec(reqSpec).multiPart("zipfile", new File("incorrect_data.zip")).log().all().
                when().post("/upload.json").
                then().statusCode(400).log().all();
    }

    //incorrect location file
    @Test
    public void unauthorized(){

        given().contentType("multipart/form-data").
                queryParam("app_id","VmznfFZdwjN4j0Gzke0F").
                queryParam("app_code","incorrect").
                multiPart("zipfile", new File("incorrect_data.zip")).log().all().
                when().post("/upload.json").
                then().statusCode(401).log().all();
    }


}
