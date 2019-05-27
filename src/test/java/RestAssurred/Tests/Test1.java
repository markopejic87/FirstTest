package RestAssurred.Tests;

import RestAssurred.BaseApi;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * todo: class comment
 *
 * @author mpejic
 */
public class Test1 extends BaseApi
{
    @Test
    public void myTest(){
        given().log().all().
                when().get("").
                then().statusCode(200).
                and().
                body("",equalTo(""));
    }



}
