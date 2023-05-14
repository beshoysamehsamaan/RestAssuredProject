import org.example.Requests.Requests;
import io.restassured.response.Response;
import org.example.ResponcesModels.ListUserResponse;
import org.example.ResponcesModels.LoginResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class ListUsersTests {

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
    public void listUsersSuccessPage(){
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization",token);
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("page","2");
        Response listUsersResponse = Requests.listusers(headers,queryParams);
        ListUserResponse listUserResponseObject = listUsersResponse.as(ListUserResponse.class);
        // JsonPath usersJsonPath = listUsersResponse.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(listUserResponseObject.page,2);
        softAssert.assertAll();
    }

    @Test
    public void listUsersPerPage(){
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization",token);
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("page","2");
        Response listUsersResponse = Requests.listusers(headers,queryParams);
        ListUserResponse listUserResponseObject = listUsersResponse.as(ListUserResponse.class);
        //JsonPath usersJsonPath = listUsersResponse.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(listUserResponseObject.perPage,6);
        softAssert.assertAll();
    }

    @Test
    public void listUsersSize(){
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization",token);
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("page","2");
        Response listUsersResponse = Requests.listusers(headers,queryParams);
        ListUserResponse listUserResponseObject = listUsersResponse.as(ListUserResponse.class);
        // JsonPath usersJsonPath = listUsersResponse.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(listUserResponseObject.data.size(),6);
        softAssert.assertAll();
    }

    @Test
    public void listUsersid(){
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization",token);
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("page","2");
        Response listUsersResponse = Requests.listusers(headers,queryParams);
        ListUserResponse listUserResponseObject = listUsersResponse.as(ListUserResponse.class);
        //JsonPath usersJsonPath = listUsersResponse.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(listUserResponseObject.data.get(0).id,7);
        softAssert.assertAll();
    }


}