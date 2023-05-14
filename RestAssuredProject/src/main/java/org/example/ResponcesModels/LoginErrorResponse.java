package org.example.ResponcesModels;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "error"
})
@Generated("jsonschema2pojo")
public class LoginErrorResponse {

    @JsonProperty("error")
    public String error;

}