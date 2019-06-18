package RestAssurred.Tests;

import RestAssurred.BaseApi;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeleteLocationTest extends BaseApi {

    //Delete custom location with correct data
    @Test
    public void delete_custom_location_correct(){
        RequestSpecification uploadReqSpec = requestSpecBuilders
                .uploadLocationSpecBuilder("MYLAYER","my_layer_content.zip")
                .build();

        given()
                .spec(uploadReqSpec)
                .when().post(UPLOAD_PATH)
                .then().statusCode(201).log().all();

        RequestSpecification deleteReqSpec = requestSpecBuilders
                .deleteLocationSpecBuilder("MYLAYER1")
                .build();

        given()
                .spec(deleteReqSpec).log().all()
                .when().get(DELETE_PATH)
                .then().statusCode(200).log().all();

    }

    //method not allowed - 401
    @Test
    public void method_not_allowed_test(){

        RequestSpecification deleteReqSpec = requestSpecBuilders
                .deleteLocationSpecBuilder("MYLAYER1")
                .build();
        given().spec(deleteReqSpec).log().all().queryParam("layer_ids","MYLAYER1").
                when().delete(DELETE_PATH).
                then().statusCode(405).log().all();

    }
}
