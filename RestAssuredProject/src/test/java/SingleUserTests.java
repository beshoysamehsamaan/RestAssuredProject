import org.example.Requests.Requests;
import io.restassured.response.Response;
import org.example.ResponcesModels.LoginResponse;
import org.example.ResponcesModels.SingleUserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class SingleUserTests {

    static String username ="eve.holt@reqres.in";
    static String password ="cityslicka";
    static String token = "";


    @BeforeClass
    public void loginSuccess (){
        Response loResponse = Requests.login(username,password);
        LoginResponse loginResponseObject = loResponse.as(LoginResponse.class);
        token=loginResponseObject.token;

    }

    @Test
    public void singleUserSuccessPage(){
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization",token);
        String id = "/2" ;
        Response singleUsersResponse = Requests.singleuser(headers,id);
        SingleUserResponse singleUserResponseObject = singleUsersResponse.as(SingleUserResponse.class);
        // JsonPath usersJsonPath = listUsersResponse.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(singleUserResponseObject.data.firstName,"Janet");
        softAssert.assertAll();
    }
}
