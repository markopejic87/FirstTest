package RestAssurred;


import io.restassured.RestAssured;

import org.junit.BeforeClass;
/**
 * todo: class comment
 *
 * @author mpejic
 */
public class BaseApi
{
    protected static final String BASE_URI = "https://bclc-canucks2.betware.com/";
    protected static final String BASE_PATH = "/lma/rest/v1/";


    @BeforeClass
    public static void setup(){
        RestAssured.baseURI=BASE_URI;
        RestAssured.basePath=BASE_PATH;
    }


}
