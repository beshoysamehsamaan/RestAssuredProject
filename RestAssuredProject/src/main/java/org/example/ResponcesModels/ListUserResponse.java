package org.example.ResponcesModels;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "per_page",
        "total",
        "total_pages",
        "data",
        "support"
})

public class ListUserResponse {

    @JsonProperty("page")
    public int page;
    @JsonProperty("per_page")
    public int perPage;
    @JsonProperty("total")
    public int total;
    @JsonProperty("total_pages")
    public int totalPages;
    @JsonProperty("data")
    public List<UserData> data;
    @JsonProperty("support")
    public Support support;

}
