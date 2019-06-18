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
                uploadLocationSpecBuilder("MYLAYER","my_layer_content.zip").
                build();

        given()
                .spec(reqSpec)
                .when()
                .post(UPLOAD_PATH)
                .then()
                .statusCode(201).log().all();
    }


    //incorrect location file
    @Test
    public void upload_location_incorrect(){

        RequestSpecification reqSpec = requestSpecBuilders
                .uploadLocationSpecBuilder("MYLAYER2","incorrect_data.zip")
                .build();

        given()
                .spec(reqSpec)
                .when()
                .post(UPLOAD_PATH)
                .then()
                .statusCode(400).log().all();
    }

    //trying to send the request with incorrect password
    @Test
    public void unauthorized(){

        given()
                .contentType("multipart/form-data")
                .queryParam("app_id","VmznfFZdwjN4j0Gzke0F")
                .queryParam("app_code","incorrect")
                .multiPart("zipfile", new File("my_layer_content.zip"))
                .when().post(UPLOAD_PATH)
                .then().statusCode(401).log().all();
    }


}
