package RestAssurred;


import com.sun.jna.platform.win32.WinBase;
import io.restassured.RestAssured;

import org.junit.BeforeClass;
/**
 * todo: class comment
 *
 * @author mpejic
 */
public class BaseApi
{
    protected static final String BASE_URI = "https://cle.api.here.com";
    protected static final String BASE_PATH = "/2/layers";
    protected static final String UPLOAD_PATH="/upload.json";
    protected static final String DELETE_PATH="/delete.json";
    protected static final String MODIFY_PATH="/modify.json";

    protected RequestSpecBuilders requestSpecBuilders = new RequestSpecBuilders();


    @BeforeClass
    public static void setup(){
        RestAssured.baseURI=BASE_URI;
        RestAssured.basePath=BASE_PATH;
    }


}
