package RestAssurred.Tests;

import RestAssurred.BaseApi;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

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
                uploadLocationSpecBuilder("MYLAYER",correctFile).
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
                .uploadLocationSpecBuilder("MYLAYER2",incorrectFile)
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

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(correctFile);


        given()
                .contentType("multipart/form-data")
                .queryParam("app_id","VmznfFZdwjN4j0Gzke0F")
                .queryParam("app_code","incorrect")
                .multiPart("zipfile",correctFile,is)
                .when().post(UPLOAD_PATH)
                .then().statusCode(401).log().all();
    }


    @Test
    public void upload_custom_location_no_file(){
        RequestSpecification reqSpec = requestSpecBuilders
                .commonAuthorizationSpecBuilder()
                .setContentType("multipart/form-data")
                .addQueryParam("layer_id","MYLAYER").
                build();

        given()
                .spec(reqSpec)
                .when()
                .post(UPLOAD_PATH)
                .then()
                .statusCode(400).log().all();
    }


    @Test
    public void upload_custom_location_incorrect_format(){
        RequestSpecification reqSpec = requestSpecBuilders
                .commonAuthorizationSpecBuilder()
                .setContentType("text/plain")
                .build();

        given()
                .spec(reqSpec)
                .when()
                .post(UPLOAD_PATH)
                .then()
                .statusCode(415).log().all();
    }


}
