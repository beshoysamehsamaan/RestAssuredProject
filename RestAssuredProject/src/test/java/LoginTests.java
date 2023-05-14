import org.example.Requests.Requests;
import io.restassured.response.Response;
import org.example.ResponcesModels.LoginErrorResponse;
import org.example.ResponcesModels.LoginResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests {

    static String username ="eve.holt@reqres.in";
    static String password ="cityslicka";

    @Test
    public static void successLogin(){
        Response loResponse = Requests.login(username,password);
        LoginResponse loResponseObject = loResponse.as(LoginResponse.class);
        //JsonPath loginJsonPath = loResponse.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loResponse.statusCode(),200,"login successfully");
        softAssert.assertNotNull(loResponseObject.token,"token returned");
        softAssert.assertAll();
    }

    @Test
    public static void successLogin2(){
        Response loResponse = Requests.login(username,password);

    }

    @Test
    public static void failLoginEmail(){
        Response loResponse = Requests.login("",password);
        LoginErrorResponse loResponseObject = loResponse.as(LoginErrorResponse.class);
        //JsonPath loginJsonPath = loResponse.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loResponseObject.error,"Missing email or username");
        softAssert.assertAll();
    }

    @Test
    public static void failLoginPassword(){
        Response loResponse = Requests.login(username,"");
        LoginErrorResponse loResponseObject = loResponse.as(LoginErrorResponse.class);
        //JsonPath loginJsonPath = loResponse.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loResponseObject.error,"Missing password");
        softAssert.assertAll();
    }
}
