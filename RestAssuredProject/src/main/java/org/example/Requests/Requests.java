package org.example.Requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.Help.Helper;
import org.example.Help.PropertiesLoader;
import org.example.RequestModels.CreateUserRequest;
import org.example.RequestModels.LoginRequest;

import java.util.Map;

public class Requests {

    public  static Response login(String username, String password)
    {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.email=username;
        loginRequest.password=password;

        Response loginResponse = RestAssured.given().log().all().contentType("application/json")
                .body(Helper.getObjectAsString(loginRequest)).post(PropertiesLoader.readProperty("baseUrl") +PropertiesLoader.readProperty("loginEndPoint"));
        return loginResponse;
    }

    public  static Response createUser(String name , String job )
    {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.name=name;
        createUserRequest.job=job;

        Response createResponse = RestAssured.given().log().all().contentType("application/json")
                .body(Helper.getObjectAsString(createUserRequest)).post(PropertiesLoader.readProperty("baseUrl") +PropertiesLoader.readProperty("usersEndPoint"));
        return createResponse;
    }

    public  static Response listusers (Map<String,String>  headers, Map<String,String> queryParams)
    {
        Response listUsersResponse = RestAssured.given().log().all().headers(headers)
                .queryParams(queryParams)
                .get(PropertiesLoader.readProperty("baseUrl") +PropertiesLoader.readProperty("usersEndPoint"));
        return listUsersResponse;
    }

    public  static Response singleuser (Map<String,String>  headers , String id)
    {
        Response singleUsersResponse = RestAssured.given().log().all().headers(headers)
                .get(PropertiesLoader.readProperty("baseUrl") +PropertiesLoader.readProperty("usersEndPoint")+id);
        return singleUsersResponse;
    }


}
