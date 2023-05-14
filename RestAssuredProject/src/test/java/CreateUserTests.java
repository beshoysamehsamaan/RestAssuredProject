import io.restassured.response.Response;
import org.example.Requests.Requests;
import org.example.ResponcesModels.CreateUserResponse;
import org.example.ResponcesModels.ListUserResponse;
import org.example.ResponcesModels.LoginResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class CreateUserTests {

    static String name ="beshoo";
    static String job ="tester";
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
    public void createUserSuccess(){
        Response createUserResponse = Requests.createUser(name,job);
        CreateUserResponse createUserResponseObject = createUserResponse.as(CreateUserResponse.class);
        // JsonPath usersJsonPath = listUsersResponse.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(createUserResponseObject.name,"beshoo");
        softAssert.assertAll();
    }
}
