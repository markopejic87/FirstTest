package RestAssurred.Tests;

import RestAssurred.BaseApi;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ModifyLocationTest extends BaseApi {


    //append geometry to existing object
    @Test
    public void append_to_custom_location(){
        RequestSpecification UploadReqSpec = requestSpecBuilders.
                uploadLocationSpecBuilder("MYLAYER3","my_layer_content.zip").
                build();

        given()
                .spec(UploadReqSpec)
                .when()
                .post(UPLOAD_PATH)
                .then()
                .statusCode(201).log().all();

    RequestSpecification modifyReqSpec = requestSpecBuilders.
            modifyLocationSpecBuilder("MYLAYER3", "my_layer_content_append.zip","append").
            build();


    given()
                .spec(modifyReqSpec)
                .when()
                .post(MODIFY_PATH)
                .then()
                .statusCode(200).body("action",Matchers.containsString("append")).log().all();
}



    //update geometry to existing object
    @Test
    public void update_custom_location(){
        RequestSpecification UploadReqSpec = requestSpecBuilders.
                uploadLocationSpecBuilder("MYLAYER4","my_layer_content.zip").
                build();

        given()
                .spec(UploadReqSpec)
                .when()
                .post(UPLOAD_PATH)
                .then()
                .statusCode(201).log().all();

        RequestSpecification modifyReqSpec = requestSpecBuilders.
                modifyLocationSpecBuilder("MYLAYER4", "my_layer_content_update.zip","update").
                build();


        given()
                .spec(modifyReqSpec)
                .when()
                .post(MODIFY_PATH)
                .then()
                .statusCode(200).body("action",Matchers.containsString("update")).log().all();
    }


    //Modify non existing location
    @Test
    public void modify_non_existing_location(){

        RequestSpecification modifyReqSpec = requestSpecBuilders.
                modifyLocationSpecBuilder("NonExisting", "my_layer_content_update.zip","append").
                build();


        given()
                .spec(modifyReqSpec)
                .when()
                .post(MODIFY_PATH)
                .then()
                .statusCode(404).log().all();
    }

    //update geometry to existing object
    @Test
    public void update_custom_location_with_incorrect_format(){
        RequestSpecification UploadReqSpec = requestSpecBuilders.
                uploadLocationSpecBuilder("MYLAYER4","my_layer_content.zip").
                build();

        given()
                .spec(UploadReqSpec)
                .when()
                .post(UPLOAD_PATH)
                .then()
                .statusCode(201).log().all();

        RequestSpecification modifyReqSpec = requestSpecBuilders.
                modifyLocationSpecBuilder("MYLAYER4", "incorrect_data.zip","update").
                build();


        given()
                .spec(modifyReqSpec)
                .when()
                .post(MODIFY_PATH)
                .then()
                .statusCode(400).log().all();
    }

}
