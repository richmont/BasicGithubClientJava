package com.github.richmont;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GithubUserDeserializer {
    private GithubUser user;
    private String jsonContent;
    private GithubApiGetUser api;

    public GithubUserDeserializer(GithubApiGetUser api) {
        this.api = api;
    }

    public GithubUser getUser() {
        return user;
    }

    public void setUser(GithubUser user) {
        this.user = user;
    }

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }

    public GithubApiGetUser getApi() {
        return api;
    }

    public void setApi(GithubApiGetUser api) {
        this.api = api;
    }

    public void deserialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        GithubApiGetUser api = this.getApi();
        if (api.getResponseCode() == 200){
            GithubUser user = mapper.readValue(api.getJsonData(), GithubUser.class);
        }

    }
}
